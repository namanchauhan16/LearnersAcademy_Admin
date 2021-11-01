package com.simplilearn.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;

import com.simplilearn.entity.Classd;
import com.simplilearn.util.HibernateUtil;

public class ReadClassD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadClassD() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Classd> classdList = session.createQuery("select _ca from Classd _ca").getResultList();

			List<HashMap<Object, Object>> clsList = new ArrayList<>();
			for (Classd classd : classdList) {
				HashMap<Object, Object> classdMap = new HashMap<>();
				classdMap.put("subjectName", classd.getSubjectName());
				classdMap.put("teacherName", classd.getTeacherName());
				classdMap.put("studentName", classd.getStudentName());
				clsList.add(classdMap);
			}
			

			JSONArray jsonArray = new JSONArray(clsList);
			request.getRequestDispatcher("display_classd.jsp?classd=" + jsonArray.toString()).forward(request,
					response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

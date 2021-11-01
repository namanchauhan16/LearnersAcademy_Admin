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

import com.simplilearn.entity.Classb;
import com.simplilearn.util.HibernateUtil;

public class ReadClassB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadClassB() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Classb> classbList = session.createQuery("select _ca from Classb _ca").getResultList();

			List<HashMap<Object, Object>> clsList = new ArrayList<>();
			for (Classb classb : classbList) {
				HashMap<Object, Object> classbMap = new HashMap<>();
				classbMap.put("subjectName", classb.getSubjectName());
				classbMap.put("teacherName", classb.getTeacherName());
				classbMap.put("studentName", classb.getStudentName());
				clsList.add(classbMap);
			}
			

			JSONArray jsonArray = new JSONArray(clsList);
			request.getRequestDispatcher("display_classb.jsp?classb=" + jsonArray.toString()).forward(request,
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

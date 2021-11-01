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

import com.simplilearn.entity.Classa;
import com.simplilearn.util.HibernateUtil;

public class ReadClassA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadClassA() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Classa> classaList = session.createQuery("select _ca from Classa _ca").getResultList();

			List<HashMap<Object, Object>> clsList = new ArrayList<>();
			for (Classa classa : classaList) {
				HashMap<Object, Object> classaMap = new HashMap<>();
				classaMap.put("subjectName", classa.getSubjectName());
				classaMap.put("teacherName", classa.getTeacherName());
				classaMap.put("studentName", classa.getStudentName());
				clsList.add(classaMap);
			}
			

			JSONArray jsonArray = new JSONArray(clsList);
			request.getRequestDispatcher("display_classa.jsp?classa=" + jsonArray.toString()).forward(request,
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

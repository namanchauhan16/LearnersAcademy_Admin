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

import com.simplilearn.entity.Classe;
import com.simplilearn.util.HibernateUtil;

public class ReadClassE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadClassE() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Classe> classeList = session.createQuery("select _ca from Classe _ca").getResultList();

			List<HashMap<Object, Object>> clsList = new ArrayList<>();
			for (Classe classe : classeList) {
				HashMap<Object, Object> classeMap = new HashMap<>();
				classeMap.put("subjectName", classe.getSubjectName());
				classeMap.put("teacherName", classe.getTeacherName());
				classeMap.put("studentName", classe.getStudentName());
				clsList.add(classeMap);
			}
			

			JSONArray jsonArray = new JSONArray(clsList);
			request.getRequestDispatcher("display_classe.jsp?classe=" + jsonArray.toString()).forward(request,
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

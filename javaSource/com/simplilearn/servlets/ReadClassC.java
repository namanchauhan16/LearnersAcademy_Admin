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

import com.simplilearn.entity.Classc;
import com.simplilearn.util.HibernateUtil;

public class ReadClassC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadClassC() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Classc> classcList = session.createQuery("select _ca from Classc _ca").getResultList();

			List<HashMap<Object, Object>> clsList = new ArrayList<>();
			for (Classc classc : classcList) {
				HashMap<Object, Object> classcMap = new HashMap<>();
				classcMap.put("subjectName", classc.getSubjectName());
				classcMap.put("teacherName", classc.getTeacherName());
				classcMap.put("studentName", classc.getStudentName());
				clsList.add(classcMap);
			}
			

			JSONArray jsonArray = new JSONArray(clsList);
			request.getRequestDispatcher("display_classc.jsp?classc=" + jsonArray.toString()).forward(request,
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

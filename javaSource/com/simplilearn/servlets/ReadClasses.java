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

import com.simplilearn.entity.Class;
import com.simplilearn.util.HibernateUtil;

public class ReadClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadClasses() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Class> classesList = session.createQuery("select _c from Class _c").getResultList();

			List<HashMap<Object, Object>> clsList = new ArrayList<>();
			for (Class clas : classesList) {
				HashMap<Object, Object> classMap = new HashMap<>();
				classMap.put("classId", clas.getClassId());
				classMap.put("className", clas.getClassName());
				clsList.add(classMap);
			}
			JSONArray jsonArray = new JSONArray(clsList);
			request.getRequestDispatcher("display_classes.jsp?classes=" + jsonArray.toString()).forward(request,
					response);

		} catch (Exception e) {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}

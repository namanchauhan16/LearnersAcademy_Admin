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

import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;


public class ReadStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public ReadStudents() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			
			List<Student> studentsList = session.createQuery("select _s from Student _s").getResultList();
			
			 
			 List<HashMap<Object, Object>> stdList = new ArrayList<>();
			for (Student student : studentsList) {
				HashMap<Object, Object> studentMap = new HashMap<>();
				studentMap.put("studentName", student.getStudentName());
				studentMap.put("studentId", student.getStudentId());
				stdList.add(studentMap);
			}
			
			JSONArray jsonArray = new JSONArray(stdList);
			request.getRequestDispatcher("display_students.jsp?students="+jsonArray.toString()).forward(request, response);
			
		} catch (Exception e) {
				e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

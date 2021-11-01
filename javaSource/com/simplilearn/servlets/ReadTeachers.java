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

import com.simplilearn.entity.Teacher;
import com.simplilearn.util.HibernateUtil;


public class ReadTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ReadTeachers() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			
			List<Teacher> teachersList = session.createQuery("select _t from Teacher _t").getResultList();
			
			 List<HashMap<Object, Object>> tchList = new ArrayList<>();
			 for (Teacher teacher : teachersList) {
				 HashMap<Object, Object> teacherMap = new HashMap<>();
				 teacherMap.put("teacherId", teacher.getTeacherId());
				 teacherMap.put("teacherName", teacher.getTeacherName());
				 tchList.add(teacherMap);
			}
			 JSONArray jsonArray = new JSONArray(tchList);
			 request.getRequestDispatcher("display_teachers.jsp?teachers="+jsonArray.toString()).forward(request, response);
			
		} catch (Exception e) {
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

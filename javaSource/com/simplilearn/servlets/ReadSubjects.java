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

import com.simplilearn.entity.Subject;
import com.simplilearn.util.HibernateUtil;


public class ReadSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ReadSubjects() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			
	        List<Subject> subjectsList = session.createQuery("Select _sub from Subject _sub").getResultList();
	        
	        List<HashMap<Object, Object>> subList = new ArrayList<>();
	        
	        for(Subject subject: subjectsList) {
	        	HashMap<Object, Object> subjectMap = new HashMap<>();
	        	subjectMap.put("subjectId", subject.getSubjectId());
	        	subjectMap.put("subjectName", subject.getSubjectName());
	        	subList.add(subjectMap);
	        }
	        JSONArray jsonArray = new JSONArray(subList);
	        request.getRequestDispatcher("display_subjects.jsp?subjects="+jsonArray.toString()).forward(request, response);
		} catch (Exception e) {
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

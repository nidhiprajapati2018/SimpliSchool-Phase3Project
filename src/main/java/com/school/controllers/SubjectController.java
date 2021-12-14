package com.school.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.dao.SubjectDao;
import com.school.dao.UserDao;
import com.school.entity.Subject;

/**
 * Servlet implementation class SubjectController
 */
@WebServlet("/subject")
public class SubjectController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	private SubjectDao subjectDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		subjectDao = new SubjectDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Subject> subjects;
		Subject subject;
		RequestDispatcher dispatcher=null;
		
		String mode = request.getParameter("flag");
		String id = request.getParameter("id");
		
		if(mode !=null && mode.equalsIgnoreCase("edit")) {
			subject = subjectDao.getSubject(Long.parseLong(id));
			request.setAttribute("subject", subject);
			subjects = subjectDao.getSubjects();
			request.setAttribute("subjects", subjects);
			dispatcher = request.getRequestDispatcher("resources/subject/subject.jsp");
		} else if(mode != null && mode.equalsIgnoreCase("delete")) {
			subjectDao.deleteSubject(Long.parseLong(id));
			subjects = subjectDao.getSubjects();
			request.setAttribute("subjects", subjects);
			dispatcher = request.getRequestDispatcher("resources/subject/subject.jsp");
		} else {
			subjects = subjectDao.getSubjects();
			request.setAttribute("subjects", subjects);
			dispatcher = request.getRequestDispatcher("resources/subject/subject.jsp");
		}
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		long sid = -1;
		
		if(id != null && id != "") {
			sid = Long.parseLong(id);
		}
		
		String subject = request.getParameter("subject");
		String grade = request.getParameter("grade");
		
		if(sid == -1) {
			subjectDao.saveSubject(subject, grade);
		} else {
			subjectDao.updateSubject(sid, subject, grade);
		}
		
		
		List<Subject> subjects = subjectDao.getSubjects();
		request.setAttribute("subjects", subjects);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("resources/subject/subject.jsp");
		dispatcher.forward(request, response);
	}

}

package com.school.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.dao.TeacherDao;
import com.school.dao.UserDao;
import com.school.entity.Teacher;

/**
 * Servlet implementation class TeacherController
 */
@WebServlet("/teacher")
public class TeacherController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	private TeacherDao teacherDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		teacherDao = new TeacherDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Teacher> teachers;
		Teacher teacher;
		RequestDispatcher dispatcher=null;
		
		String mode = request.getParameter("flag");
		String id = request.getParameter("id");
		
		if(mode !=null && mode.equalsIgnoreCase("edit")) {
			teacher = teacherDao.getTeacher(Long.parseLong(id));
			request.setAttribute("teacher", teacher);
			dispatcher = request.getRequestDispatcher("resources/teacher/edit-teacher.jsp");
		} else if(mode != null && mode.equalsIgnoreCase("delete")) {
			teacherDao.deleteTeacher(Long.parseLong(id));
			teachers = teacherDao.getTeachers();
			request.setAttribute("teachers", teachers);
			dispatcher = request.getRequestDispatcher("resources/teacher/teacher.jsp");
		} else {
			teachers = teacherDao.getTeachers();
			request.setAttribute("teachers", teachers);
			dispatcher = request.getRequestDispatcher("resources/teacher/teacher.jsp");
		}
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		long sid = -1;
		
		if(id != null) {
			sid = Long.parseLong(id);
		}
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String let = request.getParameter("let");
		String set = request.getParameter("set");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		if(sid == -1) {
			teacherDao.saveTeacher(fname, lname, let, set, phone, email);
		} else {
			teacherDao.updateTeacher(sid, fname, lname, let, set, phone, email);
		}
		
		
		List<Teacher> teachers = teacherDao.getTeachers();
		request.setAttribute("teachers", teachers);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("resources/teacher/teacher.jsp");
		dispatcher.forward(request, response);
	}

}

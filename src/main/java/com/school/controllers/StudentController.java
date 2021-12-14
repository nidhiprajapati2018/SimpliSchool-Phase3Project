package com.school.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.school.dao.StudentDao;
import com.school.dao.UserDao;
import com.school.entity.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/student")
public class StudentController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	private StudentDao studentDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		studentDao = new StudentDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> students;
		Student student;
		RequestDispatcher dispatcher=null;
		
		String mode = request.getParameter("flag");
		String id = request.getParameter("id");
		
		if(mode !=null && mode.equalsIgnoreCase("edit")) {
			student = studentDao.getStudent(Long.parseLong(id));
			request.setAttribute("student", student);
			dispatcher = request.getRequestDispatcher("resources/student/edit-student.jsp");
		} else if(mode != null && mode.equalsIgnoreCase("delete")) {
			studentDao.deleteStudent(Long.parseLong(id));
			students = studentDao.getStudents();
			request.setAttribute("students", students);
			dispatcher = request.getRequestDispatcher("resources/student/student.jsp");
		} else {
			students = studentDao.getStudents();
			request.setAttribute("students", students);
			dispatcher = request.getRequestDispatcher("resources/student/student.jsp");
		}
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		long sid = -1;
		String status = "active";
		
		if(id != null) {
			sid = Long.parseLong(id);
			status = request.getParameter("status");
		}
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String grade = request.getParameter("grade");
		
		if(sid == -1) {
			studentDao.saveStudent(fname, lname, grade, status);
		} else {
			studentDao.updateStudent(sid, fname, lname, grade, status);
		}
		
		
		List<Student> students = studentDao.getStudents();
		request.setAttribute("students", students);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("resources/student/student.jsp");
		dispatcher.forward(request, response);
	}

}

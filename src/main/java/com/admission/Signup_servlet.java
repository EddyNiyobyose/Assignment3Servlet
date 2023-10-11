package com.admission;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.realm.AuthenticatedUserRealm;

import com.mysql.cj.Session;

/**
 * Servlet implementation class Signup_servlet
 */
@WebServlet("/Signup_servlet")
public class Signup_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean authenticated;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(authenticated) {
			HttpSession session = request.getSession();
			session.setAttribute(password, email);
			
			response.sendRedirect("admission.jsp");
			
	}else {
	    request.setAttribute("error", "Invalid Email or Password");
		request.getRequestDispatcher("signup.jsp").forward(request, response);	
	}
	}

}

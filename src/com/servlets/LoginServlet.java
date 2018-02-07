package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;
import com.dao.DaoFactory;
import com.dao.UserDao;



@WebServlet(name="/LoginServlet" , urlPatterns= {"/login"})
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDao userDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDao = daoFactory.getUserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("users", userDao.lister());
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        
        if (request.getParameter("email").isEmpty()) {
        	System.out.println("Veuillez remplir l'email");
        }
        
        else if (request.getParameter("password").isEmpty()) {
        	System.out.println("Veuillez remplir votre password");
        } 
        else {
        	
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        
        
        
        HttpSession session = request.getSession();
     
        session.setAttribute("email", email);
        session.setAttribute("firstname", firstname);
        userDao.ajouter(user);
        
        request.setAttribute("users", userDao.lister());
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
        dispatcher.forward(request, response);
        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }


    

}

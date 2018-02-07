package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DaoFactory;
import com.bean.User;
import com.dao.*;

/**
 * Servlet implementation class Test
 */
@WebServlet(name = "/SignupServlet", urlPatterns = {"/signup"})
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao userDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.userDao = daoFactory.getUserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
   /* 	try { */
            request.setAttribute("users", userDao.lister());
       /* }
        catch (DaoException e) {
            request.setAttribute("erreur", e.getMessage());
        }*/
        this.getServletContext().getRequestDispatcher("/WEB-INF/signup.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(request.getParameter("password"));
        user.setFirstname(request.getParameter("firstname"));
        user.setLastname(request.getParameter("lastname"));
        user.setPassword(request.getParameter("password2"));
        
        
        if( !request.getParameter("password").equals(request.getParameter("password2"))) {
        		System.out.println("vos 2 mots de passes ne sont pas identique");
        }
        else if (request.getParameter("email").isEmpty()) {
        	System.out.println("Veuillez remplir l'email");
        }
        
        else if (request.getParameter("password").isEmpty()) {
        	System.out.println("Veuillez remplir votre password");
        } 
        else if (request.getParameter("password2").isEmpty()) {
        	System.out.println("Veuillez remplir votre password2");
        } 
        else if (request.getParameter("firstname").isEmpty()) {
        	System.out.println("Veuillez remplir firstname");
        }
        else if (request.getParameter("lastname").isEmpty()) {
        	System.out.println("Veuillez remplir votre lastname");
        }
        else {
        	
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        
        
        
        HttpSession session = request.getSession();
     
        session.setAttribute("email", email);
        session.setAttribute("firstname", firstname);
        
        userDao.ajouter(user);
        request.setAttribute("users", userDao.lister());
        System.out.println("vous êtes bien inscrit");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
        dispatcher.forward(request, response);
        }
       
        
        
        
        
        
    }
    
    

}

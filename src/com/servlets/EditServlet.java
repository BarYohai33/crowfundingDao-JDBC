package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bean.Edit;
import com.dao.DaoFactory;
import com.dao.EditDao;


/**
 * Servlet implementation class Categories
 */
@WebServlet(name="/EditServlet", urlPatterns = {"/myprojects"})
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private EditDao editDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.editDao = daoFactory.getEditDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("edits", editDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/myprojects.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	Edit edit = new Edit();
        edit.setTitre(request.getParameter("titre"));
        edit.setProjet(request.getParameter("projet"));
        
        if (request.getParameter("titre").isEmpty()) {
        	System.out.println("Veuillez remplir le titre");
        }
        
        else if (request.getParameter("projet").isEmpty()) {
        	System.out.println("Veuillez remplir les détails du projet");
        } 
        else {

        
            
        
        	editDao.ajouter(edit);
        request.setAttribute("edits", editDao.lister());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home.jsp");
        dispatcher.forward(request, response);
        }
        //this.getServletContext().getRequestDispatcher("/WEB-INF/myprojects.jsp").forward(request, response);
	}

}


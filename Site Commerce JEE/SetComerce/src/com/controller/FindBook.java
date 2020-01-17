package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Model.Book;
import com.dao.CManager;

/**
 * Servlet implementation class FindBook
 */
@WebServlet("/FindBook")
public class FindBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CManager c ;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindBook() {
        super();
        // TODO Auto-generated constructor stub
        c = new CManager();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String bookName = request.getParameter("FindBook");
		
		Book namBook = (Book)c.FindBook(bookName);
		
		
		if(namBook != null) {
			//test = test.replaceAll(" ", "-");
			String m1= "http://localhost:8084/SetComerce/Images/"+namBook.getBookName().replaceAll(" ", "-")+".jpg";
			String m2= "http://localhost:8084/SetComerce/Images/"+namBook.getBookName().replaceAll(" ", "-")+".pdf";
			HttpSession ses = request.getSession(true);
			
			ses.setAttribute("adresse_image",m1);
			ses.setAttribute("adresse_pdf",m2);
			ses.setAttribute("Book",namBook);
			response.sendRedirect("BookSearch.jsp");
			
			
		}else {
			
			response.sendRedirect("NoResoltFound.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


import java.util.*;
import java.lang.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;

import java.io.FileNotFoundException;

public class MostSoldProducts extends HttpServlet {

  protected void processReq(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
		response.setContentType("text/html");
		HttpSession session= request.getSession();
        java.io.PrintWriter out = response.getWriter();
		MySqlDataStoreUtilities mysql = new MySqlDataStoreUtilities();
		ArrayList<String> searchcar = mysql.MostBought();
		session.setAttribute("mostbought",searchcar);
		//out.println(searchcar);
		request.getRequestDispatcher("MostSoldLocation").forward(request, response);
		out.close();
		
	}
    
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processReq(request, response);
		  
    } 
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
         processReq(request, response);
    }
}

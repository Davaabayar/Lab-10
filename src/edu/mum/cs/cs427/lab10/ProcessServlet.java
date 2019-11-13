package edu.mum.cs.cs427.lab10;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/process")
public class ProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] fields = {"name","gender","category","message"};
		boolean hasError = false;
		for (String field : fields) {
			if (request.getParameter(field) == null || request.getParameter(field).trim().isEmpty()){
				request.setAttribute(field, field + " should not be empty.");
				hasError = true;
			}
		}		
		if (hasError){
			RequestDispatcher rd = request.getRequestDispatcher("contactus");
        	rd.forward(request, response);          
        }else {
        	System.out.println("call thank you");
        	RequestDispatcher rd = request.getRequestDispatcher("thankyou");
        	rd.forward(request, response);        	
            //response.sendRedirect("ThankYouServlet");  
        }   
	}

}

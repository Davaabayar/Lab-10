package edu.mum.cs.cs427.lab10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContactusServlet
 */
@WebServlet("/thankyou")
public class ThankYouServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pageCounter; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThankYouServlet() {
        super();      
    }
    
    @Override
    public void init() throws ServletException {    	
    	super.init();
    	pageCounter = 0;
    	System.out.println("contact us servlet init");    	
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pageCounter++;         
		String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String category = request.getParameter("category");
        String message = request.getParameter("message");
        int totalhit = Integer.parseInt(request.getAttribute("totalHit").toString());
        PrintWriter writer = response.getWriter();
        String htmlResponse = this.buildHtml(name, gender, category, message, totalhit);
        writer.println(htmlResponse);
	}
	protected String buildHtml(String name, String gender, String category, String message, int totalCount) {
		return "<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"<title>CS427-Lesson 10</title>\r\n" + 
				"<link rel=\"stylesheet\"\r\n" + 
				"	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n" + 
				"	integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n" + 
				"	crossorigin=\"anonymous\">\r\n" + 
				"<style>\r\n" + 
				"body {\r\n" + 
				"	padding: 0;\r\n" + 
				"	margin: 0;\r\n" + 
				"	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n" + 
				"	min-height: 100vh;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".container {\r\n" + 
				"	width: 1280px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"footer {\r\n" + 
				"	position: fixed;\r\n" + 
				"	left: 0;\r\n" + 
				"	bottom: 0;\r\n" + 
				"	width: 100%;\r\n" + 
				"}\r\n" + 
				"</style>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<header>\r\n" + 
				"		<nav\r\n" + 
				"			class=\"navbar navbar-expand-lg navbar-dark bg-primary primary-color\">\r\n" + 
				"			<a class=\"navbar-brand\" href=\"#\">CS427-WAP::Lab10</a>\r\n" + 
				"			<div class=\"collapse navbar-collapse\" id=\"basicExampleNav\">\r\n" + 
				"				<ul class=\"navbar-nav mr-auto\">\r\n" + 
				"					<li class=\"nav-item active\"><a class=\"nav-link\" href=\"home\">Home\r\n" + 
				"							<span class=\"sr-only\">(current)</span>\r\n" + 
				"					</a></li>\r\n" + 
				"					<li class=\"nav-item\"><a class=\"nav-link\" href=\"contactus\">Contact</a>\r\n" + 
				"					</li>\r\n" + 
				"				</ul>\r\n" + 
				"				<form class=\"form-inline\">\r\n" + 
				"					<div class=\"md-form my-0\">\r\n" + 
				"						<input class=\"form-control mr-sm-2\" type=\"text\"\r\n" + 
				"							placeholder=\"Search\" aria-label=\"Search\">\r\n" + 
				"					</div>\r\n" + 
				"				</form>\r\n" + 
				"			</div>\r\n" + 
				"		</nav>\r\n" + 
				"	</header>\r\n" + 
				"	<div class=\"container\">\r\n" + 
				"		<div class=\"card mt-5\">		 \r\n" + 
				"		   <h2 class=\"card-header font-weight-light\">Thank you! Your message has been recieved as follows:</h2>\r\n" + 
				"		  	<div class=\"card-body\">\r\n" + 
				"			    <h4 class=\"card-title font-weight-light\">Name: "+name+"</h4>\r\n" + 
				"			    <p><span class=\"font-italic\">Gender&nbsp;&nbsp;&nbsp;&nbsp;</span>:  "+gender+"</p>\r\n" + 
				"			    <p><span class=\"font-italic\">Category </span>:  "+category+"</p>\r\n" + 
				"			    <p><span class=\"font-italic\">Message&nbsp;&nbsp;</span>:  "+message+"</p>\r\n" + 
				"			    <p>Please feel free to <a href=\"contactus\" class=\"\">Contact us</a> again.</p>\r\n" + 
				"		  </div>\r\n" + 
				"		</div>\r\n" + 
				"		<p class=\"mt-3\">Hit count for this page:"+this.pageCounter+"</p>\r\n" + 
				"	    <p>Total hit count for the entiry web app:"+totalCount+"</p>\r\n" + 
				"	</div>\r\n" + 
				"	<footer class=\"bg-secondary text-white mt-4\">\r\n" + 
				"		<div class=\"container-fluid py-3\">\r\n" + 
				"			<div class=\"row\">\r\n" + 
				"				<div class=\"col-md-6\">Davaabayar.B ::SC-WAP</div>\r\n" + 
				"				<div class=\"col-md-6 text-right align-self-end\">@November 2019</div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"	</footer>\r\n" + 
				"</body>\r\n" + 
				"</html>";
	}

}

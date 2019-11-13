package edu.mum.cs.cs427.lab10;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contactus")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pageCounter;

	@Override
	public void init() throws ServletException {
		super.init();
		pageCounter = 0;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("contact servlet do get:");
		pageCounter++;
		Map errs = new HashMap<String, String>();
		String[] fields = { "name", "gender", "category", "message" };
		for (String field : fields) {
			errs.put(field, "");
		}
		PrintWriter writer = response.getWriter();
		String htmlResponse = this.builtHtml(errs, fields,
				Integer.parseInt(request.getAttribute("totalHit").toString()));
		writer.println(htmlResponse);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public static String capitalize(String str) {
		if (str == null)
			return str;
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map errs = new HashMap<String, String>();
		String[] fields = { "name", "gender", "category", "message" };
		for (String field : fields) {
			errs.put(field, "");
			if (request.getParameter(field) == null || request.getParameter(field).trim().isEmpty()) {
				errs.put(field, "<div style=\"color:red; font-style:italic; font-size:14px;\">" + this.capitalize(field)
						+ " should not be empty.</div>");
			}
		}
		pageCounter++;
		PrintWriter writer = response.getWriter();
		String htmlResponse = this.builtHtml(errs, fields,
				Integer.parseInt(request.getAttribute("totalHit").toString()));
		writer.println(htmlResponse);
	}

	public String builtHtml(Map errs, String[] fields, int totalHit) {
		return "<!DOCTYPE html>\r\n" + "<html lang=\"en\">\r\n" + "\r\n" + "<head>\r\n"
				+ "    <title>Contact us</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n"
				+ "        integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n"
				+ "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js\"></script>\r\n"
				+ "    <style>\r\n" + "        body {\r\n" + "            padding: 0;\r\n"
				+ "            margin: 0;\r\n"
				+ "            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;\r\n" + "        }\r\n"
				+ "\r\n" + "        .container {\r\n" + "            width: 1280px;\r\n" + "        }\r\n" + "\r\n"
				+ "        h1 {\r\n" + "            margin-top: 40px;\r\n" + "        }\r\n" + "\r\n"
				+ "        label,\r\n" + "        input[type=\"text\"] {\r\n" + "            display: block;\r\n"
				+ "            width: 100%;\r\n" + "        }\r\n" + "\r\n" + "        input[type=\"text\"],\r\n"
				+ "        input[type=\"password\"],\r\n" + "        select {\r\n" + "            font-size: 16px;\r\n"
				+ "            width: 100%;\r\n" + "            padding: 12px 15px;\r\n"
				+ "            border: 1px solid #ccc;\r\n" + "            border-radius: 4px;\r\n"
				+ "            box-sizing: border-box;\r\n" + "        }\r\n" + "\r\n" + "        label {\r\n"
				+ "            margin: 15px 0 5px 0;\r\n" + "        }\r\n" + "\r\n" + "        .mt40 {\r\n"
				+ "            margin-top: 40px;\r\n" + "        }\r\n" + "\r\n" + "        section h2 {\r\n"
				+ "            background: #007bff;\r\n" + "            color: #fff;\r\n"
				+ "            padding: 15px;\r\n" + "            border-radius: 8px 8px 0 0;\r\n"
				+ "            font-size: 20px;\r\n" + "            margin: 0;\r\n" + "        }\r\n" + "footer{\r\n"
				+ "	position: fixed;\r\n" + "   left: 0;\r\n" + "   bottom: 0;\r\n" + "   width: 100%;}"
				+ "    </style>\r\n" + "</head>\r\n" + "\r\n" + "<body>\r\n" + "<header>\r\n" + "		<nav\r\n"
				+ "			class=\"navbar navbar-expand-lg navbar-dark bg-primary primary-color\">\r\n"
				+ "			<a class=\"navbar-brand\" href=\"#\">CS427-WAP::Lab10</a>\r\n"
				+ "			<div class=\"collapse navbar-collapse\" id=\"basicExampleNav\">\r\n"
				+ "				<ul class=\"navbar-nav mr-auto\">\r\n"
				+ "					<li class=\"nav-item active\"><a class=\"nav-link\" href=\"home\">Home\r\n"
				+ "							<span class=\"sr-only\">(current)</span>\r\n"
				+ "					</a></li>\r\n"
				+ "					<li class=\"nav-item\"><a class=\"nav-link\" href=\"contactus\">Contact</a>\r\n"
				+ "					</li>\r\n" + "					</ul>\r\n"
				+ "				<form class=\"form-inline\">\r\n"
				+ "					<div class=\"md-form my-0\">\r\n"
				+ "						<input class=\"form-control mr-sm-2\" type=\"text\"\r\n"
				+ "							placeholder=\"Search\" aria-label=\"Search\">\r\n"
				+ "					</div>\r\n" + "				</form>\r\n" + "			</div>\r\n"
				+ "		</nav>\r\n" + "	</header><div class=\"container\">"
				+ "    <section><h1>Customer contact form</h1>\r\n"
				+ "        <form name=\"contactForm\" method=\"post\" action=\"process\">\r\n"
				+ "            <div class=\"row\">\r\n" + "                <div class=\"col-md-12\">\r\n"
				+ "                    <label for=\"name\">*Name</label>\r\n"
				+ "                    <input type=\"text\" name=\"name\" id=\"name\">\r\n" + errs.get(fields[0])
				+ "                </div>\r\n" + "                <div class=\"col-md-12\">\r\n"
				+ "                    <label for=\"gender\">*Gender</label>\r\n"
				+ "<div class=\"custom-control custom-radio custom-control-inline\">\r\n"
				+ "  <input type=\"radio\" class=\"custom-control-input\" id=\"defaultInline1\" name=\"gender\" value=\"male\">\r\n"
				+ "  <label class=\"custom-control-label\" for=\"defaultInline1\">Male</label>\r\n" + "</div>"
				+ "<div class=\"custom-control custom-radio custom-control-inline\">\r\n"
				+ "  <input type=\"radio\" class=\"custom-control-input\" id=\"defaultInline2\" name=\"gender\" value=\"female\">\r\n"
				+ "  <label class=\"custom-control-label\" for=\"defaultInline2\">Female</label>\r\n" + "</div>"
				+ errs.get(fields[1]) + "                </div>\r\n" + "                <div class=\"col-md-12\">\r\n"
				+ "                    <label for=\"category\">*Category</label>\r\n"
				+ "                    <select name=\"category\" id=\"category\">\r\n"
				+ "						<option value=\"\" ></option>"
				+ "                    	<option value=\"Feedback\">Feedback</option>\r\n"
				+ "                    	<option value=\"Inquiry\">Inquiry</option>\r\n"
				+ "                    	<option value=\"Complaint\">Complaint</option>\r\n"
				+ "                    </select>\r\n" + errs.get(fields[2]) + "                </div>\r\n"
				+ "                <div class=\"col-md-12\">\r\n"
				+ "                    <label for=\"messsage\">*Message</label>\r\n"
				+ "                    <textarea class=\"form-control\" id=\"message\" rows=\"3\" name=\"message\"></textarea>             \r\n"
				+ errs.get(fields[3]) + "                </div>\r\n" + "            </div>\r\n"
				+ "            <button id=\"submitBtn\" type=\"submit\" class=\"btn btn-lg btn-primary mt40\">Submit</button>\r\n"
				+ "        </form>             \r\n" + "<p class=\"mt-5\">Hit count for this page: " + pageCounter
				+ "</p>" + "<p>Total hit count for the entiry web app: " + totalHit + "</p>"
				+ "</section></div>   \r\n<footer class=\"bg-secondary text-white mt-4\">\r\n"
				+ "    <div class=\"container-fluid py-3\">        \r\n" + "        <div class=\"row\">\r\n"
				+ "            <div class=\"col-md-6\">Davaabayar.B ::SC-WAP</div>          \r\n"
				+ "            <div class=\"col-md-6 text-right align-self-end\">@November 2019</div>\r\n"
				+ "        </div>\r\n" + "    </div>\r\n" + "</footer>" + "</body>\r\n" + "</html>";
	}
}

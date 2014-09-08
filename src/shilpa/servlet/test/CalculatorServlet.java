package shilpa.servlet.test;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.math.*;
import java.util.ArrayList;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");
        
       // String result = param1+ " desc= " + param2;
       // response.getWriter().write(result);
        
       // String responseResult = "HELLO "+ param1+param2;
        //System.out.println(param1);
        YelpParser woo = new YelpParser();
        ArrayList<NameLinkPair> names = woo.parse("http://www.yelp.com/search?find_desc="+param1+"&find_loc="+param2);
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8"); 
        for (NameLinkPair name: names)
        	response.getWriter().write(name.getName()+"\n");
        
	}


}

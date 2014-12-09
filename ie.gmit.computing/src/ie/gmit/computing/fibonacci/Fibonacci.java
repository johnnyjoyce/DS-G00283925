package ie.gmit.computing.fibonacci;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Fibonacci extends HttpServlet {
 public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
	
		PrintWriter w = resp.getWriter();
		
		String input = req.getParameter("input");
		
		if((input == null) || (input.length() == 0)){
			w.println("{\"exception\":\"no input\"}");
			return;
		}
		
	    try
	    {
	      // the String to int conversion happens here
	      int in = Integer.parseInt(input);
	      int result = 0;
	      
	      if(in <= 1){
	    	result = in;  
	      }else{
		      int[] fibs = new int[in + 1];
		      
		      fibs[0] = 0;
		      fibs[1] = 1;

		      for(int i = 2; i < in + 1; ++i){
		    	  fibs[i] = fibs[i - 1] + fibs[i - 2];
		      }
	    	  result = fibs[in];
	      }
		    // print out the value after the conversion
		    w.println("{\"result\":" + result + "}");
	    }
	    catch (NumberFormatException nfe)
	    {
	      w.println("{\"exception\":" + nfe.getMessage() + "}");
	    }
	    
	}
}
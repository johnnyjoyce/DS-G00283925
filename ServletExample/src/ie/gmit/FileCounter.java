package ie.gmit;

import ie.gmit.servlet.FileDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FileCounter
 */

@WebServlet("/FileCounter")
public class FileCounter extends HttpServlet {
  private static final long serialVersionUID = 1L;
  private FibService fs;
  
  int count;
  private FileDao dao;

  public void init() throws ServletException {
    dao = new FileDao();
    fs = new FibService();
    try 
    {
    	Fibonacci fibonacci = new Fibonacci(1099);
    	LocateRegistry .createRegistry(1099);
    	Naming.bind("fibo", fibonacci);
    	count = dao.getCount();
    }
    catch (Exception e) 
    {
      getServletContext().log("An exception occurred in FileCounter", e);
      throw new ServletException("An exception occurred in FileCounter"
          + e.getMessage());
    }
  }
  
  public void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException 
  { 
	  String rType = request.getParameter("request-Type");
	  System.out.println(rType);
	  
	  if(rType.equals("Add"))
	  {
		  String jobNum = "";
		  jobNum += fs.add(Integer.parseInt(request.getParameter("max")));
		  request.setAttribute("jobNum", jobNum);
		  request.getRequestDispatcher("FibRequest.jsp").forward(request, response);
	  }
	  else if(rType.equals("poll"))
	  {
		  
		  System.out.println("This is poll");
		  String result = null;
		  try
		  {
			  RemoteFibonacci remote = (RemoteFibonacci)Naming.lookup("rmi://localhost:1099/fibo");
			  System.out.println(request.getSession().getAttribute("max"));
			  result = remote.getFibonacci(Integer.valueOf(String.valueOf(request.getSession().getAttribute("max"))));
			  System.out.println(result);
			  request.setAttribute("result", result);
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		  
		  String jobNum = "";
		  try
		  {
			  jobNum += fs.add(Integer.parseInt(request.getParameter("jobNum")));
			  System.out.println(jobNum);
		  }
		  catch(Exception e)
		  {
			  e.getMessage();
		  }
		  request.getRequestDispatcher("FibonacciResults.jsp?result=" + result).forward(request, response);
	  	}
	 }
	  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	  {
		 doGet(req, resp); 
	  }
	  
	  public void destroy()
	  {
		 super.destroy();
		 try
		 {
			 dao.save(count);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	  }
 }
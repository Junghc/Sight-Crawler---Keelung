package sightCrawler;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class SightAPI
 */
@WebServlet("/SightAPI.do")
public class SightAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final boolean True = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SightAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("1"); 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		response.addHeader("Access-Control-Allow-Origin", "*");
        PrintWriter out = response.getWriter();
        
		String place = request.getParameter("zone");
		//out.println(place); 
		//System.out.println(place); 
		KeelungSightsCrawler crawler = new KeelungSightsCrawler();		
		Sight[] sights = null;
		
		sights = crawler.getItems(place);// 中山 中正 仁愛 安樂 信義 暖暖	
		
		/*
		
			String jsonString = "";
			for (Sight s: sights) {		
				
				//System.out.println(s);	
				GsonBuilder builder = new GsonBuilder(); 
				builder.setPrettyPrinting();
				Gson gson = builder.create(); 
				 jsonString += gson.toJson(s); 
				
			}*/
			
			GsonBuilder builder = new GsonBuilder(); 
			builder.setPrettyPrinting();
			Gson gson = builder.create(); 
			
			
			//out.println(jsonString); 			
			response.getWriter().write(gson.toJson(sights));
			//request.setAttribute("jsondata",jsonString);
			//request.getRequestDispatcher("result.jsp").forward(request, response);
			return;
			/*RequestDispatcher requestDispatcher; 
requestDispatcher = request.getRequestDispatcher("/thankYou.jsp");
requestDispatcher.forward(request, response);*/
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

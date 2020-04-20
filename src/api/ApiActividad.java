package api;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

/**
 * Servlet implementation class ApiActividad
 */
@WebServlet("/ApiActividad")
public class ApiActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int id = Integer.parseInt(request.getParameter("id"));
		
		ModeloActividad mActividad = new ModeloActividad();
		Actividad actividad = mActividad.get(id);
		
		JSONObject jsonObject = new JSONObject(actividad);
		String jsonString = jsonObject.toString();
		
		PrintWriter out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "UTF8"), true);
		//PrintWriter out = response.getWriter();
		
		response.setHeader("Access-Control-Allow-Origin", "*"); //json deia denean ez da behar
		response.setContentType("application/json");     //erantzunaren MIME mota zein den zehazten du
		response.setCharacterEncoding("UTF-8");          //kodigikazioa zehazten du
		
		out.print(jsonString);
		out.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

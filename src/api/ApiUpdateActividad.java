package api;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

/**
 * Servlet implementation class ApiUpdateActividad
 */
@WebServlet("/ApiUpdateActividad")
public class ApiUpdateActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiUpdateActividad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String jsonActividad = request.getParameter("actividad");
		
		JSONObject jsonObject = new JSONObject(jsonActividad);
		
		Actividad actividad = new Actividad();
		actividad.setId(jsonObject.getInt("id"));
		actividad.setNombre(jsonObject.getString("nombre"));
			//data...
		Date fechaInicio = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			fechaInicio=formato.parse(jsonObject.getString("fechaInicio"));
		} catch (JSONException | ParseException e1) {
			e1.printStackTrace();
		}
		
		actividad.setFecha_inicio(fechaInicio);
		actividad.setDias(jsonObject.getString("dias"));
		actividad.setHoras(jsonObject.getInt("horas"));
		actividad.setMaxParticipantes(jsonObject.getInt("maxParticipantes"));
		actividad.setPrecio(jsonObject.getDouble("precio"));
		
		ModeloActividad mActividad =  new ModeloActividad();
		mActividad.update(actividad);
		
		try {
			mActividad.getConexion().close();
		} catch (SQLException e) {
			System.out.println("Errorea conexioa ixtean");
			e.printStackTrace();
		}
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setCharacterEncoding("UTF-8");
	}

}

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

import org.json.JSONObject;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

/**
 * Servlet implementation class ApiCreateActividad
 */
@WebServlet("/ApiCreateActividad")
public class ApiCreateActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiCreateActividad() {
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
		//datuak jaso
		request.setCharacterEncoding("UTF-8");
		String jsonActividad = request.getParameter("actividad");
		
		System.out.println(jsonActividad);
		JSONObject jsonObject = new JSONObject(jsonActividad);
		
		Actividad actividad = new Actividad();
		actividad.setNombre(jsonObject.getString("nombre"));
			//data...
		Date fechaInicio = null;
		
		String fechaInicioParametro = jsonObject.getString("fechaInicio");
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechaInicio = formato.parse(request.getParameter("fechaInicio"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		actividad.setDias(jsonObject.getString("dias"));
		actividad.setHoras(jsonObject.getInt("horasSemana"));
		actividad.setHoras(jsonObject.getInt("maxParticipantes"));
		actividad.setPrecio(jsonObject.getDouble("precio"));
		
//		System.out.println(actividad.getNombre());
//		System.out.println(actividad.getFecha_inicio());
//		System.out.println(actividad.getDias());
//		System.out.println(actividad.getHoras());
//		System.out.println(actividad.getMaxParticipantes());
//		System.out.println(actividad.getPrecio());
		
		
	}

}

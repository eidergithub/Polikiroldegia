package api;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import modelo.bean.MiUsuario;
import modelo.dao.ModeloUsuario;

/**
 * Servlet implementation class ApiCreateUsuario
 */
@WebServlet("/ApiCreateUsuario")
public class ApiCreateUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiCreateUsuario() {
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
		request.setCharacterEncoding("UTF-8"); //eineak eta ondo irakurtzeko
		String jsonUsuario = request.getParameter("usuario");
		
		System.out.println(jsonUsuario);
		JSONObject jsonObject = new JSONObject(jsonUsuario);
		
		MiUsuario usuario = new MiUsuario();
		usuario.setNombreApellido(jsonObject.getString("nombreApellido"));
		usuario.setCodigo(jsonObject.getString("codigo"));
		usuario.setDni(jsonObject.getString("dni"));
		
		ModeloUsuario mUsuario = new ModeloUsuario();
		//validar
		if (usuario.validar()) { 
			//datuen luzeera ondo badago
			if (mUsuario.existDni(usuario.getDni()) || mUsuario.existCodigo(usuario.getCodigo())) { 
				//kodea eta NANa existitzen badira error
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Validar: Kodea edo NANa errepikatu da");
			} else { 
				//ez badira existitzen usuarioa gehitu
				mUsuario.insert(usuario);
				
				try {
					mUsuario.getConexion().close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			//datuak txarto sartu dira
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Validar: Datuak txarto sartu dira");
		}
			
		try {
			mUsuario.getConexion().close();
		} catch (SQLException e) {
			System.out.println("Errorea conexioa ixtean");
			e.printStackTrace();
		}
		
		response.setHeader("Access-Control-Allow-Origin","*"); 
		response.setCharacterEncoding("UTF-8");
	}

}

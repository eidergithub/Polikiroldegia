package modelo.bean;

public class MiUsuario extends Usuario{
	
	public boolean validar() {
		if (super.getDni().length()==9 && super.getCodigo().length()==4) {
			return true;
		} else {
			return false;
		}
	}
}

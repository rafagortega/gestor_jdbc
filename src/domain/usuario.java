package domain;

//Esta clase, la clase usuario, representa los objetos/registros de la bbdd y serán lo que usaremos para
//crear nuevos registros/objetos o modificarlos o extraerlos
public class usuario {
	private int id;
	private String usuario;
	private String password;
	
	public usuario() {
		
	}

	public usuario(int id) {
		super();
		this.id = id;
	}

	public usuario(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public usuario(int id,String usuario, String password) {
		super();
		this.id=id;
		this.usuario = usuario;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "usuario [id=" + id + ", usuario=" + usuario + ", password=" + password + "]";
	}
	
	
}

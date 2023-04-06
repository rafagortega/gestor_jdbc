package datos;

import java.sql.*;
import java.util.*;
import domain.usuario;

//la clase usuarioDAO es la clase donde definimos los metodos para manipulacion de los datos de la base de datos

public class usuarioDAO {
	
	private static final String SQL_SELECT="SELECT * FROM usuario";
	private static final String SQL_INSERT="INSERT INTO usuario(usuario_id,usuario,password) VALUES(?,?,?)";
	private static final String SQL_UPDATE="UPDATE usuario SET usuario= ?, password = ? WHERE usuario_id=?;";
	private static final String SQL_DELETE="DELETE FROM usuario WHERE usuario_id = ?;";
	
	
	//el metodo seleccionar devuelve una lista con todos usuarios
	public List<usuario> seleccionar(){
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		usuario usuario=null;
		List<usuario>clientes= new ArrayList<usuario>();
		
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(SQL_SELECT);
			rs=stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("usuario_id");
				String usuarioN = rs.getString("usuario");
				String password = rs.getString("password");
	
				
				usuario = new usuario(id,usuarioN,password);
				clientes.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				Conexion.close(rs);
				Conexion.close(stmt);
				Conexion.close(conn);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return clientes;
	}
	
	//devuelve un arraylist con los objetos de la consulta especifica
	public List<usuario> seleccionar(String consulta){
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		usuario usuario=null;
		List<usuario>clientes= new ArrayList<usuario>();
		
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(consulta);
			rs=stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("usuario_id");
				String usuarioN = rs.getString("usuario");
				String password = rs.getString("password");
	
				
				usuario = new usuario(id,usuarioN,password);
				clientes.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				Conexion.close(rs);
				Conexion.close(stmt);
				Conexion.close(conn);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return clientes;
	}
	
	//inserta el objeto que pasamos por parametro
	//devuelve 1 o 0 si se ha insertado o no respectivamente
	public int insertar(usuario usuario) {
		Connection conn=null;
		PreparedStatement stmt = null;
		int registros=0;
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(SQL_INSERT);
			stmt.setInt(1, usuario.getId());
			stmt.setString(2,usuario.getUsuario());
			stmt.setString(3, usuario.getPassword());
			
			registros=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return registros;
	}
	
	//si un objeto es cambiado, para que quede constancia en la bbdd hay que actualizarlo,
	//para ello mediante este metodo se pasa el objeto y en caso de existir su registro, se actualiza
	public int actualizar(usuario usuario) {
		Connection conn=null;
		PreparedStatement stmt = null;
		int registros=0;
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1,usuario.getUsuario());
			stmt.setString(2, usuario.getPassword());
			stmt.setInt(3, usuario.getId());
			registros=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return registros;
	}
	//si el objeto pasado por parametro existe en la bbdd, lo elimina
	//para ello comprueba si su id coincide con la primarykey
	public int eliminar(usuario usuario) {
		Connection conn=null;
		PreparedStatement stmt = null;
		int registros=0;
		try {
			conn=Conexion.getConnection();
			stmt=conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, usuario.getId());
			registros=stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Conexion.close(stmt);
				Conexion.close(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		return registros;

}
}

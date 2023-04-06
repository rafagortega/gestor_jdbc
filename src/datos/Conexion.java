package datos;

import java.sql.*;
//Esta clase es la que usaremos para acceder a nuestra bbdd mediante los metodos que nos ofrece la libreria jdbc
public class Conexion {
	private static final String nombreBBDD="basededatos";
	private static final String jdbc_url= "jdbc:mysql://localhost:3306/"+nombreBBDD+"?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
	private static final String jdbc_user="";
	private static final String jdbc_password="";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(jdbc_url, jdbc_user, jdbc_password);
	}
	
	public static void close(ResultSet rs) throws SQLException {
		rs.close();
	}
	
	public static void close(Statement smtm) throws SQLException {
		smtm.close();
	}
	
	public static void close(PreparedStatement smtm) throws SQLException {
		smtm.close();
	}
	
	public static void close(Connection conn) throws SQLException {
		conn.close();
	}
}

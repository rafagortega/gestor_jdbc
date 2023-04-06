package test;

import java.util.List;


import datos.usuarioDAO;

import domain.usuario;

public class TestManejoUsuarios {

	public static void main(String[] args) {
		usuarioDAO usuariodao=new usuarioDAO();
		
		//insertando un objeto en la base de datos
		usuario usuarioInsertado= new usuario(16,"User","Password");
		usuariodao.insertar(usuarioInsertado);
		usuarioInsertado.setUsuario("NuevoNombre");
		usuarioInsertado.setPassword("NuevoTel");
		usuariodao.actualizar(usuarioInsertado);
		List<usuario> usuarios = usuariodao.seleccionar();
		for(usuario cliente:usuarios){
			System.out.println(cliente);
			
		}
		
		usuariodao.eliminar(usuarioInsertado);
		usuarios = usuariodao.seleccionar();
		for(usuario cliente:usuarios){
			System.out.println(cliente);
			
		}
		
	}

}

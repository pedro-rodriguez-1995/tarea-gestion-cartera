package com.sinensia.business;

import java.sql.SQLException;
import java.util.List;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetAll;
import com.sinensia.dao.UsuarioDao;
import com.sinensia.model.Usuario;

public class UsuarioLogic {

	public static int comprobarUsuario(String nombre, String password) throws SQLException {
		int idusuario = 0;
		IGetAll<Usuario> usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = usuarioDao.getAll();

		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equals(nombre) && usuario.getPassword().equals(password)) {
				idusuario = usuario.getIdusuario();
			}

		}

		return idusuario;
	}

	public static int insertarUsuario(String nombre, String password) throws SQLException {
		boolean existe = false;
		int idusuario = 0;
		IGetAll<Usuario> usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = usuarioDao.getAll();

		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equals(nombre)) {
				existe = true;
			}

		}
		if (!existe) {
			IAdd<Usuario> usuarioDao1 = new UsuarioDao();
			Usuario newusuario = new Usuario();
			newusuario.setNombre(nombre);
			newusuario.setPassword(password);
			idusuario = usuarioDao1.add(newusuario);

		}

		return idusuario;
	}

}

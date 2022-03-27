package com.sinensia.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetAll;
import com.sinensia.dao.UsuarioDao;
import com.sinensia.model.Usuario;

public class UsuarioLogic {

	public int comprobarUsuario(String nombre, String password, String method) throws SQLException {
		int idusuario = 0;
		IGetAll<Usuario> usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = new ArrayList<Usuario>();

		if (method.equals("stored")) {
			usuarios = usuarioDao.getAllStored();
		} else {
			usuarios = usuarioDao.getAll();
		}

		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equals(nombre) && usuario.getPassword().equals(password)) {
				idusuario = usuario.getIdusuario();
			}

		}

		return idusuario;
	}

	public int insertarUsuario(String nombre, String password, String method) throws SQLException {
		boolean existe = false;
		int idusuario = 0;
		IGetAll<Usuario> usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = new ArrayList<Usuario>();

		if (method.equals("stored")) {
			usuarios = usuarioDao.getAllStored();
		} else {
			usuarios = usuarioDao.getAll();
		}

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

			if (method.equals("stored")) {
				idusuario = usuarioDao1.addStored(newusuario);
			} else {
				idusuario = usuarioDao1.add(newusuario);
			}

		}

		return idusuario;
	}

}

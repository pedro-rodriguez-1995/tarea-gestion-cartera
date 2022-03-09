package com.sinensia.dao;

import java.sql.SQLException;
import java.util.List;

import com.sinensia.model.Usuario;

public class UsuarioDao extends BaseDao implements IDao<Usuario> {

	@Override
	public int add(Usuario usuario) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(Usuario usuario) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Usuario> get() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.sinensia.dao;
import java.sql.SQLException;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetById;
import com.sinensia.model.Usuario;
public class UsuarioDao extends BaseDao implements IAdd<Usuario> , IGetById<Usuario> {

	@Override
	public int add(Usuario modelo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario getById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	


}

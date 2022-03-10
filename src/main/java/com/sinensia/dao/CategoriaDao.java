package com.sinensia.dao;

import java.sql.SQLException;
import java.util.List;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetAll;


import com.sinensia.model.Categoria;

public class CategoriaDao extends BaseDao implements IAdd<Categoria>, IGetAll<Categoria>  {

	@Override
	public List<Categoria> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Categoria modelo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	

	

	
	
}

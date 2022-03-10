package com.sinensia.dao;

import java.sql.SQLException;
import java.util.List;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetAll;
import com.sinensia.contract.IRemove;
import com.sinensia.contract.IModify;

import com.sinensia.model.Categoria;

public class CategoriaDao extends BaseDao implements IAdd<Categoria>, IRemove<Categoria>, IGetAll<Categoria> ,IModify<Categoria> {

	@Override
	public List<Categoria> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int remove(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int add(Categoria modelo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modify(Categoria modelo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
	
}

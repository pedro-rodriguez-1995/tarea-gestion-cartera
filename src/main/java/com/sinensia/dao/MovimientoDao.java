package com.sinensia.dao;
import java.sql.SQLException;
import java.util.List;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetByUserId;
import com.sinensia.contract.IRemove;
import com.sinensia.contract.IModify;

import com.sinensia.model.Movimiento;
public class MovimientoDao extends BaseDao implements IAdd<Movimiento>, IGetByUserId<Movimiento>, IRemove<Movimiento>, IModify<Movimiento>  {

	@Override
	public int modify(Movimiento modelo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Movimiento> getByUserId(int userid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Movimiento modelo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	

}

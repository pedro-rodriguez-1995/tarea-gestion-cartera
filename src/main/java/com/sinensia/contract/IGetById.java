package com.sinensia.contract;

import java.sql.SQLException;

public interface IGetById<T> {
	public T getById(int id) throws SQLException;
}

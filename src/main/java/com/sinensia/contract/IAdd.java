package com.sinensia.contract;

import java.sql.SQLException;

public interface IAdd<T> {

	public int add(T modelo) throws SQLException;

	public int addStored(T modelo) throws SQLException;
}

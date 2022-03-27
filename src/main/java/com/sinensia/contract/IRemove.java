package com.sinensia.contract;

import java.sql.SQLException;

public interface IRemove<T> {

	public int remove(int id) throws SQLException;

	public int removeStored(int id) throws SQLException;
}

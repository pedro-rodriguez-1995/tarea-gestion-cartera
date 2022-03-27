package com.sinensia.contract;

import java.sql.SQLException;
import java.util.List;

public interface IGetAll<T> {
	public List<T> getAll() throws SQLException;

	public List<T> getAllStored() throws SQLException;
}

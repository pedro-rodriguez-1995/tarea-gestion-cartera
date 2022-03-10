package com.sinensia.contract;

import java.sql.SQLException;

public interface IRemove<T> {

	public int remove(int id) throws SQLException;
}

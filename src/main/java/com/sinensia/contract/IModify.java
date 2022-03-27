package com.sinensia.contract;

import java.sql.SQLException;

public interface IModify<T> {
	public int modify(T modelo) throws SQLException;

	public int modifyStored(T modelo) throws SQLException;
}

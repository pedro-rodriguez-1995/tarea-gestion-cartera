package com.sinensia.contract;

import java.sql.SQLException;
import java.util.List;

public interface IGetByUserId<T> {
	public List<T> getByUserId(int userid) throws SQLException;
}

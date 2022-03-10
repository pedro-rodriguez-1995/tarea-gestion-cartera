package com.sinensia.contract;

import java.sql.SQLException;
import java.util.List;

public interface IGetByUserIdAndCategoryId <T>{
	public List<T> getByUserIdAndCategoryId(int userid, int categoryid) throws SQLException;
}

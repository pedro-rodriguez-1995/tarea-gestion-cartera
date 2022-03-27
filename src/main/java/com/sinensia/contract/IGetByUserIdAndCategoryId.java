package com.sinensia.contract;

import java.sql.SQLException;
import java.util.List;

public interface IGetByUserIdAndCategoryId<T> {
	public List<T> getByUserIdAndCategoryId(int userid, int categoryid) throws SQLException;

	public List<T> getByUserIdAndCategoryIdPag(int userid, int categoryid, int start, int recordsPerPage)
			throws SQLException;

	public List<T> getByUserIdAndCategoryIdStored(int userid, int categoryid) throws SQLException;

	public List<T> getByUserIdAndCategoryIdPagStored(int userid, int categoryid, int start, int recordsPerPage)
			throws SQLException;
}

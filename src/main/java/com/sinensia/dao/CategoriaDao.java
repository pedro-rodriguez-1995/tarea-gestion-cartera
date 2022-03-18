package com.sinensia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sinensia.contract.IGetAll;
import com.sinensia.model.Categoria;

public class CategoriaDao extends BaseDao implements IGetAll<Categoria> {
	private Connection connection;

	@Override
	public List<Categoria> getAll() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();

		PreparedStatement preparedStatement = null;

		try {
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM categorias");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int idcategoria = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				String url = resultSet.getString("url");
				String tipo = resultSet.getString("tipo");
				categorias.add(new Categoria(idcategoria, url, nombre, tipo, null));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
		}
		if (connection != null) {
			connection.close();
		}
		return categorias;
	}

}

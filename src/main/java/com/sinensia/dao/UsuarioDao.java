package com.sinensia.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetAll;
import com.sinensia.contract.IGetById;
import com.sinensia.model.Usuario;

public class UsuarioDao extends BaseDao implements IAdd<Usuario>, IGetById<Usuario>, IGetAll<Usuario> {
	private Connection connection;

	@Override
	public int add(Usuario usuario) throws SQLException {

		int idUsuario = 0;
		PreparedStatement preparedStatement = null;
		ResultSet rsKey = null;
		try {
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement("INSERT INTO usuarios (nombre, password) VALUE (?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getPassword());

			preparedStatement.executeUpdate();

			rsKey = preparedStatement.getGeneratedKeys();
			rsKey.next();
			idUsuario = rsKey.getInt(1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null)
				preparedStatement.close();
			if (rsKey != null)
				rsKey.close();
			if (connection != null)
				connection.close();
		}
		return idUsuario;
	}

	@Override
	public Usuario getById(int id) throws SQLException {
		Usuario usuario = null;

		PreparedStatement preparedStatement = null;

		try {
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM usuarios WHERE id = ?");

			preparedStatement.setString(1, Integer.toString(id));
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int idusuario = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				String password = resultSet.getString("password");

				usuario = new Usuario(idusuario, nombre, password, null);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return usuario;
	}

	@Override
	public List<Usuario> getAll() throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		PreparedStatement preparedStatement = null;

		try {
			connection = super.getConnection();
			preparedStatement = connection.prepareStatement("SELECT * FROM usuarios");

			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int idusuario = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				String password = resultSet.getString("password");

				usuarios.add(new Usuario(idusuario, nombre, password, null));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return usuarios;
	}

	@Override
	public List<Usuario> getAllStored() throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();

		CallableStatement callableStatement = null;

		try {
			connection = super.getConnection();
			callableStatement = connection.prepareCall("{call getAllUser()}");

			ResultSet resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
				int idusuario = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				String password = resultSet.getString("password");

				usuarios.add(new Usuario(idusuario, nombre, password, null));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return usuarios;
	}

	@Override
	public Usuario getByIdStored(int id) throws SQLException {
		Usuario usuario = null;

		CallableStatement callableStatement = null;

		try {
			connection = super.getConnection();
			callableStatement = connection.prepareCall("{call getByIdUser(?)}");

			callableStatement.setString(1, Integer.toString(id));
			ResultSet resultSet = callableStatement.executeQuery();
			if (resultSet.next()) {
				int idusuario = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				String password = resultSet.getString("password");

				usuario = new Usuario(idusuario, nombre, password, null);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (callableStatement != null) {
				callableStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

		return usuario;
	}

	@Override
	public int addStored(Usuario usuario) throws SQLException {
		int idUsuario = 0;
		CallableStatement callableStatement = null;
		ResultSet rsKey = null;
		try {
			connection = super.getConnection();
			callableStatement = connection.prepareCall("{call addUser(?,?,?)}");

			callableStatement.setString(1, usuario.getNombre());
			callableStatement.setString(2, usuario.getPassword());
			callableStatement.registerOutParameter(3, Types.INTEGER);
			callableStatement.executeUpdate();
			idUsuario = callableStatement.getInt(3);

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (callableStatement != null)
				callableStatement.close();
			if (rsKey != null)
				rsKey.close();
			if (connection != null)
				connection.close();
		}
		return idUsuario;
	}

}

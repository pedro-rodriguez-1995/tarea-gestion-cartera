package com.sinensia.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetById;
import com.sinensia.contract.IGetByUserId;
import com.sinensia.contract.IGetByUserIdAndCategoryId;
import com.sinensia.contract.IModify;
import com.sinensia.contract.IRemove;
import com.sinensia.model.Movimiento;

public class MovimientoDao extends BaseDao implements IAdd<Movimiento>, IGetByUserId<Movimiento>, IRemove<Movimiento>,
		IModify<Movimiento>, IGetByUserIdAndCategoryId<Movimiento>, IGetById<Movimiento> {

	private Connection connect;

	@Override
	public int modify(Movimiento movimiento) throws SQLException {
		int rows = 0;
		PreparedStatement preparedStatement = null;
		ResultSet rsKey = null;
		try {
			connect = super.getConnection();
			preparedStatement = connect
					.prepareStatement("UPDATE movimientos SET tipo = ?, importe = ? , fecha = ? WHERE id = ?");

			preparedStatement.setString(1, movimiento.getTipo());
			preparedStatement.setString(2, movimiento.getImporte().toString());
			preparedStatement.setString(3, movimiento.getFecha().toString());
			preparedStatement.setString(4, Integer.toString(movimiento.getIdmovimiento()));

			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (rsKey != null) {
				rsKey.close();

			}
			if (connect != null) {
				connect.close();
			}

		}

		return rows;
	}

	@Override
	public int remove(int id) throws SQLException {
		int row = 0;
		PreparedStatement preparedStatement = null;
		ResultSet rsKey = null;
		try {
			connect = super.getConnection();
			preparedStatement = connect.prepareStatement("DELETE FROM movimientos WHERE id = ?");

			preparedStatement.setString(1, Integer.toString(id));

			row = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (rsKey != null) {
				rsKey.close();

			}
			if (connect != null) {
				connect.close();
			}

		}

		return row;
	}

	@Override
	public List<Movimiento> getByUserId(int userid) throws SQLException {
		List<Movimiento> listamovimientos = new ArrayList<Movimiento>();

		PreparedStatement preparedStatement = null;

		try {
			connect = super.getConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM movimientos WHERE idUsuario = ?");
			preparedStatement.setString(1, Integer.toString(userid));
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int idmovimiento = resultSet.getInt("id");
				int idusuario = resultSet.getInt("idUsuario");
				int idcategoria = resultSet.getInt("idcategoria");
				String tipo = resultSet.getString("tipo");
				BigDecimal importe = resultSet.getBigDecimal("importe");
				LocalDate fecha = LocalDate.parse(resultSet.getString("fecha"));

				Movimiento movimiento = new Movimiento(idmovimiento, idusuario, importe, idcategoria, tipo, fecha);

				listamovimientos.add(movimiento);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connect != null) {
				connect.close();
			}
		}

		return listamovimientos;
	}

	@Override
	public int add(Movimiento movimiento) throws SQLException {
		int idmovimiento = 0;
		PreparedStatement preparedStatement = null;
		ResultSet rsKey = null;
		try {
			connect = super.getConnection();
			preparedStatement = connect.prepareStatement(
					"INSERT INTO movimientos (idUsuario,idCategoria,tipo,importe,fecha) VALUE (?,?,?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, Integer.toString(movimiento.getIdusuario()));
			preparedStatement.setString(2, Integer.toString(movimiento.getIdcategoria()));
			preparedStatement.setString(3, movimiento.getTipo());
			preparedStatement.setString(4, movimiento.getImporte().toString());
			preparedStatement.setString(5, movimiento.getFecha().toString());

			preparedStatement.executeUpdate();
			rsKey = preparedStatement.getGeneratedKeys();

			rsKey.next();
			idmovimiento = rsKey.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (rsKey != null) {
				rsKey.close();

			}
			if (connect != null) {
				connect.close();
			}

		}

		return idmovimiento;
	}

	@Override
	public List<Movimiento> getByUserIdAndCategoryId(int userid, int categoriaid) throws SQLException {
		List<Movimiento> listamovimientos = new ArrayList<Movimiento>();

		PreparedStatement preparedStatement = null;

		try {
			connect = super.getConnection();
			preparedStatement = connect
					.prepareStatement("SELECT * FROM movimientos WHERE idUsuario = ? AND idCategoria = ?");
			preparedStatement.setString(1, Integer.toString(userid));
			preparedStatement.setString(2, Integer.toString(categoriaid));
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int idmovimiento = resultSet.getInt("id");
				int idusuario = resultSet.getInt("idUsuario");
				int idcategoria = resultSet.getInt("idcategoria");
				String tipo = resultSet.getString("tipo");
				BigDecimal importe = resultSet.getBigDecimal("importe");
				LocalDate fecha = LocalDate.parse(resultSet.getString("fecha"));

				Movimiento movimiento = new Movimiento(idmovimiento, idusuario, importe, idcategoria, tipo, fecha);

				listamovimientos.add(movimiento);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connect != null) {
				connect.close();
			}
		}

		return listamovimientos;
	}

	@Override
	public Movimiento getById(int id) throws SQLException {
		Movimiento movimiento = null;

		PreparedStatement preparedStatement = null;

		try {
			connect = super.getConnection();
			preparedStatement = connect.prepareStatement("SELECT * FROM movimientos WHERE id = ?");

			preparedStatement.setString(1, Integer.toString(id));
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int idmovimiento = resultSet.getInt("id");
				int idusuario = resultSet.getInt("idUsuario");
				int idcategoria = resultSet.getInt("idcategoria");
				String tipo = resultSet.getString("tipo");
				BigDecimal importe = resultSet.getBigDecimal("importe");
				LocalDate fecha = LocalDate.parse(resultSet.getString("fecha"));

				movimiento = new Movimiento(idmovimiento, idusuario, importe, idcategoria, tipo, fecha);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connect != null) {
				connect.close();
			}
		}

		return movimiento;
	}

	@Override
	public List<Movimiento> getByUserIdAndCategoryIdPag(int userid, int categoriaid, int currentPage,
			int recordsPerPage) throws SQLException {
		List<Movimiento> listamovimientos = new ArrayList<Movimiento>();
		int start = currentPage * recordsPerPage - recordsPerPage;
		PreparedStatement preparedStatement = null;

		try {
			connect = super.getConnection();
			preparedStatement = connect
					.prepareStatement("SELECT * FROM movimientos WHERE idUsuario = ? AND idCategoria = ? LIMIT ?, ?");
			preparedStatement.setString(1, Integer.toString(userid));
			preparedStatement.setString(2, Integer.toString(categoriaid));
			preparedStatement.setInt(3, start);
			preparedStatement.setInt(4, recordsPerPage);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int idmovimiento = resultSet.getInt("id");
				int idusuario = resultSet.getInt("idUsuario");
				int idcategoria = resultSet.getInt("idcategoria");
				String tipo = resultSet.getString("tipo");
				BigDecimal importe = resultSet.getBigDecimal("importe");
				LocalDate fecha = LocalDate.parse(resultSet.getString("fecha"));

				Movimiento movimiento = new Movimiento(idmovimiento, idusuario, importe, idcategoria, tipo, fecha);

				listamovimientos.add(movimiento);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connect != null) {
				connect.close();
			}
		}

		return listamovimientos;
	}

}

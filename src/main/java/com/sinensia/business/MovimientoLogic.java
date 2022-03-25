package com.sinensia.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetByUserId;
import com.sinensia.contract.IGetByUserIdAndCategoryId;
import com.sinensia.contract.IRemove;
import com.sinensia.dao.MovimientoDao;
import com.sinensia.model.Movimiento;

public class MovimientoLogic {

	public List<Movimiento> listarMovimientosCategoria(int idusuario, int idcategoria, int mes) throws SQLException {
		IGetByUserIdAndCategoryId<Movimiento> movimientoDao = new MovimientoDao();
		List<Movimiento> listamovmes = movimientoDao.getByUserIdAndCategoryId(idusuario, idcategoria);
		for (Movimiento movimiento : listamovmes) {

			if (movimiento.getFecha().getMonthValue() != mes) {
				listamovmes.remove(movimiento);
			}

		}
		return listamovmes;

	}

	public BigDecimal totalMovimientos(int idusuario, int mes) throws SQLException {
		IGetByUserId<Movimiento> movimientoDao = new MovimientoDao();
		List<Movimiento> listamovimientos = movimientoDao.getByUserId(idusuario);
		BigDecimal total = new BigDecimal(0);
		for (Movimiento movimiento : listamovimientos) {
			if (movimiento.getFecha().getMonthValue() == mes) {
				if (movimiento.getTipo().equals("ingreso")) {
					total = total.add(movimiento.getImporte());
				} else {
					total = total.subtract(movimiento.getImporte());
				}
			}
		}
		return total;
	}

	public BigDecimal totalMovimientosCategoria(int idusuario, int idcategoria, int mes) throws SQLException {
		IGetByUserIdAndCategoryId<Movimiento> movimientoDao = new MovimientoDao();
		List<Movimiento> listamovimientos = movimientoDao.getByUserIdAndCategoryId(idusuario, idcategoria);
		BigDecimal total = new BigDecimal(0);
		for (Movimiento movimiento : listamovimientos) {
			if (movimiento.getFecha().getMonthValue() == mes) {
				if (movimiento.getTipo().equals("ingreso")) {
					total = total.add(movimiento.getImporte());
				} else {
					total = total.subtract(movimiento.getImporte());
				}
			}
		}
		return total;
	}

	public int insertarMovimiento(int idcategoria, int idusuario, BigDecimal importe, String tipo, LocalDate fecha)
			throws SQLException {
		IAdd<Movimiento> movimientoDao = new MovimientoDao();
		Movimiento movimiento = new Movimiento();
		movimiento.setIdcategoria(idcategoria);
		movimiento.setIdusuario(idusuario);
		movimiento.setImporte(importe);
		movimiento.setTipo(tipo);
		movimiento.setFecha(LocalDate.now());
		return movimientoDao.add(movimiento);

	}

	public int borrarMovimiento(int idmovimiento) throws SQLException {
		IRemove<Movimiento> movimientoDao = new MovimientoDao();
		return movimientoDao.remove(idmovimiento);
	}

	public List<Movimiento> listarMovimientosCategoriaPag(int idusuario, int idcategoria, int mes, int currentPage,
			int recordsPerPage) throws SQLException {
		IGetByUserIdAndCategoryId<Movimiento> movimientoDao = new MovimientoDao();
		List<Movimiento> listamovmes = movimientoDao.getByUserIdAndCategoryIdPag(idusuario, idcategoria, currentPage,
				recordsPerPage);
		for (Movimiento movimiento : listamovmes) {

			if (movimiento.getFecha().getMonthValue() != mes) {
				listamovmes.remove(movimiento);
			}

		}
		return listamovmes;

	}

	public int numOfPages(int rows, int recordsPerPage) {
		int nOfPages = rows / recordsPerPage;

		if (nOfPages % recordsPerPage > 0) {

			nOfPages++;
		}
		return nOfPages;
	}
}

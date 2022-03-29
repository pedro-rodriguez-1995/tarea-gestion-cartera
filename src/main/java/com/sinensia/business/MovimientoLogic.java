package com.sinensia.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetByUserId;
import com.sinensia.contract.IGetByUserIdAndCategoryId;
import com.sinensia.contract.IRemove;
import com.sinensia.dao.MovimientoDao;
import com.sinensia.model.Movimiento;

public class MovimientoLogic {

	public List<Movimiento> listarMovimientosCategoria(int idusuario, int idcategoria, int mes, String method)
			throws SQLException {
		IGetByUserIdAndCategoryId<Movimiento> movimientoDao = new MovimientoDao();
		List<Movimiento> listamovmes = new ArrayList<Movimiento>();

		if (method.equals("stored")) {
			listamovmes = movimientoDao.getByUserIdAndCategoryIdStored(idusuario, idcategoria);
		} else {
			listamovmes = movimientoDao.getByUserIdAndCategoryId(idusuario, idcategoria);
		}
		List<Movimiento> toRemove = new ArrayList<Movimiento>();
		for (Movimiento movimiento : listamovmes) {

			if (movimiento.getFecha().getMonthValue() != mes) {
				toRemove.add(movimiento);
			}

		}
		listamovmes.removeAll(toRemove);
		return listamovmes;

	}

	public BigDecimal totalMovimientos(int idusuario, int mes, String method) throws SQLException {
		IGetByUserId<Movimiento> movimientoDao = new MovimientoDao();
		List<Movimiento> listamovimientos = new ArrayList<Movimiento>();

		if (method.equals("stored")) {
			listamovimientos = movimientoDao.getByUserIdStored(idusuario);
		} else {
			listamovimientos = movimientoDao.getByUserId(idusuario);
		}

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

	public BigDecimal totalMovimientosCategoria(int idusuario, int idcategoria, int mes, String method)
			throws SQLException {
		IGetByUserIdAndCategoryId<Movimiento> movimientoDao = new MovimientoDao();
		List<Movimiento> listamovimientos = new ArrayList<Movimiento>();

		if (method.equals("stored")) {
			listamovimientos = movimientoDao.getByUserIdAndCategoryIdStored(idusuario, idcategoria);
		} else {
			listamovimientos = movimientoDao.getByUserIdAndCategoryId(idusuario, idcategoria);
		}

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

	public int insertarMovimiento(int idcategoria, int idusuario, BigDecimal importe, String tipo, LocalDate fecha,
			String method) throws SQLException {
		IAdd<Movimiento> movimientoDao = new MovimientoDao();
		int idmovimiento = 0;
		Movimiento movimiento = new Movimiento();
		movimiento.setIdcategoria(idcategoria);
		movimiento.setIdusuario(idusuario);
		movimiento.setImporte(importe);
		movimiento.setTipo(tipo);
		movimiento.setFecha(fecha);

		if (method.equals("stored")) {
			idmovimiento = movimientoDao.addStored(movimiento);
		} else {
			idmovimiento = movimientoDao.add(movimiento);
		}

		return idmovimiento;

	}

	public int borrarMovimiento(int idmovimiento, String method) throws SQLException {
		IRemove<Movimiento> movimientoDao = new MovimientoDao();
		int rows = 0;
		if (method.equals("stored")) {
			rows = movimientoDao.removeStored(idmovimiento);
		} else {
			rows = movimientoDao.remove(idmovimiento);
		}

		return rows;
	}

	public List<Movimiento> listarMovimientosCategoriaPag(int idusuario, int idcategoria, int mes, int currentPage,
			int recordsPerPage, String method) throws SQLException {

		int start = currentPage * recordsPerPage - recordsPerPage;
		IGetByUserIdAndCategoryId<Movimiento> movimientoDao = new MovimientoDao();
		List<Movimiento> listamovmes = new ArrayList<Movimiento>();

		if (method.equals("stored")) {
			listamovmes = movimientoDao.getByUserIdAndCategoryIdPagStored(idusuario, idcategoria, start,
					recordsPerPage);
		} else {
			listamovmes = movimientoDao.getByUserIdAndCategoryIdPag(idusuario, idcategoria, start, recordsPerPage);
			;
		}
		List<Movimiento> toRemove = new ArrayList<Movimiento>();
		for (Movimiento movimiento : listamovmes) {

			if (movimiento.getFecha().getMonthValue() != mes) {
				toRemove.add(movimiento);
			}

		}
		listamovmes.removeAll(toRemove);
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

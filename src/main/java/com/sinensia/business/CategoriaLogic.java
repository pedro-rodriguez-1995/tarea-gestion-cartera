package com.sinensia.business;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sinensia.contract.IGetAll;
import com.sinensia.contract.IGetByUserIdAndCategoryId;
import com.sinensia.dao.CategoriaDao;
import com.sinensia.dao.MovimientoDao;
import com.sinensia.model.Categoria;
import com.sinensia.model.Movimiento;

public class CategoriaLogic {

	public Map<Categoria, BigDecimal> listarCategoriasUsuarioTipo(int idusuario, int mes, String tipo, String method)
			throws SQLException {
		Map<Categoria, BigDecimal> mapcategoria = new HashMap<Categoria, BigDecimal>();
		IGetAll<Categoria> categoriaDao = new CategoriaDao();
		IGetByUserIdAndCategoryId<Movimiento> movimientoDao = new MovimientoDao();
		List<Categoria> listacategorias = new ArrayList<Categoria>();
		if (method.equals("stored")) {
			listacategorias = categoriaDao.getAllStored();
		} else {
			listacategorias = categoriaDao.getAll();
		}

		for (Categoria categoria : listacategorias) {
			if (categoria.getTipo().equals(tipo)) {

				if (method.equals("stored")) {
					categoria.setListamovimientos(
							movimientoDao.getByUserIdAndCategoryIdStored(idusuario, categoria.getIdcategoria()));

				} else {
					categoria.setListamovimientos(
							movimientoDao.getByUserIdAndCategoryId(idusuario, categoria.getIdcategoria()));

				}

				MovimientoLogic movlogic = new MovimientoLogic();
				BigDecimal totalcategoria = movlogic.totalMovimientosCategoria(idusuario, categoria.getIdcategoria(),
						mes, method);

				mapcategoria.put(categoria, totalcategoria);
			}
		}

		return mapcategoria;
	}

	public List<Categoria> listarCategoriasTipo(String tipo, String method) throws SQLException {
		IGetAll<Categoria> categoriaDao = new CategoriaDao();
		List<Categoria> listacategorias = new ArrayList<Categoria>();
		List<Categoria> listacategoriasf = new ArrayList<Categoria>();
		if (method.equals("stored")) {
			listacategorias = categoriaDao.getAllStored();
		} else {
			listacategorias = categoriaDao.getAll();
		}

		for (Categoria categoria : listacategorias) {
			if (categoria.getTipo().equals(tipo)) {
				listacategoriasf.add(categoria);
			}
		}

		return listacategoriasf;

	}
}

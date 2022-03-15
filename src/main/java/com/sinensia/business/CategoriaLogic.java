package com.sinensia.business;

import java.math.BigDecimal;
import java.sql.SQLException;
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

	public static Map<Categoria, BigDecimal> listarCategoriasUsuario(int idusuario, int mes) throws SQLException {
		Map<Categoria, BigDecimal> mapcategoria = new HashMap<Categoria, BigDecimal>();
		IGetAll<Categoria> categoriaDao = new CategoriaDao();
		IGetByUserIdAndCategoryId<Movimiento> movimientoDao = new MovimientoDao();
		List<Categoria> listacategorias = categoriaDao.getAll();

		for (Categoria categoria : listacategorias) {
			categoria
					.setListamovimientos(movimientoDao.getByUserIdAndCategoryId(idusuario, categoria.getIdcategoria()));

			BigDecimal totalcategoria = MovimientoLogic.totalMovimientosCategoria(idusuario, categoria.getIdcategoria(),
					mes);

			mapcategoria.put(categoria, totalcategoria);

		}

		return mapcategoria;
	}

	public static List<Categoria> listarCategorias() throws SQLException {
		IGetAll<Categoria> categoriaDao = new CategoriaDao();
		return categoriaDao.getAll();

	}
}

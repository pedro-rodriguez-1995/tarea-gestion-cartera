package com.sinensia.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetById;
import com.sinensia.contract.IGetByUserId;
import com.sinensia.contract.IGetByUserIdAndCategoryId;
import com.sinensia.contract.IModify;
import com.sinensia.contract.IRemove;
import com.sinensia.model.Movimiento;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimientoDaoTest {
	private static int idMovimiento = 0;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void test1Add() throws Exception {
        Movimiento movimiento = new Movimiento();
        IAdd<Movimiento> movimientoDao = new MovimientoDao();
        movimiento.setIdcategoria(5);
        movimiento.setIdusuario(5);
        movimiento.setImporte(new BigDecimal(500));
        movimiento.setTipo("gasto");
        movimiento.setFecha(LocalDate.now());
        idMovimiento = movimientoDao.add(movimiento);
        assertTrue(idMovimiento > 0);

    }
	@Test
	public void test2Modify() throws Exception {
		Movimiento movimiento = new Movimiento();
		IModify<Movimiento> movimientoDao = new MovimientoDao();
		movimiento.setTipo("ingreso");
		movimiento.setImporte(new BigDecimal(300));
		movimiento.setFecha(LocalDate.now().minusDays(1));
		movimiento.setIdmovimiento(idMovimiento);
		int rows = movimientoDao.modify(movimiento);
		assertTrue(rows > 0);
	}
	@Test
	public void test3GetByUserId() throws Exception {
		IGetByUserId<Movimiento> movimientoDao = new MovimientoDao();
		List<Movimiento> listaalumnos = movimientoDao.getByUserId(5);
		assertTrue(!listaalumnos.isEmpty());
	}
	
	@Test
	public void test4GetByUserIdAndCategoryId() throws Exception {
		IGetByUserIdAndCategoryId<Movimiento> movimientoDao = new MovimientoDao();
		List<Movimiento> listaalumnos = movimientoDao.getByUserIdAndCategoryId(5,5);
		assertTrue(!listaalumnos.isEmpty());
	}
	
	@Test
	public void test5GetById() throws Exception {
		IGetById<Movimiento> movimientoDao = new MovimientoDao();
		Movimiento movimiento = movimientoDao.getById(idMovimiento);
		assertTrue(movimiento !=null);
	}
	@Test
	public void test6Remove() throws Exception {
		IRemove<Movimiento> movimientoDao = new MovimientoDao();
		IGetById<Movimiento> movimientoDao2 = new MovimientoDao();
		movimientoDao.remove(idMovimiento);
		Movimiento movimiento = movimientoDao2.getById(5);
		assertTrue(movimiento ==null);
	}
}

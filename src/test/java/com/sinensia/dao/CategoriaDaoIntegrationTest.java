package com.sinensia.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sinensia.contract.IGetAll;
import com.sinensia.model.Categoria;

public class CategoriaDaoIntegrationTest {

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
	public void testGetAll() throws Exception {

		IGetAll<Categoria> categoriaDao = new CategoriaDao();
		List<Categoria> categorias = categoriaDao.getAll();
		assertTrue(!categorias.isEmpty());
	}

	@Test
	public void testGetAllStored() throws Exception {

		IGetAll<Categoria> categoriaDao = new CategoriaDao();
		List<Categoria> categorias = categoriaDao.getAllStored();
		assertTrue(!categorias.isEmpty());
	}

}

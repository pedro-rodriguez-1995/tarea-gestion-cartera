package com.sinensia.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sinensia.contract.IAdd;
import com.sinensia.contract.IGetAll;
import com.sinensia.contract.IGetById;
import com.sinensia.model.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDaoIntegrationTest {
	private static int idUsuario = 0;

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
		Usuario usuario = new Usuario();
		IAdd<Usuario> usuarioDao = new UsuarioDao();

		usuario.setNombre("Test");
		usuario.setPassword("passwdtest");
		idUsuario = usuarioDao.add(usuario);
		assertTrue(idUsuario > 0);
	}

	@Test
	public void test2GetById() throws Exception {
		IGetById<Usuario> usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.getById(idUsuario);
		assertTrue(usuario != null);
	}

	@Test
	public void test3GetAll() throws Exception {
		IGetAll<Usuario> usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = usuarioDao.getAll();
		assertTrue(!usuarios.isEmpty());
	}

	@Test
	public void test4AddStored() throws Exception {
		Usuario usuario = new Usuario();
		IAdd<Usuario> usuarioDao = new UsuarioDao();

		usuario.setNombre("TestStored");
		usuario.setPassword("passwdteststored");
		idUsuario = usuarioDao.addStored(usuario);
		assertTrue(idUsuario > 0);
	}

	@Test
	public void test5GetByIdStored() throws Exception {
		IGetById<Usuario> usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.getByIdStored(idUsuario);
		assertTrue(usuario != null);
	}

	@Test
	public void test6GetAll() throws Exception {
		IGetAll<Usuario> usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = usuarioDao.getAllStored();
		assertTrue(!usuarios.isEmpty());
	}

}

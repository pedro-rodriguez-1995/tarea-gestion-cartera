package com.sinensia.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.sinensia.contract.IAdd;
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
	public void test2GetById() throws Exception{
		IGetById<Usuario> usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.getById(idUsuario);
		assertTrue(usuario !=null);
	}

}

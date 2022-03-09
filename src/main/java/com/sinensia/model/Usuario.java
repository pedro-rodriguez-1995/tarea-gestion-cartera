package com.sinensia.model;

import java.util.List;

public class Usuario {
 private int idusuario;
 private String nombre;
 private String password;
 private List<Movimiento> listamovimientos;
public Usuario() {
}
public Usuario(int idusuario, String nombre, String password, List<Movimiento> listamovimientos) {
	this.idusuario = idusuario;
	this.nombre = nombre;
	this.password = password;
	this.listamovimientos = listamovimientos;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<Movimiento> getListamovimientos() {
	return listamovimientos;
}
public void setListamovimientos(List<Movimiento> listamovimientos) {
	this.listamovimientos = listamovimientos;
}
 
 
}

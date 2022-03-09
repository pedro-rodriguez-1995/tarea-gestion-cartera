package com.sinensia.model;

import java.util.List;

public class Categoria {
private int idcategoria;
private String urlimagen;
private String nombre;
private List<Movimiento> listamovimientos;
public Categoria() {
}
public Categoria(int idcategoria, String urlimagen, String nombre, List<Movimiento> listamovimientos) {
	this.idcategoria = idcategoria;
	this.urlimagen = urlimagen;
	this.nombre = nombre;
	this.listamovimientos = listamovimientos;
}
public int getIdcategoria() {
	return idcategoria;
}
public void setIdcategoria(int idcategoria) {
	this.idcategoria = idcategoria;
}
public String getUrlimagen() {
	return urlimagen;
}
public void setUrlimagen(String urlimagen) {
	this.urlimagen = urlimagen;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public List<Movimiento> getListamovimientos() {
	return listamovimientos;
}
public void setListamovimientos(List<Movimiento> listamovimientos) {
	this.listamovimientos = listamovimientos;
}

}

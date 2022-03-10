package com.sinensia.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movimiento {
private int idmovimiento;
private int idusuario;
private BigDecimal importe;
private int idcategoria;
private String tipo;
private LocalDate fecha;
public Movimiento() {
}
public Movimiento(int idmovimiento, int idusuario, BigDecimal importe, int idcategoria, String tipo,
		LocalDate fecha) {
	this.idmovimiento = idmovimiento;
	this.idusuario = idusuario;
	this.importe = importe;
	this.idcategoria = idcategoria;
	this.tipo = tipo;
	this.fecha = fecha;
}
public int getIdmovimiento() {
	return idmovimiento;
}
public void setIdmovimiento(int idmovimiento) {
	this.idmovimiento = idmovimiento;
}
public int getIdusuario() {
	return idusuario;
}
public void setIdusuario(int idusuario) {
	this.idusuario = idusuario;
}
public BigDecimal getImporte() {
	return importe;
}
public void setImporte(BigDecimal importe) {
	this.importe = importe;
}
public int getIdcategoria() {
	return idcategoria;
}
public void setIdcategoria(int idcategoria) {
	this.idcategoria = idcategoria;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public LocalDate getFecha() {
	return fecha;
}
public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}



}

package com.sinensia.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Movimiento {
private int idmovimiento;
private int idusuario;
private BigDecimal cantidad;
private int idcategoria;
private boolean tipomovimiento;
private LocalDate fecha;
public Movimiento() {
}
public Movimiento(int idmovimiento, int idusuario, BigDecimal cantidad, int idcategoria, boolean tipomovimiento,
		LocalDate fecha) {
	this.idmovimiento = idmovimiento;
	this.idusuario = idusuario;
	this.cantidad = cantidad;
	this.idcategoria = idcategoria;
	this.tipomovimiento = tipomovimiento;
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
public BigDecimal getCantidad() {
	return cantidad;
}
public void setCantidad(BigDecimal cantidad) {
	this.cantidad = cantidad;
}
public int getIdcategoria() {
	return idcategoria;
}
public void setIdcategoria(int idcategoria) {
	this.idcategoria = idcategoria;
}
public boolean isTipomovimiento() {
	return tipomovimiento;
}
public void setTipomovimiento(boolean tipomovimiento) {
	this.tipomovimiento = tipomovimiento;
}
public LocalDate getFecha() {
	return fecha;
}
public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}



}

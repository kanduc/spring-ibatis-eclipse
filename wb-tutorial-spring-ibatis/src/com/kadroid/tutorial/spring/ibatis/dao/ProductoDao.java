package com.kadroid.tutorial.spring.ibatis.dao;

import java.util.List;

import com.kadroid.tutorial.spring.ibatis.model.Producto;

public interface ProductoDao {
	
	public List<Producto> obtenerProductos();
	public Producto obtenerProducto(Producto producto);
	public void agregarProducto(Producto producto);
	public void actualizarProducto(Producto producto);
	public void eliminarProducto(Producto producto);

}

package com.kadroid.tutorial.spring.ibatis.service;


import java.util.List;

import com.kadroid.tutorial.spring.ibatis.model.Producto;

public interface ProductoService {
	
	public List<Producto> obtenerProductos();
	public Producto obtenerProducto(String codigo);
	public boolean agregarProducto(Producto producto);
	public boolean actualizarProducto(Producto producto);
	public boolean eliminarProducto(Producto producto);

}

package com.kadroid.tutorial.spring.ibatis.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadroid.tutorial.spring.ibatis.dao.ProductoDao;
import com.kadroid.tutorial.spring.ibatis.model.Producto;
import com.kadroid.tutorial.spring.ibatis.service.ProductoService;

//el marcador @Service indica que es un bean de la capa de negocio
@Service("productoService")
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;

	@Override
	public List<Producto> obtenerProductos() {
		String mensaje = "";
		ArrayList<Producto> lista_productos = null;

		try {
			lista_productos = (ArrayList<Producto>) productoDao
					.obtenerProductos();
		} catch (Exception ex) {
			lista_productos = null;
			System.out.println(ex);
		}
		return lista_productos;
	}
	
	@Override
	public Producto obtenerProducto(String codigo) {
		String mensaje = "";
		Producto producto = new Producto();
		producto.setCodigo_producto(codigo);

		try {
			producto = productoDao.obtenerProducto(producto);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return producto;
	}

	@Override
	public boolean agregarProducto(Producto producto) {
		Boolean resultado = true;

		try {
			productoDao.agregarProducto(producto);
			resultado = true;

		} catch (Exception ex) {
			resultado = false;
			System.out.println(ex);
		}
		return resultado;
	}

	@Override
	public boolean actualizarProducto(Producto producto) {
		Boolean resultado = true;

		try {
			productoDao.actualizarProducto(producto);
			resultado = true;

		} catch (Exception ex) {
			resultado = false;
			System.out.println(ex);
		}
		return resultado;
	}

	@Override
	public boolean eliminarProducto(Producto producto) {
		Boolean resultado = true;
		
		System.out.println("servicio del "+producto.getCodigo_producto());

		try {
			productoDao.eliminarProducto(producto);
			resultado = true;

		} catch (Exception ex) {
			resultado = false;
			System.out.println(ex);
		}
		return resultado;
	}

}

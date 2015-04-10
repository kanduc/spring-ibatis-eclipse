package com.kadroid.tutorial.spring.ibatis.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.kadroid.tutorial.spring.ibatis.dao.ProductoDao;
import com.kadroid.tutorial.spring.ibatis.model.Producto;

//ibatis-sql
//orm
//tx
//spring.jdbc

//el marcador @Repository indica que esta clase es un DAO
@Repository 
public class ProductoDaoImpl extends SqlMapClientDaoSupport implements ProductoDao{
	
	
	//la anotacion @Autowired indica una dependencia opcional, asi no levante la dependencia el app levantaria
	@Autowired
    public ProductoDaoImpl(SqlMapClient sqlMapClient){
       setSqlMapClient(sqlMapClient);
   }

	@Override
	public List<Producto> obtenerProductos() {
		Producto producto= new Producto();
		return getSqlMapClientTemplate().queryForList("getProductos", producto);
	}
	
	@Override
	public Producto obtenerProducto(Producto producto) {
		return (Producto) getSqlMapClientTemplate().queryForObject("getProducto",producto);
	}

	@Override
	public void agregarProducto(Producto producto) {
		getSqlMapClientTemplate().insert("addProducto", producto);
	}

	@Override
	public void actualizarProducto(Producto producto) {
		getSqlMapClientTemplate().update("updProducto", producto);
		
	}

	@Override
	public void eliminarProducto(Producto producto) {
		System.out.println("dao del "+producto.getCodigo_producto());
		getSqlMapClientTemplate().delete("delProducto", producto);
		
	}

	

}

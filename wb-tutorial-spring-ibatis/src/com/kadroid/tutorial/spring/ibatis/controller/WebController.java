package com.kadroid.tutorial.spring.ibatis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kadroid.tutorial.spring.ibatis.model.Producto;
import com.kadroid.tutorial.spring.ibatis.service.ProductoService;


@Controller
public class WebController {
	
	
	Map model = null;
	
	@Autowired
   	private ProductoService productoService;
	
	@RequestMapping("/inicio.htm") 
	public ModelAndView Inicio(HttpServletRequest req) throws Exception {
		
		
		List<Producto> lista_productos = new ArrayList<>();
		lista_productos=productoService.obtenerProductos();
		
		model = new HashMap();
		
		model.put("lista", lista_productos);
		model.put("saludo", "hola");
		
		for (int i = 0; i < lista_productos.size(); i++) {
			System.out.println("requisitos "+lista_productos.get(i).getNombre_producto()+" --- "+lista_productos.get(i).getCodigo_producto());
		}
		return new ModelAndView("inicio", model);
		
	}
	
	@RequestMapping("/crear.htm") 
	public ModelAndView Crear_producto(HttpServletRequest req) throws Exception {
		
		return new ModelAndView("producto_crear");
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value={"/guardar.htm"}) 
	public ModelAndView guardar_producto(@ModelAttribute("producto") Producto producto) throws Exception {
		
		
		productoService.agregarProducto(producto);

		return new ModelAndView("redirect:inicio.htm");
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value={"/editar.htm"}) 
	public ModelAndView Editar_producto(@RequestParam(value="codigo") String codigo) throws Exception {
		
		Producto producto = productoService.obtenerProducto(codigo);
		model = new HashMap();
		model.put("producto", producto);
		System.out.println("producto "+producto.getNombre_producto());
		
		return new ModelAndView("producto_editar", model);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value={"/actualizar.htm"}) 
	public ModelAndView actualizar_producto(@ModelAttribute("producto") Producto producto,  ModelMap modelo) throws Exception {
		
		productoService.actualizarProducto(producto);
		
		return new ModelAndView("redirect:inicio.htm");
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value={"/eliminar.htm"}) 
	public ModelAndView eliminar_producto(@RequestParam(value="codigo") String codigo) throws Exception {
		
		
		Producto producto = new Producto();
		producto.setCodigo_producto(codigo);
		productoService.eliminarProducto(producto);
		
		return new ModelAndView("redirect:inicio.htm");
		
	}
}

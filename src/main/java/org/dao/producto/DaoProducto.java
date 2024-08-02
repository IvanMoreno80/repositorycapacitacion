package org.dao.producto;

import java.util.List;

import org.modelo.producto.Producto;


public interface DaoProducto {
	
	public void addProducto(Producto producto);
	public List<Producto> listProducto();
	public Producto getProductoById(int id);
	public void deleteProducto(int id);

}

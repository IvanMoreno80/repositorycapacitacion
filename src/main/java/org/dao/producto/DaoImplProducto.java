package org.dao.producto;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.modelo.producto.Producto;


import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class DaoImplProducto implements DaoProducto {
	
	@SessionTarget
	private Session session;
	
	@TransactionTarget
	private Transaction transaction;

	@Override
	public void addProducto(Producto producto) {
		// TODO Auto-generated method stub
		try {
			session.saveOrUpdate(producto);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception: "+e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Producto> listProducto() {
		List<Producto> list = null;
		try {
			list = (List<Producto>) session.createQuery("from Producto").list();
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return list;
	}

	@Override
	public Producto getProductoById(int id) {
		Producto producto = null;
		try {
			producto = (Producto) session.get(Producto.class, id);
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}
		return producto;
	}

	@Override
	public void deleteProducto(int id) {
		Producto producto = null;
		try {
			producto = (Producto) session.get(Producto.class, id);
			session.delete(producto);
		} catch (Exception e) {
			System.out.println("Exception: "+e.getMessage());
		}


	}

}

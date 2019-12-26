package cl.transbank.restaurant.app.service;

import java.util.List;

import cl.transbank.restaurant.app.entity.Venta;

public interface IVentaService {
	
	List<Venta> findAll();

	Venta save(Venta venta);
	
}

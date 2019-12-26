package cl.transbank.restaurant.app.models.service;

import java.util.List;

import cl.transbank.restaurant.app.models.entity.Venta;

public interface IVentaService {
	
	List<Venta> findAll();

	Venta save(Venta venta);
	
}

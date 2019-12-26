package cl.transbank.restaurant.app.service;

import java.util.List;

import cl.transbank.restaurant.app.entity.Venta;
import cl.transbank.restaurant.app.service.dto.VentaDTO;

public interface IVentaService {
	
	List<Venta> findAll();

	Venta save(VentaDTO venta);
	
}

package cl.transbank.restaurant.app.service;

import cl.transbank.restaurant.app.entity.Venta;
import cl.transbank.restaurant.app.service.dto.VentaDTO;

import java.util.List;

public interface IVentaColaMQService {
	
	List<Venta> findColaMQAll();
	
}

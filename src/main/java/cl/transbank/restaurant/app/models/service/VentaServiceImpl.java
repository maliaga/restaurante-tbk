package cl.transbank.restaurant.app.models.service;

import java.util.List;

import cl.transbank.restaurant.app.models.dao.IVentaDao;
import cl.transbank.restaurant.app.models.entity.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VentaServiceImpl implements IVentaService {

	@Autowired
	private IVentaDao ventaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Venta> findAll() {
		return (List<Venta>) ventaDao.findAll();
	}

	@Override
	@Transactional
	public Venta save(Venta venta) {
		return ventaDao.save(venta);
		
	}
}

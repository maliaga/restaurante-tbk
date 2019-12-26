package cl.transbank.restaurant.app.service;

import java.util.Date;
import java.util.List;

import cl.transbank.restaurant.app.dao.IVentaDao;
import cl.transbank.restaurant.app.entity.Venta;
import cl.transbank.restaurant.app.service.dto.VentaDTO;
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
	public Venta save(VentaDTO venta) {

		Venta v = new Venta();
		v.setNombre(venta.getNombre());
		v.setDetalle(venta.getDetalle());
		v.setCreateAt(new Date());

		return ventaDao.save(v);
	}
}

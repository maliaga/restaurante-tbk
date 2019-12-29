package cl.transbank.restaurant.app.service.impl;

import cl.transbank.restaurant.app.dao.IVentaDao;
import cl.transbank.restaurant.app.entity.Venta;
import cl.transbank.restaurant.app.service.IVentaColaMQService;
import cl.transbank.restaurant.app.service.IVentaService;
import cl.transbank.restaurant.app.service.dto.VentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class VentaColaMQServiceImpl implements IVentaColaMQService {

	@Autowired
	private IVentaDao ventaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Venta> findColaMQAll() {
		return (List<Venta>) ventaDao.findAll();
	}

}

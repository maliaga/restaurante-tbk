package cl.transbank.restaurant.app.service.impl;

import cl.transbank.restaurant.app.dao.IVentaDao;
import cl.transbank.restaurant.app.entity.Venta;
import cl.transbank.restaurant.app.service.IVentaColaMQService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaColaMQServiceImpl implements IVentaColaMQService {

	private final Logger log = LoggerFactory.getLogger(VentaColaMQServiceImpl.class);

	@Autowired
	private IVentaDao ventaDao;

	/**
	 * Metodoq que entrega todas las ventas
	 * @return lista de ventas simulando una COLA MQ
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Venta> findColaMQAll() {

		log.info("IVentaColaMQService.findColaMQAll Obteniendo todas la ventas ");

		return (List<Venta>) ventaDao.findAll();
	}

}

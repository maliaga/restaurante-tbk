package cl.transbank.restaurant.app.service.impl;

import cl.transbank.restaurant.app.dao.IVentaDao;
import cl.transbank.restaurant.app.entity.Venta;
import cl.transbank.restaurant.app.service.IVentaService;
import cl.transbank.restaurant.app.service.dto.VentaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Clase de servicio para laas ventas
 */
@Service
public class VentaServiceImpl implements IVentaService {

	private final Logger log = LoggerFactory.getLogger(VentaServiceImpl.class);

	@Autowired
	private IVentaDao ventaDao;

	@Autowired
	private VentaColaMQServiceImpl ventaColaMQService;

	/**
	 * Metodoa que busca todas las ventas guaedadas en la base de datos
	 * @return
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Venta> findAll() {

		log.info("VentaServiceImpl.findAll Obteniendo todas la ventas ");

		return ventaColaMQService.findColaMQAll();
	}

	/**
	 * Metodoaq que guarda una Venta
	 * @param venta <code>nombre y detalle</code>
	 * @return venta creada
	 */
	@Override
	@Transactional
	public Venta save(VentaDTO venta) {

		log.info("VentaServiceImpl.save Guandando una venta ");

		Venta v = new Venta();
		v.setNombre(venta.getNombre());
		v.setDetalle(venta.getDetalle());
		v.setCreateAt(new Date());

		return ventaDao.save(v);
	}
}

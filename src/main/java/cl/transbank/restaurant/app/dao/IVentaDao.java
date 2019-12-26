package cl.transbank.restaurant.app.dao;

import org.springframework.data.repository.CrudRepository;

import cl.transbank.restaurant.app.entity.Venta;

public interface IVentaDao extends CrudRepository<Venta, Long>{


}

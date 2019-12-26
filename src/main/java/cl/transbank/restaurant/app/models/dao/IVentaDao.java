package cl.transbank.restaurant.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import cl.transbank.restaurant.app.models.entity.Venta;

public interface IVentaDao extends CrudRepository<Venta, Long>{


}

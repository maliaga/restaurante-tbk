package cl.transbank.restaurant.app.service;

import cl.transbank.restaurant.app.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

	Usuario findByUsername(String username);
}

package cl.transbank.restaurant.app.controllers;

import cl.transbank.restaurant.app.service.IUserService;
import cl.transbank.restaurant.app.service.dto.LoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Clase controladora de AUTH
 */
@RestController
@RequestMapping("/auth")
public class LoginController {

	private final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private IUserService iUserService;

	/**
	 * Metodoa para hacer el LOGIN
	 * @param login objeto que contiene el usuario y el password
	 * @return password encriptado
	 */
	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginDTO login) {
		log.info("Ejecutando login con los datos: " + login.toString());

		String pass = iUserService.login(login);
		return ResponseEntity.ok(pass);
	}
}
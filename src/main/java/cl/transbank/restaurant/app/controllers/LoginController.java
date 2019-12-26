package cl.transbank.restaurant.app.controllers;

import cl.transbank.restaurant.app.service.dto.LoginDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@PostMapping(value = "/login")
	public String guardar(@Valid @RequestBody LoginDTO login) {
		return null;
	}
}
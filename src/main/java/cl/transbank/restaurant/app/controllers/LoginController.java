package cl.transbank.restaurant.app.controllers;

import cl.transbank.restaurant.app.service.IUserService;
import cl.transbank.restaurant.app.service.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class LoginController {

	@Autowired
	private IUserService iUserService;
	
	@PostMapping(value = "/login")
	public ResponseEntity<String> login(@Valid @RequestBody LoginDTO login) {

		String pass = iUserService.login(login);
		return ResponseEntity.ok(pass);
	}
}
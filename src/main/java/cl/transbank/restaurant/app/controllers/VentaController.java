package cl.transbank.restaurant.app.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import cl.transbank.restaurant.app.entity.Venta;
import cl.transbank.restaurant.app.service.dto.VentaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cl.transbank.restaurant.app.service.IVentaService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	private IVentaService ventaService;

	@GetMapping(value = "/ventas")
	public ResponseEntity<List<Venta>> listar() {
		List<Venta> ventas = ventaService.findAll();
		return ResponseEntity.ok(ventas);
	}
	
	@PostMapping(value = "/ventas")
	public ResponseEntity<Venta> guardar(@Valid @RequestBody VentaDTO venta) {
		Venta v = ventaService.save(venta);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
																							.path("/{id}")
																							.buildAndExpand(v.getId())
																							.toUri();

		return ResponseEntity.created(location).body(v);
	}
}
package cl.transbank.restaurant.app.controllers;

import cl.transbank.restaurant.app.entity.Venta;
import cl.transbank.restaurant.app.service.IVentaService;
import cl.transbank.restaurant.app.service.dto.VentaDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Clase controladora que amneja las ventas
 */
@RestController
@RequestMapping("/api")
public class VentaController {

	private final Logger log = LoggerFactory.getLogger(VentaController.class);

	@Autowired
	private IVentaService ventaService;

	/**
	 * Metodo controlador que entrega todas la ventas
	 * @return lista de ventas
	 */
	@GetMapping(value = "/ventas")
	public ResponseEntity<List<Venta>> listar() {
		log.info("Ejecutanto API Ventas listar todoas");

		List<Venta> ventas = ventaService.findAll();
		return ResponseEntity.ok(ventas);
	}

	/**
	 * Controlador que guarda uan venta
	 * @param venta objeto ventas <code>nombre y detalle<code/>
	 * @return la venta creada
	 */
	@PostMapping(value = "/ventas")
	public ResponseEntity<Venta> guardar(@Valid @RequestBody VentaDTO venta) {
		log.info("Ejecutanto API Ventas guardar");

		Venta v = ventaService.save(venta);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
																							.path("/{id}")
																							.buildAndExpand(v.getId())
																							.toUri();

		return ResponseEntity.created(location).body(v);
	}
}
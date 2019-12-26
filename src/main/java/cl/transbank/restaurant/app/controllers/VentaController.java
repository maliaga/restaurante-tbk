package cl.transbank.restaurant.app.controllers;

import java.util.List;

import javax.validation.Valid;

import cl.transbank.restaurant.app.models.entity.Venta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cl.transbank.restaurant.app.models.service.IVentaService;

@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	private IVentaService ventaService;

	@GetMapping(value = "/ventas")
	public List<Venta> listar() {
		return ventaService.findAll();
	}
	
	@PostMapping(value = "/ventas")
	public Venta guardar(@Valid @RequestBody Venta venta) {
		return ventaService.save(venta);
	}
}
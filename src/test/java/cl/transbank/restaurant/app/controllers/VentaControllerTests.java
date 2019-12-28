package cl.transbank.restaurant.app.controllers;

import cl.transbank.restaurant.app.entity.Venta;
import cl.transbank.restaurant.app.service.IVentaService;
import cl.transbank.restaurant.app.service.dto.VentaDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import org.junit.platform.runner.JUnitPlatform;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class VentaControllerTests {

    @InjectMocks
    VentaController ventaController;

    @Mock
    IVentaService ventaService;

    @Test
    public void deberiaListarLasVentas()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        List<Venta> ventas = new ArrayList<>(0);
        ventas.add(new Venta());
        ventas.add(new Venta());
        ventas.add(new Venta());
        ventas.add(new Venta());
        ventas.add(new Venta());

        when(ventaService.findAll()).thenReturn(ventas);

        ResponseEntity<List<Venta>> responseEntity = ventaController.listar();

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().size()).isEqualTo(5);
    }

    @Test
    public void deberiaAgregarUnaVenta()
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Venta ventaOUT = new Venta();
        ventaOUT.setId(1L);
        ventaOUT.setNombre("Nombre");
        ventaOUT.setDetalle("Detalle");
        ventaOUT.setCreateAt(new Date());
        when(ventaService.save(any(VentaDTO.class))).thenReturn(ventaOUT);

        VentaDTO venta = new VentaDTO("Nombre", "Detalle");
        ResponseEntity<Venta> responseEntity = ventaController.guardar(venta);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }
}

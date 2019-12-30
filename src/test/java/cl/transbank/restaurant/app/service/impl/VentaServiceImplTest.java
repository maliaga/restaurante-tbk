package cl.transbank.restaurant.app.service.impl;

import cl.transbank.restaurant.app.dao.IVentaDao;
import cl.transbank.restaurant.app.entity.Venta;
import cl.transbank.restaurant.app.service.dto.VentaDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class VentaServiceImplTest {

    @InjectMocks
    VentaServiceImpl ventaService;

    @Mock
    private IVentaDao ventaDao;

    @Mock
    private VentaColaMQServiceImpl ventaColaMQService;

    @Test
    public void deberiaValidarFindAll(){

        Venta venta = new Venta();
        venta.setId(1L);
        venta.setNombre("Primera Venta");
        venta.setDetalle("Detalle de la Venta");
        venta.setCreateAt(new Date());

        List<Venta> ventas = new ArrayList<>(0);
        ventas.add(venta);
        ventas.add(new Venta());
        ventas.add(new Venta());
        ventas.add(new Venta());
        ventas.add(new Venta());

        when(ventaColaMQService.findColaMQAll()).thenReturn(ventas);

        List<Venta> ventasResp = ventaService.findAll();

        assertThat(ventasResp.size()).isEqualTo(5);
        assertThat(ventasResp.get(0).getId()).isEqualTo(1L);
        assertThat(ventasResp.get(0).getNombre()).isEqualTo("Primera Venta");
        assertThat(ventasResp.get(0).getDetalle()).isEqualTo("Detalle de la Venta");
    }

    @Test
    public void deberiaValidarGuardarUnaVenta(){

        VentaDTO ventaIn = new VentaDTO();
        ventaIn.setNombre("Primera Venta");
        ventaIn.setDetalle("Detalle de la Venta");

        Venta ventaOUT = new Venta();
        ventaOUT.setId(1L);
        ventaOUT.setNombre("Primera Venta");
        ventaOUT.setDetalle("Detalle de la Venta");
        ventaOUT.setCreateAt(new Date());

        when(ventaDao.save(any(Venta.class))).thenReturn(ventaOUT);

        Venta ventaResp = ventaService.save(ventaIn);

        assertThat(ventaResp.getId()).isEqualTo(1L);
        assertThat(ventaResp.getNombre()).isEqualTo("Primera Venta");
        assertThat(ventaResp.getDetalle()).isEqualTo("Detalle de la Venta");
    }
}

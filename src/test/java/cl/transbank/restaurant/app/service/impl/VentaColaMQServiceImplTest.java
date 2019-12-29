package cl.transbank.restaurant.app.service.impl;

import cl.transbank.restaurant.app.dao.IVentaDao;
import cl.transbank.restaurant.app.entity.Venta;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class VentaColaMQServiceImplTest {

    @InjectMocks
    VentaColaMQServiceImpl ventaColaMQService;

    @Mock
    IVentaDao ventaDao;

    @Test
    public void deberiaValidarFindAllPorCola(){

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

        when(ventaDao.findAll()).thenReturn(ventas);

        List<Venta> ventasResp = ventaColaMQService.findColaMQAll();

        assertThat(ventasResp.size()).isEqualTo(5);
        assertThat(ventasResp.get(0).getId()).isEqualTo(1L);
        assertThat(ventasResp.get(0).getNombre()).isEqualTo("Primera Venta");
        assertThat(ventasResp.get(0).getDetalle()).isEqualTo("Detalle de la Venta");

    }
}

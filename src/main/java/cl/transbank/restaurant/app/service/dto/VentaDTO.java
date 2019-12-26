package cl.transbank.restaurant.app.service.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class VentaDTO implements Serializable {

    @NotEmpty
    private String nombre;

    @NotEmpty
    private String detalle;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}

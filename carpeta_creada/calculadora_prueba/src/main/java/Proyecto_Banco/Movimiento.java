package Proyecto_Banco;

import java.time.LocalDateTime;

public class Movimiento {
    private String tipo;
    private double cantidad;
    private LocalDateTime fecha;

    public Movimiento(String tipo, double cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = LocalDateTime.now();
    }

    public String Detalle() {
        return fecha + " - " + tipo + " - " + cantidad;
    }
}

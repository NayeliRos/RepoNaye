package Proyecto_Banco;

import java.util.ArrayList;

public class Cuenta_Bancaria {
    private Cliente titular;
    private double saldo;
    private ArrayList<Movimiento> historial;

    public Cuenta_Bancaria(Cliente titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
        this.historial = new ArrayList<>();
    }

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            saldo = saldo + cantidad;
            historial.add(new Movimiento("INGRESO", cantidad));
        }
    }

    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            //  saldo = saldo - monto;
            saldo -= cantidad;
            historial.add(new Movimiento("RETIRO", cantidad));
        } else {
            System.out.println("Error, llame al banco");
        }
    }

    public double consultar() {
        return saldo;
    }

    public Cliente titular() {
        return titular;
    }

    public void mostrar_Historial() {
        System.out.println("Movimientos de cuenta ");
        for (Movimiento i : historial) {
            System.out.println(i.Detalle());

        }
    }
}

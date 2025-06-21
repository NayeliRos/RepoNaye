package Proyecto_Banco;

public class Cliente {
    private String nombre;
    private String documento;

    public Cliente(String nombre, String documento) {
        this.nombre = nombre;
        this.documento = documento;
    }

    public String nombre() {
        return nombre;
    }

    public String documento() {
        return documento;
    }
}

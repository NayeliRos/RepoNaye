package org.example;

public class usuario_DB {
    private int id;
    private String documento;
    private String clave;

    public usuario_DB() {
    }

    public usuario_DB(String documento, String clave) {
        this.documento = documento;
        this.clave = clave;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}

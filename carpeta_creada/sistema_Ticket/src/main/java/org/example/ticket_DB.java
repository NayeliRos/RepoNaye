package org.example;

public class ticket_DB {
    private String documento;
    private String ticket;

    public ticket_DB(String documento, String ticket) {
        this.documento = documento;
        this.ticket = ticket;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Ticket{" + "documento = '" + documento + ", ticket '" + ticket + "}";
    }
}



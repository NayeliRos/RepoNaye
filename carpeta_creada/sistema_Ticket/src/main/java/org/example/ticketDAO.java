package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ticketDAO {
    public static void registrarTicket(ticket_DB ticket) {
        String InsertDAO = "insert into GES_TICKET (documento, ticket) values (?,?)";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(InsertDAO)) {
            stmt.setString(1, ticket.getDocumento());
            stmt.setString(2, ticket.getTicket());
            stmt.executeUpdate();
            System.out.println("Ticket creado correctamente");

        } catch (Exception e) {
            System.out.println("Error al registrar ticket " + e.getMessage());
        }
    }

    public static void actualizarTicket(ticket_DB ticket) {
        String updateDAO = "update GES_TICKET set  ticket = ? where documento = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(updateDAO)) {
            stmt.setString(1, ticket.getTicket());
            stmt.setString(2, ticket.getDocumento());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("Ticket actualizado correctamente");
            } else {
                System.out.println("No se encontro ticket con este documento");
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar Usuario " + e.getMessage());
        }
    }

    public static boolean eliminarTicket(String documento) {
        String deleteSQL = "DELETE FROM GES_TICKET WHERE documento = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(deleteSQL)) {

            stmt.setString(1, documento);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Ticket eliminado correctamente");
                return true;
            } else {
                System.out.println("No se encontró ticket con este documento");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar ticket: " + e.getMessage());
            return false;
        }
    }
}



package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

public class usuarioDAO {
    public static boolean validarLogin(String documento, String clave) {
        String Select_DAO = "Select * from Usuarios where documento = ? and clave = ? ";
        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(Select_DAO)) {
            stmt.setString(1, documento);
            stmt.setString(2, clave);
            ResultSet respuesta = stmt.executeQuery();
            return respuesta.next();
        } catch (Exception e) {
            System.out.println("Error al validar login");
            return false;
        }
    }

    public static boolean registrarDocumento(usuario_DB documento) {
        String InsertDAO = "insert into USUARIOS (documento, clave ) values (?,?)";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(InsertDAO)) {
            stmt.setString(1, documento.getDocumento());
            stmt.setString(2, documento.getClave());
            stmt.executeUpdate();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Documento ya existente en los registros");
            return false;

        } catch (Exception e) {
            System.out.println("Error al registrar Usuario " + e.getMessage());
            return false;
        }
    }

    public static boolean actualizarDocumento(String antiguoDocumento, String nuevaClave) {
        // String updateDAO = "update USUARIOS set documento = ?, clave = ? where documento = ?";
        String updateDAO = "update USUARIOS set  clave = ? where documento = ?";

        try (Connection conn = ConexionDB.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(updateDAO)) {
           /* stmt.setString(1, nuevoDocumento.getDocumento());
            stmt.setString(2, nuevoDocumento.getClave());
            stmt.setString(3, antiguoDocumento);*/
            stmt.setString(1, nuevaClave);
            stmt.setString(2, antiguoDocumento);

            int filas = stmt.executeUpdate();
            return filas > 0;

        } catch (Exception e) {
            System.out.println("Error al actualizar Usuario " + e.getMessage());
            return false;
        }
    }
}

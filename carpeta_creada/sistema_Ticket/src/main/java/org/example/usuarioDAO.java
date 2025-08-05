package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}

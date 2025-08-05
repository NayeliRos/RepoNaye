package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public static Connection obtenerConexion() {
        String DB_url = "jdbc:mysql://localhost:3306/db_ticket";
        String DB_user = "Nayeli6989";
        String DB_pass = "Nayeli6989@";

        try {
            // Asegúrate de tener esta línea
            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(DB_url, DB_user, DB_pass);
        } catch (ClassNotFoundException e) {
            System.out.println("⛔ Driver no encontrado: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("⛔ Error de conexión o consulta: " + e.getMessage());
            return null;
        }
    }
}
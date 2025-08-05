package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class gestionar_Ticket_DB {
    private static final String DB_url = "jdbc:mysql://localhost:3306/db_ticket";
    private static final String DB_user = "Nayeli6989";
    private static final String DB_pass = "Nayeli6989@";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hola, por favor ingresa tu documento: ");
        String documento_scanner = scanner.nextLine();

        try {
            // Asegúrate de tener esta línea
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(DB_url, DB_user, DB_pass);
            System.out.println("✅ Conexión exitosa");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("⛔ Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("⛔ Error de conexión o consulta: " + e.getMessage());
        }

        try (Connection conn = DriverManager.getConnection(DB_url, DB_user, DB_pass)) {
            String Select_DB = "Select ticket from ges_ticket where documento = ? ";
            PreparedStatement Select = conn.prepareStatement(Select_DB);
            Select.setString(1, documento_scanner);
            ResultSet result = Select.executeQuery();
            if (result.next()) {
                String ticket_E = result.getString("ticket"); //ticket_E = TICKET EXTISTENTE
                System.out.println("Ya tienes un ticket " + ticket_E + " en curso, por favor espera tu turno ");
                System.out.println("Deseas generar otro ticket ?");
                System.out.println("Si  - No ");
                String respuesta = scanner.nextLine().toUpperCase();
                if (respuesta.equals("SI")) {
                    String ticket_Nuevo = generar_Ticket();
                    String update_Db = "Update ges_ticket set ticket = ? where documento = ? ";
                    PreparedStatement Update = conn.prepareStatement(update_Db);
                    Update.setString(1, ticket_Nuevo);
                    Update.setString(2, documento_scanner);
                    Update.executeUpdate();
                    System.out.println("Se genero el ticket: " + ticket_Nuevo + " gracias");

                } else {
                    System.out.println("Gracias");
                }
            } else {
                String ticket_Nuevo = generar_Ticket();
                String insert_Db = " ";
                PreparedStatement Insert = conn.prepareStatement(insert_Db);
                Insert.setString(1, documento_scanner);
                Insert.setString(2, ticket_Nuevo);
                Insert.executeUpdate();
                System.out.println("Se genero el ticket: " + ticket_Nuevo + " gracias");
            }
        } catch (SQLException e) {
            System.out.println("error de conexión");
        }
    }

    private static String generar_Ticket() {
        return "TK" + new Random().nextInt(10000);
    }
}
package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class gestionar_Ticket {
    private static Map<String, String> ticket_Db = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ticket_Db.put("62602627", "TKy");
        System.out.println("Hola, por favor ingresa tu documento: ");
        String documento = scanner.nextLine();
        if (ticket_Db.containsKey(documento)) {
            String ticket_E = ticket_Db.get(documento); //ticket_E = TICKET EXTISTENTE
            System.out.println("Ya tienes un ticket " + ticket_E + " en curso, por favor espera tu turno ");
            System.out.println("Deseas generar otro ticket ?");
            System.out.println("Si  - No ");
            String respuesta = scanner.nextLine().toUpperCase();
            if (respuesta.equals("SI")) {
                String ticket_N = generar_Ticket(); // ticket_N = TICKET NUEVO
                ticket_Db.put(documento, ticket_N);
                System.out.println("Se genero el ticket: " + ticket_N + " gracias");
            } else {
                System.out.println("Gracias");
            }
        } else {
            String ticket_N = generar_Ticket();
            ticket_Db.put(documento, ticket_N);
            System.out.println("Se genero el ticket: " + ticket_N + " gracias");
        }
    }

    private static String generar_Ticket() {
        return "TK" + new Random().nextInt(10000);
    }
}

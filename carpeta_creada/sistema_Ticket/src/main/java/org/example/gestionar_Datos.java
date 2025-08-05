package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class gestionar_Datos {
    //  private static Map<String, String> documento_Bd = new HashMap<>();
    static ArrayList<String> usuario = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String documento = scanner.nextLine();
        usuario.add(documento);
        String dni = usuario.get(0);
        if (!dni.equals("")) {
            System.out.println("DNI:" + dni);
        } else {
            System.out.println("No existe DNI");
        }

        System.out.println("Ingresar documento: ");
        //String documento = scanner.nextLine();
         /*if (documento_Bd.containsKey(documento)) {
            String usuario_E = documento_Bd.get(documento); // DOCUMENTO EXITENTE
            System.out.println("CLIENTE : Nayeli LLamoca " +
                    "CUENTA: 6256658996556548995" +
                    " EDAD : 24 años");
            //System.out.println("Deseas Agregar un nuevo usuario ?");
            //System.out.println("Si  - No ");
            String respuesta = scanner.nextLine().toUpperCase();
            if (respuesta.equals("SI")) {
                String ticket_N = generar_Cuenta(); // ticket_N = TICKET NUEVO
                documento_Bd.put(documento, ticket_N);
                System.out.println("Ingresa los datos del nuevo usuario");
            } else {
                System.out.println("Gracias");
            }
        } else {
            String ticket_N = generar_Cuenta();
            documento_Bd.put(documento, ticket_N);
            System.out.println("El usuario no se encuentra registrado, Deseas Agregar un nuevo usuario");
            System.out.println("Si  - No ");
            String respuesta = scanner.nextLine().toUpperCase();
            if (respuesta.equals("SI")) {
                String documento_N = generar_Cuenta(); // ticket_N = TICKET NUEVO
                documento_Bd.put(documento, ticket_N);
                System.out.println("Se genero la nueva cuenta: " + documento_N + " gracias");
            } else {
                System.out.println("Gracias");
            }
        }
    */
    }

    private static String generar_Cuenta() {
        return "T001233" + new Random().nextInt(105225000);
    }
}
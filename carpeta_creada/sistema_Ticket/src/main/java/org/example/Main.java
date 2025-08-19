package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        usuarioDAO persona = new usuarioDAO();
        ticketDAO ticketDAO = new ticketDAO();

        System.out.println("Bienvenido, ingresa tus datos porfavor");
        System.out.println("Ingresa tu documento");
        String documento = scanner.nextLine();
        System.out.println("Ingresa clave");
        String clave = scanner.nextLine();
        boolean loginExito = usuarioDAO.validarLogin(documento, clave);
        if (loginExito) {
            System.out.println("Bienvenido " + documento);
            mostrarMenuPrincipal();

        } else {
            System.out.println("error, ingresa datos validos");
        }
        scanner.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("Hola,  que deseas hacer hoy ? ");
        System.out.println("1 : MENU USUARIO");
        System.out.println("2 : MENU TICKET");
        System.out.println("0 : SALIR");

        String eleccion = scanner.nextLine();

        switch (eleccion) {
            case "1":
                mostrarMenuUsuario();
                break;
            case "2":
                mostrarMenuTicket();
                break;
            case "0":
                System.out.println("saliendo");
                return;
            default:
                System.out.println("opcion invalida");
        }
    }

    private static void mostrarMenuUsuario() {
        System.out.println("Bienvenido, elije la opción que deseas ejecutar");
        System.out.println("1 : REGISTRAR DOCUMENTO");
        System.out.println("2 : ACTUALIZAR CLAVE");
        System.out.println("0 : SALIR");

        String eleccion = scanner.nextLine();

        switch (eleccion) {
            case "1":
                registrar();
                break;
            case "2":
                actualizar();
                break;
            case "0":
                System.out.println("saliendo");
                return;
            default:
                System.out.println("opcion invalida");
        }
    }

    static void registrar() {
        System.out.println("Registra el nuevo documeto");
        String nuevoDoc = scanner.nextLine();
        System.out.println("Registra la nueva clave");
        String clave = scanner.nextLine();

        usuario_DB nuevo = new usuario_DB(nuevoDoc, clave);

        if (usuarioDAO.registrarDocumento(nuevo)) {
            System.out.println("Documento registrado de manera exitosa");
        } else {
            System.out.println("Error al registrar");
        }
    }

    static void actualizar() {
        System.out.println("Ducumento que desea actualizar");
        String antiguoDocumento = scanner.nextLine();
        System.out.println("Ingresa tu nueva clave");
        String clave = scanner.nextLine();

        // usuario_DB actualizar = new usuario_DB(antiguoDocumento, clave);

        if (usuarioDAO.actualizarDocumento(antiguoDocumento, clave)) {
            System.out.println("Documento actualize de manera exitosa");
        } else {
            System.out.println("Error al registrar");
        }
    }

    private static void mostrarMenuTicket() {
        System.out.println("Bienvenido, elije la opción que deseas ejecutar");
        System.out.println("1 : CREAR TICKET");
        System.out.println("2 : ACTUALIZAR TICKET");
        System.out.println("3 : ELIMINAR TICKET");
        System.out.println("0 : SALIR");

        String eleccion = scanner.nextLine();

        switch (eleccion) {
            case "1":
                registrarT();
                break;
            case "2":
                actualizarT();
                break;
            case "0":
                System.out.println("saliendo");
                return;
            case "3":
                eliminarT();
                return;
            default:
                System.out.println("opcion invalida");
        }
    }

    private static String generar_Ticket() {
        return "TK" + new Random().nextInt(10000);
    }

    static void registrarT() {

        System.out.println("Ingrese su numero de documento : ");
        String documentoT = scanner.nextLine();
        System.out.println("Generando ticket, espere porfavor");
        String ticket = generar_Ticket();

        ticket_DB ticketN = new ticket_DB(documentoT, ticket);
        ticketDAO.registrarTicket(ticketN);
    }

    static void actualizarT() {
        System.out.println("Ingresa documento, del ticket que deseas actualizar");
        String documentoT = scanner.nextLine();
        System.out.println(" Generando ticket nuevo...");
        String ticketNuevo = generar_Ticket();
        ticketDAO.actualizarTicket(new ticket_DB(documentoT, ticketNuevo));
    }

    static void eliminarT() {
        System.out.println("Ingresa el documento del ticket que deseas eliminar:");
        String documentoT = scanner.nextLine();
        System.out.println(" Eliminando ticket...");
        ticketDAO.eliminarTicket((documentoT));
    }
}
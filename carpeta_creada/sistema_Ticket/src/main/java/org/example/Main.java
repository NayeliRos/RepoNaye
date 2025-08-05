package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        usuarioDAO persona = new usuarioDAO();
        System.out.println("Bienvenido, ingresa tus datos porfavor");
        System.out.println("Ingresa tu documento");
        String documento = scanner.nextLine();
        System.out.println("Ingresa clave");
        String clave = scanner.nextLine();
        boolean loginExito = usuarioDAO.validarLogin(documento, clave);
        if (loginExito) {
            System.out.println("Bienvenido " + documento);
        } else {
            System.out.println("error, ingresa datos validos");
        }
        scanner.close();
    }
}
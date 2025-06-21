package Proyecto_Banco;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Nayeli Llamoca Ccoyllo", "62602625");
        Cuenta_Bancaria cuenta_Banco = new Cuenta_Bancaria(cliente, 15.1);

        cuenta_Banco.ingresar(1000);
        cuenta_Banco.retirar(200);
        cuenta_Banco.ingresar(100);
        cuenta_Banco.ingresar(100);
        cuenta_Banco.ingresar(100);
        cuenta_Banco.ingresar(100);
        cuenta_Banco.ingresar(100);
        cuenta_Banco.mostrar_Historial();
        System.out.println("Tu saldo es de : " + cuenta_Banco.consultar());
    }
}

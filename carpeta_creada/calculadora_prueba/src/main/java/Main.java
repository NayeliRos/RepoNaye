public class Main {
    public static void main(String[] args) {
        cuenta_Banco cuentaNayeli = new cuenta_Banco("Nayeli Llamoca Ccoyllo", 12.65);

        System.out.println("Hola " + cuentaNayeli.titular());
        System.out.println("Tu saldo es de " + cuentaNayeli.consultar());

        cuentaNayeli.ingresar(1000);
        System.out.println("Tu saldo es de " + cuentaNayeli.consultar());

        cuentaNayeli.retirar(500);
        System.out.println("Tu saldo es de " + cuentaNayeli.consultar());

        cuentaNayeli.retirar(4000);
    }
}
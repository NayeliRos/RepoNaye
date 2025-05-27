import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner medida = new Scanner(System.in);
        double numero;
        char conversion;
        System.out.println("¿QUE CONVERSION DESEAS HACER HOY ? ELIGE TU OPCIÓN \n A : DE CENTIMETROS A METROS\n B : DE METROS A KILOMETROS \n C : DE CENTIMETROS A KILOMETROS \n D : DE METRO A CENTIMETROS\n E : DE KILOMETROS A METROS \n F : DE KILOMETROS A CENTIMETROS");
        conversion = medida.next().charAt(0);

        System.out.println(" AHORA INGRESA UN NUMERO ");
        numero = medida.nextDouble();
        if (numero < 0) {
            System.out.println("El numero no puede ser negativo");
        } else {
            double respuesta = 0;
            switch (conversion) {
                case 'A':
                    respuesta = numero / 100;
                    System.out.println("el resultado es:" + respuesta + " metros");
                    break;
                case 'B':
                    respuesta = numero / 1000;
                    System.out.println("el resultado es:" + respuesta + " kilometros");
                    break;

                case 'C':
                    respuesta = numero / 100000;
                    System.out.println("el resultado es:" + respuesta + " kilometros");
                    break;

                case 'D':
                    respuesta = numero * 100;
                    System.out.println("el resultado es:" + respuesta + " centimetros");
                    break;

                case 'E':
                    respuesta = numero * 1000;
                    System.out.println("el resultado es:" + respuesta + " metros");
                    break;

                case 'F':
                    respuesta = numero * 100000;
                    System.out.println("el resultado es:" + respuesta + " centimetros");
                    break;
                default:
                    System.out.println("El caracter que asignaste es invalido");
            }
        }
        medida.close();
    }
}

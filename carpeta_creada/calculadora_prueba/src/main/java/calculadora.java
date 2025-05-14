import java.util.Scanner;

public class calculadora {
    public static void main(String[] args) {
        Scanner numero = new Scanner(System.in);
        double datoUno, datoDos, resultado;
        char operacion;
        System.out.println("Hola, ingresa un número:");
        datoUno = numero.nextDouble();

        System.out.println("Hola, ingresa el segundo número:");
        datoDos = numero.nextDouble();

        System.out.println("¿que tipo de operación quieres realizar ?\n + - * /");
        operacion = numero.next().charAt(0);

        switch (operacion) {
            case '+':
                resultado = datoUno + datoDos;
                System.out.println("el resultado es:" + resultado);
                break;

            case '-':
                resultado = datoUno - datoDos;
                System.out.println("el resultado es:" + resultado);
                break;


            case '*':
                resultado = datoUno * datoDos;
                System.out.println("el resultado es:" + resultado);
                break;

            case '/':
                if (datoDos == 0) {
                    System.out.println("No se  puede dividir entre 0");
                } else {
                    resultado = datoUno / datoDos;
                    System.out.println("el resultado es:" + resultado);
                }
                break;

            default:
                System.out.println("El caracter que asignaste es invalido");
        }
        numero.close();
    }
}

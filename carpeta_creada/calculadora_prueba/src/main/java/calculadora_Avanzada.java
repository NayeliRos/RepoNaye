public class calculadora_Avanzada {
    public static double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    public static double raizCuadrada(double numero, double indice) {
        if (indice == 0) {
            System.out.println("EL INDICE NO DEBE SER 0");
            return Double.NaN;

        }
        if (numero < 0 && indice % 2 == 0) {
            System.out.println("No se puede realizar raíz par de un numero negativo");
            return Double.NaN;
        }

        return Math.pow(numero, 1.0 / indice);
    }
}

public class persona {
    String nombre;
    int edad;
    double peso;
    double estatura;

    public persona(String nombre, int edad, double peso, double estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
    }

    public double calculoImc() {
        return peso / (estatura * estatura);
    }

    public String imc() {
        double imc = calculoImc();
        if (imc < 18.5) {
            return "Hola, tu imc es de " + imc + " Estas muy delgado";
        } else if (imc < 24.9) {
            return "Hola, tu imc es de " + imc + " Estas aceptable";
        } else if (imc < 29.9) {
            return "Hola, tu imc es de " + imc + " Estas EN SOBREPESO";
        } else if (imc < 34.9) {
            return "Hola, tu imc es de " + imc + " Estas OBESIDAD 1";
        } else if (imc < 39.9) {
            return "Hola, tu imc es de " + imc + " Estas OBESIDAD 2";
        } else {
            return "Hola, tu imc es de " + imc + " Estas OBESIDAD 3";
        }
    }

    public static void main(String[] args) {
        persona persona1 = new persona("Nayeli", 24, 45, 1.58);
        double imc = persona1.calculoImc();
        String resultado = persona1.imc();
        System.out.println(resultado);
    }

}

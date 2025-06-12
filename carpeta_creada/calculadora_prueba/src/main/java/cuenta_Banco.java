public class cuenta_Banco {
    private String titular;
    private double saldo;

    public cuenta_Banco(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void ingresar(double monto) {
        if (monto > 0) {
            saldo = saldo + monto;
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            //  saldo = saldo - monto;
            saldo -= monto;
        } else {
            System.out.println("Error, llame al banco");
        }
    }

    public double consultar() {
        return saldo;
    }

    public String titular() {
        return titular;
    }
}

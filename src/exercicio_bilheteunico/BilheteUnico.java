package exercicio_bilheteunico;

import java.util.Random;

public class BilheteUnico {
    static final double TARIFA = 5.20;
    double saldo;
    long numero;
    Usuario usuario;

    public BilheteUnico(String nome, long cpf, String perfil) {
        Random random = new Random();
        numero = random.nextLong(1000, 10000);
        usuario = new Usuario(nome, cpf, perfil);
    }

    //método para carregar o bilhete
    public double carregar(double valor) {
        saldo += valor;
        return saldo;
    }
    //método para consultar o saldo do bilhete
    public double consultaSaldo() {
        return saldo;
    }
    //método para passar na catraca
    public String passarNaCatraca() {
        double debito = TARIFA / 2;
        if (usuario.perfil.equalsIgnoreCase("normal")) {
            debito = TARIFA;
        }
        if(saldo >= debito) {
            saldo -= debito;
            return "Catraca liberada!";
        }
        return "Saldo insuficiente!";
    }
}

package exercicio_bilheteunico;

import java.util.Random;

public class Teste {
    public static void main(String[] args) {
        int[] x = new int[10];

        preencheVetor(x);
        printVetor(x);
    }

    public static int[] preencheVetor(int[] x) {

        for (int i = 0; i < x.length; i++) {
            Random random = new Random();
            x[i] = random.nextInt(15);
        }
        return x;
    }

    public static void printVetor(int[] x) {
        //usar este for para percorrer vetores, porém sem nosso controle (ELE OBRIGATÓRIAMENTE PERCORRERÁ TODO O VETOR)
        for (int i : x) {
            System.out.println(i);
        }
    }
}

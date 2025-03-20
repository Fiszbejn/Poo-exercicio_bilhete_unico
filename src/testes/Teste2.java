package testes;

public class Teste2 {
    public static void main(String[] args) {
        System.out.println("soma = " + somar(2, 3));
        System.out.println("soma = " + somar(2, 3, 4));
        System.out.println("soma = " + somar(2, 3, 4, 1, 7));
    }

    public static int somar(int... x) {
        int total = 0;
        for (int i : x) {
            total += i;
        }
        return total;
    }
//    public static double somar(double x, double y) {
//        return x + y;
//    }
//    public static double somar(double x, double y, double z) {
//        return x + y + z;
//    }
//    public static double somar(double x, double y, double z, double k, double l) {
//        return x + y + z + k + l;
//    }
}

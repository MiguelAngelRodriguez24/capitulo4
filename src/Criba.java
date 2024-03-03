import java.util.Scanner;

public class Criba {
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0];
        } else {
            boolean[] esPrimo = inicializarPrimos(max);
            cribarMultiplos(max, esPrimo);
            return obtenerPrimos(max, esPrimo);
        }
    }

    private static boolean[] inicializarPrimos(int max) {
        boolean[] esPrimo = new boolean[max + 1];
        for (int i = 2; i < esPrimo.length; i++) {
            esPrimo[i] = true;
        }
        esPrimo[0] = esPrimo[1] = false;
        return esPrimo;
    }

    private static void cribarMultiplos(int max, boolean[] esPrimo) {
        for (int i = 2; i * i <= max; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= max; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }

    private static int[] obtenerPrimos(int max, boolean[] esPrimo) {
        int cuenta = contarPrimos(max, esPrimo);
        int[] primos = new int[cuenta];
        for (int i = 0, j = 0; i < esPrimo.length; i++) {
            if (esPrimo[i]) {
                primos[j++] = i;
            }
        }
        return primos;
    }

    private static int contarPrimos(int max, boolean[] esPrimo) {
        int cuenta = 0;
        for (boolean primo : esPrimo) {
            if (primo) {
                cuenta++;
            }
        }
        return cuenta;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = teclado.nextInt();
        int[] primos = generarPrimos(dato);

        System.out.println("\nVector de primos hasta: " + dato);
        for (int i = 0; i < primos.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(primos[i] + "\t");
        }
    }
}

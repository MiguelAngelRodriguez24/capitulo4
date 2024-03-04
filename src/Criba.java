import java.util.Scanner;

/**
 * La clase Criba nos permite generar los numeros primos de un numero determinado.
 */
public class Criba {
    /**
     * El metodo generarPrimos nos proporciona los numeros primos de la variable int que deseemos.
     * @param max Variable que indica el numero del cual obtendremos los numeros primos
     */
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0];
        } else {
            boolean[] esPrimo = inicializarPrimos(max);
            cribarMultiplos(max, esPrimo);
            return obtenerPrimos(max, esPrimo);
        }
    }

    /**
     *Crea un array de booleanos y comprueba si son numeros primos de la variable max.
     * @param max En este caso max es la variable que define la longitud del array.
     * @return Devuelve el array con los booleanos definidos.
     */
    private static boolean[] inicializarPrimos(int max) {
        boolean[] esPrimo = new boolean[max + 1];
        for (int i = 2; i < esPrimo.length; i++) {
            esPrimo[i] = true;
        }
        esPrimo[0] = esPrimo[1] = false;
        return esPrimo;
    }

    /**
     * Marca como no primos los múltiplos de los números primos encontrados.
     * @param max Define la longitud de la tabla.
     */
    private static void cribarMultiplos(int max, boolean[] esPrimo) {
        for (int i = 2; i * i <= max; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= max; j += i) {
                    esPrimo[j] = false;
                }
            }
        }
    }

    /**
     * Nos proporciona los numeros primos.
     * @param max Longitud maxima de la tabla.
     * @return Un array que contiene los numeros que son primos.
     */
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

    /**
     * Cuenta cuantos numeros primos tenemos.
     * @return La cantidad de números primos encontrados.
     */
    private static int contarPrimos(int max, boolean[] esPrimo) {
        int cuenta = 0;
        for (boolean primo : esPrimo) {
            if (primo) {
                cuenta++;
            }
        }
        return cuenta;
    }

    /**
     * El metodo principal del programa que solicita un numero al usuario y calcula cuantos numeros primos hay
     * hasta ese numero.
     */
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

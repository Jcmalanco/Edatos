package actividad3;

public class FibonacciRecursivo {

    /**
     * @param n posición en la serie (n >= 0)
     * @return valor de Fibonacci en la posición n
     */
    public static int fibonacci(int n) {
        // Caso base: los dos primeros números
        if (n == 0) return 0;
        if (n == 1) return 1;

        // Caso recursivo: Fibonacci(n) = Fibonacci(n-1) + Fibonacci(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    
    //Imprime todos los valores de Fibonacci desde 0 hasta n.
    
    public static void imprimirSerie(int n) {
        System.out.println("Serie de Fibonacci hasta " + n + ":");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println(); // salto de línea
    }
}

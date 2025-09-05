package actividad3;

public class FibonacciRecursivo {

    // Función recursiva para calcular el enésimo número de Fibonacci
    public static int fibonacci(int n) {
        if (n == 0) return 0; // caso base
        if (n == 1) return 1; // caso base
        return fibonacci(n - 1) + fibonacci(n - 2); // caso recursivo
    }

    public static void main(String[] args) {
        int n = 10; // ejemplo: calcular el décimo número
        System.out.println("Fibonacci de " + n + " es: " + fibonacci(n));
    }
}

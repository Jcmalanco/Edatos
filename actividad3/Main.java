package actividad3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE PROBLEMAS RECURSIVOS ===");
            System.out.println("1. Serie de Fibonacci");
            System.out.println("2. Suma de Subconjuntos (Subset Sum)");
            System.out.println("3. Resolver Sudoku (Backtracking)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> ejecutarFibonacci(sc);
                case 2 -> ejecutarSubsetSum(sc);
                case 3 -> ejecutarSudoku();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida, intenta de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }

    // Ejecutar Fibonacci
    private static void ejecutarFibonacci(Scanner sc) {
    System.out.print("Introduce n para mostrar la serie de Fibonacci hasta n: ");
    int n = sc.nextInt();

    // Llamamos al método que imprime toda la serie hasta n
    FibonacciRecursivo.imprimirSerie(n);
}


    // Ejecutar Subset Sum
    private static void ejecutarSubsetSum(Scanner sc) {
        int[] conjunto = {3, 34, 4, 12, 5, 2};
        System.out.print("Introduce el valor objetivo: ");
        int target = sc.nextInt();

        boolean existe = SubsetSum.subsetSum(conjunto, conjunto.length, target);
        if (existe) {
            System.out.println("Sí existe un subconjunto que suma " + target);
        } else {
            System.out.println("No existe subconjunto que sume " + target);
        }
    }

    // Ejecutar Sudoku
    private static void ejecutarSudoku() {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (SudokuSolver.solveSudoku(board)) {
            System.out.println("Sudoku resuelto:");
            SudokuSolver.printBoard(board);
        } else {
            System.out.println("No existe solución para este Sudoku.");
        }
    }
}

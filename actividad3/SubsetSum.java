package actividad3;

public class SubsetSum {

    // Función recursiva para determinar si existe un subconjunto con suma objetivo
    public static boolean subsetSum(int[] nums, int n, int target) {
        if (target == 0) return true; // caso base
        if (n == 0) return false;     // caso base

        if (nums[n - 1] > target) {
            return subsetSum(nums, n - 1, target); // ignorar el último elemento
        }

        // probar incluyendo o excluyendo el último número
        return subsetSum(nums, n - 1, target) || subsetSum(nums, n - 1, target - nums[n - 1]);
    }

    public static void main(String[] args) {
        int[] conjunto = {3, 34, 4, 12, 5, 2};
        int target = 9;
        int n = conjunto.length;

        if (subsetSum(conjunto, n, target)) {
            System.out.println("Sí existe un subconjunto que suma " + target);
        } else {
            System.out.println("No existe subconjunto que sume " + target);
        }
    }
}
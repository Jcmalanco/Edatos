public class par {
    static boolean espar (int n){
        if (n == 0) return true;
        return esimpar(n - 1);
    }

    static boolean esimpar(int n){
        if (n == 0) return false;
        return espar(n - 1);
    }

    public static void main(String[] args) {
        int num = 7;
        System.out.println(num + " es par?" + espar(num));
        System.out.println(num + " es impar?" + esimpar(num));
    }
}

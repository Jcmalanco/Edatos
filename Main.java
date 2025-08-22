import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcionMenu;
        
        // manu de opciones
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Listas Ligadas");
            System.out.println("2. Pila");
            System.out.println("3. Cola");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcionMenu = sc.nextInt();

            switch (opcionMenu) {
                case 1: menuListas(sc); break;
                case 2: menuPila(sc); break;
                case 3: menuCola(sc); break;
                case 4: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcionMenu != 4);

        sc.close();
    }

    public static void menuListas(Scanner sc) {
        System.out.println("\nElige tipo de lista:");
        System.out.println("1. Simplemente ligada");
        System.out.println("2. Doblemente ligada");
        System.out.println("3. Circular");
        int tipo = sc.nextInt();
        boolean isDoubly = tipo == 2;
        boolean isCircular = tipo == 3;

        LinkedList<String> lista = new LinkedList<>(isDoubly, isCircular);

        int opcion;
        sc.nextLine();
        do {
            System.out.println("\n--- MENU LISTA ---");
            System.out.println("1. Insertar");
            System.out.println("2. Eliminar");
            System.out.println("3. Mostrar");
            System.out.println("4. Regresar");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa valor: ");
                    String valor = sc.nextLine();
                    lista.insert(valor); break;
                case 2:
                    System.out.print("Ingresa valor a eliminar: ");
                    String eliminar = sc.nextLine();
                    lista.delete(eliminar); break;
                case 3: lista.display(); break;
                case 4: System.out.println("Regresando..."); break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 4);
    }

    public static void menuPila(Scanner sc) {
        Pila<String> pila = new Pila<>();
        int opcion;
        do {
            System.out.println("\n--- MENU PILA ---"); //Actividad2
            System.out.println("1. Push");
            System.out.println("2. Pop/eliminar");
            System.out.println("3. Peek");
            System.out.println("4. Mostrar pila");
            System.out.println("5. Regresar");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingresa valor: ");
                    pila.push(sc.nextLine()); break;
                case 2: System.out.println("Eliminado: " + pila.pop()); break; // elimina un elemento de la fila con un pop
                case 3: System.out.println("Tope: " + pila.peek()); break; //muestra el ultimo valor
                case 4: pila.display(); break; //muestra la fila entera
                case 5: break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }

    public static void menuCola(Scanner sc) {
        Cola<String> cola = new Cola<>();
        int opcion;
        do {
            System.out.println("\n--- MENU COLA ---"); //Actividad2
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Mostrar cola");
            System.out.println("5. Regresar");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Ingresa valor: ");
                    cola.enqueue(sc.nextLine()); break;
                case 2: System.out.println("Eliminado: " + cola.dequeue()); break;
                case 3: System.out.println("Frente: " + cola.peek()); break;
                case 4: cola.display(); break;
                case 5: break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }
}

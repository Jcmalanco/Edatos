import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;

        // Menú de selección de tipo de lista
        while (true) {
            try {
                System.out.println("Selecciona el tipo de lista:");
                System.out.println("1. Simplemente enlazada");
                System.out.println("2. Doblemente enlazada");
                System.out.println("3. Circular simplemente enlazada");
                System.out.println("4. Circular doblemente enlazada");
                System.out.print("Opción: ");
                choice = sc.nextInt();
                sc.nextLine();

                if (choice >= 1 && choice <= 4) {
                    break;
                } else {
                    System.out.println("Opción inválida, intenta nuevamente.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.\n");
                sc.nextLine(); // limpiar buffer
            }
        }

        boolean isDoubly = (choice == 2 || choice == 4);
        boolean isCircular = (choice == 3 || choice == 4);

        LinkedList<Object> list = new LinkedList<>(isDoubly, isCircular);

        int option = -1;
        do {
            try {
                System.out.println("\n--- Menú ---");
                System.out.println("1. Insertar elemento");
                System.out.println("2. Eliminar elemento");
                System.out.println("3. Buscar elemento");
                System.out.println("4. Mostrar lista");
                System.out.println("5. Ejemplo con primitivos");
                System.out.println("6. Ejemplo con cadenas");
                System.out.println("7. Ejemplo con contactos");
                System.out.println("0. Salir");
                System.out.print("Opción: ");
                option = sc.nextInt();
                sc.nextLine();

                switch (option) {
                    case 1:
                        System.out.print("Ingrese el dato (como texto): ");
                        String data = sc.nextLine();
                        list.insert(data);
                        System.out.println("Elemento insertado.");
                        break;
                    case 2:
                        System.out.print("Dato a eliminar: ");
                        String delData = sc.nextLine();
                        if (list.delete(delData)) {
                            System.out.println("Eliminado correctamente.");
                        } else {
                            System.out.println("No encontrado.");
                        }
                        break;
                    case 3:
                        System.out.print("Dato a buscar: ");
                        String searchData = sc.nextLine();
                        System.out.println(list.search(searchData) ? "Encontrado." : "No encontrado.");
                        break;
                    case 4:
                        list.display();
                        break;
                    case 5:
                        DataTypeExamples.primitiveExample((LinkedList<Integer>)(LinkedList<?>)list);
                        System.out.println("Ejemplo de enteros agregado.");
                        break;
                    case 6:
                        DataTypeExamples.stringExample((LinkedList<String>)(LinkedList<?>)list);
                        System.out.println("Ejemplo de cadenas agregado.");
                        break;
                    case 7:
                        DataTypeExamples.contactExample((LinkedList<DataTypeExamples.Contact>)(LinkedList<?>)list);
                        System.out.println("Ejemplo de contactos agregado.");
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opción inválida, intenta nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                sc.nextLine();
            }
        } while (option != 0);

        sc.close();
    }
}

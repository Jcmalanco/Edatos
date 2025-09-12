package actividad4;

// Clase Nodo: representa un nodo del árbol binario
class Nodo {
    int id;
    String nombre;
    Nodo izquierda;
    Nodo derecha;

    public Nodo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierda = null;
        this.derecha = null;
    }
}

// Clase ArbolBinario: operaciones principales
class ArbolBinario {
    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Insertar un nuevo nodo (empleado)
    public void insertar(int id, String nombre) {
        raiz = insertarRec(raiz, id, nombre);
    }

    private Nodo insertarRec(Nodo raiz, int id, String nombre) {
        if (raiz == null) {
            raiz = new Nodo(id, nombre);
            return raiz;
        }
        if (id < raiz.id) {
            raiz.izquierda = insertarRec(raiz.izquierda, id, nombre);
        } else if (id > raiz.id) {
            raiz.derecha = insertarRec(raiz.derecha, id, nombre);
        }
        return raiz;
    }

    // Buscar empleado por ID
    public Nodo buscar(int id) {
        return buscarRec(raiz, id);
    }

    private Nodo buscarRec(Nodo raiz, int id) {
        if (raiz == null || raiz.id == id) {
            return raiz;
        }
        if (id < raiz.id) {
            return buscarRec(raiz.izquierda, id);
        }
        return buscarRec(raiz.derecha, id);
    }

    // Eliminar empleado por ID
    public void eliminar(int id) {
        raiz = eliminarRec(raiz, id);
    }

    private Nodo eliminarRec(Nodo raiz, int id) {
        if (raiz == null) return raiz;

        if (id < raiz.id) {
            raiz.izquierda = eliminarRec(raiz.izquierda, id);
        } else if (id > raiz.id) {
            raiz.derecha = eliminarRec(raiz.derecha, id);
        } else {
            // Caso 1: Nodo sin hijos
            if (raiz.izquierda == null && raiz.derecha == null) {
                return null;
            }
            // Caso 2: Nodo con un hijo
            else if (raiz.izquierda == null) {
                return raiz.derecha;
            } else if (raiz.derecha == null) {
                return raiz.izquierda;
            }
            // Caso 3: Nodo con dos hijos -> buscar sucesor
            raiz.id = valorMinimo(raiz.derecha);
            raiz.derecha = eliminarRec(raiz.derecha, raiz.id);
        }
        return raiz;
    }

    private int valorMinimo(Nodo nodo) {
        int min = nodo.id;
        while (nodo.izquierda != null) {
            min = nodo.izquierda.id;
            nodo = nodo.izquierda;
        }
        return min;
    }

    // Recorridos
    public void preorden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.id + "-" + nodo.nombre + " ");
            preorden(nodo.izquierda);
            preorden(nodo.derecha);
        }
    }

    public void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.izquierda);
            System.out.print(nodo.id + "-" + nodo.nombre + " ");
            inorden(nodo.derecha);
        }
    }

    public void postorden(Nodo nodo) {
        if (nodo != null) {
            postorden(nodo.izquierda);
            postorden(nodo.derecha);
            System.out.print(nodo.id + "-" + nodo.nombre + " ");
        }
    }
}

// Clase Principal: Caso práctico de empleados
public class GestionEmpleados {
    public static void main(String[] args) {
        ArbolBinario empleados = new ArbolBinario();

        // Insertar empleados
        empleados.insertar(50, "Ana");
        empleados.insertar(30, "Luis");
        empleados.insertar(70, "Carlos");
        empleados.insertar(20, "Maria");
        empleados.insertar(40, "Pedro");
        empleados.insertar(60, "Sofia");
        empleados.insertar(80, "Jorge");

        System.out.println("Recorrido INORDEN (ordenado por ID):");
        empleados.inorden(empleados.raiz);
        System.out.println("\n");

        // Buscar un empleado
        int idBuscar = 40;
        Nodo resultado = empleados.buscar(idBuscar);
        if (resultado != null) {
            System.out.println("Empleado encontrado: " + resultado.id + " - " + resultado.nombre);
        } else {
            System.out.println("Empleado con ID " + idBuscar + " no encontrado.");
        }

        // Eliminar un empleado
        System.out.println("\nEliminando empleado con ID 30...");
        empleados.eliminar(30);
        empleados.inorden(empleados.raiz);

        // Recorridos
        System.out.println("\n\nRecorrido PREORDEN:");
        empleados.preorden(empleados.raiz);

        System.out.println("\n\nRecorrido POSTORDEN:");
        empleados.postorden(empleados.raiz);
    }
}

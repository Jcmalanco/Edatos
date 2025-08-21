public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private final boolean isDoubly;
    private final boolean isCircular;

    public LinkedList() {
        this(false, false);
    }

    public LinkedList(boolean isDoubly, boolean isCircular) {
        this.isDoubly = isDoubly;
        this.isCircular = isCircular;
        this.head = null;
        this.tail = null;
    }

    // Insertar al final
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
            if (isCircular) {
                head.next = head;
                if (isDoubly) head.prev = head;
            }
            return;
        }

        tail.next = newNode;
        if (isDoubly) newNode.prev = tail;
        tail = newNode;

        if (isCircular) {
            tail.next = head;
            if (isDoubly) head.prev = tail;
        }
    }

    // Eliminar primer nodo con ese dato
    public void delete(T data) {
        if (head == null) return;

        Node<T> current = head;
        Node<T> prev = null;

        do {
            if ((current.data == null && data == null) ||
                (current.data != null && current.data.equals(data))) {

                // único nodo
                if (current == head && current == tail) {
                    head = tail = null;
                    return;
                }

                // borrar cabeza
                if (current == head) {
                    head = head.next;
                    if (isCircular) tail.next = head;
                    if (isDoubly && head != null) head.prev = tail;
                    return;
                }

                // borrar cola
                if (current == tail) {
                    if (isDoubly) {
                        tail = tail.prev;
                        tail.next = isCircular ? head : null;
                        if (isCircular && head != null) head.prev = tail;
                    } else {
                        if (prev != null) prev.next = isCircular ? head : null;
                        tail = prev;
                    }
                    return;
                }

                // borrar en medio
                if (isDoubly) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                } else {
                    if (prev != null) prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (isCircular ? current != head : current != null);
    }

    public boolean search(T data) {
        if (head == null) return false;
        Node<T> current = head;
        do {
            if ((current.data == null && data == null) ||
                (current.data != null && current.data.equals(data))) {
                return true;
            }
            current = current.next;
        } while (isCircular ? current != head : current != null);
        return false;
    }

    public void display() {
        if (head == null) {
            System.out.println("Lista vacía.");
            return;
        }
        Node<T> current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (isCircular ? current != head : current != null);
        System.out.println("null");
    }

    // Métodos para Pila y Cola
    public void insertAtStart(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public T removeFromStart() {
        if (head == null) return null;
        T data = head.data;
        head = head.next;
        if (head == null) tail = null;
        return data;
    }

    public T peek() {
        return (head != null) ? head.data : null;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

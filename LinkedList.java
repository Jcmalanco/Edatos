public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private boolean isDoubly;
    private boolean isCircular;

    public LinkedList(boolean isDoubly, boolean isCircular) {
        this.isDoubly = isDoubly;
        this.isCircular = isCircular;
        this.head = null;
        this.tail = null;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = tail = newNode;
            if (isCircular) {
                head.next = head;
                if (isDoubly) head.prev = head;
            }
        } else {
            if (isDoubly) {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            if (isCircular) {
                tail.next = head;
                if (isDoubly) head.prev = tail;
            }
        }
    }

    public boolean delete(T data) {
        if (head == null) return false;

        Node<T> current = head;

        do {
            if (current.data.equals(data)) {
                if (current == head && current == tail) { // único nodo
                    head = tail = null;
                } else if (current == head) { // borrar cabeza
                    head = head.next;
                    if (isCircular) tail.next = head;
                    if (isDoubly && head != null) head.prev = tail;
                } else if (current == tail) { // borrar cola
                    tail = tail.prev;
                    if (tail != null) tail.next = isCircular ? head : null;
                    if (isDoubly && head != null) head.prev = tail;
                } else { // borrar en medio
                    if (isDoubly) {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    } else {
                        Node<T> temp = head;
                        while (temp.next != current) temp = temp.next;
                        temp.next = current.next;
                    }
                }
                return true;
            }
            current = current.next;
        } while (isCircular ? current != head : current != null);

        return false;
    }

    // Buscar
    public boolean search(T data) {
        if (head == null) return false;
        Node<T> current = head;
        do {
            if (current.data.equals(data)) return true;
            current = current.next;
        } while (isCircular ? current != head : current != null);
        return false;
    }

    // Mostrar
    public void display() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Node<T> current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (isCircular ? current != head : current != null);
        System.out.println();
    }
}

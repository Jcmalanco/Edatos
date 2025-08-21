public class Pila<T> {
    private LinkedList<T> list = new LinkedList<>();

    public void push(T data) {
        list.insertAtStart(data);
    }

    public T pop() {
        return list.removeFromStart();
    }

    public T peek() {
        return list.peek();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        System.out.print("Pila (tope -> base): ");
        list.display();
    }
}
public class Cola<T> {
    private LinkedList<T> list;

    public Cola() {
        list = new LinkedList<>();
    }

    public void enqueue(T data) {
    list.insert(data);
    }

    public T dequeue() {
        return list.removeFromStart();
    }

    public T peek() {
        return list.peek();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void display() {
        System.out.print("Cola (frente -> final): ");
        list.display();
    }
}
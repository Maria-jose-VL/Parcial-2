package punto3;

public class Queue<T> {

    private int size;
    private Node<T> front;
    private Node<T> rear;

    public Queue() {
        this.size = 0;
        this.front = null;
        this.rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        T data = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }

    public void imprimir() {
        imprimirRecursivo(front);
    }

    private void imprimirRecursivo(Node<T> actual) {
        if (actual == null) {
            return;
        }

        System.out.println(actual.getData());
        imprimirRecursivo(actual.getNext());
    }
}

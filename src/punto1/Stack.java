package punto1;

public class Stack<T> {

    private int size;
    private Node<T> top;

    public Stack() {
        this.size = 0;
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> newNodeSimple = new Node<>(data);
        if (isEmpty()) {
            top = newNodeSimple;
        } else {
            newNodeSimple.setNext(top);
            top = newNodeSimple;
        }
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        T data = top.getData();
        top = top.getNext();
        size--;
        return data;
    }

    public Stack<T> clonarPila() {
        Stack<T> copia = new Stack<>();
        Stack<T> auxiliar = new Stack<>();

        clonarRecursivo(this, auxiliar);

        while (!auxiliar.isEmpty()) {
            copia.push(auxiliar.pop());
        }

        return copia;
    }

    private void clonarRecursivo(Stack<T> original, Stack<T> auxiliar) {
        if (original.isEmpty()) {
            return;
        }

        T dato = original.pop();
        auxiliar.push(dato);

        clonarRecursivo(original, auxiliar);

        original.push(dato);
    }

    public void imprimir() {
        imprimirRecursivo(top);
    }

    private void imprimirRecursivo(Node<T> actual) {
        if (actual == null) {
            return;
        }

        System.out.println(actual.getData());
        imprimirRecursivo(actual.getNext());
    }

    public void addAll(Stack<T> pila2) {
        Stack<T> auxiliar = new Stack<>();
        pasarPila(pila2, auxiliar);
        agregarElementos(auxiliar);
    }

    private void pasarPila(Stack<T> origen, Stack<T> auxiliar) {
        if (origen.isEmpty()) {
            return;
        }

        auxiliar.push(origen.pop());
        pasarPila(origen, auxiliar);
    }

    private void agregarElementos(Stack<T> auxiliar) {
        if (auxiliar.isEmpty()) {
            return;
        }

        T dato = auxiliar.pop();
        push(dato);
        agregarElementos(auxiliar);
    }
}
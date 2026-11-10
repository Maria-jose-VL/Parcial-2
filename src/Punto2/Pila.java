package Punto2;

public class Pila {
    Nodo tope;

    public Pila() {
        tope = null;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void apilar(String dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public String desapilar() {
        if (estaVacia()) {
            return null;
        }
        String dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }

    // imprime la pila desde el tope hasta el fondo
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("pila vacia");
            return;
        }
        Nodo actual = tope;
        while (actual != null) {
            System.out.print(actual.dato + " ");
            actual = actual.siguiente;
        }
        System.out.println();
    }
}

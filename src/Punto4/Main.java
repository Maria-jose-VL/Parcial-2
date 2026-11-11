package Punto4;


public class Main {

    public static void main(String[] args) {

        ArbolBinario arbol = new ArbolBinario();


        arbol.insertar(40);
        arbol.insertar(20);
        arbol.insertar(60);
        arbol.insertar(10);
        arbol.insertar(30);
        arbol.insertar(50);
        arbol.insertar(70);

        // Definir el rango
        int inferior = 20;
        int superior = 50;

        // Contar equipos dentro del rango
        int cantidad = arbol.contarEquiposEnRango(
                arbol.raiz, inferior, superior);

        System.out.println("Equipos entre " + inferior +
                " y " + superior + ": " + cantidad);
    }
}


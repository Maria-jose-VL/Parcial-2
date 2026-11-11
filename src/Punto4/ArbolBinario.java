package Punto4;


public class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // Insertar un código en el ABB
    public void insertar(int codigo) {
        raiz = insertarRecursivo(raiz, codigo);
    }

    private Nodo insertarRecursivo(Nodo actual, int codigo) {

        if (actual == null) {
            return new Nodo(codigo);
        }

        if (codigo < actual.codigo) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, codigo);
        } else if (codigo > actual.codigo) {
            actual.derecho = insertarRecursivo(actual.derecho, codigo);
        }

        return actual;
    }

    // Contar equipos dentro de un rango
    public int contarEquiposEnRango(Nodo raiz, int inferior, int superior) {

        // Si el árbol está vacío o el rango es inválido
        if (raiz == null || inferior > superior) {
            return 0;
        }

        int contador = 0;

        // Verificar si el código está dentro del rango
        if (raiz.codigo >= inferior && raiz.codigo <= superior) {
            contador = 1;
        }

        // Recorrer izquierda solamente si puede haber valores del rango
        if (raiz.codigo > inferior) {
            contador += contarEquiposEnRango(
                    raiz.izquierdo, inferior, superior);
        }

        // Recorrer derecha solamente si puede haber valores del rango
        if (raiz.codigo < superior) {
            contador += contarEquiposEnRango(
                    raiz.derecho, inferior, superior);
        }

        return contador;
    }
}


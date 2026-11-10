package Punto2;

public class Obtener {
    public static Pila obtenerSegmento(Pila original, int inicio, int fin) {
        Pila resultado = new Pila();

        if (inicio < 1 || inicio > fin) {
            return resultado;
        }

        Pila auxiliar = new Pila();
        Pila segmento = new Pila();
        int posicion = 0;

        // se saca todo contando la posicion, el tope es la posicion 1
        while (!original.estaVacia()) {
            String accion = original.desapilar();
            posicion++;
            auxiliar.apilar(accion);

            if (posicion >= inicio && posicion <= fin) {
                segmento.apilar(accion);
            }
        }

        // se restaura la pila original
        while (!auxiliar.estaVacia()) {
            original.apilar(auxiliar.desapilar());
        }

        // al final posicion tiene la cantidad de elementos
        if (fin > posicion) {
            return resultado;
        }

        // se invierte para que la accion de la posicion inicio quede en el tope
        while (!segmento.estaVacia()) {
            resultado.apilar(segmento.desapilar());
        }

        return resultado;
    }

    public static void main(String[] args) {
        Pila acciones = new Pila();
        acciones.apilar("A1");
        acciones.apilar("A2");
        acciones.apilar("A3");
        acciones.apilar("A4");
        acciones.apilar("A5");
        acciones.apilar("A6");

        System.out.print("Original: ");
        acciones.mostrar();

        System.out.print("inicio = 2, fin = 4: ");
        obtenerSegmento(acciones, 2, 4).mostrar();

        System.out.print("inicio = 3, fin = 3: ");
        obtenerSegmento(acciones, 3, 3).mostrar();

        System.out.print("inicio = 0, fin = 3: ");
        obtenerSegmento(acciones, 0, 3).mostrar();

        System.out.print("inicio = 4, fin = 2: ");
        obtenerSegmento(acciones, 4, 2).mostrar();

        System.out.print("inicio = 2, fin = 9: ");
        obtenerSegmento(acciones, 2, 9).mostrar();

        System.out.print("Original al final: ");
        acciones.mostrar();
    }
}


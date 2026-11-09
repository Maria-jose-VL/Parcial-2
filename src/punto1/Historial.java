package punto1;

public class Historial {

    public static Stack<Operacion> obtenerUltimasConfirmadas(Stack<Operacion> historial, int n) {
        Stack<Operacion> resultado = new Stack<>();

        if (n <= 0) {
            return resultado;
        }

        Stack<Operacion> temporal = new Stack<>();
        recorrer(historial, temporal, n, 0);

        // temporal quedó con la más antigua arriba, así que se invierte
        while (!temporal.isEmpty()) {
            resultado.push(temporal.pop());
        }

        return resultado;
    }

    private static void recorrer(Stack<Operacion> historial, Stack<Operacion> temporal,
                                 int n, int seleccionadas) {
        if (historial.isEmpty()) {
            return;
        }

        Operacion op = historial.pop();

        if (op.getEstado() == Operacion.Estado.CONFIRMADA && seleccionadas < n) {
            temporal.push(op);
            seleccionadas++;
        }

        recorrer(historial, temporal, n, seleccionadas);

        // al volver de la recursión se restaura la pila original
        historial.push(op);
    }
}
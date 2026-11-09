package punto1;

public class Main {

    public static void main(String[] args) {

        Stack<Operacion> historial = new Stack<>();

        historial.push(new Operacion("O1", Operacion.Estado.ANULADA));
        historial.push(new Operacion("O2", Operacion.Estado.CONFIRMADA));
        historial.push(new Operacion("O3", Operacion.Estado.CONFIRMADA));
        historial.push(new Operacion("O4", Operacion.Estado.ANULADA));
        historial.push(new Operacion("O5", Operacion.Estado.CONFIRMADA));

        System.out.println("Historial original:");
        historial.imprimir();

        System.out.println("\nUltimas 2 confirmadas:");
        Stack<Operacion> r1 = Historial.obtenerUltimasConfirmadas(historial, 2);
        r1.imprimir();

        System.out.println("\nUltimas 10 confirmadas (hay menos):");
        Stack<Operacion> r2 = Historial.obtenerUltimasConfirmadas(historial, 10);
        r2.imprimir();

        System.out.println("\nn = 0:");
        Stack<Operacion> r3 = Historial.obtenerUltimasConfirmadas(historial, 0);
        System.out.println("Vacia: " + r3.isEmpty());

        System.out.println("\nn = -3:");
        Stack<Operacion> r4 = Historial.obtenerUltimasConfirmadas(historial, -3);
        System.out.println("Vacia: " + r4.isEmpty());

        System.out.println("\nHistorial despues de las pruebas (debe ser igual):");
        historial.imprimir();
    }
}
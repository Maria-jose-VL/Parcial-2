package punto3;

public class Main {

    private static Queue<Solicitud> crearEjemplo() {
        Queue<Solicitud> cola = new Queue<>();

        cola.enqueue(new Solicitud("S1", Solicitud.Prioridad.NORMAL, 10));
        cola.enqueue(new Solicitud("S2", Solicitud.Prioridad.ALTA, 30));
        cola.enqueue(new Solicitud("S3", Solicitud.Prioridad.ALTA, 15));
        cola.enqueue(new Solicitud("S4", Solicitud.Prioridad.NORMAL, 5));

        return cola;
    }

    private static void probar(String titulo, Queue<Solicitud> pendientes, int minutos) {
        System.out.println("=== " + titulo + " (" + minutos + " min) ===");

        System.out.println("Pendientes antes:");
        pendientes.imprimir();

        Queue<Solicitud> seleccionadas = GestorSolicitudes.seleccionarSolicitudes(pendientes, minutos);

        System.out.println("Seleccionadas:");
        seleccionadas.imprimir();

        System.out.println("Pendientes despues:");
        pendientes.imprimir();
        System.out.println();
    }

    public static void main(String[] args) {

        probar("Ejemplo del enunciado", crearEjemplo(), 25);

        probar("Minutos = 0", crearEjemplo(), 0);

        probar("Minutos negativos", crearEjemplo(), -5);

        probar("Alcanza para todas", crearEjemplo(), 100);

        probar("Ninguna cabe", crearEjemplo(), 4);

        probar("Cola vacia", new Queue<Solicitud>(), 20);

        probar("Duracion igual al tiempo restante", crearEjemplo(), 15);
    }
}

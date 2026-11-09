package punto3;

public class GestorSolicitudes {

    public static Queue<Solicitud> seleccionarSolicitudes(Queue<Solicitud> pendientes, int minutos) {
        Queue<Solicitud> seleccionadas = new Queue<>();

        if (minutos <= 0) {
            return seleccionadas;
        }

        // la segunda pasada trabaja con los minutos que sobraron de la primera
        minutos = procesarPasada(pendientes, seleccionadas, minutos, Solicitud.Prioridad.ALTA);
        procesarPasada(pendientes, seleccionadas, minutos, Solicitud.Prioridad.NORMAL);

        return seleccionadas;
    }

    // Recorre toda la cola de pendientes una vez, mira solo las de la prioridad
    // indicada y retorna los minutos que quedan.
    private static int procesarPasada(Queue<Solicitud> pendientes, Queue<Solicitud> seleccionadas,
                                      int minutos, Solicitud.Prioridad prioridad) {
        Queue<Solicitud> restantes = new Queue<>();

        minutos = recorrer(pendientes, seleccionadas, restantes, minutos, prioridad);
        devolver(restantes, pendientes);

        return minutos;
    }

    private static int recorrer(Queue<Solicitud> pendientes, Queue<Solicitud> seleccionadas,
                                Queue<Solicitud> restantes, int minutos, Solicitud.Prioridad prioridad) {
        if (pendientes.isEmpty()) {
            return minutos;
        }

        Solicitud solicitud = pendientes.dequeue();

        if (solicitud.getPrioridad() == prioridad && solicitud.getDuracion() <= minutos) {
            seleccionadas.enqueue(solicitud);
            minutos = minutos - solicitud.getDuracion();
        } else {
            restantes.enqueue(solicitud);
        }

        return recorrer(pendientes, seleccionadas, restantes, minutos, prioridad);
    }

    // Pasa todo de origen a destino conservando el orden
    private static void devolver(Queue<Solicitud> origen, Queue<Solicitud> destino) {
        if (origen.isEmpty()) {
            return;
        }

        destino.enqueue(origen.dequeue());
        devolver(origen, destino);
    }
}
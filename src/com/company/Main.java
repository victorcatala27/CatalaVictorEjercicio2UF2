package com.company;
/**Al iniciarse la aplicación, se presenta al usuario un menú de acciones consistente e:
 * [1] Añadir un evento a la aplicación
 * [2] Borrar un evento de la aplicación
 * [3] Ver todos los eventos
 * [4] Gestionar una tarea de un evento
 * [5] Salir del programa
 * Se pedirá al usuario, de querer crear un Evento, que añada características identificativas del mismo tales como
 * -nombre, -fecha, -orden de prioridad, -tareas (que seran las acciones que habrá que llevar a cabo)
 *
* */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Event> events = new ArrayList<>(); // Lista de eventos

    public static void main(String[] args) {
        Main programa = new Main();
        programa.inicio();
    }
/**
 *Método principal encargado de gestionar el programa con sus opciones y funcionalidades
 */
    public void inicio() {
        Scanner scanner = new Scanner(System.in);
        boolean salirDelPrograma = false;

        System.out.println("Bienvenido a LSINNOVA Event Planner");

        while (!salirDelPrograma) { // Bucle principal del menú
            System.out.println("\nSelecciona una opción:");
            System.out.println("[1] Añadir evento");
            System.out.println("[2] Borrar un evento");
            System.out.println("[3] Ver todos los eventos");
            System.out.println("[4] Gestionar una tarea de un evento");
            System.out.println("[5] Salir del programa");

            if (scanner.hasNextInt()) { // Validar entrada del usuario
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar entrada

                switch (opcion) {
                    case 1:
                        agregarEvento(scanner);
                        break;
                    case 2:
                        borrarEvento(scanner);
                        break;
                    case 3:
                        verEventos();
                        break;
                    case 4:
                        gestionarTarea(scanner);
                        break;
                    case 5:
                        salirDelPrograma = true;
                        System.out.println("Gracias por confiar en LSINNOVA Event Planner. Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Por favor, selecciona una opción válida entre 1 y 5.");
                }
            } else {
                System.out.println("Entrada no válida. Por favor, introduce un número entre 1 y 5.");
                scanner.nextLine(); // Limpiar entrada incorrecta
            }
        }
    }
    /**
     * Permite al usuario añadir un evento con título, fecha, prioridad y tareas
     * @param scanner para capturar la entrada del usuario
     */
    public void agregarEvento(Scanner scanner) {
        System.out.println("Introduce el título del evento a añadir:");
        String title = scanner.nextLine();

        System.out.println("Introduce el año del evento:");
        int year = scanner.nextInt();

        System.out.println("Introduce el mes del evento (1-12):");
        int month = scanner.nextInt();

        System.out.println("Introduce el día del evento (1-31):");
        int day = scanner.nextInt();
        scanner.nextLine(); // Limpiar entrada

        LocalDate date = LocalDate.of(year, month, day);

        System.out.println("Selecciona la prioridad del evento (1: HIGH, 2: MEDIUM, 3: LOW):");
        int priorityOption = scanner.nextInt();
        scanner.nextLine(); // Limpiar entrada

        Event.Priority priority;
        if (priorityOption == 1) {
            priority = Event.Priority.HIGH;
        } else if (priorityOption == 2) {
            priority = Event.Priority.MEDIUM;
        } else {
            priority = Event.Priority.LOW;
        }

        Event nuevoEvento = new Event(title, date, priority);

        // Agregar tareas al evento
        System.out.println("¿Deseas agregar tareas a este evento? (1: Sí, 0: No):");
        int respuesta = scanner.nextInt();
        scanner.nextLine(); // Limpiar entrada

        while (respuesta == 1) {
            System.out.println("Introduce la descripción de la tarea:");
            String taskDescription = scanner.nextLine();
            EventTask newTask = new EventTask(taskDescription);
            nuevoEvento.addTask(newTask);

            System.out.println("¿Deseas agregar otra tarea? (1: Sí, 0: No):");
            respuesta = scanner.nextInt();
            scanner.nextLine(); // Limpiar entrada

            if (respuesta == 0) {
                break; // Salir del bucle si el usuario selecciona 0
            }
        }

        events.add(nuevoEvento);

        System.out.println("Evento añadido correctamente: " + nuevoEvento);
    }

    /**
    * Permite al usuario borrar un evento a partir de su titulo, el cual debe ser exacto
    * @param scanner para poder recoger la entrada del usuario
    */

    public void borrarEvento(Scanner scanner) {
        if (events.isEmpty()) {
            System.out.println("No hay eventos almacenados.");
            return;
        }

        System.out.println("Introduce el título del evento que deseas borrar:");
        String titleToDelete = scanner.nextLine();

        boolean eventFound = false;
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).getTitle().equalsIgnoreCase(titleToDelete)) {
                events.remove(i);
                eventFound = true;
                System.out.println("El evento '" + titleToDelete + "' ha sido eliminado.");
                break;
            }
        }

        if (!eventFound) {
            System.out.println("No se encontró un evento con ese título.");
        }
    }

    /**
     * Muestra los eventos almacenados y de no haberlos informa al usuario
     */
    public void verEventos() {
        if (events.isEmpty()) {
            System.out.println("No hay eventos almacenados.");
        } else {
            System.out.println("Lista de eventos:");
            for (Event event : events) {
                System.out.println(event);
            }
        }
    }

    /**
     * Permite gestionar las tareas de un evento seleccionado por su título.
     * El usuario puede marcar o desmarcar tareas como completadas.
     * @param scanner para poder recoger la entrada del usuario.
     */
    public void gestionarTarea(Scanner scanner) {
        if (events.isEmpty()) {
            System.out.println("No hay eventos almacenados.");
            return;
        }

        System.out.println("Introduce el título del evento para gestionar tareas:");
        String eventTitle = scanner.nextLine();

        Event selectedEvent = null;
        for (Event event : events) {
            if (event.getTitle().equalsIgnoreCase(eventTitle)) {
                selectedEvent = event;
                break;
            }
        }

        if (selectedEvent == null) {
            System.out.println("No se encontró un evento con ese título.");
            return;
        }

        ArrayList<EventTask> tasks = selectedEvent.getTask();
        if (tasks.isEmpty()) {
            System.out.println("El evento no tiene tareas asociadas.");
            return;
        }

        System.out.println("Lista de tareas del evento:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + tasks.get(i));
        }

        System.out.println("Selecciona el número de la tarea para modificar:");
        if (scanner.hasNextInt()) {
            int taskIndex = scanner.nextInt() - 1;
            scanner.nextLine(); // Limpiar entrada

            if (taskIndex >= 0 && taskIndex < tasks.size()) {
                EventTask selectedTask = tasks.get(taskIndex);

                if (selectedTask.isCompleted()) {
                    selectedTask.desmarcarCompleta();
                    System.out.println("La tarea '" + selectedTask.getText() + "' ha sido desmarcada como completada.");
                } else {
                    selectedTask.marcarCompleta();
                    System.out.println("La tarea '" + selectedTask.getText() + "' ha sido marcada como completada.");
                }
            } else {
                System.out.println("Selección no válida.");
            }
        } else {
            System.out.println("Entrada no válida. Por favor, introduce un número.");
            scanner.nextLine(); // Limpiar entrada incorrecta
        }
    }
}


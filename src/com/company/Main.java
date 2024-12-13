package com.company;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    private ArrayList<Event> events=new ArrayList<>();

    public  void main(String[] args) {
        Main programa=new Main ();
        programa.inicio();
    }

    public void inicio(){
        Scanner scanner= new Scanner(System.in);
        boolean salirDelPrograma=false;

        System.out.println("Bienvenido a LSINNOVA Event Planner");

        while (!salirDelPrograma) { // Bucle encargado del menu de opciones
            System.out.println("\nSelecciona una opción:");
            System.out.println("[1] Añadir evento");
            System.out.println("[2] Borrar un evento");
            System.out.println("[3] Ver todos los eventos");
            System.out.println("[4] Marcar o desmarcar la tarea de un evento como completada");
            System.out.println("[5] Salir del programa");

            //Bucle que valida la opcion y recoge los casos para las acciones
            if (scanner.hasNextInt()) { // Garantizamos que sea un número
                int opcion = scanner.nextInt();
                scanner.nextLine();

                if (opcion >= 1 && opcion <= 5) { //Bucle a modo de control para verificar que esté en el rango
                    switch (opcion) {
                        case 1:
                            agregarEvento();
                            break;
                        case 2:
                            borrarEvento();
                            break;
                        case 3:
                            verEventos();
                            break;
                        case 4:
                            gestionarTarea();
                            break;
                        case 5:
                            salirDelPrograma = true;
                            System.out.println("Gracias por confiar en LSINNOVA Event Planner. Saliendo del programa...");
                            break;
                    }
                } else {
                    System.out.println("Por favor, selecciona una opción válida entre 1 y 5.");
                }
            } else { // Si no es un número
                System.out.println("Entrada no válida. Por favor, introduce un número entre 1 y 5.");
                scanner.nextLine();
            }
        }

    }
//Metodos

    //Agregar un evento
    public void agregarEvento( Scanner scanner){
        System.out.println("Introduce el título del evento a añadir");

        String title=scanner.nextLine();

        System.out.println("Introduce el año del evento");
        int año=scanner.nextInt();

        System.out.println("Introduce el mes del evento (1-12)");
        int mes=scanner.nextInt();

        System.out.println("Introduce el dia del evento (1-31)");
        int dia= scanner.nextInt();
        LocalDate date= LocalDate.of(año, mes, dia);

        System.out.println("Selecciona la prioridad del evento (1:HIGH, 2:MEDIUM, 3: LOW");
        int priorityOption= scanner.nextInt();
        scanner.nextLine();

        Event.Priority priority;
        if(priorityOption==1){
            priority=Event.Priority.HIGH;

        }else if (priorityOption==2){
            priority=Event.Priority.MEDIUM;

        }else {
            priority=Event.Priority.LOW;
        }

        //añadir evento a la Lista
        Event newEvento=new Event(title, date, priority);
        events.add(newEvento);
        System.out.println("El evento ha sido añadido:"+newEvento);

    }


    public void borrarEvento(Scanner scanner){
        if (events.isEmpty()){
            System.out.println("No hay eventos guardados");
            return;
        }

        System.out.println("Introduce el título del evento que deseas borrar:");
        String titleToDelete= scanner.nextLine();

        boolean eventoEncontrado=false;

        for (int i = 0; i < ; i++) {
            if (events.get(i).getTitle().equalsIgnoreCase(titleToDelete)) {
                events.remove(i);
                eventoEncontrado=true;
                System.out.println("El evento"+ titleToDelete+ "ha sido eliminado correctamente");
                break;
            }
        }
        if (!eventoEncontrado){
            System.out.println("No se ha encontrado ningun evento con el título"+ titleToDelete+);
        }
    }
    public void verEventos(){
        if (events.isEmpty()){
            System.out.println("No hay eventos almacenados");
        }else{
            System.out.println("Lista de eventos");
            for (Event event: events){
                System.out.println(event);
            }

        }



    }


    public void gestionarTarea(){

    }
}

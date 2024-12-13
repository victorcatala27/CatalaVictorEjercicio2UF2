package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public  void inicio(String[] args) {
        Main programa=new Main ();
        programa.inicio();
    }

    public void inicio(){
        Scanner scanner= new Scanner(System.in);
        boolean salirDelPrograma=false;
        System.out.println("Bienvenido a LSINNOVA Event Planner");
        boolean
        while (!salirDelPrograma){
            System.out.println("\nSelecciona una opción:");
            System.out.println("Pulsa [1] para añadir evento ");
            System.out.println("Pulsa [2] para borrar un evento");
            System.out.println("Pulsa [3] para ver todos los eventos");
            System.out.println("Pulsa [4] para marcar o desmarcar la tarea de un evento como completada");
            System.out.println("Pulsa [5] para salir del programa");

            scanner.nextLine();

            if (input.hasNextInt()){
                int opcion=scanner.nextInt();
                input.nextLine();

                if(opcion>=1&& opcion<=4){
                    switch (opcion){
                        case 1:
                            agregarEvento();
                            break;

                        case 2:
                            borrarEvento();
                            break;
                        case 3:
                            listarEventos();
                            break;

                        case 4:
                            verEventos();
                            break;

                        case 5:
                            break;
                            salirDelPrograma=true;
                            System.out.println("Gracias por confiar en LSINNOVA Event Planner. Saliendo del programa...");
                            break;
                    }
                }else {
                    System.out.println("Valor erróneo. Asegúrate de escoger una de las opciones del menú");

                }
            }else {
                System.out.println("Valor erróneo. Asegúrate de escoger una de las opciones del menú");
            }
        }

    }
//metodos para gestionar las opciones del menú
    public void agregarEvento(){

    }


    public void borrarEvento(){


    }
    public void verEventos(){


    }


    public void gestionarTarea(){

    }
}

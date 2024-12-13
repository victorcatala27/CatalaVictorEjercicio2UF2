package com.company;

import java.util.ArrayList;


public class Main {
    public  void inicio(String[] args) {
        Main programa=new Main ();
        programa.inicio();
    }

    public void incio(){
        System.out.println("Bienvenido a LSINNOVA Event Planner");

        System.out.println("\nSelecciona una opción:");
        System.out.println("Pulsa [1] para añadir evento ");
        System.out.println("Pulsa [2] para borrar un evento");
        System.out.println("Pulsa [3] para ver todos los eventos");
        System.out.println("Pulsa [4] para marcar o desmarcar la tarea de un evento como completada");
        System.out.println("Pulsa [5] para salir del programa");

        int opcion=scanner.nextInt();
        scanner.nextLine();
        if (input.hasNextInt()){
            input.nextLine();

            if(opcion>=1&& opcion<=4){
                switch (opcion){
                    case 1:

                }
            }else {
                System.out.println("Valor erróneo. Asegúrate de escoger una de las opciones del menú")
            }
        }
    }
}

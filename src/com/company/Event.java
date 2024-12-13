package com.company;

import java.time.LocalDate;
import java.util.ArrayList;


//Creación de la clase Event con sus respectivos atributos
public class Event {
    private String title;
    private LocalDate date;
    private Priority priority;
    private ArrayList<EventTask> task;

    //Enum con las prioridades definidas
    public  enum Priority {HIGH, MEDIUM, LOW}

    //Constructor del objeto Event
    public Event(String title, LocalDate date, Priority priority) {
        this.title = title;
        this.date = date;
        this.priority= priority;
        this.task = new ArrayList<>();
    }

    public void addTask (EventTask task){
        this.task.add(task);
    }
//Metodo getter para saber las tareas completadas. Lo recorremos con un bucle para analizar posicion por posicion
    public int getTareasCompletadas(){
        int completadas = 0;
        for (EventTask task : task) {
            if(task.isCompleted()){
                completadas++;
            }
        }
        return completadas;
    }

//Métodos getter para el título, array de eventos y las prioridades  y fechas de los mismos
    public ArrayList<EventTask> getTask() {
        return task;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public Priority getPriority() {
        return priority;
    }

    //Método toString
    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", task=" + task +
                ", priority="+priority+
                ", tasksCompleted=" + getTareasCompletadas()+ "/"+ task.size()+
                '}';
    }
}


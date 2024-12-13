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

    /**
     * Añade una tarea a la lista de tareas del evento.
     * @param task Tarea que se desea añadir.
     */
    public void addTask (EventTask task){
        this.task.add(task);
    }

    /**
     * Calcula el número de tareas completadas dentro del evento.
     * @return Número de tareas completadas.
     */
    public int getTareasCompletadas(){
        int completadas = 0;
        for (EventTask task : task) {
            if(task.isCompleted()){
                completadas++;
            }
        }
        return completadas;
    }

    /**
     * Obtiene la lista de tareas asociadas al evento.
     * @return Lista de tareas.
     */
    public ArrayList<EventTask> getTask() {
        return task;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }
    /**
     * Obtiene la prioridad del evento.
     * @return La prioridad del evento.
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Devuelve una representación en cadena del evento, mostrando su título, fecha,
     * prioridad y el progreso de las tareas completadas.
     * @return Cadena que describe el evento.
     */
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


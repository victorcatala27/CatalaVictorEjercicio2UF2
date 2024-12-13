package com.company;

public class EventTask {
    private String text;
    private boolean isCompleted;

    //Constructor para crear una nueva tarea
    public EventTask (String text){
        this.text=text;
        this.isCompleted= false;
    }

    //Metodo para marcar como completada una tarea
    public void marcarCompleta(){
        this.isCompleted=true;
    }

    //Desmarca la tarea, indicando que no está completada.
    public void  desmarcarCompleta(){
        this.isCompleted=false;
    }

    /**
     * Verifica si la tarea está completada.
     * @return true si la tarea está completada, false en caso contrario.
     */
    public boolean isCompleted(){
        return this.isCompleted;
    }

    /**
     * Obtiene la descripción de la tarea.
     * @return El texto que describe la tarea.
     */
    public String getText(){
        return text;
    }

    /**
     * Establece una nueva descripción para la tarea.
     * @param text Nueva descripción de la tarea.
     */
    public void setText(String text){
        this.text=text;
    }


    /**
     * Devuelve una representación en cadena de la tarea, mostrando su descripción y estado.
     * @return Cadena que describe la tarea.
     */
    @Override
    public String toString() {
        return "Task { " +
                "text='" + text + '\'' +
                ", Completada=" + (isCompleted ? "Sí" : "No") +
                " }";
    }

}





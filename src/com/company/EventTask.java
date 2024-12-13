package com.company;

public class EventTask {
    private String text;
    private boolean isCompleted;

    //constructor
    public EventTask (String text){
        this.text=text;
        this.isCompleted= false;
    }

    //Metodo para marcar como completada una tarea
    public void marcarCompleta(){
        this.isCompleted=true;
    }

    //Metodo para desmarcar la tarea
    public void  desmarcarCompleta(){
        this.isCompleted=false;
    }

    //Método para marcar si está completa una tarea
    public boolean isCompleted(){
        return this.isCompleted;
    }

    //Metodo getter y setter para el texto
    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text=text;
    }


    //Método toString para printar los detalles
    @Override
    public String toString() {
        return "Task { " +
                "text='" + text + '\'' +
                ", Completada=" + (isCompleted ? "Sí" : "No") +
                " }";
    }

}





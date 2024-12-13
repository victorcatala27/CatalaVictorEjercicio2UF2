package com.company;

public class EventTask {
    private String text;
    private boolean isCompleted;

    //constructor
    public EventTask (String text, boolean isCompleted){
        this.text=text;
        this.isCompleted= isCompleted;
    }

    //Metodos
    public void markAsCompleted(){
        this.isCompleted=!this.isCompleted;
    }

    @Override
    public String toString() {
        return "EventTask{" +
                "text='" + text + '\'' +
                '}';
    }
}

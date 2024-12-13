package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

;
//atributos
public class Event {
    private String title;
    private LocalDate date;
    private Priority priority;
    private ArrayList<EventTask> task;


    //Constructor del objeto Event
    public Event(String title, LocalDate date, ArrayList<EventTask> task, Priority priorityr) {
        this.title = title;
        this.date = date;
        this.task = task;
        this.priority=priority;

    }

    @Override
    public String toString() {
        return "Event{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", task=" + task +
                ", priority="+priority+
                '}';
    }
}


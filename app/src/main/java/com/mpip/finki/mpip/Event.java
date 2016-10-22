package com.mpip.finki.mpip;

import java.util.Date;


public class Event {
    String text;
    Date dateCreated;

    public Event(String Text, Date DateCreated) {
        this.text = Text;
        this.dateCreated = DateCreated;
    }

    @Override
    public String toString() {
        return text + " " + dateCreated;
    }

}

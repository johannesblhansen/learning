package dk.johannes.show_notifications_frontend.core;

import lombok.Getter;

@Getter
public class EventStringData {

    private String content;

    public EventStringData() {
    }

    public EventStringData(String content) {
        this.content = content;
    }
}
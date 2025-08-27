package ru.testtask.simplewebsocketserver.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
public class WebSocketSessionCounter {

    private int active = 0;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        active++;
        System.out.println("Client connect. Active: " + active);
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        if (active > 0) {
            active--;
        }
        System.out.println("Client disconnect. Active: " + active);
    }

    public int getActive() {
        return active;
    }

    public boolean hasSubscribers() {
        return active > 0;
    }
}
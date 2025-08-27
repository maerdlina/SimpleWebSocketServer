package ru.testtask.simplewebsocketserver.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledMessageService {

    private final SimpMessagingTemplate messagingTemplate;
    private final WebSocketSessionCounter sessionCounter;

    public ScheduledMessageService(SimpMessagingTemplate messagingTemplate,
                                   WebSocketSessionCounter sessionCounter) {
        this.messagingTemplate = messagingTemplate;
        this.sessionCounter = sessionCounter;
    }

    @Scheduled(fixedRate = 5000)
    public void sendMessageBySchedule() {
        if (!sessionCounter.hasSubscribers()) {
            return;
        }

        String message = "Server: " + new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("Send message (" + sessionCounter.getActive() + " clients): " + message);
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
package ru.testtask.simplewebsocketserver.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledMessageService {

    private final SimpMessagingTemplate messagingTemplate;
    private static final SimpleDateFormat DATE_FORMAT =
            new SimpleDateFormat("HH:mm:ss");

    public ScheduledMessageService(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Scheduled(fixedRate = 5000)
    public void sendMessageBySchedule() {
        String message = "Message from server: " + DATE_FORMAT.format(new Date());
        System.out.println("Sending message: " + message);
        this.messagingTemplate.convertAndSend("/topic/messages", message);
    }

}
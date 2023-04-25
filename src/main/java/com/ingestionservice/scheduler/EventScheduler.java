package com.ingestionservice.scheduler;

import com.ingestionservice.event.EventSender;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@RequiredArgsConstructor
public class EventScheduler {

    private final EventSender eventSender;

    @Scheduled(fixedDelay = 50000)
    public void methodScheduler(){
        eventSender.sentFileNames();
    }
}

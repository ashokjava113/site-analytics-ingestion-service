package com.ingestionservice.event;

import com.ingestionservice.api.models.Files;
import com.ingestionservice.event.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventSender {

    private final AmqpTemplate amqpTemplate;

    @Value("${aws.file.account}")
    private String accounts;

    @Value("${aws.file.account_custom_event}")
    private String accountCustomEvent;
    Date date = new Date();
    String strDateFormat = "yyyy-MM-dd";
    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
    String formatedDate = dateFormat.format(date);

    public void sentFileNames(){
        Files files = new Files();
        files.setAccountFile(accounts);
        files.setAccountCustomEventFile(accountCustomEvent);
        amqpTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME,RabbitConfig.ROUTING_KEY,files);
        log.info("message sent successfully.....");
    }
}

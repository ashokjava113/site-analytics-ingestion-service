package com.ingestionservice.event;

import com.ingestionservice.api.models.Files;
import com.ingestionservice.data.service.FileService;
import com.ingestionservice.event.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class EventConsumer {

    private final FileService fileService;

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void messageListener(Files files) throws IOException {
        log.info("message received : "+files.getAccountFile());
        boolean fileExists = false;

        if(files.getAccountFile() != null || files.getAccountFile().equals("")){
            log.info("inside if");
            fileExists = fileService.checkS3ObjectValidity(files.getAccountFile());
            if(fileExists) {
                log.info("the file "+files.getAccountFile() + " exists");
                fileService.storeAccounts(files.getAccountFile());
            }
        }
        if(files.getAccountCustomEventFile() != null || files.getAccountCustomEventFile().equals("")){
            fileExists = fileService.checkS3ObjectValidity(files.getAccountCustomEventFile());
            if(fileExists){
                fileService.storeAccountCustomEvent(files.getAccountCustomEventFile());
            }
        }
    }
}

/*
package liga.medical.messageanalyzer.core.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import liga.medical.dto.MessageType;
import liga.medical.dto.RabbitMessageDto;
import liga.medical.messageanalyzer.core.api.MessageRouterService;
import liga.medical.messageanalyzer.core.api.MessageSenderService;
import liga.medical.messageanalyzer.core.model.MessageQueueNames;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageRouterServiceImpl implements MessageRouterService {

    private final MessageSenderService rabbitSenderService;
    private final ObjectMapper objectMapper;

    @Override
    public void routeMessage(String message) {
        try {
            RabbitMessageDto rabbitMessageDto = objectMapper.readValue(message, RabbitMessageDto.class);
            MessageType messageType = rabbitMessageDto.getType();

            switch (messageType) {
                case DAILY:
                    rabbitSenderService.sendMessage(rabbitMessageDto, MessageQueueNames.DAILY_QUEUE_NAME);
                    break;
                case ALERT:
                    rabbitSenderService.sendMessage(rabbitMessageDto, MessageQueueNames.ALERT_QUEUE_NAME);
                    break;
                case ERROR:
                    rabbitSenderService.sendMessage(rabbitMessageDto, MessageQueueNames.ERROR_QUEUE_NAME);
                    break;
                default:
                    log.info("Cannot send message [{}] to any queue", rabbitMessageDto);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
*/

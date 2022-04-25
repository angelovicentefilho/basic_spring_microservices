package br.com.avf.microservices.payroll.kafka.consumer;

import br.com.avf.microservices.commons.domain.Payment;
import br.com.avf.microservices.commons.entity.Worker;
import br.com.avf.microservices.payroll.services.PaymentHandler;
import br.com.avf.microservices.payroll.services.PaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static br.com.avf.microservices.payroll.kafka.constant.ApplicationConstants.*;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-25, Monday
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PayrollConsumer {

    private final PaymentHandler handler;

    @KafkaListener(groupId = GROUP_ID_JSON, topics = TOPIC_NAME_WORKER, containerFactory = KAFKA_LISTENER_CONTAINER_FACTORY)
    public void receiveMessage(Worker worker) throws JsonProcessingException{
        var mapper = new ObjectMapper();
        String objectString = mapper.writeValueAsString(worker);
        log.info(">>> Received: '{}'", objectString);
        this.handler.on(worker);
    }

}

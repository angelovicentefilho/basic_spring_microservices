package br.com.avf.microservices.worker.kafka.producer;

import br.com.avf.microservices.commons.entity.Worker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static br.com.avf.microservices.worker.kafka.constant.ApplicationConstants.TOPIC_NAME_WORKER;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-25, Monday
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PayrollProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(Worker worker) {
        try {
            kafkaTemplate.send(TOPIC_NAME_WORKER, worker);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package br.com.avf.microservices.worker.kafka.consumer;

import br.com.avf.microservices.worker.kafka.producer.PayrollProducer;
import br.com.avf.microservices.worker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static br.com.avf.microservices.worker.kafka.constant.ApplicationConstants.*;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-25, Monday
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WorkerConsumer {

    private final WorkerRepository repository;
    private final PayrollProducer producer;

    @KafkaListener(groupId = GROUP_ID_JSON_PAYROLL, topics = TOPIC_NAME_PAYROLL, containerFactory = KAFKA_LISTENER_CONTAINER_FACTORY)
    public void receiveMessage(Long workerId) {
        log.info(">>> Received: '{}'", workerId);
        var worker = this.repository.findById(workerId);
        worker.ifPresent(producer::sendMessage);
    }

}

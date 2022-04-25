package br.com.avf.microservices.payroll.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static br.com.avf.microservices.payroll.kafka.constant.ApplicationConstants.TOPIC_NAME_PAYROLL;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-25, Monday
 */
@Service
@RequiredArgsConstructor
public class WorkerProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    //Enviar para o worker-service o worker id
    public void sendMessage(Long workerId) {
        try {
            kafkaTemplate.send(TOPIC_NAME_PAYROLL, workerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

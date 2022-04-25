package br.com.avf.microservices.payroll.services;

import br.com.avf.microservices.commons.domain.Payment;
import br.com.avf.microservices.payroll.feign.WorkerFeignWebClient;
import br.com.avf.microservices.payroll.kafka.consumer.PayrollConsumer;
import br.com.avf.microservices.payroll.kafka.producer.WorkerProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final WorkerProducer producer;
    private final PaymentHandler handler;


    @Override
    public Payment payment(Long workerId, int days) {
        producer.sendMessage(workerId);
        handler.setDays(days);
        return handler.getPayment();
    }

}

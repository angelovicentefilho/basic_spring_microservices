package br.com.avf.microservices.payroll.services;

import br.com.avf.microservices.commons.domain.Payment;
import br.com.avf.microservices.commons.entity.Worker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-25, Monday
 */
@Service
@RequiredArgsConstructor
@Data
public class PaymentHandler {

    private int days;
    private Payment payment;

    public void on(Worker worker) {
        setPayment(new Payment(worker.getName(), worker.getDailyIncome(), getDays()));
    }
}

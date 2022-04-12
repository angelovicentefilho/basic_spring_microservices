package br.com.avf.microservices.payroll.services;

import br.com.avf.microservices.payroll.domains.Payment;
import br.com.avf.microservices.payroll.feign.WorkerFeignWebClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final WorkerFeignWebClient webClient;


    @Override
    public Payment payment(Long workerId, int days) {
        var worker = webClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}

package br.com.avf.microservices.payroll.services;

import br.com.avf.microservices.commons.domain.Payment;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
public interface PaymentService {
    Payment payment(Long workerId, int days);
}

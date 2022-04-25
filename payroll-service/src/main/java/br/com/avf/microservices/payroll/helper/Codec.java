package br.com.avf.microservices.payroll.helper;

import br.com.avf.microservices.commons.domain.Payment;
import br.com.avf.microservices.payroll.protocols.PaymentResponse;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
@UtilityClass
public class Codec {
    public static PaymentResponse toResponse(Payment payment) {
        var response = new PaymentResponse();
        BeanUtils.copyProperties(payment, response);
        return response;
    }
}

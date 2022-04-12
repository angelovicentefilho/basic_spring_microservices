package br.com.avf.microservices.payroll.resources;

import br.com.avf.microservices.payroll.helper.Codec;
import br.com.avf.microservices.payroll.protocols.PaymentResponse;
import br.com.avf.microservices.payroll.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentResource {

    private final PaymentService service;


    @GetMapping("/{workerId}/days/{days}")
    public ResponseEntity<PaymentResponse> payment(@PathVariable Long workerId, @PathVariable Integer days) {
        var payment = service.payment(workerId, days);
        return ResponseEntity.ok(Codec.toResponse(payment));
    }

    @GetMapping("/{workerId}/days/{days}/pay")
    public ResponseEntity<PaymentResponse> pay(@PathVariable Long workerId, @PathVariable Integer days) {
        var payment = service.payment(workerId, days);
        return ResponseEntity.ok(Codec.toResponse(payment));
    }
}

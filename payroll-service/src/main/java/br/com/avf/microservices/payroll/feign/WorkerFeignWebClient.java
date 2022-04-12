package br.com.avf.microservices.payroll.feign;

import br.com.avf.microservices.payroll.protocols.WorkerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
@Service
@FeignClient(name = "worker-service", path = "/api/v1/workers")
public interface WorkerFeignWebClient {

    @GetMapping("/{id}")
    ResponseEntity<WorkerResponse> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<WorkerResponse> findAll();

}

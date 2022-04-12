package br.com.avf.microservices.worker.resources;

import br.com.avf.microservices.worker.codec.Codec;
import br.com.avf.microservices.worker.protocols.WorkerResponse;
import br.com.avf.microservices.worker.services.WorkerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
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
@RequestMapping("/api/v1/workers")
@RequiredArgsConstructor
@Slf4j
public class WorkerResource {

    private final WorkerService service;
    private final Environment environment;

    @GetMapping("/{id}")
    public ResponseEntity<WorkerResponse> findById(@PathVariable Long id) {
        log.info(">>> Port:......'{}'", this.environment.getProperty("local.server.port"));;
        var response = Codec.toResponse(this.service.findById(id));
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<WorkerResponse> findAll() {
        log.info(">>> Port:......'{}'", this.environment.getProperty("local.server.port"));;
        var response = Codec.toResponse(this.service.findAll());
        return ResponseEntity.ok(response);
    }


}

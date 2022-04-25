package br.com.avf.microservices.worker;

import br.com.avf.microservices.commons.entity.Worker;
import br.com.avf.microservices.worker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

@SpringBootApplication
@EntityScan("br.com.avf.microservices.commons")
@RequiredArgsConstructor
public class StartWorkerService {

    private final WorkerRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(StartWorkerService.class, args);
    }

    @PostConstruct
    public void init() {
        Worker[] workers = {
          new Worker(1L, "Angelo",  BigDecimal.valueOf(250.00)),
          new Worker(2L, "Elias", BigDecimal.valueOf(230.00)),
          new Worker(3L, "Adriano", BigDecimal.valueOf(220.00)),
        };

        Arrays.stream(workers).collect(Collectors.toList()).forEach(this.repository::save);
    }

}

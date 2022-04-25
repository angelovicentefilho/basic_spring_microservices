package br.com.avf.microservices.worker.services;

import br.com.avf.microservices.commons.entity.Worker;

import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
public interface WorkerService {
    List<Worker> findAll();

    Worker findById(Long id);
}

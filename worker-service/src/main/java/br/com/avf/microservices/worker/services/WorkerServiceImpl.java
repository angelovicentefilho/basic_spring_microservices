package br.com.avf.microservices.worker.services;

import br.com.avf.microservices.commons.entity.Worker;
import br.com.avf.microservices.worker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {

    private final WorkerRepository repository;

    @Override
    public List<Worker> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Worker findById(Long id) {
        return this.repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Não foi possível localizar o Worker"));
    }

}

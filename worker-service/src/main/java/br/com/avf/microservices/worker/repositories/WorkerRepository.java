package br.com.avf.microservices.worker.repositories;

import br.com.avf.microservices.commons.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}

package br.com.avf.microservices.worker.codec;

import br.com.avf.microservices.worker.entities.Worker;
import br.com.avf.microservices.worker.protocols.WorkerResponse;
import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-12, Tuesday
 */
@UtilityClass
public class Codec {

    public static WorkerResponse toResponse(Worker worker) {
        var response = new WorkerResponse();
        BeanUtils.copyProperties(worker, response);
        return response;
    }

    public static WorkerResponse toResponse(List<Worker> workers) {
        var r = workers.stream().map(Codec::toResponse).collect(Collectors.toList());
        return WorkerResponse.builder()
                .workers(r).build();
    }
}

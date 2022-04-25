package br.com.avf.microservices.worker.kafka.constant;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-25, Monday
 */
public class ApplicationConstants {
    public static final String KAFKA_LOCAL_SERVER_CONFIG = "localhost:29092";
    public static final String TOPIC_NAME_PAYROLL = "payroll-consumer-1";
    public static final String TOPIC_NAME_WORKER = "worker-consumer-1";
    public static final String KAFKA_LISTENER_CONTAINER_FACTORY = "kafkaListenerContainerFactory";
    public static final String GROUP_ID_JSON_PAYROLL = "group-worker-1";
}

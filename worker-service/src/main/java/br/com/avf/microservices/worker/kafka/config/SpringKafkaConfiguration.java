package br.com.avf.microservices.worker.kafka.config;


import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;

import static br.com.avf.microservices.worker.kafka.constant.ApplicationConstants.GROUP_ID_JSON_PAYROLL;
import static br.com.avf.microservices.worker.kafka.constant.ApplicationConstants.KAFKA_LOCAL_SERVER_CONFIG;
import static org.apache.kafka.clients.consumer.ConsumerConfig.*;
import static org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG;
import static org.springframework.kafka.support.serializer.JsonDeserializer.TRUSTED_PACKAGES;

/**
 * @author angelo.vicente - angelovicentefilho@gmail.com
 * @since 2022-04-25, Monday
 */
@EnableKafka
@Configuration
public class SpringKafkaConfiguration {

    //ProducerFactory
    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        var configMap = new HashMap<String, Object>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KAFKA_LOCAL_SERVER_CONFIG);
        configMap.put(KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configMap.put(VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configMap.put(TRUSTED_PACKAGES, "*");
        return new DefaultKafkaProducerFactory<>(configMap);
    }
    //KafkaTemplate
    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
    //ConsumerFactory
    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        var configMap = new HashMap<String, Object>();
        configMap.put(BOOTSTRAP_SERVERS_CONFIG, KAFKA_LOCAL_SERVER_CONFIG);
        configMap.put(KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configMap.put(VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        configMap.put(GROUP_ID_CONFIG, GROUP_ID_JSON_PAYROLL);
        configMap.put(TRUSTED_PACKAGES, "*");
        return new DefaultKafkaConsumerFactory<>(configMap);
    }
    //ConcurrentKafkaListenerContainerFactory
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Long> kafkaListenerContainerFactory() {
        var factory = new ConcurrentKafkaListenerContainerFactory<String, Long>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

}

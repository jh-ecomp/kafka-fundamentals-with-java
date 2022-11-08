package br.com.joao.ecommerce;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.Closeable;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

class KafkaDispatcherService<T> implements Closeable {
    private final KafkaProducer<String, T> producer;
    KafkaDispatcherService(){
        this.producer = new KafkaProducer<>(properties());
    }

    void send(String topic, String key, T value) throws ExecutionException, InterruptedException {
        Callback callback = (recordMetadata, e) -> {
            if (e != null) {
                e.printStackTrace();
                return;
            }
            System.out.println("Sucesso! Enviando no topic: " + recordMetadata.topic() + "::: partition: "
                    + recordMetadata.partition() + " | offset: " + recordMetadata.offset() + " | timestamp: " +
                    recordMetadata.timestamp());
        };
        var record = new ProducerRecord<>(topic, key, value);
        producer.send(record, callback).get();
    }

    private static Properties properties() {
        var properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, GsonSerializer.class.getName());
        return properties;
    }

    @Override
    public void close(){
        producer.close();
    }
}

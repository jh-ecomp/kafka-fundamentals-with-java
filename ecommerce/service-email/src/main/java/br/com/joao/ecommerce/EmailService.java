package br.com.joao.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Map;

public class EmailService {

    public static void main(String[] args) {
        var emailService = new EmailService();
        try(var service = new KafkaConsumerService(EmailService.class.getSimpleName(),
                "ECOMMERCE_SEND_EMAIL",
                emailService::parse,
                String.class,
                Map.of())){
            service.run();
        }
    }

    private void parse(ConsumerRecord<String,String> record){
        System.out.println("Enviando email");
        System.out.println("Key: " + record.key() + " | value: " + record.value() + " | partition: "
                + record.partition() + " | offset: " + record.offset());
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Email processado!");
        System.out.println("-------------------------------------------");
    }
}

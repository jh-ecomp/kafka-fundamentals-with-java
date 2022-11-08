package br.com.joao.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public class FraudDetectorService {

    public static void main(String[] args) {
        var fraudDetectorService = new FraudDetectorService();

        try(var service = new KafkaConsumerService(FraudDetectorService.class.getSimpleName(),
                "ECOMMERCE_NEW_ORDER",
                fraudDetectorService::parse,
                Order.class,
                Map.of())){
            service.run();
        }
    }

    private void parse(ConsumerRecord<String,Order> record){
        System.out.println("Processando novo pedido, checando fraude...");
        System.out.println("Key: " + record.key() + " | value: " + record.value() + " | partition: "
                + record.partition() + " | offset: " + record.offset());
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Pedido processado!");
        System.out.println("-------------------------------------------");
    }
}

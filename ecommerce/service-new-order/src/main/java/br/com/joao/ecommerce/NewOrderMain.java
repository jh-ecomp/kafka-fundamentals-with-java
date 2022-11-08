package br.com.joao.ecommerce;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain{

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try(var orderDispatcher = new KafkaDispatcherService<Order>()) {
            try(var emailDispatcher = new KafkaDispatcherService<String>()){
                for (var i = 0; i < 10; i++) {
                    var userId = UUID.randomUUID().toString();
                    var orderId = UUID.randomUUID().toString();

                    var amount = new BigDecimal(Math.random() * 5000 + 1);
                    var order = new Order(userId, orderId, amount);

                    orderDispatcher.send("ECOMMERCE_NEW_ORDER", userId, order);
                    var email = "Recebemos seu pedido de nº: " + orderId + ". Use-o para acompanhar seu pedido na nossa plataforma.";
                    emailDispatcher.send("ECOMMERCE_SEND_EMAIL", userId, email);

                }
            }
        }
    }
}

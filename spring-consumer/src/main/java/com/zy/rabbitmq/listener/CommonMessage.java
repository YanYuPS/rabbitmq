package com.zy.rabbitmq.listener;

import org.springframework.amqp.core.Message;

public class CommonMessage {

    public void onMessage(Message message) {
        try {
            System.out.println("路由名："+message.getMessageProperties().getReceivedExchange());
            System.out.println("路由key："+message.getMessageProperties().getReceivedRoutingKey());
            System.out.println("队列名："+message.getMessageProperties().getConsumerQueue());
            System.out.println("消息："+new String(message.getBody(), "utf-8"));
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

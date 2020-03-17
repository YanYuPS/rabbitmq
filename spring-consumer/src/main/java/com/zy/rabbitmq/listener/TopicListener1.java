package com.zy.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class TopicListener1 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("通配符1："+
                    " 路由名："+message.getMessageProperties().getReceivedExchange()+
                    " , 路由key："+message.getMessageProperties().getReceivedRoutingKey()+
                    " , 队列名："+message.getMessageProperties().getConsumerQueue()+
                    " , 消息："+new String(message.getBody(), "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

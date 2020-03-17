package com.zy.rabbitmq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;


public class SpringQueueListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
//        CommonMessage commonMessage =new CommonMessage();
//        commonMessage.onMessage(message);

        try {
            System.out.println("简单："+
                    " 路由名："+message.getMessageProperties().getReceivedExchange()+
                    " , 路由key："+message.getMessageProperties().getReceivedRoutingKey()+
                    " , 队列名："+message.getMessageProperties().getConsumerQueue()+
                    " , 消息："+new String(message.getBody(), "utf-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

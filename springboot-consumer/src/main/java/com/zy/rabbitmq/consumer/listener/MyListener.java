package com.zy.rabbitmq.consumer.listener;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 监听消息
 */
@Component
public class MyListener {
    /**
     * 监听某个队列的消息
     * @param message 接收到的消息
     */
    @RabbitListener(queues = "queue_ai")
    public void topicAi(String message){
        System.out.println("topicAi接收到的消息为：" + message);
    }

    @RabbitListener(queues = "queue_be")
    public void topicBe(String message){
        System.out.println("topicBe接收到的消息为：" + message);
    }

    @RabbitListener(queues = "queue")
    public void queue(String message){
        System.out.println("queue接收到的消息为：" + message);
    }

    @RabbitListener(queues = "fanout_queue_1")
    public void fanout1(String message){
        System.out.println("fanout1接收到的消息为：" + message);
    }

    @RabbitListener(queues = "fanout_queue_2")
    public void fanout2(String message){
        System.out.println("fanout2接收到的消息为：" + message);
    }
}

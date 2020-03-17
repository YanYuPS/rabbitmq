package com.zy.rabbitmq.producer.test;

import com.zy.rabbitmq.producer.config.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 注意这个类所在包 要和 启动类所在包 相同
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void test(){
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE,"简单消息");

        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE,"","广播消息");

        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE_AI, "ai.a.a", "通配符消息，路由key：ai.a.a");
        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE_AI, "ai.a", "通配符消息，路由key：ai.a");
        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE_BE, "be.a.a", "通配符消息，路由key：be.a.a");
        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE_BE, "be.a", "通配符消息，路由key：be.a");
    }
}

package com.zy.rabbitmq.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

//通配符

    //交换机名字、队列名字
    public static final String TOPIC_EXCHANGE_AI = "topic_exchange_ai";
    public static final String TOPIC_QUEUE_AI = "queue_ai";
    //声明交换机   durable持久化 ，topicExchange 通配符交换机
    @Bean("topicExchangeAi")
    public Exchange topicExchangeAi(){
        return ExchangeBuilder.topicExchange(TOPIC_EXCHANGE_AI).durable(true).build();
    }
    //声明队列
    @Bean("topicQueueAi")
    public Queue topicQueueAi(){
        return QueueBuilder.durable(TOPIC_QUEUE_AI).build();
    }
    //绑定队列和交换机(指定通配符)    Qualifier 注入 ，noargs 不需要参数
    @Bean
    public Binding topicQueueExchangeAi(@Qualifier("topicQueueAi") Queue queue,
                                      @Qualifier("topicExchangeAi") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("ai.#").noargs();
    }


    //交换机名字、队列名字
    public static final String TOPIC_EXCHANGE_BE = "topic_exchange_be";
    public static final String TOPIC_QUEUE_BE = "queue_be";
    //声明交换机
    @Bean("topicExchangeBe")
    public Exchange topicExchangeBe(){
        return ExchangeBuilder.topicExchange(TOPIC_EXCHANGE_BE).durable(true).build();
    }
    //声明队列
    @Bean("topicQueueBe")
    public Queue topicQueueBe(){
        return QueueBuilder.durable(TOPIC_QUEUE_BE).build();
    }
    //绑定队列和交换机(指定通配符)
    @Bean
    public Binding topicQueueExchangeBe(@Qualifier("topicQueueBe") Queue queue,
                                      @Qualifier("topicExchangeBe") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("be.*").noargs();
    }


//简单

    //队列名字
    public static final String QUEUE = "queue";
    //声明队列
    @Bean("queue")
    public Queue queue(){
        return QueueBuilder.durable(QUEUE).build();
    }



//广播

    //交换机名字、队列名字
    public static final String FANOUT_EXCHANGE = "fanout_exchange_be";
    public static final String FANOUT_QUEUE_1 = "fanout_queue_1";
    public static final String FANOUT_QUEUE_2 = "fanout_queue_2";
    //声明交换机
    @Bean("fanoutExchange")
    public Exchange fanoutExchange(){
        return ExchangeBuilder.fanoutExchange(FANOUT_EXCHANGE).durable(true).build();
    }
    //声明队列
    @Bean("fanoutQueue1")
    public Queue fanoutQueue1(){
        return QueueBuilder.durable(FANOUT_QUEUE_1).build();
    }
    @Bean("fanoutQueue2")
    public Queue fanoutQueue2(){
        return QueueBuilder.durable(FANOUT_QUEUE_2).build();
    }
    //绑定队列和交换机
    @Bean
    public Binding fanoutQueueExchange1(@Qualifier("fanoutQueue1") Queue queue,
                                        @Qualifier("fanoutExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }
    @Bean
    public Binding fanoutQueueExchange2(@Qualifier("fanoutQueue2") Queue queue,
                                       @Qualifier("fanoutExchange") Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }




}

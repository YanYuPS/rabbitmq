package com.zy.easy;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class ConnectionUtil {
    public static Connection getConnection() throws Exception {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //主机地址;默认为 localhost
        connectionFactory.setHost("172.16.212.31");
        //连接端口;默认为 5672
        connectionFactory.setPort(5672);
        //虚拟主机名称;默认为 /
        connectionFactory.setVirtualHost("/zy001");
        //连接用户名;默认为guest
        connectionFactory.setUsername("zy");
        //连接密码;默认为guest
        connectionFactory.setPassword("zy");
        //创建连接
        return connectionFactory.newConnection();
    }
}

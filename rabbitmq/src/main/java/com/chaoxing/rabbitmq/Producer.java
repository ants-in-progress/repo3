package com.chaoxing.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Producer {
    public static void main(String[] args) {
        //读取配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("\\rabbitMQ.xml");
        //获取模板类
        RabbitTemplate template = context.getBean(RabbitTemplate.class);
        String str = "Spring-message";
        //构建MessageProperties对象
        MessageProperties messageProperties = new MessageProperties();
        //设置参数
        messageProperties.setContentEncoding("UTF-8");
        messageProperties.setContentType("text/plain");
        //构建消息对象
        Message message = new Message(str.getBytes(), messageProperties);
        //使用模板发送消息
        template.send(message);
    }
}

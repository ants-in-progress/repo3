package com.chaoxing.rabbitmq;

public class Consumer {

    //对应监听器中所指定的method
    public void listen(String msg) {
        System.out.println("Spring Consumer 接收到消息：" + msg);
    }
}

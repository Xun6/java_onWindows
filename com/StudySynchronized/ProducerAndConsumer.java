package com.StudySynchronized;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 主程序
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        // 创建任务队列
        Queue<String> queue = new LinkedList<>();

        Consumer<String> consumer = new Consumer<>(queue);
        Producer<String> producer = new Producer<>(queue,1024);

        // 创建消费者线程
        for (int i = 0; i<100; i++){
            Thread consumerThread = new Thread(() -> {
                while(true){
                    try{
                        String task = consumer.consumerDemo();
                        consumeProcess(task);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"消费者-" + i);
            // 开始执行线程
            consumerThread.start();
        }

        // 创建生产者线程
        for (int i = 0; i<3; i++){
            Thread producerThread = new Thread(() -> {
               while(true){
                   try{
                       String urlTask = produceProcess();
                       producer.produceDemo(urlTask);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            },"生产者-" + i);
            // 开始执行线程
            producerThread.start();
        }
    }

    // 模拟生产过程
    private static String produceProcess() {
        StringBuilder st = new StringBuilder();
        st.append("www.");
        // 随机生成5个字符
        for (int i = 0; i<6; i++){
            int rand = (int)(Math.random() * 25);
            char ch = (char)(rand + 'a');
            st.append(ch);
        }
        st.append(".com");
        return st.toString();
    }

    // 模拟消费过程
    private static void consumeProcess(String task) throws InterruptedException {
        System.out.println("执行开始:" + task);
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
        System.out.println("执行结束:" + task);
    }
}

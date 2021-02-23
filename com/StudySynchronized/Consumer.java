package com.StudySynchronized;

import java.util.Queue;

/**
 * 任务消费者
 */
public class Consumer<T> {
    private Queue<T> tasks;

    public Consumer(Queue<T> tasks){
        this.tasks = tasks;
    }

    // 消费者取出任务元素
    public T consumerDemo() throws InterruptedException {
        synchronized (tasks){
            // 判断队列任务为空时，进入等待
            while(tasks.size() == 0){
                System.out.println(Thread.currentThread().getName() + "进入等待。。。");
                // 释放 monitor(锁)
                tasks.wait();
            }
            // 取出队列中头一个任务元素
            T ret = tasks.poll();
            tasks.notifyAll(); // 唤醒所有
            return ret;
        }
    }
}

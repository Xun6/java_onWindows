package com.StudySynchronized;

import java.util.Queue;

/**
 * 任务生产者
 */
public class Producer<T> {
    private Queue<T> tasks;
    // 设置最大任务数
    private int maxTaskCount = 0;

    // 带参构造函数
    public Producer(Queue<T> tasks,int maxTaskCount){
        this.tasks = tasks;
        this.maxTaskCount = maxTaskCount;
    }

    // 生产者加入任务元素
    public void produceDemo(T task) throws InterruptedException {
        synchronized (tasks){
            // 判断队列超过任务最大值，进入等待
            while(tasks.size() >= maxTaskCount){
                System.out.println(Thread.currentThread().getName() + "进入等待---");
                tasks.wait();
            }
            tasks.add(task); //添加元素进入队列
            // 唤醒所有
            tasks.notifyAll();
        }
    }
}

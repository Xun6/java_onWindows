package com.StudySynchronized;

public class test {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        int j = 0;
        for (int i = 0; i<3; i++){
//            while(true){
                System.out.println("ceshi"+i);
                synchronized (object){
                    while(true){
                        System.out.println("进入等待！！！");
                        object.wait();
                    }
                }
//                j++;
//                Thread thread = new Thread(() -> {
//                    while(true){
//                        System.out.println("i");
//                    }
//                },"线程" + i);
//                thread.start();
//            }
        }
    }
}

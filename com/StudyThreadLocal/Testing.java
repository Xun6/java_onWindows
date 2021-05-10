package com.StudyThreadLocal;


import java.util.List;

public class Testing {
//    private static final ThreadLocal<List<PerformanceTracker.Phase>> PHASES = new ThreadLocal<>();
//    private static final ThreadLocal<Long> PHASE_START_TIME = new ThreadLocal<>();
    public static void main(String[] args) {
//        PHASE_START_TIME.getClass();
//        PHASE_START_TIME.set(System.currentTimeMillis());
//        PHASE_START_TIME.set(1L);
//        PHASE_START_TIME.get();
//        System.out.println(PHASE_START_TIME.get());

        // 创建一个线程测试一下
        Thread thread = new Thread(()->{
            System.out.println("处理开始...");
            PerformanceTracker.reset(); // 初始化

            // 处理一
            InputHandler inputHandler = new InputHandler();
            String content = inputHandler.getInput();

            // 处理二
            DBquery query = new DBquery();
            query.query();

            // 处理三
            ContentProcess contentProcess = new ContentProcess();
            contentProcess.process(content);

            PerformanceTracker.finish();
            System.out.println("处理结束");
        },"testThread_1");
        thread.start();  // 线程开始执行
    }
}

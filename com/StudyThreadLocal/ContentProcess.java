package com.StudyThreadLocal;

/**
 * 模拟内容执行过程
 */
public class ContentProcess {
    public void process(String content) {
        PerformanceTracker.startPhase();
        long ms = content.chars().reduce(Integer::sum).orElse(0);
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        PerformanceTracker.endPhase("ProcessContent");
    }
}

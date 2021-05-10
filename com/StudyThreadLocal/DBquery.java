package com.StudyThreadLocal;

import java.util.concurrent.TimeUnit;

/**
 * 模拟查询处理
 */
public class DBquery {
    public void query() {
        PerformanceTracker.startPhase();

        try {
            Thread.sleep((int)(Math.random()* TimeUnit.SECONDS.toMillis(5)));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        PerformanceTracker.endPhase("DBQuery");
    }
}

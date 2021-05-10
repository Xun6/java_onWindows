package com.StudyThreadLocal;

import java.util.ArrayList;
import java.util.List;

/**
 * ThreadLocal使用示例
 */
public class PerformanceTracker {
    //  静态内部类
    private static class Phase {
        /**
         * 带参构造方法
         * @param name  处理逻辑的名称
         * @param duration  程序处理持续时间
         */
        public Phase(String name, long duration) {
            this.name = name;
            this.duration = duration;
        }

        private String name;
        private long duration;

        // 重写toString方法
        @Override
        public String toString() {
            return "Phase{" +
                    "name='" + name + '\'' +
                    ", duration=" + duration +
                    "}\n";
        }
    }

    // TODO ThreadLocal一般都是 static的
    // TODO 这样使用ThreadLocal，这些数据不用在应用程序之间传递，而且还可以为每个线程保留自己的一份数据
    private static final ThreadLocal<List<Phase>> PHASES = new ThreadLocal<>();
    private static final ThreadLocal<Long> PHASE_START_TIME = new ThreadLocal<>();
    // 重置初始化(确保每个线程执行前，ThreadLocal均初始化（存储一个副本）)
    public static void reset() {
        PHASES.set(new ArrayList<>());
        PHASE_START_TIME.set(-1L);
    }

    //模拟开始阶段
    public static void startPhase() {
        PHASE_START_TIME.set(System.currentTimeMillis()); //设置存入当前时间值
    }

    // 模拟结束阶段
    public static void endPhase(String phaseName) {
        long start = PHASE_START_TIME.get(); // 取出时间值
        // 添加元素（Phase对象）到List中
        PHASES.get().add(new Phase(phaseName, System.currentTimeMillis() - start));
    }

    //
    public static void finish() {
        List<Phase> phases = PHASES.get(); // 获取存储在ThreadLocal中的 List对象（Phase）
        PHASES.set(null); // 清空 ThreadLocal
        PHASE_START_TIME.set(null); // 清空 ThreadLocal

        StringBuilder out = new StringBuilder("------Thread Execution Phase Durations---------\n");
        phases.forEach(out::append);
        out.append("--------------------------------------\n");
        System.out.println(out.toString());
    }
}

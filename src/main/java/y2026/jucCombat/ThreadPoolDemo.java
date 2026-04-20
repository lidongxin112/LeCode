package y2026.jucCombat;
import java.util.concurrent.*;

/**
 * 题目.5
 * 写一个线程池，并说明提交任务后的执行流程。
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(
                2,
                4,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        try {
            for (int i = 1; i <= 8; i++) {
                int taskId = i;
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " 执行任务 " + taskId);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                });
            }
        } finally {
            pool.shutdown();
        }
    }
}

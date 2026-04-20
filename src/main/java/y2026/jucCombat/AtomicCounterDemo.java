package y2026.jucCombat;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多个线程同时对计数器加一，最后结果准确。
 */
public class AtomicCounterDemo {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger counter = new AtomicInteger(0);

        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    counter.incrementAndGet();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("最终结果: " + counter.get());
    }
}

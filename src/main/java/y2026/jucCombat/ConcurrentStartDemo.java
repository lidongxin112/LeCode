package y2026.jucCombat;

import java.util.concurrent.CountDownLatch;

/**
 * 题目.4
 * 多个线程准备好后同时开始执行，最后主线程等它们都结束。
 */
public class ConcurrentStartDemo {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 5;
        CountDownLatch readyLatch = new CountDownLatch(threadCount);
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch doneLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("线程 " + index + " 准备中");
                    readyLatch.countDown();
                    startLatch.await();

                    System.out.println("线程 " + index + " 开始执行");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    doneLatch.countDown();
                }
            }).start();
        }

        readyLatch.await();
        long start = System.currentTimeMillis();
        startLatch.countDown();
        doneLatch.await();
        long end = System.currentTimeMillis();

        System.out.println("总耗时: " + (end - start) + " ms");
    }
}

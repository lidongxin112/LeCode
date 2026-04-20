package y2026.jucCombat;

import java.util.concurrent.CountDownLatch;

/**
 * 题目.4
 * 主线程要等 3 个子线程都执行完，才能继续执行。
 */
public class LatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 1; i <= 3; i++) {
            int index = i;
            new Thread(() -> {
                try {
                    System.out.println("子线程 " + index + " 开始执行");
                    Thread.sleep(1000L * index);
                    System.out.println("子线程 " + index + " 执行完成");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown();
                }
            }).start();
        }

        latch.await();
        System.out.println("所有子线程执行完成，主线程继续");
    }
}

package y2026.jucCombat;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int threadCount = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadCount, () -> {
            System.out.println("所有线程准备完成，一起出发！");
        });
        for (int i = 1; i <= threadCount; i++) {
            int id = i;
            new Thread(() -> {
                try {
                    System.out.println("线程 " + id + " 正在准备...");
                    Thread.sleep((long) (Math.random() * 2000));

                    System.out.println("线程 " + id + " 已准备，等待其他线程");
                    barrier.await(); // 核心点

                    System.out.println("线程 " + id + " 开始执行任务！");
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}

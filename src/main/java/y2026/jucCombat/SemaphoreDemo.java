package y2026.jucCombat;

import java.util.concurrent.Semaphore;

/**
 * 题目.4
 * 模拟 10 个线程抢车位，但同一时刻只能 3 个线程进入。
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 10; i++) {
            int carNo = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("车辆 " + carNo + " 进入停车场");
                    Thread.sleep(2000);
                    System.out.println("车辆 " + carNo + " 离开停车场");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}

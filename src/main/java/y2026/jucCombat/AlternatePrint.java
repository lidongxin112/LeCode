package y2026.jucCombat;

/**
 * 题目.1
 * 两个线程，一个打印奇数，一个打印偶数，交替输出 1~100。
 */
public class AlternatePrint {
    private int num = 1;
    private final Object lock = new Object();
    public void printOdd() {
        while (true) {
            synchronized (lock) {
                while (num <= 100 && num % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if (num > 100) {
                    lock.notifyAll();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " -> " + num++);
                lock.notifyAll();
            }
        }
    }
    public void printEven() {
        while (true) {
            synchronized (lock) {
                while (num <= 100 && num % 2 == 1) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }

                if (num > 100) {
                    lock.notifyAll();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " -> " + num++);
                lock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        AlternatePrint ap = new AlternatePrint();
        new Thread(ap::printOdd, "odd").start();
        new Thread(ap::printEven, "even").start();
    }
}

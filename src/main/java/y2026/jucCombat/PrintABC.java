package y2026.jucCombat;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目.2
 * 三个线程分别打印 A、B、C，要求按顺序循环打印 10 次。
 */
public class PrintABC {
    private final Lock lock = new ReentrantLock();
    private final Condition conditionA = lock.newCondition();
    private final Condition conditionB = lock.newCondition();
    private final Condition conditionC = lock.newCondition();

    private int state = 1; // 1-A, 2-B, 3-C

    public void printA(int times) {
        for (int i = 0; i < times; i++) {
            lock.lock();
            try {
                while (state != 1) {
                    conditionA.await();
                }
                System.out.print("A");
                state = 2;
                conditionB.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } finally {
                lock.unlock();
            }
        }
    }

    public void printB(int times) {
        for (int i = 0; i < times; i++) {
            lock.lock();
            try {
                while (state != 2) {
                    conditionB.await();
                }
                System.out.print("B");
                state = 3;
                conditionC.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } finally {
                lock.unlock();
            }
        }
    }

    public void printC(int times) {
        for (int i = 0; i < times; i++) {
            lock.lock();
            try {
                while (state != 3) {
                    conditionC.await();
                }
                System.out.print("C");
                state = 1;
                conditionA.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintABC printer = new PrintABC();
        int times = 10;

        new Thread(() -> printer.printA(times)).start();
        new Thread(() -> printer.printB(times)).start();
        new Thread(() -> printer.printC(times)).start();
    }
}

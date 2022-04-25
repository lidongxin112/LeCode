package JUC.Lock;

/**
 * 死锁
 *
 * @author 东鑫
 */
public class deadlock {
//    public static void main(String[] args) {
//        Object j1 = new Object();
//        Object j2 = new Object();
//        Thread t1 = new Thread(new T1(j1, j2));
//        Thread t2 = new Thread(new T1(j2, j1));
//        t1.start();
//        t2.start();
//    }

    static class T1 implements Runnable {
        Object o1;
        Object o2;

        public T1(Object o1, Object o2) {
            this.o1 = o1;
            this.o2 = o2;
        }

        @Override
        public void run() {
            synchronized (o1) {
                System.out.println(Thread.currentThread().getName()+"\t自己持有"+o1+"\t尝试获取"+o2);

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (o2) {
                System.out.println(Thread.currentThread().getName()+"\t自己持有"+o2+"\t尝试获取"+o1);
            }
        }
    }

     static class DealLockThread implements  Runnable {
        private String lockA;
        private String lockB;

        public DealLockThread(String lockA, String lockB) {
            this.lockA = lockA;
            this.lockB = lockB;
        }

        @Override
        public void run() {
            synchronized (lockA){
                System.out.print(Thread.currentThread().getName()+"\t自己持有"+lockA+"\t尝试获取"+lockB);
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockB){
                    System.out.print(Thread.currentThread().getName()+"\t自己持有"+lockB+"\t尝试获取"+lockA);
                }
            }

        }
        /**
         */
        public static void main(String[] args) {
            // TODO Auto-generated method stub
            String lockA = "lookA";
            String lockB = "lookB";
            new Thread(new DealLockThread(lockA,lockB),"ThreadAAA").start();
            new Thread(new DealLockThread(lockB,lockA),"ThreadBBB").start();

        }
    }
}

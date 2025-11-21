//package simple;
//
//import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.BlockingDeque;
//import java.util.concurrent.LinkedBlockingDeque;
//
//public class ThreadPool {
//    BlockingDeque<Runnable> workQueue;
//    List<WorkQueue> workThreadList = new ArrayList<>();
//    ThreadPool(int poolSize,BlockingDeque<Runnable> workQueue){
//        this.workQueue = workQueue;
//        for(int i=0;i<poolSize;i++){
//            WorkThread workThread = new WorkThread();
//            workThread.start();
////            workThreadList.add(workThread);
//        }
//    }
//    void execute(Runnable command) throws Exception {
//        workQueue.put(command);
//    }
//
//
//    class WorkThread extends Thread{
//        @Override
//        public void run() {
//            while(true){
//                Runnable task = null;
//                try {
//                    task = workQueue.take();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                task.run();
//            }
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//            BlockingDeque<Runnable> workQueue = new LinkedBlockingDeque<>();
//            ThreadPool  pool = new ThreadPool(2,workQueue);
//            for (int i=0;i<10;i++){
//                final int num = i;
//                pool.execute(()->{
//                    System.out.println("线程"+num+"执行");
//                });
//            }
//    }
//}
//

package com.utils;//package com.utils;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang3.concurrent.BasicThreadFactory;
//import org.springframework.stereotype.Component;
//
//import java.util.Map;
//import java.util.concurrent.*;
//
//
///**
// * @author 东鑫
// */
//@Component
//@Slf4j
//public class ThreadPoolExecutorUtil {
//
//
//    private static volatile ThreadPoolExecutorUtil INSTANCE;
//
//   private ThreadPoolExecutorUtil(){
//
//   }
//   private static Map<String, ExecutorService> map = new ConcurrentHashMap<>();
//
//   public static ThreadPoolExecutorUtil getInstance(){
//       if (INSTANCE==null){
//           synchronized (ThreadPoolExecutorUtil.class){
//               if (INSTANCE==null){
//                   return new ThreadPoolExecutorUtil();
//               }
//           }
//       }
//       return INSTANCE;
//   }
//    /**
//     * 创建线程池
//     * 所对应的相应参数
//     */
//   public ExecutorService getThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
//                                                long keepAliveTime, TimeUnit unit,
//                                                int workQueueSize,
//                                                String poolName){
//       if (corePoolSize<=0||maximumPoolSize>corePoolSize|| StringUtils.isEmpty(poolName)||workQueueSize<=0){
//                      log.warn("参数不合规，请检查！！！！！!");
//       }
//       if (map.containsKey(poolName)){
//           return map.get(poolName);
//       }
//       return new ThreadPoolExecutor(corePoolSize,maximumPoolSize,keepAliveTime,unit,
//               new LinkedBlockingDeque<>(workQueueSize),
//               new BasicThreadFactory.Builder().namingPattern(poolName).daemon(false).build(),
//               new ThreadPoolExecutor.AbortPolicy()
//       );
//   }
//
//}

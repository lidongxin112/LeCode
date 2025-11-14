package com.utils;//package com.utils;
//
//import com.lmax.disruptor.SleepingWaitStrategy;
//import com.lmax.disruptor.dsl.Disruptor;
//import com.lmax.disruptor.dsl.ProducerType;
//
//import java.util.concurrent.Executors;
//
///**
// * @author 东鑫
// */
//public class DisruptorQueueFactory {
//
//    public DisruptorQueueFactory() {
//
//    }
//
//    //点对点模式
//
//    @SafeVarargs
//    public static <T> DisruptorQueue<T> getWorkPoolQueue(int queueSize, boolean isMoreProducer,
//                                                         ObjectDisruptorConsumer<T>... consumers) {
//        Disruptor<ObjectEvent<T>> disruptor = new Disruptor<>(new ObjectEventFactory<>(),
//                queueSize,
//                Executors.defaultThreadFactory(),
//                isMoreProducer ? ProducerType.MULTI : ProducerType.SINGLE,
//                new SleepingWaitStrategy());
//        disruptor.handleEventsWithWorkerPool(consumers);
//        return new DisruptorQueue<>(disruptor);
//    }
//
//    //发布订阅模式 多个消费者同时消费
//
//    @SafeVarargs
//    public static <T> DisruptorQueue<T> getHandleEventQueue(int queueSize, boolean isMoreProducer,
//                                                            ObjectDisruptorConsumer<T>... consumers) {
//        Disruptor<ObjectEvent<T>> disruptor = new Disruptor<>(new ObjectEventFactory<>(),
//                queueSize,
//                Executors.defaultThreadFactory(),
//                isMoreProducer ? ProducerType.MULTI : ProducerType.SINGLE,
//                new SleepingWaitStrategy());
//        disruptor.handleEventsWith(consumers);
//        return new DisruptorQueue<>(disruptor);
//    }
//
//    public static <T> DisruptorQueue<T> getQueue(Disruptor<ObjectEvent<T>> disruptor) {
//        return new DisruptorQueue<>(disruptor);
//    }
//}

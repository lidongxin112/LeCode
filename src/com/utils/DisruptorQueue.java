//package com.utils;
//
//import com.lmax.disruptor.RingBuffer;
//import com.lmax.disruptor.dsl.Disruptor;
//
//import java.util.Iterator;
//import java.util.List;
//
///**
// * @author 东鑫
// * 事件发布器
// */
//
//public class DisruptorQueue<T> {
//
//    private Disruptor<ObjectEvent<T>> disruptor;
//
//    private RingBuffer<ObjectEvent<T>> ringBuffer;
//
//    public DisruptorQueue(Disruptor<ObjectEvent<T>> disruptor) {
//        this.disruptor = disruptor;
//        this.ringBuffer = disruptor.getRingBuffer();
//        this.disruptor.start();
//    }
//
//    public void add(T t) {
//        long sequence = 0;
//        if (t != null) {
//            sequence = this.ringBuffer.next();
//        }
//        try {
//            ObjectEvent<T> event = this.ringBuffer.get(sequence);
//            event.setData(t);
//        } finally {
//            this.ringBuffer.publish(sequence);
//        }
//    }
//
//    public void addAll(List<T> ts) {
//        if (ts != null) {
//            Iterator<T> var = ts.iterator();
//            while (var.hasNext()) {
//                T t = var.next();
//                if (t != null) {
//                    add(t);
//                }
//            }
//        }
//    }
//
//    public long cursor() {
//        return this.disruptor.getRingBuffer().getCursor();
//    }
//
//    public void shutdown() {
//        this.disruptor.shutdown();
//    }
//
//    public Disruptor<ObjectEvent<T>> getDisruptor() {
//        return this.disruptor;
//    }
//
//    public void setDisruptor(Disruptor<ObjectEvent<T>> disruptor) {
//        this.disruptor = disruptor;
//    }
//
//    public RingBuffer<ObjectEvent<T>> ringBuffer() {
//        return this.ringBuffer;
//    }
//
//    public void setRingBuffer(RingBuffer<ObjectEvent<T>> ringBuffer) {
//        this.ringBuffer = ringBuffer;
//    }
//}

//package com.utils;
//
//import com.lmax.disruptor.EventHandler;
//import com.lmax.disruptor.WorkHandler;
//import lombok.extern.slf4j.Slf4j;
//import me.chanjar.weixin.common.error.WxErrorException;
//
//import java.io.FileNotFoundException;
//
///**
// * @author 东鑫
// * 事件consumer
// */
//@Slf4j
//public abstract class ObjectDisruptorConsumer<T> implements EventHandler<ObjectEvent<T>>, WorkHandler<ObjectEvent<T>> {
//
//    @Override
//    public void onEvent(ObjectEvent<T> event, long sequence, boolean endOfBatch) throws Exception {
//        this.onEvent(event);
//    }
//
//    @Override
//    public void onEvent(ObjectEvent<T> event) throws Exception {
//        this.consume(event.getData());
//    }
//
//    public abstract void consume(T var) throws FileNotFoundException, WxErrorException;
//}

package com.utils.coding;//package com.utils.coding;
//
//import com.suixingpay.notifier.utils.kafka.utils.BeanUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.kafka.common.header.Headers;
//import org.apache.kafka.common.serialization.Serializer;
//
//import java.util.Map;
//
///**
// * @Author:东鑫
// */
//@Slf4j
//public class EncodingKafka implements Serializer<Object> {
//
//    public EncodingKafka() {
//    }
//
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//        Serializer.super.configure(configs, isKey);
//    }
//
//    @Override
//    public byte[] serialize(String topic, Object data) {
//        return BeanUtils.beanToByte(data);
//    }
//
//    @Override
//    public byte[] serialize(String topic, Headers headers, Object data) {
//        return Serializer.super.serialize(topic, headers, data);
//    }
//
//    @Override
//    public void close() {
//        Serializer.super.close();
//    }
//}

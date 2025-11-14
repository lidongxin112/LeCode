package com.utils.coding;//package com.utils.coding;
//
//
//import com.suixingpay.notifier.utils.kafka.utils.BeanUtils;
//import org.apache.kafka.common.serialization.Deserializer;
//
//import java.util.Map;
//
//public class DecodingKafka implements Deserializer<Object> {
//
//    public DecodingKafka() {
//    }
//
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//        Deserializer.super.configure(configs, isKey);
//    }
//
//    @Override
//    public Object deserialize(String topic, byte[] data) {
//        return BeanUtils.byteToObject(data);
//    }
//
//    @Override
//    public void close() {
//        Deserializer.super.close();
//    }
//}

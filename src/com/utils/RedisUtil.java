//package com.utils;
//
//import com.suixingpay.ace.redis.IRedisOperater;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * @Author:东鑫
// */
//@Slf4j
//@Component
//public class RedisUtil {
//    @Resource
//    private IRedisOperater redisOperater;
//
//    //redis记录的前缀名
//    private static final String PER_STR = "notifier";
//
//    /**
//     * 统计重试的次数
//     * @param name
//     */
//    public void addNumber(String name) {
//        try {
//            String key = PER_STR + "_" + name;
//            redisOperater.incr(key);
//        } catch (Exception e) {
//            log.error("redis插入数据失败" + e);
//        }
//    }
//
//    /**
//     * 查询当前已经失败的次数
//     * @param name
//     */
//    public Long getNumber(String name){
//        Long num = 0L;
//        try {
//            String key = PER_STR + "_" + name;
//            num = redisOperater.getLong(key);
//        }catch (Exception e){
//            log.error("redis提取数据失败"+e);
//        }
//        return num;
//    }
//
//    public void delete(String name){
//        try {
//            String key = PER_STR + "_" + name;
//            redisOperater.delete(key);
//        }catch (Exception e){
//            log.error("redis提取数据失败"+e);
//        }
//    }
//
//}

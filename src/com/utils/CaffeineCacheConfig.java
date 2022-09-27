//package com.utils;
//
//import com.github.benmanes.caffeine.cache.Cache;
//import com.github.benmanes.caffeine.cache.CacheLoader;
//import com.github.benmanes.caffeine.cache.Caffeine;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.caffeine.CaffeineCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author 东鑫
// */
//
//@Slf4j
//@EnableCaching
//@Configuration
//public class CaffeineCacheConfig {
//
//    //具体规则对应
//    @Bean("caffeine")
//    public Cache<String,String> caffeineCache(){
//        return Caffeine.newBuilder()
//                .maximumSize(100)
////                .refreshAfterWrite(5,TimeUnit.MINUTES)
//                .build();
//    }
//
//    @Bean
//    public CacheLoader<String, Object> cacheLoader() {
//        CacheLoader<String, Object> cacheLoader = new CacheLoader<String, Object>() {
//            @Override
//            public Object load(String key) throws Exception {
//                return null;
//            }
//            // 重写这个方法将oldValue值返回回去，进而刷新缓存
//            @Override
//            public Object reload(String key, Object oldValue) throws Exception {
//                return oldValue;
//            }
//        };
//        return cacheLoader;
//    }
//    @Bean("cache")
//    public Caffeine caffeineConfig() {
//        return Caffeine.newBuilder()
//                .maximumSize(100)
//                .refreshAfterWrite(5, TimeUnit.MINUTES)
//                .removalListener((key, value, cause) ->
//                        log.info("key:" + key + "value:" + value + "删除的原因" + cause));
//    }
//    //全部的group 对应的pattern
//    @Bean(name = "caffeineManager")
//    public CacheManager cacheManager(Caffeine caffeine,CacheLoader cacheLoader) {
//        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
//        caffeineCacheManager.setCacheLoader(cacheLoader);
//        caffeineCacheManager.setCaffeine(caffeine);
//        return caffeineCacheManager;
//    }
////    @Bean(name = "caffeineManager")
////    public CacheManager cacheManager(Caffeine caffeine) {
////        CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
////        caffeineCacheManager.setCaffeine(caffeine);
////        return caffeineCacheManager;
////    }
//
//
//
//}

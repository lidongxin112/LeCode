//package com.utils;
//
//
//import com.github.benmanes.caffeine.cache.CacheLoader;
//import com.github.benmanes.caffeine.cache.Caffeine;
//import com.github.benmanes.caffeine.cache.Expiry;
//import com.github.benmanes.caffeine.cache.LoadingCache;
//import com.suixingpay.notifier.domain.Rule;
//import com.suixingpay.notifier.utils.kafka.config.CaffeineCacheConfig;
//import com.suixingpay.notifier.utils.pattren.DataObject;
//import lombok.extern.slf4j.Slf4j;
//import org.checkerframework.checker.index.qual.NonNegative;
//import org.springframework.cache.Cache;
//import org.springframework.cache.CacheManager;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
///**
// * 初始化cache
// *
// * @author 东鑫
// */
//@Slf4j
//@Component
//public class CaffeineUtil {
//
//    @Resource
//    private CaffeineCacheConfig config;
////    public static Map<String, Object> ObjToMap(Object obj){
////        Map<String, Object> map = new HashMap<>();
////        Field[] declaredFields = obj.getClass().getDeclaredFields();
////        for (Field filed : declaredFields) {
////            filed.setAccessible(true);
////            try {
////                map.put(filed.getName(), filed.get(obj));
////            } catch (IllegalAccessException e) {
////                log.info("数据提取失败，请检查缓存是否生效！！！");
////                e.printStackTrace();
////            }
////        }
////        return map;
////    }
//
////    public Map<String, Object> Cache() {
////        Caffeine caffeine = util.caffeineConfig();
////        CacheLoader<String, Object> cacheLoader = util.cacheLoader();
////        CacheManager cacheManager = util.cacheManager(caffeine,cacheLoader);
////
////        Cache cache = cacheManager.getCache("caffeineManager");
////        Object nativeCache = cache.getNativeCache();
////        Map<String, Object> map = (Map<String, Object>) ObjToMap(nativeCache).get("cache");
////        return map;
////    }
//    public Cache Cache() {
//        Caffeine caffeine = config.caffeineConfig();
//        CacheLoader<String, Object> cacheLoader = config.cacheLoader();
//        CacheManager cacheManager = config.cacheManager(caffeine,cacheLoader);
//        Cache cache = cacheManager.getCache("caffeineManager");
////        CacheManager cacheManager = util.cacheManager(caffeine);
////        Cache cache = cacheManager.getCache("caffeineManager");
////        Object nativeCache = cache.getNativeCache();
////        Map<String, Object> map = (Map<String, Object>) ObjToMap(nativeCache).get("cache");
//        return cache;
//    }
//    public List<Rule> list(String group){
//        Cache cache = Cache();
//        Cache.ValueWrapper wrapper = cache.get(group);
//        Object obj = wrapper.get();
//        return (List<Rule>) obj;
//    }
//
//    public LoadingCache<String, DataObject> createSynchronizeCache() {
//        LoadingCache<String, DataObject> cache = Caffeine.newBuilder()
//                .maximumSize(100)
//                .removalListener((key, value, cause) ->
//                        log.info("key:" + key + "value:" + value + "删除的原因" + cause))
//                .expireAfter(new Expiry<String, DataObject>() {
//
//                    @Override
//                    public long expireAfterCreate(String key, DataObject value, long currentTime) {
//                        return 1000 * 60 * 60 * 24;
//                    }
//
//                    @Override
//                    public long expireAfterUpdate(String key, DataObject value, long currentTime, @NonNegative long currentDuration) {
//                        return currentDuration;
//                    }
//
//                    @Override
//                    public long expireAfterRead(String key, DataObject value, long currentTime, @NonNegative long currentDuration) {
//                        return currentDuration;
//                    }
//                })
//                .weakKeys()
//                .weakValues()
//                .refreshAfterWrite(1, TimeUnit.MINUTES)
//                .build(key -> DataObject.get("Data for" + key));
//
//        return cache;
//    }
//}

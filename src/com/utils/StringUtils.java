//package com.utils;
//
//import com.github.benmanes.caffeine.cache.Cache;
//import com.github.benmanes.caffeine.cache.LoadingCache;
//import com.suixingpay.notifier.utils.kafka.config.CaffeineCacheConfig;
//import com.suixingpay.notifier.utils.pattren.DataObject;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.text.StringSubstitutor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.server.PathContainer;
//import org.springframework.stereotype.Component;
//import org.springframework.web.util.pattern.PathPattern;
//import org.springframework.web.util.pattern.PathPatternParser;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author 东鑫
// */
//@Slf4j
//@Component
//public class StringUtils {
//
//    @Autowired
//    private PathPatternParser parser;
//
//    @Autowired
//    private CaffeineCacheConfig config;
//
//    /**
//     * @param noticeName 通知名
//     * @param pattern    group对应的pattern集合
//     * @return
//     */
//    public String stringTemplate(String noticeName, List<String> pattern) {
//        Cache<String, String> cache = config.caffeineCache();
//        String relPattern = "";
//        int max = 0;
//        Map<Integer, String> map = new HashMap<>();
//        PathPattern pathPattern = null;
//        PathPattern pathPattern1 = null;
//        if (cache.getIfPresent(noticeName)!=null) {
//            relPattern = cache.getIfPresent(noticeName);
//            return relPattern;
//        }
//
//        pathPattern = parser.parse(noticeName);
//        for (String pat : pattern) {
//            pathPattern1 = parser.parse(pat);
//            int i = pathPattern1.compareTo(pathPattern);
//            boolean matches = pathPattern.matches(PathContainer.parsePath(pat));
//            if (matches){
//                cache.put(noticeName,pat);
//                return pat;
//            }
//            max = Math.max(max,i);
//            map.put(max,pat);
//        }
//        relPattern = map.get(max);
//        cache.put(noticeName,relPattern);
//        return relPattern;
//    }
//    /**
//     * @param template 模板
//     * @param content  消息内容
//     * @return
//     */
//    public String stringReplace(String content, String template) {
//        String[] split = content.split("-");
//        Map<String, String> map = new HashMap<>();
//        for (String s : split) {
//            map.put(s, s);
//        }
//        StringSubstitutor s = new StringSubstitutor(map);
//        String resolvedString = s.replace(template);
//        return resolvedString;
//    }
//
//
//}

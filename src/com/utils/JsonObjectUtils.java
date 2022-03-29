//package com.utils;
//
//import com.google.gson.Gson;
//import com.suixingpay.ace.exception.BadRequestException;
//import com.suixingpay.notifier.domain.serviceVo.*;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//
///**
// * @author 东鑫
// */
//@Slf4j
//@Component
//public class JsonObjectUtils {
//
//    public Object jsonChange(String subChannel, String config) {
//        //String json = JSON.toJSONString(config);
//        String json = config;
//        Object obj = null;
//        Gson gson = new Gson();
//        switch (subChannel) {
//            case "robot":
//                WXRobotMessage wxRobotMessage = gson.fromJson(json, WXRobotMessage.class);
//                break;
//            case "group":
//                obj = gson.fromJson(json, WXGroupMessage.class);
//                break;
//            case "app":
//                obj = gson.fromJson(json, WXApplicationMessage.class);
//                break;
//            case "sms":
//                obj = gson.fromJson(json, SmsMessage.class);
//                break;
//            case "mail":
//                obj = gson.fromJson(json, MailMessage.class);
//                break;
//            default:
//                log.warn("接受的格式不对请重试!!!!");
//                throw new BadRequestException("暂不支持" + subChannel + "方式发送！");
//        }
//        return obj;
//    }
//}

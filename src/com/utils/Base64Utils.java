//package com.utils;
//
//import Decoder.BASE64Decoder;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.*;
//
//
//@Slf4j
//public class Base64Utils implements MultipartFile,Serializable {
//
//    private  byte[] imgContent;
//
//    private String header;
//
//    public Base64Utils() {
//    }
//
//    public Base64Utils(byte[] imgContent, String header) {
//        this.imgContent = imgContent;
//        this.header = header;
//    }
//
//    @Override
//    public String getName() {
//        return System.currentTimeMillis() + Math.random() + "." + header.split("/")[1];
//    }
//
//    @Override
//    public String getOriginalFilename() {
//        return System.currentTimeMillis() + Math.random() * 10000 + "." + header.split("/")[1];
//    }
//
//    @Override
//    public String getContentType() {
//        return header.split(":")[1];
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return imgContent == null || imgContent.length == 0;
//    }
//
//    @Override
//    public long getSize() {
//        return imgContent.length;
//    }
//
//    @Override
//    public byte[] getBytes() throws IOException {
//        return imgContent;
//    }
//
//    @Override
//    public InputStream getInputStream() throws IOException {
//        return new ByteArrayInputStream(imgContent);
//    }
//
//    @Override
//    public void transferTo(File dest) throws IOException, IllegalStateException {
//        new FileOutputStream(dest).write(imgContent);
//    }
//
//    public  MultipartFile base64(String base64) {
//        try {
//            String[] baseStrs = base64.split(",");
//            BASE64Decoder decoder = new BASE64Decoder();
//            byte[] b = new byte[0];
//            b = decoder.decodeBuffer(baseStrs[1]);
//            for (int i=0;i<b.length;i++){
//                if (b[i]<0){
//                    b[i]+=256;
//                }
//            }
//            String[] split = baseStrs[0].split(";");
//            return new Base64Utils(b,split[0]);
//        }catch (Exception e){
//            e.printStackTrace();
//            log.warn("base64转换失败");
//            return null;
//        }
//    }
//}

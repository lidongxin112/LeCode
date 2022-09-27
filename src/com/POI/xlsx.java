//package com.POI;
//
//import java.io.*;
//import java.util.Date;
//
//public class xlsx {
//    public static void main(String[] args) {
//        encryptExcel();
//    }
//
//    private static void encryptExcel() {
//        String filePath = System.getProperty("dir");
//        if (StringUtils.isBlank(filePath)) {
//            filePath = "customer.xlsx";
//        }
//        //POI 解析
//        try {
//            File file;
//            FileInputStream inputStream;
//            FileOutputStream outputStream;
//            BufferedInputStream input;
//
//            File outFile = new File("decrypt.xlsx");
//            if (!outFile.exists()) {
//                outFile.createNewFile();
//            } else {
//                File tmpFile = new File("decrypt" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmss") + ".xlsx");
//                outFile.renameTo(tmpFile);
//                outFile.createNewFile();
//            }
//            // 先读取,分析数据
//            String path = "F:\\ss\\aa.xlsx";
//
//            file = new File(path);
//            inputStream = new FileInputStream(file);
//            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
//            // 同时创建Excel表 输出Excel
//            String pat = "F:\\ss\\v.xlsx";
//            file = new File(pat);
//            outputStream = new FileOutputStream(file);
//            XSSFWorkbook hssfWork = new XSSFWorkbook();
//            int number = workbook.getNumberOfSheets();
//            for (int i = 0; i < number; i++) {
//                XSSFSheet sheetAt = workbook.getSheetAt(i);
//                String sheetName = sheetAt.getSheetName();
//                XSSFSheet sheet = hssfWork.createSheet(sheetName);
//                // t
//                XSSFRow sheetRow = sheet.createRow(0);
//                XSSFRow row = sheetAt.getRow(0);
//                short lastCellNum = row.getLastCellNum();
//                int lastRowNum = sheetAt.getLastRowNum();
//                int phone = 0;
//                for (int k=0;k<lastCellNum;k++) {
//                    String cellValue = row.getCell(k).getStringCellValue();
//                    if ("phone".equals(cellValue)){
//                        phone = k;
//                    }
//                    sheetRow.createCell(k).setCellValue(cellValue);
//                }
//
//                for (int j = 1; j <= lastRowNum; j++) {
//                    sheetRow = sheet.createRow(j);
//                    row = sheetAt.getRow(j);
//                    for (int k=0;k<lastCellNum;k++) {
//                        String cellValue = row.getCell(k).getStringCellValue();
//                        if (k==phone){
//                            cellValue = EncryptUtils.encrypt(cellValue,"mobile0123456789");
//                        }
//                        sheetRow.createCell(k).setCellValue(cellValue);
//                    }
//                }
//            }
//            hssfWork.write(outputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
////
////
////    public void aa() {
////        for (int j = 0; j < lastCellNum; j++) {
////            String cellValue = row.getCell(j).getStringCellValue();
////            sheetRow.createCell(j).setCellValue(cellValue);
////            if (cellValue.equals("phone")) {
////                int lastRowNum = sheetAt.getLastRowNum();
////                for (int k = 1; k <= lastRowNum; k++) {
////                    String cell = row.getCell(k).getStringCellValue();
////                    cell = EncryptUtils.encrypt(cell, "mobile0123456789");
////                    sheetRow.createCell(j).setCellValue(cell);
////                }
////            } else {
////                int lastRowNum = sheetAt.getLastRowNum();
////                for (int k = 1; k <= lastRowNum; k++) {
////                    String cell = row.getCell(k).getStringCellValue();
////                    String cel = EncryptUtils.encrypt(cell, "mobile0123456789");
////                    sheetRow.createCell(j).setCellValue(cel);
////                }
////            }
////        }
////
////        int lastRowNum = sheetAt.getLastRowNum();
////        for (int k = 1; k <= lastRowNum; k++) {
////            for (int j = 0; j < lastCellNum; j++) {
////                String cellValue = row.getCell(j).getStringCellValue();
////                sheetRow.createCell(j).setCellValue(cellValue);
////            }
////        }
////    }
//}

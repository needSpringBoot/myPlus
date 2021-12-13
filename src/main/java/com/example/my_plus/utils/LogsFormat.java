package com.example.my_plus.utils;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class LogsFormat {

    public static String format(String data) throws IOException {
        File file = new File(data);
        String text = IOUtils.toString(new FileInputStream(file), "UTF-8");
        String[] arr = text.split("\n");
        JsonParser parser = new JsonParser();
        String time, log;
        StringBuilder sb = new StringBuilder(1024 * 10);
        for (int i = 0; i < arr.length; i++) {
            try {
                JsonObject jsonObject = parser.parse(arr[i]).getAsJsonObject();
//                time = jsonObject.get("time").getAsString();
                log = jsonObject.get("log").getAsString();
//                sb.append(i + 1);
//                sb.append("\t");
                sb.append(log);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        try {
//            String format = format(readFileContent("C:\\Users\\qinkun\\Desktop\\76e26aaf54c0789c49dfef0532f6c86387a0de4afcece64a822a5c6b8e3a8121\\76e26aaf54c0789c49dfef0532f6c86387a0de4afcece64a822a5c6b8e3a8121-json.log"));
            String format = format("C:\\Users\\qinkun\\Desktop\\76e26aaf54c0789c49dfef0532f6c86387a0de4afcece64a822a5c6b8e3a8121\\76e26aaf54c0789c49dfef0532f6c86387a0de4afcece64a822a5c6b8e3a8121-json.log");
            System.out.println(format);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }




}

package com.bjb.mainMethod;

import com.mysql.jdbc.StringUtils;

import java.io.*;

/**
 * @Description
 * @Author XJT
 * @CreateDate
 * @Return
 * @Version
 */
public class ReadTxt {
    public static void main(String[] args) {
        File file = new File("F:/box/res/一级栏目/二级栏目/资源/简介.txt");
        if (file.exists()) {
            String content = txtString(file);
            if (!StringUtils.isEmptyOrWhitespaceOnly(content)) {
                System.out.println(content);
            } else {
                System.out.println("txt文本内容为空");
            }
        }
    }

    private static String txtString(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "GBK"));//构造一个BufferedReader类来读取文件
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {//使用readLine方法，一次读一行
                stringBuilder.append(tempStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringBuilder.toString();
    }
}

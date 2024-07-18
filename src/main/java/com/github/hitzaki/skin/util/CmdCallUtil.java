package com.github.hitzaki.skin.util;

import java.io.*;

/**
 * 系统调用
 * @author hitzaki
 */
public class CmdCallUtil {
    private static final String CMD_SUFFIX = "bat";
    /**
     * 执行单个cmd指令 或 批处理文件
     */
    public static void exeCmdOne(String locationCmd){
        try {
            Process process = Runtime.getRuntime().exec(locationCmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while((line = br.readLine())!=null){
                System.out.println(new String(line.getBytes(), "GBK"));
            }
            br.close();
            try {
                process.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 执行一个批处理文件 使用resources下的相对路径
     */
    public static void exeCmdByRelative(String relativeBatPath){
        // 解析
        // TODO 检查文件前后缀, 后期抽取成单独的工具
//        if (!CMD_SUFFIX.equals(relativeBatPath.substring(relativeBatPath.lastIndexOf(".")+1))){
//            relativeBatPath = relativeBatPath + "." + CMD_SUFFIX;
//        }
        // TODO 应该开启另一个线程 或 使用线程池执行 避免双向指令阻塞主线程
        InputStream inputStream = CmdCallUtil.class.getResourceAsStream(relativeBatPath);
        if (inputStream != null) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while((line = br.readLine())!=null){
                    System.out.println(line);
                    exeCmdOne(line);
                }
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 调用执行程序
    }
}

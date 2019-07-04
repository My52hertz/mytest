package com.hertz.io;

import java.io.*;

/**
 * @author sunyi,
 * @date 2019/6/6,
 * @time 11:11,
 */
public class MyIOInputStream {
    public static  void main(String[] args) throws IOException {
        /**
        * 什么是IO流？
         * 就是数据的流向，数据从一段向另一端的流向
         * 所以就有一端想另一端，数据源和目的地
         * 分类：以程序为中心
         * 流向来分：输入流和输出流
         * 以数据来分：
         *      字节流：二进制，可以处理一切：文本，doc,音频
         *      字符流：文本文件，其他的处理不了
         * 按功能分：
         *      节点流：包裹源头
         *      处理流：增强功能，提供性能
         *
         * 常用IO流：字节流和字符流
         * 1. 字节流（抽象类）：
         * 输入流：InputStream 输出流：OutPutStream（文件FileInputStream,FileOutPutStream）
         * 2. 字符流
         * 输入流：Reader 输出流 writer
         *
         * 操作：1. 建立联系 2. 选择流 3. 操作,就是数组大小+read+write 4. 释放资源
        */
        //FileCopy(new File("/Users/sunyi/Downloads/study/其他/dns日志数据.txt"),new File("/Users/sunyi/Downloads/study/其他/dns日志数据1.txt"));
        AllCopy(new File("/Users/sunyi/Downloads/study/其他/dns日志数据.txt"),new File("/Users/sunyi/Downloads/study/haha/"));
    }
    public static void AllCopy(File file,File NewFile)  {
        File file1 = file;
        File newFile = NewFile;

        if(file1.isDirectory()){
            newFile = new File(NewFile.getPath(),file1.getName());

        }
        FileCopyde(file1,newFile);


    }

    private static void FileCopyde(File file1, File newFile) {
        if (file1.isFile() && !file1.isHidden()){
            try {
                FileCopy(file1,newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (file1.isDirectory()){
            newFile.mkdirs();
            for (File fi: file1.listFiles()) {
                FileCopyde(fi, new File(newFile,fi.getName()));
                System.out.println(fi);
            }
        }
    }

    public static void FileCopy(File file,File newFile) throws IOException {
        File file1 = file;
        File newFile1 = newFile;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileOutputStream = new FileOutputStream(newFile1);
            byte[] by = new byte[(int) file1.length()];
            int len = 0;
            while (-1 != (len=fileInputStream.read(by))){
                fileOutputStream.write(by,0,len);
                fileOutputStream.flush();
            }
        } catch (FileNotFoundException e) {
            System.out.println(file1.getName()+"文件打开失败");
        } catch (IOException e) {
            System.out.println("文件读取失败");
        }finally {
            //先打开的后关闭
            fileOutputStream.close();
            fileInputStream.close();

        }


    }

    public static void FileW(){
        //1. 建立联系
        File file = new File("/Users/sunyi/Downloads/study/其他/dns日志数据.txt");
        //2. 选择流
        OutputStream out = null;
        try {
            //OutputStream out;
            out = new FileOutputStream(file,true);
            //3. 定义长度
           String str = "haha";

            out.write(str.getBytes());
            out.flush();

            } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
        } catch (IOException e) {
            System.out.println("文件写入失败");
        }finally {
            if (out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("文件写出失败");
                }
            }
        }
    }
    public static void FileRW() throws IOException {
        //1. 建立联系
        File file = new File("/Users/sunyi/Downloads/study/其他/dns日志数据.txt");
        //2. 选择流
        InputStream fileInputStream = new FileInputStream(file);
        // 3. 定义长度
        byte[] bytes = new byte[(int)file.length()];
        int len = 0;
        // 4. 读取
        while (-1 != (len=fileInputStream.read(bytes))){
            String str =  new String(bytes,0,len);
            System.out.println(str);
        }
        // 5. 关系流
        fileInputStream.close();
    }
}

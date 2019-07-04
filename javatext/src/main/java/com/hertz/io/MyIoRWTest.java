package com.hertz.io;

import java.io.*;

/**
 * 字符流：
 * 字符流只能读取人类可识别的文本，就是txt可以打开的。
 */
public class MyIoRWTest {
    public static void main(String[] args) throws IOException {


//        Mywriter(new File("/Users/sunyi/Downloads/study/其他/dns日志数据.txt"));
//        MyRead(new File("/Users/sunyi/Downloads/study/其他/dns日志数据.txt"));
        //(new File("/Users/sunyi/Downloads/study/其他/dns日志数据.txt"),new File("/Users/sunyi/Downloads/study/其他/dns日志数据2.txt"));
        MyAll(new File("/Users/sunyi/Downloads/study/其他/"),new File("/Users/sunyi/Downloads/study/haha/"));

    }
    public static  void MyAll(File file,File newfile) throws IOException {

        if (file.isDirectory()){
            newfile = new File(newfile.getPath(),file.getName());
        }


        copyall(file,newfile);
    }

    public static void copyall(File file, File newfile) throws IOException {
        System.out.println(1);
        if (file.isFile() && !file.isHidden()){
            System.out.println(2);
            MyRW(file,newfile);
        }else if(file.isDirectory()){

            newfile.mkdirs();

            for (File fi :file.listFiles()) {
                copyall(fi,new File(newfile,fi.getName()));
            }
        }
    }


    public static void MyRW(File file ,File Newfile) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = new FileWriter(Newfile);
        char[] chars = new char[(int) file.length()];
        int len = 0;
        try {
            if (file.isFile() && !file.isHidden()){
                fileReader = new FileReader(file);
                if (-1 != (len=fileReader.read(chars))){
                    fileWriter.write(chars,0,len);
                }
            }
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileWriter.close();
            fileReader.close();
        }


    }

    public static void Mywriter(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write("hertz");
        fileWriter.close();

    }

    public static void MyRead(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
        char[] ch = new char[(int) file.length()];
        int len = 0;

        if(-1 != (len=fileReader.read(ch))){
            String s = new String(ch,0,len);
            System.out.println(s);
        }
    }

}

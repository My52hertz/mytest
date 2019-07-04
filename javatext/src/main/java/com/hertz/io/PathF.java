package com.hertz.io;

import java.io.File;
import java.io.IOException;


/**
 * @author sunyi,
 * @date 2019/6/5,
 * @time 12:16,
 */
public class PathF {
    public static  void main(String[] args) throws IOException, InterruptedException {
        test4();
    }
    private static void test4() {
        File file = new File("/Users/sunyi/Downloads/study/其他/");
        if (file.exists()){
            if (file.isDirectory()){
                String[] list = file.list(); //展示文件夹下面的所有文件。
                for (String strig : list) {
                    System.out.println(strig);
                }
            }else if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            }
            File[] files = file.listFiles();
            System.out.println("+++++++++++++++++++++++++++++++");
            for (File fi :files) {
                System.out.println(fi);
            }
        }
    }
    public static void test3() throws IOException, InterruptedException {
        File tempFile = File.createTempFile("tes", "_tmp", new File("/Users/sunyi/Downloads/study/其他/"));
        Thread.sleep(20000);
        tempFile.deleteOnExit();//退出即删除
    }

    public static void test2() throws IOException {
        File path = new File("/Users/sunyi/Downloads/study/其他/aaa");
        if(!path.exists()){
            boolean newFile = path.createNewFile();
            System.out.println(newFile==true?"成功":"失败");
        }else {
            System.out.println("创建文件失败");
        }
        boolean delete = path.delete();
        System.out.println(delete);
    }

    public static void test1(){
        File file = new File("/Users/sunyi/Downloads/study/其他/dns日志数据.txt");
        System.out.println("判断文件是否存在"+file.exists()); //判断文件是否存在
        System.out.println("是否可读"+file.canWrite()+"是否可写"+file.canRead()); //文件是否可读写
        System.out.println("是文件"+file.isFile()+"是文件夹"+file.isDirectory());  //没有真实存在，默认文件夹
        System.out.println("是否是绝对路径"+file.isAbsolute());
        long length = file.length(); //字节数,文件夹长度是0，只能读文件的
        System.out.println(length);
    }
    public  static void test(){
        /**
         * 获取文件名的方式
         */
        //File file = new File("/52hertz/用户/sunyi/下载/dns日志数据.txt");
        File file = new File("txt.txt");
        System.out.println(file.getPath());//如果定义的是绝对名称，返回绝对名称，否则返回相对路径
        System.out.println(file.getName()); //返回名称
        System.out.println(file.getAbsolutePath()); // 返回绝对路径
        System.out.println(file.getParent()); // 返回上级目录。没有返回null，声明的路径。
    }
}
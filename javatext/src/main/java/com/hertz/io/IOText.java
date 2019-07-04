package com.hertz.io;

import javafx.scene.shape.Path;

import java.io.File;

/**
 * @author sunyi,
 * @date 2019/6/5,
 * @time 11:30,
 */
public class IOText {
    public static  void main(String[] args) {
        /**
         * file是文件和路径名称的抽象表现形式
         * pathSeparat
         * 两个常用常量
         * 路径分隔符：pathSeparator就是一个分隔符，路径分隔符
         * 名称分隔符：File.separator
         *
         */
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);

        //路径的表示形式(推荐使用)
        String path = "/52hertz/用户/sunyi/下载/";
        String name = "dns日志数据.txt";
        //System.out.println(path);
        File file = new File(new File(path),name); //相对路径。
        System.out.println(file.getName());
        File file1 = new File("/52hertz/用户/sunyi/下载/dns日志数据.txt");
        System.out.println(file.getName()); //绝对路径。

        file1 = new File("tet.txt");
        System.out.println(file1.getName());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());

    }
}

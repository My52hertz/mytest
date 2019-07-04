package com.hertz.io;

import java.io.*;
import java.util.stream.Stream;


/**
 * @author sunyi,
 * @date 2019/6/6,
 * @time 16:29,
 * 处理流是处理流的流，不直接连接到数据源或者目的地，是处理数据的留，通过对其他流的处理提其他流的性能。和操作灵活性
 * 针对字节：
 * 字节缓冲流：和字节流没有很大的区别，因此，在操作的时候可以加上。提升性能。
 * BufferedInputStream
 * BufferOutPutStream
 * 针对字符：
 * 字符缓冲流
 * BufferedReader  readline
 * BufferWriter    newline(换行符)
 * 字符缓冲流：自己特有的方法，比方说readline,
 *
 *
 */
public class Mychuliliu {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/sunyi/Downloads/study/其他/dns日志数据.txt");
        zifu(file);

    }
    public static void zifu(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        char[] ch = new char[(int) file.length()];
        String str = null;
        while((str = bufferedReader.readLine()) != null)
           System.out.println(str);

    }






    public static void zijie(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        byte[] by = new byte[(int) file.length()];
        int len = 0;
        if(-1!= (len=bufferedInputStream.read(by))){
            String s = new String(by,0,len);
            System.out.println(s);
        }
        bufferedInputStream.close();
    }
}

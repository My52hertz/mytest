package com.hertz.io;

import java.io.*;

/**
 * @author sunyi,
 * @date 2019/6/11,
 * @time 10:30,
 * 转换流：
 * 只能字节流转换成字符流：主要就是处理乱码的（编码集，解码集）
 * 乱码一般是编码集不一致，导致乱码
 * 字节数长度不够。
 *
 * 输出流：OutPutStringWriter 编码
 * 输入流：InPutStringReader  解码
 *
 *
 * 从文件中读取类型和字符串：只能是基本数据类型+字符串 保留数据+类型 dataInputStream  dataOutputStream
 *                             引用类型 保留数据+类型 ObjectInputSream ObjectOutPutStream 使用该类型必须进行序列化，有的元素不需要进行序列化，可以使用transient进行声明。
 *                             两个流的顺序必须一致。
 *
 *
 *
 */
public class ZHL {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("a")),"utf-8"));


    }
}

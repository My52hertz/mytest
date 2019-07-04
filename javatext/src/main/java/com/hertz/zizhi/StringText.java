package com.hertz.zizhi;

/**
 * @author sunyi,
 * @date 2019/6/13,
 * @time 21:02,
 */

class Demo{
    String temp = "String1";
}
public class StringText {
    public static void main(String[] args){
        Demo demo = new Demo();
        demo.temp = "woed";
        System.out.println(demo.temp);
        fun(demo);
        System.out.println(demo.temp);

    }
    public static void fun(Demo demo1){
        demo1.temp = "STRING";
    }

}

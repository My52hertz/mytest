package com.hertz.type;

/**
 * @author sunyi,
 * @date 2019/6/13,
 * @time 14:00,
 */
public class KB {
    public static void main(String[] args){
       add(1,2,3);



    }

    private static void add(int... arr) {
       for (int x = 0;x <arr.length;x++){
           arr[x] = arr[x]+10;
           System.out.println(arr[x]);
       }
    }

}

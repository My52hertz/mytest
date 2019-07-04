package com.hertz.type;

/**
 * 方法的重载一定参数类型或者个数的不一致，如果是方法的返回值不一致，那么就不是方法的重载、
 * return可以返回到方法的调用处，
 *
 */
public class CZ {
    public static void main(String[] args){
     //fun(10);//retuen结束方法，并将代码返回调用处。
       System.out.println( sun(1));
    }
    public static int sun(int x){
        if (x<=1){
            return 1;
        }else {
            return x+sun(x-1);
        }
    }

    public static void fun(int x){
        System.out.println(1);

        if (x==10){
            return;
        }

        System.out.println(2);
    }




    public static int add(int a,int b){
        int tmp = 0;
        return tmp = a+b;

    }
    public static int add(int a,int b,int c){
        int tmp = 0;

        return tmp = a+b+c;
    }
    public static float add(float a,float b){
        float tmp = 0;
        return tmp = a+b;

    }
}

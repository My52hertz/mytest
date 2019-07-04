package com.hertz.type;

import java.util.Arrays;

/**
 * @author sunyi,
 * @date 2019/6/11,
 * @time 15:53,
 */
public class num {
    public static void main(String[] args){
        /**
        * 功能描述:
        * 数组声明是在栈中保留了数据的名称
         * 数组的定义是在堆内存中分配内存
        */
        int arr[] =  {1,2,3,4,5,6};
        int arr1[] =  {11,22,33,44,55,66};
        System.arraycopy(arr,1,arr1,2,3);
        Arrcopy(arr,1,arr1,2,3);

       Arrays.sort(arr);
       for (int arr2:arr1){
           System.out.println(arr2);
       }

       // MinMax(arr);
        //Px(arr);
    }

    private static void Arrcopy(int[] arr, int i, int[] arr1, int i1, int i2) {
        for (int x = 0; x < i2; x++) {
            arr1[i1+x] = arr[i+x];

        }
    }

    private static void Px(int[] arr) {

        for (int x = 0; x<arr.length;x++){
            for (int y=0;y<arr.length;y++){
                if (arr[x] < arr[y]) {
                    int tmp = arr[x];
                    arr[x]= arr[y];
                    arr[y] = tmp;
                }
            }
        }
        for (int x : arr){
            System.out.println(x);
        }

    }

    public  static void MinMax(int[] arr){
        int max =0;
        int min = 0;


        for (int x =0;x<arr.length;x++){
            if(arr[x] > max){
                max = arr[x];
            }
            if (arr[x] < min){
                min = arr[x];
            }

        }
        System.out.println("max" + max+"  "+"min"+min);

    }
}

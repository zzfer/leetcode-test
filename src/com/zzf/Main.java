package com.zzf;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {
        int[] i = {1, 20, 30, 70, 40, 80, 90, 10 };
        int target = 10;
        System.out.println("最终结果下标是："+Arrays.toString(sum(i, target)));
    }


    public static int[] sum(int[] is, int target){
        int [] result = new int[2];
        int a = 0;
        for(int i = 0; i < is.length ; i++){
            for(int j = i+1; j < is.length ; j++){
                if(is[i] + is[j] >= target){
                    if(a == 0){
                        a = is[i] + is[j];
                        result[0] = i;
                        result[1] = j;
                    }
                    if(a > is[i] + is[j]){
                        a = is[i] + is[j];
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return result;
    }
}

package com.zzf;

/**
 * 循环 和 递归
 *
 * @author zhaozhifei
 * @className CyclicAndRecursion
 * @date 2022/3/8
 */
public class CyclicAndRecursion {

    public static void main(String[] args) {

        long startCyclic = System.currentTimeMillis();
        Cyclic(100000);
        long endCyclic = System.currentTimeMillis();
        System.out.println();
        System.out.println("循环使用：" + (endCyclic - startCyclic) + "毫秒");


        long startRecursion = System.currentTimeMillis();
        Recursion(100000);
        System.out.println();
        long endRecursion = System.currentTimeMillis();
        System.out.println("递归使用：" + (endCyclic - startCyclic) + "毫秒");
    }

    /**
     * 循环
     *
     * @param num
     */
    public static void Cyclic(Integer num) {
        for (int i = 0; i < num; i++) {
            System.out.print(i);
        }
    }

    /**
     * 递归
     *
     * @param num
     */
    public static void Recursion(Integer num) {
        if (num != 0) {
            Recursion(num - 1);
            System.out.print(num);
        }
    }
}

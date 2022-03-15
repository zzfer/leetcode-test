package com.zzf;

/**
 * 求多项式的值
 * <p>
 * 求给定多项式在定点x处的值
 * <p>
 * f(x) = a₀ + a₁x + ... + a(n-₁)x(n-¹) + an x的n次方
 *
 * @author zhaozhifei
 * @className Polynomial
 * @date 2022/3/8
 */
public class Polynomial {

    public static void main(String[] args) {

        long start1 = System.currentTimeMillis();
        double[] a = {1, 2, 3, 4};
        System.out.println(Polynomial1(3, a, 3));
        long end1 = System.currentTimeMillis();
        System.out.println("求多项式的值：" + (end1 - start1) + "毫秒");

        double[] b = {1, 2, 3, 4};
        long start2 = System.currentTimeMillis();
        System.out.println(Polynomial2(3, b, 3));
        long end2 = System.currentTimeMillis();
        System.out.println("优化后：" + (end2 - start2) + "毫秒");
    }

    /**
     * 求多项式的值
     * f(x) = a₀ + a₁x + ... + a(n-₁)x(n-¹) + an x的n次方
     *
     * @param n 系数
     * @param a a₀ a₁.....
     * @param x x的n次方
     */
    public static double Polynomial1(int n, double[] a, double x) {
        double p = a[0];
        for (int i = 1; i <= n; i++) {
            p += (a[i] * Math.pow(x, i));
        }
        return p;
    }

    /**
     * 优化多项式的值
     * f(x) = a₀ + a₁x + ... + a(n-₁)x(n-¹) + an x的n次方
     *
     * @param n 系数
     * @param a a₀ a₁.....
     * @param x x的n次方
     */
    public static double Polynomial2(int n, double[] a, double x) {

        double p = a[n];
        for (int i = n; i > 0; i--) {
            p = a[i - 1] + x * p;
        }
        return p;
    }
}

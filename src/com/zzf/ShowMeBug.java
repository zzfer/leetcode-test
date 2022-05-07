package com.zzf;

import java.util.HashMap;

/**
 * 棒球得分
 */
public class ShowMeBug {
  // 请根据题目要求确定返回值类型和参数列表(输入)
  public int solution(String[] a) {
    HashMap map = new HashMap();
    int result = 0;
    // 在这⾥书写你的代码
    for(int i = 0; i < a.length; i++){
      if(a[i].equals("+")){
        a[i] = String.valueOf(result);
        result += result;
      }else if(a[i].equals("D")){
        a[i] = String.valueOf(Integer.valueOf(a[i-1])+ Integer.valueOf(a[i-2]));
        result += (Integer.valueOf(a[i-1])+ Integer.valueOf(a[i-2]));
      }else if(a[i].equals("C")){
        a[i] = String.valueOf(-Integer.valueOf(a[i-1]));
        result -= Integer.valueOf(a[i-1]);
      }else{
        result += Integer.valueOf(a[i]);
      }
    }
    return result;
  }

  // 本题面试官未设置测试用例
  // 请在 main 函数书写自己的测试代码
  public static void main(String[] args) {
    ShowMeBug instance = new ShowMeBug();
    // 测试代码参考示例，请根据题目修改
    String[] sample = {"5","2","C","D","+"};
    int ret = instance.solution(sample);
    if (ret == 30) {
      System.out.printf("succeed to execute, expected result is 30, got %d", ret);
    } else {
      System.out.printf("failed to execute, expected result is 30, got %d", ret);
    }
  }
}
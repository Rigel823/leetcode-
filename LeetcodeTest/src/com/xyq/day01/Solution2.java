package com.xyq.day01;

import java.util.Arrays;

public class Solution2 {
        public String largestNumber(int[] nums) {
            int n = nums.length;    //获取输入数组长度
            String[] ss = new String[n];    //新建一个等长数组
            for (int i = 0; i < n; i++){    //把数据转换为字符串，依次存入新建数组中
                ss[i] = "" + nums[i];
            }
            Arrays.sort(ss, (a, b) -> {     //运用数组的排序方法进行排序
                String sa = a + b, sb = b + a ;
                return sb.compareTo(sa);
            });

            StringBuilder sb = new StringBuilder(); //字符串对象
            for (String s : ss){    //拼接
                sb.append(s);
            }
            int len = sb.length();  //获取长度
            int k = 0;
            while (k < len - 1 && sb.charAt(k) == '0') {
                k++;
            }
            return sb.substring(k);
        }
}

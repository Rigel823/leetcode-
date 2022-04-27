package com.xyq.day01;

import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;    //获取输入整型数组的长度
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        /**
         * 1. 定义一个和原数组一样大的引用类型的数组
         * 2. for循环遍历原数组数组，把数据值放在引用类型数组中
         * 调用数组方法，对其进行排序
         *
         * Comparator是外部比较器，
         *      用于比较来对象与对象之间的，两个对象进行比较，
         *      多用于集合排序
         * 而Comparable可以认为是一个内比较器，根据对象某一属性进行排序的
         *
         * Lambda 表达式是 JDK8 的一个新特性，可以取代大部分的匿名内部类，写出更优雅的 Java 代码，
         *  尤其在集合的遍历和其他集合操作中，可以极大地优化代码结构。
         *  Lambda 规定接口中只能有一个需要被实现的方法，不是规定接口中只能有一个方法
         *  语法形式为 () -> {}，其中 () 用来描述参数列表，{} 用来描述方法体，-> 为 lambda运算符 ，读作(goes to)。
         */
        Integer[] numsArr = new Integer[n];     //构建等长的引用类型的整型数组
        for (int i = 0; i < n; i++) {   //for循环，将输入数组的值存放在引用类型的数组中
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {    //调用Arrays的sort方法，这里运用了Lambda表达式，理解为一个返回值就好
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();    //引用类型，用ret来存放字符串
        for (int num : numsArr) {   //for循环遍历数组，把这些字符串进行拼接
            ret.append(num);
        }
        return ret.toString();      //以字符串的形式返回
    }
}
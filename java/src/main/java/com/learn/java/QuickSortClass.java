package com.learn.java;

public class QuickSortClass {
    public static void main(String[] args) {
        int[] temp = new int[]{5, 1, 10, 99, 2, 4, 6, 22, 25, 88, 65, 74};
        quickSort(temp, 0, temp.length - 1);
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

    public static void quickSort(int s[], int l, int r) {
        if (l < r) {
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) {  //从右向左找第一个小于x的数
                    j--;
                }
                if (i < j) {  //有可能会有i=j的情况
                    s[i] = s[j];
                    i++;
                }

                while (i < j && s[i] < x) {  // 从左向右找第一个大于等于x的数
                    i++;
                }
                if (i < j) {  //有可能会有相等的情况
                    s[j] = s[i];
                    j--;
                }
            }
            s[i] = x;
            quickSort(s, l, i - 1); // 递归调用
            quickSort(s, i + 1, r);
        }
    }

}


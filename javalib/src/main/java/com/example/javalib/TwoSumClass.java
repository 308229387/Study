package com.example.javalib;

import java.util.HashMap;
import java.util.Map;

public class TwoSumClass {
    static int[] a = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        int[] b = twoSum(a, 9);
        System.out.println(b[0] +"");
        System.out.println(b[1] +"");
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
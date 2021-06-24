package com.gyy.demo.service.Singleton;

import java.util.Arrays;

public class Solution136 {

    public int singleNumber(int[] nums) {

        int len = nums.length;
        if (len < 2) {
            return nums[0];
        }
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[len - 1] != nums[len - 2]) {
            return nums[len - 1];
        }

        for (int i = 1; i < len - 1; i++) {
            if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return 0;
    }

    /*
    用异或
    任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
    任何数和其自身做异或运算，结果是 00，即 a \oplus a=0a⊕a=0。
    异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
     */
    public int singleNumber2(int[] nums) {
        int a = 0;
        for (int num : nums) {
            a = a ^ num;
        }
        return a;
    }

}

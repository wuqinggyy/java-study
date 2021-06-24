package com.gyy.demo.service.Singleton;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution217 {

    /**
     * 时间过长
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if(set.size() == nums.length){
            return false;
        }else{
            return true;
        }

    }
}

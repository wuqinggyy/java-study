package com.gyy.demo.service.Singleton;

public class Solution283 {

    public void moveZeroes(int[] nums) {

        if(nums == null){

            return;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != 0 ){
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i++] = tmp;
            }
        }

    }


}

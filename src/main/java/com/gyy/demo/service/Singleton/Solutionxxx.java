package com.gyy.demo.service.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.relational.core.sql.In;

public class Solutionxxx {

    public int[] intersect(int[] nums1, int[] nums2) {

        Set<Integer> list = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    list.add(nums1[i]);
                }
            }
        }
        int[] intArray = new int[list.size()];
        for (int i = 1; i < list.size(); i++) {
            intArray[i] = list.;
        }
        return intArray;

    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.getOrDefault()
    }

}

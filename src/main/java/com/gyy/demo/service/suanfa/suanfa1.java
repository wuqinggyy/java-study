package com.gyy.demo.service.suanfa;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 题目：给定一个数组，传入一个参数，参数为几就找出队列中最小的几个数；
 * 
 */
public class suanfa1 {

    public static Integer[] sort(Integer[] arr,int a){
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.set(arr[i],1);
        }

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == 1){
                resultList.add(i);
            }
        }

        Integer[] tmp =new Integer[resultList.size()];
        list.toArray(tmp);
        return tmp;
    }

    public static void main(String[] args) {
        Integer[] arr = {9,0,1,3,5,7,8};
//       Arrays.sort(arr);
       Arrays.parallelSort(arr, Collections.reverseOrder());
    }
}

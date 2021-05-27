package com.gyy.demo.service.suanfa;

public class paixu {

    public static void main(String[] args) {
        int count = 0;
        int[] inta = {1,3,5,6,8,10,12,3};
        for(int i = 0 ;i<inta.length;i++){
            for(int j=0;j<i;j++){
                System.out.println(count++);
                if(inta[i] == inta[j]){
                    break;
                }

            }

        }
    }
}

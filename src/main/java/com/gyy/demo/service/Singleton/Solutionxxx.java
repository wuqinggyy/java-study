package com.gyy.demo.service.Singleton;

public class Solutionxxx {

    public int reverse(int x) {

        int rev= 0;
        if(rev< Integer.MAX_VALUE/10 || rev > Integer.MAX_VALUE/10){
            return 0;
        }
        while(x != 0){
            int digit = x%10;
            x = x/10;
            rev = rev*10 + digit;
        }

        return  rev;
    }


}

package com.gyy.demo.service.Singleton;

import java.util.Stack;

public class Solution20 {


    public boolean isValid(String s) {

        int len = s.length();
        if (len % 2 == 1) {
            return false;
        }

        char[] cc = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (cc[i] == '(' || cc[i] == '[' || cc[i] == '{') {
                stack.push(cc[i]);
            } else {
                if ( ! stack.isEmpty() && ((cc[i] == ')' && stack.peek() == '(')
                    || (cc[i] == ']' && stack.peek() == '[')
                    || (cc[i] == '}' && stack.peek() == '{'))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

}

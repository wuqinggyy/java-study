package com.gyy.demo.service;

public class fanxing {


    public static <E> void printArray(E[] inputArray) {
        for (E e : inputArray) {
            System.out.printf("" + e);
        }
    }

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("Array integerArray contains:");
        printArray(intArray); // 传递一个整型数组

        System.out.println("\nArray doubleArray contains:");
        printArray(doubleArray); // 传递一个双精度型数组

        System.out.println("\nArray characterArray contains:");
        printArray(charArray); // 传递一个字符型型数组
    }
}

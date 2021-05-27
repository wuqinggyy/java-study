package com.gyy.demo.service.map;

import sun.net.util.IPAddressUtil;

import java.util.*;

public class MapTest {



    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1,"dskj");
        map.put(2,"dsk11j");
        map.put(3,"ds222kj");
        Set<Map.Entry> set = map.entrySet();
        Set<String> stringSet = map.keySet();
        Collection collection =  map.values();
        System.out.println("1234");
    }
}

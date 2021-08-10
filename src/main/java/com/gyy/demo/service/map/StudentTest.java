package com.gyy.demo.service.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class StudentTest {

    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        Student gyy = new Student();
        gyy.setName("gyy");
        gyy.setAge(28);
        gyy.setSex("man");

        Student cxf = new Student();
        cxf.setName("cxf");
        cxf.setAge(28);
        cxf.setSex("woman");

        Student gq = new Student();
        gq.setName("gq");
        gq.setAge(31);
        gq.setSex("woman");

        list.add(gyy);
        list.add(cxf);
        list.add(gq);

        List<Student>  qqq = list.stream().filter( student -> student.getAge() >30).collect(Collectors.toList());
        System.out.println(qqq.toArray());

        list.stream().forEach(student -> {
            if("gyy".equals(student.getName())) {
                student.setAge(50);
            }
        });
        System.out.println(123);

        int sum = list.stream().mapToInt(Student::getAge).sum();
        System.out.println(sum);





        Stream<Integer> maxStream = Stream.of(1,3,5,7,2,4);
        Integer max = maxStream.max(Integer::compareTo).get();

        Stream<Integer> minStream = Stream.of(1,3,5,7,2,4);
        Integer min = minStream.min(Integer::compareTo).get();

        Stream<Integer> finaFirstStream = Stream.of(1,3,5,7,2,4);
        Integer findFirst = finaFirstStream.findFirst().get();

        Stream<Integer> peekStream = Stream.of(1,3,5,7,2,4);
        List<Integer> integers = peekStream.peek(integer -> System.out.println(integer.intValue() + 1)).collect(Collectors.toList());


        Stream<String> stringStream = Stream.of("a","a","b","c");
        stringStream.distinct().forEach(e-> System.out.println(e));

        System.out.println(max);
        System.out.println(min);
        System.out.println(findFirst);


    }

}

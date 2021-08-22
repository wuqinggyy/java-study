package com.gyy.demo.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Sort;

/**
 * @author Administrator
 */
public class Person implements Comparable<Person> {

    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age &&
            name.equals(person.name);
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person a = new Person();
        a.setAge(11);
        a.setName("gyy1");
        Person b = new Person();
        b.setAge(10);
        b.setName("gyy2");
        Person c = new Person();
        c.setAge(18);
        c.setName("gyy3");
        System.out.println(a == b);
        System.out.println(a.equals(b));
        list.add(a);
        list.add(b);
        list.add(c);
        System.out.println(list.toString());
//        Collections.sort(list);
        list.sort(Comparator.comparing(Person::getAge).reversed());
        System.out.println(list.toString());
    }


    @Override
    public int compareTo(Person o) {
//        if (this.age > o.getAge()) {
//            return 1;
//        } else if (this.age < o.getAge()) {
//            return -1;
//        } else {
//            return 0;
//        }
        return 0;
    }
}

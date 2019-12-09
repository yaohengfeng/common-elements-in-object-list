package com.github.hcsp.collection;

import java.util.*;

public class Main {
    // 请编写一个方法，获得a和b集合中的公共元素。
    public static Set<Person> commonElementsIn(List<Person> a, List<Person> b) {

        List<Person> list = new LinkedList<Person>();
        list.addAll(a); //把list复制过来，避免影响原数组
        list.retainAll(b); //内部会通过equals判断是否相同
        return new HashSet<Person>(list);
    }

    // Person类，如果两个Person对象的name相等，则认为这两个对象相等。
    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if ( obj instanceof Person ) {
                Person p = (Person) obj;
                return Objects.equals(name, p.getName());
            }

            return false;
        }

        @Override
        public String toString() {
            return "{name="+name+"}";
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) {
        List<Person> list1 = Arrays.asList(new Person("张学友"), new Person("周杰伦"));
        List<Person> list2 = Arrays.asList(new Person("周润发"), new Person("周杰伦"));
        System.out.println(commonElementsIn(list1, list2));
    }
}

package com.hertz.type;

/**
 * @author sunyi,
 * @date 2019/6/13,
 * @time 14:54,
 */
class Person {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public Person() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void fun(Person per){
        System.out.println(per.age+"  "+per.name);
    }




}
public class Person1{
    public static void main(String[] args){
        Person person = new Person();


    }

}


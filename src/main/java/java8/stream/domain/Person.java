package java8.stream.domain;

import java.util.List;

public class Person {

    private Long id;

    private String name;

    private int age;

    private Double price;

    private List list;

    public Person() {
        System.out.println("hello");
    }

    public Person(String name) {
        this.name = name;
        System.out.println("name");
    }

    public Person(Long id, String name, int age, List list) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.list = list;
    }

    public Person(Long id, String name, int age, Double price, List list) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.price = price;
        this.list = list;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("name, age");
    }

    private Person(int age) {
        this.age = age;
        System.out.println("age");
    }

    public Person(List list) {
        this.list = list;
        System.out.println("list");
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List getList() {
        return this.list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", list=" + list +
                '}';
    }
}

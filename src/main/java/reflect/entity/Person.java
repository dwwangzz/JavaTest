package reflect.entity;

import java.util.List;

public class Person implements IPerson {
	
	public String str = "I am str";
	
	private String name;
	
	private int age;
	
	private List list;
	
	public Person(){
		System.out.println("hello");
	}
	public Person(String name){
		this.name = name;
		System.out.println("name");
	}
	
	public Person(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println("name, age");
	}
	
	private Person(int age){
		this.age = age;
		System.out.println("age");
	}
	
	public Person(List list){
		this.list = list;
		System.out.println("list");
	}

	public String getName() {
		return name;
	}

	@Override
	public void eat() {
		System.out.println("person eat 了！");
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
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "Person [str=" + str + ", name=" + name + ", age=" + age + ", list=" + list + "]";
	}
}

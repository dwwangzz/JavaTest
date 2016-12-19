package reflect;

import org.junit.Test;
import reflect.entity.Person;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 1.加载类
 * 2.解析各个组成部分
 * @author wangzz-a
 * @version $Id: ReflectDemo.java, v 0.1 2015年8月5日 下午4:38:26 wangzz-a Exp $
 */
@SuppressWarnings({"unchecked", "rawtypes"})
public class ReflectDemo {

    public static void main(String[] args) throws Exception {

    }


    /**
     * 加载类 - 获得类字节码的几种方式（获取类类型的方法）
     */
    @Test
    public void getPersionClass() throws ClassNotFoundException {
        //获得类字节码的几种方式
        //1.
        Class clazz = Class.forName("reflect.entity.Person");
        System.out.println(clazz);
        //2.
        Class p = new Person().getClass();
        System.out.println(p);
        //3.
        Class c = Person.class;
        System.out.println(c);
    }

    @Test
    public void test1() throws Exception {
        //反射没有参数的构造函数
        Class clazz = Person.class;
        Constructor c = clazz.getConstructor(null);
        Person p = (Person) c.newInstance(null);
        System.out.println(p);
    }

    @Test
    public void test2() throws Exception {
        //反射有一个参数的构造函数
        Class clazz = Person.class;
        Constructor c = clazz.getConstructor(String.class);
        Person p = (Person) c.newInstance("小明");
        System.out.println(p);
        System.out.println(p.str);
    }

    @Test
    public void test3() throws Exception {
        //反射有两个参数的构造函数
        Class clazz = Person.class;
        Constructor c = clazz.getConstructor(String.class, int.class);
        Person p = (Person) c.newInstance("小明", 18);
        System.out.println(p);
        System.out.println(p.str);
    }

    @Test
    public void test4() throws Exception {
        //反射有集合参数的构造函数
        Class clazz = Person.class;
        System.out.println(List.class);
        Constructor c = clazz.getConstructor(List.class);
        //Person p = (Person) c.newInstance(new ArrayList());
        //String [] arr = {"a","b","c"};
        //Person p = (Person) c.newInstance(Arrays.asList(arr));
        Person p = (Person) c.newInstance(new ArrayList<String>(Arrays.asList(new String[]{"A", "B", "C", "D"})));
        System.out.println(p);
        System.out.println(p.str);
    }

    @Test
    public void test5() throws Exception {
        //反射私有构造函数
        Class clazz = Person.class;
        Constructor c = clazz.getDeclaredConstructor(int.class);
        //暴力反射
        c.setAccessible(true);
        Person p = (Person) c.newInstance(17);
        System.out.println(p);
        System.out.println(p.str);
    }

    @Test
    public void test6() throws Exception {
        //创建对象的另外一种途径
        Class clazz = Class.forName("reflect.entity.Person");
        Person p = (Person) clazz.newInstance();
        System.out.println(p);
        System.out.println(p.str);
    }

}

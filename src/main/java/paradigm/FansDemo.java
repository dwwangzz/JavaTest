package paradigm;

/**
 * Created by wangzz on 2016/9/14.
 */

import GsonUtil.GsonUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 如果没有泛型，我们表示一个二维的坐标
 */
class Test {

    public static void main(String[] args) {

        //没有泛型的时候我们表示一个二维坐标点
        noFanXing();

        //有泛型的时候我们表示一个二维坐标点
        //hasFanXing();

        //泛型类
        //test1();

        //泛型接口
        //非泛型类实现泛型接口
        //test2();
        //泛型类实现泛型接口
        //test3();

        //泛型方法
        //fanMethod();

        //Class<T>类传递
        //test4();

        //泛型数组
        //test5();

        //绑定类、绑定多个限定
        //test6();

        //通配符？
        //test7();


    }

    /**
     * 通配符？
     */
    private static void test7() {
        //无边界通配符 ?
        //如果没有通配符我们new4个实例
        Point<Integer> integerPoint = new Point<Integer>(3, 3);
        Point<Float> floatPoint = new Point<Float>(4.3f, 4.3f);
        Point<Double> doublePoint = new Point<Double>(4.3d, 4.90d);
        Point<Long> longPoint = new Point<Long>(12l, 23l);

        Point<?> point;
        point = new Point<Integer>(3, 3);
        point = new Point<Float>(4.3f, 4.3f);
        point = new Point<Double>(4.3d, 4.90d);
        point = new Point<Long>(12l, 23l);

        //通配符？的extends绑定
        Point<? extends Number> point1;
        point1 = new Point<Integer>(3, 3);
        point1 = new Point<Float>(4.3f, 4.3f);
        point1 = new Point<Double>(4.3d, 4.90d);
        //下面这条语句是编译报错的，因为point通配符已经限定了泛型只能为Number了
        //point1 = new Point<String>("aaa", "bbb");//编译报错
        //注意：利用<? extends Number>定义的变量，只可取其中的值，不可修改
        //point1.setX(4.3d);//编译报错

        //通配符？的super绑定
        //super通配符实例内容：能存不能取
        List<? super Manager> temp;
        temp = new ArrayList<Employee>();
        temp = new ArrayList<Manager>();
        //temp = new ArrayList<CEO>();//编译错误

        List<? super Manager> list;
        list = new ArrayList<Employee>();
        //存
        //list.add(new Employee()); //编译错误
        list.add(new Manager());
        list.add(new CEO());
        Object obj = list.get(0);
        System.out.println(obj);

        //总结 ?extends 和 the?super 通配符的特征，我们可以得出以下结论：
        //◆如果你想从一个数据类型里获取数据，使用 ?extends 通配符（能取不能存）
        //◆如果你想把对象写入一个数据结构里，使用 ? super 通配符（能存不能取）
        //◆如果你既想存，又想取，那就别用通配符。

        Point point2 = new Point(new Integer(23), new Integer(23));
        Point<?> point3 = new Point(new Integer(23), new Integer(23));
        //最后重复一遍：构造泛型实例时，如果省略了填充类型，则默认填充为无边界通配符！
    }

    /**
     * 绑定多个限定
     */
    private static void test6() {

        Student student = new Student();
        student.setId(1234567);
        student.setName("小明");
        student.setClassName("三年级一班");
        student.setAge(18);
        //eat方法中绑定多个限定
        Student xiaoming = eat(student, "大馒头");
        int age = xiaoming.getAge();
        Object id = xiaoming.getId();
        Object name = xiaoming.getName();
    }

    /**
     * 绑定多个限定
     * @param student
     * @param food
     * @param <T>
     * @return
     */
    public static <T extends Student<Integer, String, String> & Serializable> T eat(T student, String food) {
        student.eat(food);
        return student;
    }

    private static void test5() {
        Integer[] i = test5(1, 2, 3, 4, 5, 6);
        String[] strArr = test5("a", "b", "c", "d");
    }

    /**
     * 泛型数组
     * @param arg
     * @param <T>
     * @return
     */
    public static <T> T[] test5(T... arg) {  // 接收可变参数
        return arg;            // 返回泛型数组
    }

    /**
     * Class<T>类传递
     */
    private static void test4() {
        String arrStr = "[1,2,3,4,5,6,7]";
        List<Object> objects = Test.parseArray(arrStr, List.class);
        System.out.println(objects.toString());
    }

    /**
     * 泛型方法
     */
    private static void fanMethod() {

        //静态方法
        StaticFans.StaticMethod("StaticMethod");//使用方法一
        StaticFans.<String>StaticMethod("StaticMethod");//使用方法二

        //普通方法
        StaticFans staticFans = new StaticFans();
        staticFans.OtherMethod(new Integer(123));//使用方法一
        staticFans.<Integer>OtherMethod(new Integer(123));//使用方法二
    }

    /**
     * Class<T>类传递
     * @param response
     * @param object
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T, S> List<T> parseArray(String response, Class<S> object) {
        List<T> modelList = (List<T>) GsonUtil.fromJson(response, object);
        return modelList;
    }

    /**
     * 泛型类使用泛型接口
     */
    private static void test3() {
        InfoImplT<String> i = new InfoImplT<>();
        i.setVar("Fanxing");
        System.out.println(i.getVar());
        InfoImplT i2 = new InfoImplT<Long>();
        i2.setVar("Fanxing");
        System.out.println(i2.getVar());
        InfoImplT<Integer> i3 = new InfoImplT<>();
        i3.setVar(123);
        System.out.println(i3.getVar());
    }

    /**
     * 非泛型类使用泛型接口
     */
    private static void test2() {
        InfoImpl i = new InfoImpl("harvic");
        System.out.println(i.getVar());
    }

    /**
     * 泛型类
     */
    private static void test1() {
        //有时候我们id为Long类型的，有时候想为String类型的可以这样
        Student<Integer, String, String> student = new Student<>();
        student.setId(1234567);
        student.setName("小明");
        student.setClassName("三年级一班");
        student.setAge(18);
        System.out.println(student);
        //有时候我们id为Long类型的，有时候想为String类型的可以这样
        Student<String, String, String> student2 = new Student<>();
        student2.setId("1234567");
        student2.setName("小明");
        student2.setClassName("三年级一班");
        student2.setAge(18);
        System.out.println(student2);
    }

    /**
     * 有泛型的时候我们表示一个二维坐标点
     */
    private static void hasFanXing() {
        //IntegerPoint使用
        Point<Integer> p = new Point<Integer>();
        p.setX(new Integer(100));
        System.out.println(p.getX());
        //FloatPoint使用
        Point<Float> p2 = new Point<Float>();
        p2.setX(new Float(100.12f));
        System.out.println(p2.getX());
    }

    /**
     * 没有泛型的时候我们表示一个二维坐标点
     */
    private static void noFanXing() {
        ObjectPoint integerPoint = new ObjectPoint();
        integerPoint.setX(100);
        Integer integerX = (Integer) integerPoint.getX();
        System.out.println(integerX);

        ObjectPoint floatPoint = new ObjectPoint();
        floatPoint.setX(new Float(100.12f));
        //如果我们忘记存入的是float类型，编译不出错，但是运行会报错
        String floatX = (String) floatPoint.getX();
        System.out.println(floatX);
    }

}


//设置Integer类型的点坐标
class IntegerPoint {
    private Integer x;       // 表示X坐标
    private Integer y;       // 表示Y坐标

    public void setX(Integer x) {
        this.x = x;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }
}

//设置Float类型的点坐标
class FloatPoint {
    private Float x;       // 表示X坐标
    private Float y;       // 表示Y坐标

    public void setX(Float x) {
        this.x = x;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public Float getX() {
        return this.x;
    }

    public Float getY() {
        return this.y;
    }
}

class ObjectPoint {

    private Object x;
    private Object y;

    public void setX(Object x) {
        this.x = x;
    }

    public void setY(Object y) {
        this.y = y;
    }

    public Object getX() {
        return this.x;
    }

    public Object getY() {
        return this.y;
    }
}

/**
 * 使用泛型类表示一个二维坐标的点
 * @param <T>
 */
class Point<T> {// 此处可以随便写标识符号

    private T x;
    private T y;

    public Point() {
    }

    public Point(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public void setX(T x) {//作为参数
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public T getX() {//作为返回值
        return this.x;
    }

    public T getY() {
        return this.y;
    }
};


/**
 * 泛型类
 * @param <A>
 * @param <N>
 * @param <C>
 */
class Student<A, N, C> implements Serializable {

    //定义变量使用泛型
    private A id;
    private int age;
    private N name;
    private C className;

    //作为返回值
    public A getId() {
        return id;
    }

    //作为参数
    public void setId(A id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public N getName() {
        return name;
    }

    public void setName(N name) {
        this.name = name;
    }

    public C getClassName() {
        return className;
    }

    public void setClassName(C className) {
        this.className = className;
    }

    public void eat(String thing) {
        System.out.println(className + " 的 " + name + " eat : " + thing);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name=" + name +
                ", className=" + className +
                '}';
    }
}

/**
 * 泛型接口
 * @param <T>
 */
interface Info<T> {

    // 定义抽象方法，抽象方法的返回值就是泛型类型
    public T getVar();

    public void setVar(T x);

}

/**
 * 非泛型类使用泛型接口
 */
class InfoImpl implements Info<String> {   // 定义泛型接口的子类
    private String var;                // 定义属性

    public InfoImpl(String var) {        // 通过构造方法设置属性内容
        this.setVar(var);
    }

    @Override
    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public String getVar() {
        return this.var;
    }

    @Override
    public String toString() {
        return "InfoImpl{" +
                "var='" + var + '\'' +
                '}';
    }
}

/**
 * 泛型类使用泛型接口
 * @param <T>
 */
class InfoImplT<T> implements Info<T> {   // 定义泛型接口的子类
    private T var;                // 定义属性

    public InfoImplT(T var) {        // 通过构造方法设置属性内容
        this.setVar(var);
    }

    public InfoImplT() {
    }

    @Override
    public void setVar(T var) {
        this.var = var;
    }

    @Override
    public T getVar() {
        return this.var;
    }
}

class InfoImpl2<T, K, U> implements Info<U> {   // 定义泛型接口的子类
    private U var;
    private T x;
    private K y;

    public InfoImpl2(U var) {        // 通过构造方法设置属性内容
        this.setVar(var);
    }

    public InfoImpl2() {
    }

    public void setVar(U var) {
        this.var = var;
    }

    public U getVar() {
        return this.var;
    }
}

class StaticFans {

    //静态函数
    public static <T> void StaticMethod(T a) {
        System.out.println("StaticMethod: " + a.toString());
    }

    //普通函数
    public <T extends Object> void OtherMethod(T a) {
        System.out.println("OtherMethod: " + a.toString());
    }

}


class CEO extends Manager {
    public CEO() {
        System.out.println("CEO create!");
    }
}

class Manager extends Employee {
    public Manager() {
        System.out.println("Manager create!");
    }
}

class Employee {
    public Employee() {
        System.out.println("Employee create!");
    }
}
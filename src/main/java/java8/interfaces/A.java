package java8.interfaces;

/**
 * @author wangzz
 * @date 2020年03月29日 11:10
 */
public interface A {

    /**
     * JDK8之前，interface中可以定义常量和抽象方法，访问修饰符是public。
     */
    /**
     * a1和a2写法是等价的
     */
    public static final int a1 = 0;

    int a2 = 0;

    /**
     * methodA1和methodA2写法是等价的
     */
    public abstract void methodA1();

    void methodA2();

    /**
     * JDK8起，允许我们在interface中使用static和default修饰方法（使用这两种修饰符中其一就不能使用abstract修饰符），从而方法具有方法体。
     */
    /**
     * default访问修饰符修饰的方法
     */
    default void methodB1() {
        System.out.println("this is default method");
    }

    /**
     * static修饰符修饰的方法
     */
    public static void methodB2() {
        System.out.println("this is static method");
    }

    public static void main(String[] args) {
        A a = new A() {
            @Override
            public void methodA1() {

            }

            @Override
            public void methodA2() {

            }
        };
        a.methodB1();
        A.methodB2();
    }

}

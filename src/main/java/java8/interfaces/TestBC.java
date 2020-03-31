package java8.interfaces;

/**
 * 由于java支持一个实现类可以实现多个接口，如果多个接口中存在同样的static和default方法会怎么样呢？
 * 1. 如果有两个接口中的static方法一模一样，并且实现类同时实现了这两个接口，此时并不会产生错误，因为jdk8只能通过接口类调用接口中的静态方法，所以对编译器来说是可以区分的。
 * 2. 如果两个接口中定义了一模一样的default方法，并且一个实现类同时实现了这两个接口，那么必须在实现类中重写默认方法，否则编译失败。
 * @author: wangzz
 * @date: 2020年03月29日 11:24
 */
public class TestBC implements B, C {

    @Override
    public void method1() {
        System.out.println("TestAB :: 重写 :: method1");
    }

    public static void main(String[] args) {
        TestBC testBC = new TestBC();
        testBC.method1();
        // 接口实现了中的静态方法只能通过类名直接调用，无法通过实现类调用
        B.method2();
        C.method2();
    }

}

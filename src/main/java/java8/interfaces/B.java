package java8.interfaces;
/**
 * @Description:
 * @author: wangzz
 * @date: 2020年03月29日 11:21
 */
public interface B {

    default void method1() {
        System.out.println("B :: default :: method1");
    }

    static void method2() {
        System.out.println("B :: static :: method2");
    }

}

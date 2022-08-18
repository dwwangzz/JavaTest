package java8.interfaces;

/**
 * @author wangzz
 * @date 2020年03月29日 11:21
 */
public interface C {

    default void method1() {
        System.out.println("C :: default :: method1");
    }

    default void method11() {
        System.out.println("C :: default :: method11");
    }

    static void method2() {
        System.out.println("C :: static :: method2");
    }

    static void method22() {
        System.out.println("C :: static :: method22");
    }

}

package java8.lambda;

import org.junit.Test;

/**
 * @author wangzz
 * @date 2020年03月31日 15:28
 */

public class Lambda2 {

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }

    @Test
    public void test() {

        Lambda2 lambda2 = new Lambda2();
        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + lambda2.operate(10, 5, addition));
        System.out.println("10 - 5 = " + lambda2.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + lambda2.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + lambda2.operate(10, 5, division));

    }


}

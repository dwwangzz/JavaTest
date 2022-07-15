package java8.function;

import org.junit.Test;

import java.util.function.Function;

/**
 *
 * @author: wangzz
 * @date: 2022年07月15日 17:32
 */
public class FunctionTest {

    /**
     * 1、Function<Numbers, Integer> test，相当于一个待实现的接口，告诉你入参是 Numbers 类型 （上例子中是一个自定义的实体类），出参是Integer 类型。然后业务逻辑是怎样，可以自己实现。
     * 2、Function<Numbers, Integer> test1 = i -> i.getN1() - i.getN2();  实现了Functoin 的接口，业务逻辑是 Numbers 类型的一个实例，它两个字段相减。
     * 3、calculate(test1, 2, 2) 调用。
     * 4、好处就是解耦业务逻辑。
     */
    @Test
    public void test1() {
        Function<Numbers, Integer> test1 = i -> i.getN1() - i.getN2();
        Function<Numbers, Integer> test2 = i -> i.getN1() * i.getN2();
        System.out.println(calculate(test1, 2, 2));
        System.out.println(calculate(test2, 2, 2));
    }

    public Integer calculate(Function<Numbers, Integer> test, Integer number1, Integer number2) {
        Numbers n = new Numbers();
        n.setN1(number1);
        n.setN2(number2);
        return test.apply(n);
    }

}

class Numbers {
    private Integer n1;
    private Integer n2;

    public Integer getN1() {
        return n1;
    }

    public void setN1(Integer n1) {
        this.n1 = n1;
    }

    public Integer getN2() {
        return n2;
    }

    public void setN2(Integer n2) {
        this.n2 = n2;
    }

}

package java8.methodReference;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author wangzz
 * @date 2020年03月31日 16:07
 */

public class Car {

    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collide " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }


    @Test
    public void test1() {

        /**
         * 第一种方法引用的类型是构造器引用，语法是Class::new，或者更一般的形式：Class<T>::new。
         * 注意：这个构造器没有参数。
         */
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);


        /**
         * 第二种方法引用的类型是静态方法引用，语法是Class::static_method。
         * 注意：这个方法接受一个Car类型的参数。
         */
        cars.forEach(Car::collide);


        /**
         * 第三种方法引用的类型是某个类的成员方法的引用，语法是Class::method，
         * 注意，这个方法没有定义入参
         */
        cars.forEach(Car::repair);

        /**
         * 第四种方法引用的类型是某个实例对象的成员方法的引用，语法是instance::method。
         * 注意：这个方法接受一个Car类型的参数
         */
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);


        List names = new ArrayList();
        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");
        names.forEach(System.out::println);
    }

}

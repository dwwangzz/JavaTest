package java8.methodReference;

import reflect.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * JAVA8 Supplier接口
 * @author wangzz
 * @date 2020年03月31日 16:17
 */

public class SupplierDemo {

    public static void main(String[] args) {

        //Supplier<String> supplier = String::new;
        //System.out.println(supplier.get());//""
        //Supplier<Car> supplierEmp = Car::new;
        //Car emp = supplierEmp.get();

        List<Person> lisiList = new ArrayList<>();
        Consumer<Person> consumer  = x -> {
            if (x.getName().equals("lisi")){
                lisiList.add(x);
            }
        };
        Stream.of(
                new Person("zhangsan",21),
                new Person("lisi",22),
                new Person("wangwu",23),
                new Person("wangwu",24),
                new Person("lisi",23),
                new Person("lisi",26),
                new Person("zhangsan",26)
        ).forEach(consumer);

        System.out.println(lisiList);
    }

}

package java8.methodReference;

import java.util.function.Supplier;

/**
 * JAVA8 Supplier接口
 * @author wangzz
 * @date 2020年03月31日 16:17
 */

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<String> supplier = String::new;
        System.out.println(supplier.get());//""
        Supplier<Car> supplierEmp = Car::new;
        Car emp = supplierEmp.get();
    }

}

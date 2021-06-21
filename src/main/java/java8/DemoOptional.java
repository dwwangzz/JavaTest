package java8;

import lombok.Data;

import java.util.Optional;

/**
 * @author wangzz
 * @date 2021年03月30日 9:42
 */
public class DemoOptional {

    public static void main(String[] args) {

        Optional<Object> empty = Optional.empty();
        System.out.println(empty);

        Wangzz wangzz = new Wangzz();
        wangzz.setName("刘亦菲");

        Optional<Wangzz> wangzz1 = Optional.ofNullable(wangzz);
        Wangzz wangzz11 = wangzz1.get();
        System.out.println(wangzz11);

        Wangzz wangzz2 = null;
        Optional<Wangzz> wangzz22 = Optional.ofNullable(wangzz2);
        Wangzz wangzz3 = wangzz22.get();
        System.out.println(wangzz3);


    }
}

@Data
class Wangzz{
    private String name;
}

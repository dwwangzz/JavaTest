package java8.lambda;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wangzz
 * @date 2020年03月31日 14:55
 */

public class Lambda1 {

    @Test
    public void test1() {

        // 最简单的Lambda表达式
        Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));

        // 可以显示指定参数类型
        Arrays.asList("a", "b", "d").forEach((String e) -> System.out.println(e));

        // 稍微复杂点的Lambda表达式
        Arrays.asList("a", "b", "d").forEach(e -> {
            System.out.println(e);
            System.out.println(e + e);
        });

        // lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的）
        String separator = ",";
        Arrays.asList("a", "b", "d").forEach(e -> System.out.print(e + separator));

        // 以下3个方法效果是一样的
        Arrays.asList("a", "b", "d").sort((e1, e2) -> e1.compareTo(e2));
        Arrays.asList("a", "b", "d").sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });
        Arrays.asList("a", "b", "d").sort(String::compareTo);

    }

}

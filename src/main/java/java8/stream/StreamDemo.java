package java8.stream;

import com.google.common.collect.Lists;
import org.junit.Test;
import utils.EmptyUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
 * +--------------------+       +------+   +------+   +---+   +-------+
 * | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
 * +--------------------+       +------+   +------+   +---+   +-------+
 * @author wangzz
 * @date 2020年03月31日 16:32
 */

public class StreamDemo {

    /**
     * 生成流
     * 在 Java 8 中, 集合接口有两个方法来生成流：
     * stream() − 为集合创建串行流。
     * parallelStream() − 为集合创建并行流。
     */
    @Test
    public void test1() {
        List<Integer> list = Lists.newArrayList(5, 234, 54, 675, 765, 3, 542, 34, 6547, 78);
        List<Integer> collect = list.stream().sorted(Comparator.comparingInt(o -> o)).collect(Collectors.toList());
        System.out.println(collect);

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        strings.sort(String::compareTo);
        List<String> strings1 = strings.stream().filter(s -> EmptyUtil.isNotEmpty(s)).sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(strings);
        System.out.println(strings1);
    }

    @Test
    public void test2() {

        /**
         * 1. forEach
         * Stream 提供了新的方法 'forEach' 来迭代流中的每个数据。以下代码片段使用 forEach 输出了2个随机数：
         */
        Random random = new Random();
        random.ints().limit(2).forEach(System.out::println);

        /**
         * 2. map
         * map 方法用于映射每个元素到对应的结果，以下代码片段使用 map 输出了元素对应的平方数：
         */
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        System.out.println(squaresList);

        /**
         * 3. filter
         * filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串：
         */
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();

        /**
         * 4. limit
         * limit 方法用于获取指定数量的流。 以下代码片段使用 limit 方法打印出 10 条数据：
         */
        Random random2 = new Random();
        random2.ints().limit(10).forEach(System.out::println);

        /**
         * 5. sorted
         * sorted 方法用于对流进行排序。以下代码片段使用 sorted 方法对输出的 10 个随机数进行排序：
         */
        Random random3 = new Random();
        random3.ints().limit(10).sorted().forEach(System.out::println);

        /**
         * 6. 并行（parallel）程序
         * parallelStream 是流并行处理程序的代替方法。以下实例我们使用 parallelStream 来输出空字符串的数量：
         */
        List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        long count2 = strings2.parallelStream().filter(string -> string.isEmpty()).count();

        /**
         * 7. Collectors
         * Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
         */
        List<String> strings3 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings3.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered);
        String mergedString = strings3.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);

        /**
         * 8. 统计
         * 另外，一些产生统计结果的收集器也非常有用。它们主要用于int、double、long等基本类型上，它们可以用来产生类似如下的统计结果。
         */
        List<Integer> numbers2 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers2.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());


    }

}

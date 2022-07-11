package ListUtils;

import com.google.common.collect.Lists;
import java8.stream.domain.Person;
import org.apache.commons.beanutils.ConvertUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数组转集合/集合转数组
 * @author: wangzz
 * @date: 2022年07月06日 16:40
 */
public class ListArrayConvert {

    /**
     * 数组转集合
     */
    @Test
    public void arrayToList() {

        /**
         * 1. 使用 java.util 包下的 Arrays.asList 方法进行转换：
         */
        // 1.1 转换数组对象
        Long[] arr = new Long[]{10L, 20L, 30L};
        List<Long> list1 = Arrays.asList(arr);
        // 1.2 转换数组常量
        List<String> list2 = Arrays.asList("123", "456", "789");

        /**
         * 2. 原始类型数组转包装类 List
         */
        long[] arr2 = new long[]{10L, 20L, 30L};
        List<Long> list = Arrays.stream(arr2).boxed().collect(Collectors.toList());


    }

    /**
     * 集合转数组
     */
    @Test
    public void listToArray() {

        /**
         * 1、使用 List 集合的 toArray 方法：
         */
        // 方式1（推荐）
        List<Long> list = Arrays.asList(10L, 20L, 30L);
        Long[] array = list.toArray(new Long[0]);
        // 方式2
        List<String> list2 = Arrays.asList("123", "456", "789");
        String[] array2 = (String[]) list2.toArray();

        /**
         * 2、使用 Java8 流式编程方式：
         */

        // 方式1（推荐）
        List<Long> list3 = Arrays.asList(10L, 20L, 30L);
        Long[] array3 = list3.stream().map(Long::valueOf).toArray(Long[]::new);

        // 方式2
        List<String> list4 = Arrays.asList("123", "456", "789");
        Long[] array4 = (Long[]) list4.stream().map(Long::valueOf).toArray(Long[]::new);

        // 方式2
        List<String> list5 = Arrays.asList("123", "456", "789");
        Object[] array45 = list5.stream().map(String::valueOf).toArray();

        // 方式2
        List<Person> personList = init();
        Person[] people = personList.stream().toArray(Person[]::new);


        /**
         * 3、使用第三方工具，比如 Apache 的 commons-beanutils 工具包：
         * import org.apache.commons.beanutils.ConvertUtils;
         * <dependency>
         *     <groupId>commons-beanutils</groupId>
         *     <artifactId>commons-beanutils</artifactId>
         *     <version>1.9.4</version>
         * </dependency>
         */
        List<String> list6 = Arrays.asList("123", "456", "789");
        String[] array6 = (String[]) ConvertUtils.convert(list6, String[].class);

    }


    /**
     * 构造人的集合
     * @return
     */
    public List<Person> init() {
        ArrayList<Person> list = Lists.newArrayList();
        list.add(new Person(1L, "张1", 1, Lists.newArrayList(1, 2, 3, 4, 5)));
        list.add(new Person(3L, "张3", 3, Lists.newArrayList(3, 2, 3, 4, 5)));
        list.add(new Person(2L, "张2", 2, Lists.newArrayList(2, 2, 3, 4, 5)));
        list.add(new Person(4L, "张4", 4, Lists.newArrayList(4, 2, 3, 4, 5)));
        list.add(new Person(5L, "张5", 5, Lists.newArrayList(5, 2, 3, 4, 5)));
        list.add(new Person(6L, "张6", 6, Lists.newArrayList(6, 2, 3, 4, 5)));
        list.add(new Person(7L, "张7", 7, Lists.newArrayList(7, 2, 3, 4, 5)));
        list.add(new Person(8L, "张8", 8, Lists.newArrayList(8, 2, 3, 4, 5)));
        list.add(new Person(9L, "张9", 9, Lists.newArrayList(9, 2, 3, 4, 5)));
        list.add(new Person(10L, "张10", 10, Lists.newArrayList(10, 2, 3, 4, 5)));
        return list;
    }
}

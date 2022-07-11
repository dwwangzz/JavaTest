package java8.stream;

import com.google.common.collect.Lists;
import java8.stream.domain.Person;
import kryo.User;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Demo
 * @author: wangzz
 * @date: 2022年07月06日 15:51
 */
public class StreamDemo2 {

    @Test
    public void test() {
        List<Person> personList = init();
        List<String> collect = personList.stream().filter(e -> e.getAge() > 80).map(Person::getName).collect(Collectors.toList());
        System.out.println(collect);

        List<Long> ids = personList.stream().map(Person::getId).collect(Collectors.toList());
        System.out.println(ids);

        ids = ids.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(ids);

        List<Person> peoples = personList.stream().sorted(Comparator.comparing(Person::getId)).collect(Collectors.toList());
        System.out.println(peoples);


    }

    @Test
    public void map() {
        List<Person> personList = init();
        //List<Person> personList = new ArrayList<>();

        // 第一种（会出现键重复异常）：
        Map<Long, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getId, Function.identity()));

        // 第二种（针对第一种方法会出现情况）：
        // 给出key重复时，使用哪个key作为主键，以下代码中的(key1, key2) -> key2)代表key1和key2键重复时返回key2做主键
        Map<Long, Person> personMap2 = personList.stream().collect(Collectors.toMap(Person::getId, Function.identity(), (key1, key2) -> key2));

        // 第三种（只返回对象里某个属性时）：
        Map<Long, String> stringMap = personList.stream().collect(Collectors.toMap(Person::getId, Person::getName, (key1, key2) -> key2));

        // 第四种（以某个属性分组）：
        Map<Long, List<Person>> listMap = personList.stream().collect(Collectors.groupingBy(Person::getId));

    }


    @Test
    public void sorted() {
        List<Person> personList = init();


        List<Long> ids = personList.stream().map(Person::getId).collect(Collectors.toList());
        System.out.println(ids);

        // 默认是自然排序 Comparator.reverseOrder()
        ids = ids.stream().sorted().collect(Collectors.toList());
        System.out.println(ids);

        ids = ids.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(ids);

        ids = ids.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println(ids);

        // Collections.sort
        Collections.sort(ids, Comparator.reverseOrder());

        // Arrays.sort
        long[] idArr = ids.stream().mapToLong(Long::new).toArray();
        //long[] idArr = ids.stream().mapToLong(Long::valueOf).toArray();
        printTitle("Arrays.sort");
        System.out.println(Arrays.toString(idArr));
        Arrays.sort(idArr);
        System.out.println(Arrays.toString(idArr));

        List<Person> peoples = personList.stream().sorted(Comparator.comparing(Person::getId)).collect(Collectors.toList());
        System.out.println(peoples);

    }


    /**
     * 构造人的集合
     * @return
     */
    public List<Person> init() {
        ArrayList<Person> list = Lists.newArrayList();
        list.add(new Person(1L, "张1", 1, Lists.newArrayList(1, 2, 3, 4, 5)));
        list.add(new Person(1L, "张11", 11, Lists.newArrayList(11, 22, 33, 44, 55)));
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

    public void printTitle(Object... args) {
        System.out.println(String.format("========== %s ==========", Arrays.toString(args)));
    }

}

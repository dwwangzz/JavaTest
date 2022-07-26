package java8.stream;

import com.google.common.collect.Lists;
import java8.stream.domain.Person;
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
        List<Long> ids = new ArrayList<>();
        List<Person> list = personList.stream().filter(e -> {
            if (ids.contains(e.getId())) {
                return false;
            }
            ids.add(e.getId());
            return true;
        }).collect(Collectors.toList());
        list.forEach(System.out::println);
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
        Collections.sort(ids, Comparator.reverseOrder()); // 推荐用这个
        Collections.sort(ids, Collections.reverseOrder());

        // Arrays.sort
        long[] idArr = ids.stream().mapToLong(Long::new).toArray();
        //long[] idArr = ids.stream().mapToLong(Long::valueOf).toArray();
        printTitle("Arrays.sort");
        System.out.println(Arrays.toString(idArr));
        Arrays.sort(idArr);
        System.out.println(Arrays.toString(idArr));

        List<Person> peoples = personList.stream().sorted(Comparator.comparing(Person::getId)).collect(Collectors.toList());
        System.out.println(peoples);

        // 排序中出现null值，程序会报错，可以使用此处理方式
        List<Person> peoples2 = personList.stream().sorted(Comparator.comparing(Person::getId, Comparator.nullsFirst(Long::compareTo))).collect(Collectors.toList());
        List<Person> peoples3 = personList.stream().sorted(Comparator.comparing(Person::getId, Comparator.nullsFirst((o1, o2) -> {
            System.out.println(String.format("%s-%s", o1, o2));
            return 1;
        }))).collect(Collectors.toList());
        personList.stream().sorted(Comparator.comparing(Person::getId, Comparator.nullsLast(Long::compareTo)).reversed()).collect(Collectors.toList()).forEach(System.out::println);


    }

    /**
     * 断言分组
     */
    @Test
    public void partitioningBy() {
        List<Person> personList = init();

        // 场景一：为某个字段设置断言，分为两个组合
        Map<Boolean, List<Person>> map1 = personList.stream().collect(Collectors.partitioningBy(person -> person.getId() > 5));
        System.out.println(map1);

        // 场景二：为某个字段设置断言，分为两个组合，然后统计两个组合的元素个数
        Map<Boolean, Long> map2 = personList.stream().collect(Collectors.partitioningBy(person -> person.getId() > 5, Collectors.counting()));
        System.out.println(map2);

    }

    /**
     * 分组
     */
    @Test
    public void groupBy() {
        List<Person> personList = init();

        // 场景一：只对一个字段进行分组
        Map<Long, List<Person>> map1 = personList.stream().collect(Collectors.groupingBy(Person::getId));
        System.out.println(map1);

        // 场景二：两个字段结合起来，作为分组条件
        Map<String, List<Person>> map2 = personList.stream().collect(Collectors.groupingBy(StreamDemo2::groupString));
        System.out.println(map2);

        Map<String, List<Person>> map3_2 = personList.stream().collect(Collectors.groupingBy(person -> person.getId() + person.getName()));

        Function<Person, String> fun = person -> person.getId() + person.getName();
        Map<String, List<Person>> map3_1 = personList.stream().collect(Collectors.groupingBy(fun));
        System.out.println(map3_1.toString() + map3_2.toString());

        // 场景三：先对某一个字段分组，然后再将各组内的元素按照另一个字段分组
        Map<Integer, Map<String, List<Person>>> map4 = personList.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.groupingBy(Person::getName)));
        System.out.println(map4);

        // 分组求和
        //Map<Long, DoubleSummaryStatistics> statisticsMap = personList.stream().collect(Collectors.groupingBy(Person::getId, Collectors.summarizingDouble(Person::getPrice)));
        Map<Long, DoubleSummaryStatistics> statisticsMap = personList.stream().collect(Collectors.groupingBy(Person::getId, Collectors.summarizingDouble(e -> e.getPrice() == null ? 0 : e.getPrice())));
        Map<Long, Double> doubleMap = personList.stream().collect(Collectors.groupingBy(Person::getId, Collectors.summingDouble(e -> e.getPrice() == null ? 0 : e.getPrice())));
        DoubleSummaryStatistics statistics = statisticsMap.get(1L);
        System.out.println("statistics.getSum() = " + statistics.getSum());
        System.out.println("statistics.getAverage() = " + statistics.getAverage());
        System.out.println("statistics.getCount() = " + statistics.getCount());


    }

    private static String groupString(Person person) {
        return person.getId() + person.getAge() + "";
    }

    /**
     * 构造人的集合
     * @return
     */
    public List<Person> init() {
        ArrayList<Person> list = Lists.newArrayList();
        list.add(new Person(1L, "张1", 1, 1.5d, Lists.newArrayList(1, 2, 3, 4, 5)));
        list.add(new Person(1L, "张11", 11, null, Lists.newArrayList(11, 22, 33, 44, 55)));
        list.add(new Person(3L, "张3", 3, null, Lists.newArrayList(3, 2, 3, 4, 5)));
        list.add(new Person(2L, "张2", 2, null, Lists.newArrayList(2, 2, 3, 4, 5)));
        list.add(new Person(4L, "张4", 4, null, Lists.newArrayList(4, 2, 3, 4, 5)));
        list.add(new Person(5L, "张5", 5, null, Lists.newArrayList(5, 2, 3, 4, 5)));
        list.add(new Person(6L, "张6", 6, null, Lists.newArrayList(6, 2, 3, 4, 5)));
        list.add(new Person(7L, "张7", 7, null, Lists.newArrayList(7, 2, 3, 4, 5)));
        list.add(new Person(8L, "张8", 8, null, Lists.newArrayList(8, 2, 3, 4, 5)));
        list.add(new Person(9L, "张9", 9, null, Lists.newArrayList(9, 2, 3, 4, 5)));
        list.add(new Person(10L, "张10", 10, null, Lists.newArrayList(10, 2, 3, 4, 5)));
        return list;
    }

    public void printTitle(Object... args) {
        System.out.println(String.format("========== %s ==========", Arrays.toString(args)));
    }

}

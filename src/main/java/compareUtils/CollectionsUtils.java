package compareUtils;

import java.util.*;

public class CollectionsUtils {

    public static void main(String[] args) {
        //简单排序
        //jdpx();
        //复杂排序
        //fzpx();
        Long l = new Long(10);
        System.out.println(l.compareTo(1l));
        System.out.println(l.compareTo(10l));
        System.out.println(l.compareTo(11l));

    }

    /**
     * 复杂排序
     */
    public static void fzpx() {

        /**排序方法复杂使用*/
        List<TestBean> testList = new ArrayList<TestBean>();
        for (int i = 0; i < 10; i++) {
            TestBean testBean = new TestBean(i, "name" + i);
            testList.add(testBean);
        }
        //定义一个TestBean 类型的list 并打乱进行测试
        Collections.shuffle(testList);
        for (int i = 0; i < testList.size(); i++) {
            System.out.println("testList乱序  " + testList.get(i).toString());
        }
        //根据TestBean 的 id 属性进行排序，需重载实现
        Collections.sort(testList, new Comparator<TestBean>() {
            @Override
            public int compare(TestBean o1, TestBean o2) {
                // 实现正序排列
                //return o1.getId().compareTo(o2.getId());
                return new Long(o1.getId()).compareTo(o2.getId());
            }
        });
        for (int i = 0; i < testList.size(); i++) {
            System.out.println("testList正序  " + testList.get(i).toString());
        }
        //再次打乱顺序
        Collections.shuffle(testList);
        //依旧重载方法
        Collections.sort(testList, new Comparator<TestBean>() {
            @Override
            public int compare(TestBean o1, TestBean o2) {
                // 实现倒序排列
                return -1;
            }
        });
        for (int i = 0; i < testList.size(); i++) {
            System.out.println("testList倒序  " + testList.get(i).toString());
        }

    }

    /**
     * 简单排序
     */
    public static void jdpx() {
        /**排序方法简单使用*/
        List list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);   //定义个list
        System.out.println("原  顺  序" + list.toString());

        Collections.shuffle(list);
        System.out.println("打乱顺序" + list.toString());

        Collections.sort(list);
        System.out.println("正序排列" + list.toString());

        Collections.sort(list, Collections.reverseOrder());
        System.out.println("逆序排列" + list.toString());
    }


}

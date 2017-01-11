package ListUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangzz on 2017/1/11.
 */
public class ListDemo {

    public static void main(String[] args) {
        listFenYe();
    }

    /**
     * list分页
     */
    public static void listFenYe() {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");
        list.add("k");
        list.add("l");

        while (!list.isEmpty()) {
            int toIndex = list.size() > 5 ? 5 : list.size();
            List<String> temp = list.subList(0, toIndex);
            System.out.println("temp:" + temp);
            list.removeAll(temp);
            System.out.println("list:" + list);
        }
    }
}

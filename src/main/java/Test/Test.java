package Test;

import domain.Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) throws Exception {

        Demo demo = new Demo();
        List<String> list = new ArrayList<>();
        list.add("yz_hstyleqjd");
        list.add("tb_prospecsqjd");
        list.add("bb_soulineqjd");
        list.add("bb_nibbunsqjd");
        list.add("sb_honeypigqjd");
        list.add("bb_gyqjd");
        list.add("ccj_hstyleqjd");
        list.add("wd_prospecsjb");
        list.add("jd_soulinfsqjd");
        demo.setCodes(list);
        Collections.sort(list);
        System.out.println(demo.toString());
    }

}

package thread.test1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangzz
 * @date 2020年04月16日 14:40
 */

public class T07_00_AtomicInteger {

    static AtomicInteger threadNo = new AtomicInteger(1);


    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                while (threadNo.get() != 1) {
                }
                System.out.println(c);
                threadNo.set(2);
            }
        }).start();
        new Thread(() -> {
            for (char c : aC) {
                while (threadNo.get() != 2) {
                }
                System.out.println(c);
                threadNo.set(1);
            }
        }).start();
    }

}

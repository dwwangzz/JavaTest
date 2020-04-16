package thread.test1;

/**
 * 自旋锁 ,自旋锁是需要占用CPU的
 * @author wangzz
 * @date 2020年04月16日 14:20
 */
public class T06_00_cas {

    enum ReadyToRun {T1, T2}

    static volatile ReadyToRun r = ReadyToRun.T1;

    public static void main(String[] args) {
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : aI) {
                while (r != ReadyToRun.T1) {
                }
                System.out.println(c);
                r = ReadyToRun.T2;
            }
        }).start();
        new Thread(() -> {
            for (char c : aC) {
                while (r != ReadyToRun.T2) {
                }
                System.out.println(c);
                r = ReadyToRun.T1;
            }
        }).start();
    }

}

package thread.test1;

/**
 * @author wangzz
 * @date 2020年04月16日 15:14
 */
public class T02_00_sync_wait_notify {

    static Object o = new Object();
    private static volatile boolean thread1RunFlag = false;
    //private static CountDownLatch latch = new CountDownLatch(1);


    public static void main(String[] args) {

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        new Thread(() -> {
            synchronized (o) {
                for (char c : aI) {
                    System.out.println(c);
                    //latch.countDown();
                    thread1RunFlag = true;
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    o.notify();
                }
            }
        }, "t1").start();

        new Thread(() -> {
            //latch.await();
            synchronized (o) {
                while (!thread1RunFlag) {
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (char c : aC) {
                    System.out.println(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    o.notify();
                }
            }
        }, "t2").start();
    }

}

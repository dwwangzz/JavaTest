package thread;

public class TestThread extends Thread {
    @Override
    public void run() {
        while(true){
            try {
                sleep(1000);
                //这里可以写你自己要运行的逻辑代码
                System.out.println("一分钟运行一次");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

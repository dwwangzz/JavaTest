package digui;

/**
 * Created by wangzz on 2016-2-2.
 */
public class Digui {


    public static void main(String[] args) {
        int a = recursive(4);
        System.out.println(a);
    }


    public static int recursive(int i) {
        int sum = 0;
        if (0 == i)
            return (1);
        else
            sum = i * recursive(i - 1);
        return sum;
    }

}

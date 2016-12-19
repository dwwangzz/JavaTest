package random;

import java.util.HashSet;
import java.util.Random;

/**
 * 随机数
 * @author wangzz-a
 * @version $Id: RandomTest.java, v 0.1 2015年7月14日 下午12:35:36 wangzz-a Exp $
 */
public class RandomTest {

    public static void main(String[] args) {
        //System.out.println(getRandomInt(3, 5));
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        int[] arr = {1, 2, 3, 4, 5, 6};
        addUniqueRandom(set, arr);
    }


    /**
     * 生成min-max之间的随机数，包括最大值和最小值
     * @param min
     * @param max
     * @return
     * @author wangzz-a
     * @date 2015年7月14日 下午12:55:11
     */
    public static int getRandomInt(int min, int max) {
        Random random = new Random();
        int s = random.nextInt(max - min + 1) + min;
        return s;
    }

    /**
     * 随机获取数组中一个数
     * @param para
     * @return
     * @author wangzz-a
     * @date 2015年7月14日 下午2:15:37
     */
    public static int getRandomByArray(int[] para) {
        if (para == null || para.length == 0) {
            return 0;
        }
        return para[getRandomInt(0, para.length - 1)];
    }

    /**
     * 随机抽取数组b中的一个数存到a中，并且不重复，如果全部重复则返回a
     * @param aArr
     * @param bArr
     * @return
     * @author wangzz-a
     * @date 2015年7月14日 下午2:35:18
     */
    public static HashSet<Integer> addUniqueRandom(HashSet<Integer> aArr, int[] bArr) {
        if (aArr == null || bArr == null || bArr.length == 0)
            return null;
        //数组a原长度
        int alen = aArr.size();
        do {
            aArr.add(getRandomByArray(bArr));
        } while (aArr.size() <= alen);
        return aArr;
    }

}

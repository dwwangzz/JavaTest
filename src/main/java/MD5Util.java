import java.security.MessageDigest;

/**
 * MD5加密工具类 <功能详细描述>
 * @version [版本号, 2017年11月14日]
 */
public class MD5Util {

    /**
     * 32位加密
     * @param sourceStr
     * @return
     */
    public static String MD532(String sourceStr) {
        try {
            // 获得MD5摘要算法的 MessageDigest对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(sourceStr.getBytes());
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            StringBuffer buf = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int tmp = md[i];
                if (tmp < 0) {
                    tmp += 256;
                }
                if (tmp < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(tmp));
            }
            return buf.toString().toUpperCase();// 32位加密
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}

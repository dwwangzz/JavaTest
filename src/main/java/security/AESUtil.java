package security;

import lombok.SneakyThrows;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

/**
 * AES对称加解密工具类
 */
public final class AESUtil {

    private AESUtil() {
    }

    @SneakyThrows
    public static void main(String[] args) {
        String content = "000";
        System.out.println(AESUtil.decrypt(content, SALARY_ENC_KEY));
    }


    /**
     * 加密
     * @param content 待加密内容
     * @param keyWord 密码
     * @return 加密后的密文
     * @throws Exception
     */
    public static String encrypt(String content, String keyWord) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(keyWord.getBytes());
        kgen.init(128, random);
        // kgen.init(128, new SecureRandom(password.getBytes()));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        byte[] byteContent = content.getBytes("utf-8");
        cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
        byte[] result = cipher.doFinal(byteContent);

        return parseByte2HexStr(result); // 加密
    }

    /**
     * 解密
     * @param content 待解密内容
     * @param keyWord 密钥
     * @return 解密后的明文
     * @throws Exception
     */
    public static String decrypt(String content, String keyWord) throws Exception {
        byte[] contentArr = parseHexStr2Byte(content);

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        random.setSeed(keyWord.getBytes());
        kgen.init(128, random);
        // kgen.init(128, new SecureRandom(password.getBytes()));
        SecretKey secretKey = kgen.generateKey();
        byte[] enCodeFormat = secretKey.getEncoded();
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器
        cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
        byte[] result = cipher.doFinal(contentArr);

        return new String(result);
    }

    /**
     * 加密，AES/CBC/PKCS5Padding
     * @param content 待加密内容
     * @param keyWord 密码
     * @return 加密后的密文
     * @throws Exception
     */
    public static String encryptPkcs5(String content, String keyWord) throws Exception {
        //传给crypto的key、iv要使用base64格式
        byte[] key = keyWord.getBytes();
        byte[] data = content.getBytes("utf-8");

        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, new IvParameterSpec(key));
        byte[] result = cipher.doFinal(data);
        return parseByte2HexStr(result); // 加密
    }

    /**
     * 解密，AES/CBC/PKCS5Padding
     * @param content 待解密内容
     * @param keyWord 密钥
     * @return 解密后的明文
     * @throws Exception
     */
    public static String decryptPkcs5(String content, String keyWord) throws Exception {
        //传给crypto的key、iv要使用base64格式
        byte[] key = keyWord.getBytes();
        byte[] data = parseHexStr2Byte(content);

        //因为AES的加密块大小是128bit(16byte), 所以key是128、192、256bit无关
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(key));
        byte[] result = cipher.doFinal(data);
        return new String(result);
    }

    /**
     * 二进制转换成16进制
     * @param buf 字节数组
     * @return 16进制字符串
     */
    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0, len = buf.length; i < len; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    public static final String SALARY_ENC_KEY = "1990";

    /**
     * 16进制转换为二进制
     * @param hexStr 16进制字符串
     * @return 字节数组
     */
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0, len = hexStr.length(); i < len / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

}

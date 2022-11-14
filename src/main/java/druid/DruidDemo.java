package druid;

import com.alibaba.druid.filter.config.ConfigTools;
import lombok.SneakyThrows;

/**
 * druid数据库加密解密工具类
 * @author: wangzz
 * @date: 2022年11月14日 16:31
 */
public class DruidDemo {

    @SneakyThrows
    public static void main(String[] args) {

        /**
         * privateKey:MIIBVAIBADANBgkqhkiG9w0BAQEFAASCAT4wggE6AgEAAkEAgRbk0p9WJXARnvJERNNCoIhk8faLzvFVv6fK/SD3qYwojaRz4b01nXw6GcTbybxWNlC68T95WrIUtJnTbDxYtQIDAQABAkBh+8+qM7l+50bov/mjyDuNgJomsz5B0RuGQ0Wnx2tVbHCn6f6P1DKOupt8kS5NoXFQzDdoLdgd1squWbMwLtxNAiEAzTMA7xgB67c3HlYiHv4Ct5kwLLqsVssClok/mrEmFlcCIQChDD9um812lbBuq1jdIXE3ott7RzIhw+ZZYhyWX1wp0wIgcbnM0LZ7igp3D+co7ghVtS+/lWq4TToiaxASIkgAFe0CIQCGNMSvkhq4lal/sD7PmEzXBlpM81mtlajiF8am8TTGjQIgNq39mDo/0oqY15+ADb02q5ArUWlya2Onx8FvM+m7vmg=
         * publicKey:MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIEW5NKfViVwEZ7yRETTQqCIZPH2i87xVb+nyv0g96mMKI2kc+G9NZ18OhnE28m8VjZQuvE/eVqyFLSZ02w8WLUCAwEAAQ==
         * password:UPqNDjhoGY3phS9ID4YsmFkE05GeG8WGYXimT0KpTRsiBz54fV6x0cLH7W9K2TMYn7nDH6lBVq3yzgw59LELdA==
         */
        String password = "123456";
        String[] arr = ConfigTools.genKeyPair(512); // 生成公钥私钥
        System.out.println("privateKey:" + arr[0]);
        System.out.println("publicKey:" + arr[1]);
        System.out.println("password:" + ConfigTools.encrypt(arr[0], password));


        String pwd = "UPqNDjhoGY3phS9ID4YsmFkE05GeG8WGYXimT0KpTRsiBz54fV6x0cLH7W9K2TMYn7nDH6lBVq3yzgw59LELdA==";
        String publicKey = "MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIEW5NKfViVwEZ7yRETTQqCIZPH2i87xVb+nyv0g96mMKI2kc+G9NZ18OhnE28m8VjZQuvE/eVqyFLSZ02w8WLUCAwEAAQ==";
        String decrypt = ConfigTools.decrypt(publicKey, pwd);
        System.out.println("decrypt = " + decrypt);

    }

}

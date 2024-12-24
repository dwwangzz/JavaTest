package sdcmos.iep.platform.util;

import cn.hutool.extra.mail.Mail;
import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import lombok.SneakyThrows;

import javax.mail.internet.MimeUtility;

public class Demo {
    // 发送邮件
    @SneakyThrows
    public static void main(String[] args) {

        MailAccount account = new MailAccount();
        account.setHost("smtp.cmos.chinamobile.com");
        account.setPort(465);
        account.setAuth(true);
        // 此版本的hutools，from和user必须一致都是邮箱才可以
        account.setFrom("abc@qq.com");
        account.setUser("abc@qq.com");
        // User与From不一致则会报错
        // account.setUser("这是一个昵称");
        account.setPass("xxxxxx");
        account.setSslEnable(true);

        // Session session = MailUtil.getSession(account, true);

        MailUtil.send(account, "abc@qq.com", "测试", "邮件测试", false);

        String res = Mail.create(account)
                .setTos("abc@qq.com")
                .setTitle("邮件测试")
                .setContent("邮件测试123")
                .send();

        System.out.println(res);

        String encodeNickName = MimeUtility.encodeText("测试测试");
        System.out.println(encodeNickName);
    }
}

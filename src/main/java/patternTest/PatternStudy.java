package patternTest;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternStudy {

    @Test
    public void test1() {
        String takeTime = "2012/01/01";
        System.out.println(takeTime.matches("\\d{4}/(\\d{1,2})/\\d{1,2}"));
    }
    @Test
    public void test2() {
        // replace()和replaceAll()区别，replace只支持字符串的替换，不支持正则，replaceAll支持正则
        String str = "aa bbb cc	dd		ee \n\r ff";
        str = str.replaceAll("\\s", "-");// 字符串的非开始或非结束位置
        System.out.println(str);
        str = str.replace('a', 'z');// a换成z
        System.out.println(str);
        str = str.replace("-", "+");
        System.out.println(str);
    }

    @Test
    public void test3() {

        // 贪婪-从最后一个开始匹配
        Pattern pattern = Pattern.compile(".+b");
        // 非贪婪（惰性）
        // Pattern pattern = Pattern.compile(".+?b");
        Matcher matcher = pattern.matcher("abcdabceba");
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            buffer.append(matcher.group());
            buffer.append("\r\n");
        }
        System.out.println(buffer);

        // qq号校验
        String qq = "81303012";
        Pattern pattern2 = Pattern.compile("^[1-9]{1}\\d{4,11}$");
        Matcher matcher2 = pattern2.matcher(qq);
        System.out.println("是否是qq号：" + matcher2.matches());

        // 返回当前查找所获得的匹配组的数量
        System.out.println("groupCount:" + matcher.groupCount());
        // 检测目标字符串是否以匹配的子串起始
        System.out.println("lookingAt:" + matcher.lookingAt());
        // 尝试对整个目标字符展开匹配检测，也就是只有整个目标字符串完全匹配时才返回真值
        System.out.println("matches:" + matcher.matches());
        // 返回该Matcher对象的现有匹配模式，也就是对应的Pattern 对象
        System.out.println("pattern:" + matcher.pattern());
    }




}

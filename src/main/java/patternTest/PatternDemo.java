package patternTest;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java正则表达式的使用例子 1.替换字符串 2.查找字符串 (出现次数) 3.判断是否有该字符串
 * 
 * @author wangzz-a
 * @version $Id: PatternDemo.java, v 0.1 2015年10月9日 下午2:19:14 wangzz-a Exp $
 */
public class PatternDemo {

	public static void main(String[] args) {
		/*StringBuffer sbr = new StringBuffer();
		String str = "what is your name ?";
		Pattern pattern = Pattern.compile("(your|is|name)");
		Matcher matcher = pattern.matcher(str);
		matcher.find();
		System.out.println(matcher.group());
		while (matcher.find()) {
			matcher.appendReplacement(sbr, "Java");
			System.out.println("toMatchResult.group="+matcher.toMatchResult().group());
			System.out.println("toMatchResult.start="+matcher.toMatchResult().start(1));
			System.out.println(sbr);
		}
		matcher.appendTail(sbr);
		System.out.println(sbr);*/	
		Pattern pattern = Pattern.compile("### Error updating database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '([\\d-]+)'");
		String str = "### Error updating database.  Cause: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Duplicate entry '3-35917-2015' for key 'ipp_resource_id'";
		Matcher matcher = pattern.matcher(str);
		matcher.find();
		System.out.println(matcher.group(1));
		
	}

	@Test
	public void test1() {
		// java中的正则表达式的转义字符是'//'
		String takeTime = "2012/01/01";
		System.out.println(takeTime.matches("\\d{4}/(\\d{1}|\\d{3})/\\d{1,2}"));
		// 打印true
		String takeTime2 = "2012////01/01";
		System.out.println(takeTime2.matches("\\d{4}/{2,}?\\d{2}/\\d{2}"));
		// 打印true
	}

	@Test
	public void test2() {
		//replace()和replaceAll()区别，replace只支持字符串的替换，不支持正则，replaceAll支持正则
		String str = "aa bbb cc	dd		ee \n\r ff";
		// str = str.replaceAll("\\t| |\n|\r","-");//回车或换行，空格等
		// str = str.replaceAll("\\s","-");//空白字符
		// str = str.replaceAll("\\b","-");//字符串的开始或结束位置
		str = str.replaceAll("\\B", "-");//字符串的非开始或非结束位置
		System.out.println(str);
		str = str.replace('a','z');//a换成z
		System.out.println(str);
		str = str.replace("-", "+");
		System.out.println(str);

		//贪婪-从最后一个开始匹配
		Pattern pattern = Pattern.compile(".+b");
		//非贪婪（惰性）
		//Pattern pattern = Pattern.compile(".+?b");
		Matcher matcher = pattern.matcher("abcdabceba");
		StringBuffer buffer = new StringBuffer();
		while (matcher.find()) {
			buffer.append(matcher.group());
			buffer.append("\r\n");
		}
		System.out.println(buffer.toString());

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

	/**
	 * ◆字符串是否包含验证
	 * @author wangzz-a
	 * @date 2015年10月9日 下午3:46:34
	 */
	@Test
	public void test3() {
		// 查找以Java开头,任意结尾的字符串
		Pattern pattern = Pattern.compile("^Java.*$");
		Matcher matcher = pattern.matcher("Java不是人");
		boolean b = matcher.matches();
		// 当条件满足时，将返回true，否则返回false
		System.out.println(b);
		
		Pattern pattern2 = Pattern.compile("Java不是人");
		Matcher matcher2 = pattern2.matcher("^Java.*$");
		boolean b2 = matcher2.matches();
		System.out.println(b2);

		boolean b3 = Pattern.matches("^Java.*$", "Java不是人");
		System.out.println(b3);
		
		String b4 = "Java不是人";
		System.out.println(b4.matches("^Java.*$"));

	}

	/**
	 * ◆以多条件分割字符串时
	 * 
	 * @author wangzz-a
	 * @date 2015年10月9日 下午3:46:34
	 */
	@Test
	public void test4() {
		Pattern pattern = Pattern.compile("[,|\\s]+");
		String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");
		for (int i = 0; i < strs.length; i++) {
			System.out.println(strs[i]);
		}
	}

	/**
	 * ◆文字替换（首次出现字符）
	 * 
	 * @author wangzz-a
	 * @date 2015年10月9日 下午3:46:34
	 */
	@Test
	public void test5() {
		// 编译正则
		Pattern pattern = Pattern.compile("正则表达式");
		// 匹配器
		Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
		// 替换第一个符合正则的数据
		System.out.println(matcher.replaceFirst("Java"));
	}

	/**
	 * ◆文字替换（全部）
	 * 
	 * @author wangzz-a
	 * @date 2015年10月9日 下午3:46:34
	 */
	@Test
	public void test6() {
		Pattern pattern = Pattern.compile("正则表达式");
		Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
		// 替换第一个符合正则的数据
		System.out.println(matcher.replaceAll("Java"));
		// 或
		// String str = "正则表达式 Hello World,正则表达式 Hello World";
		// System.out.println(str.replaceAll("正则表达式", "Java"));

	}

	/**
	 * ◆文字替换（置换字符）
	 * 正则表达式 --> Java
	 * @author wangzz-a
	 * @date 2015年10月9日 下午3:46:34
	 */
	@Test
	public void test7() {
		Pattern pattern = Pattern.compile("正则表达式");
		Matcher matcher = pattern.matcher("前面的 正则表达式 Hello World,正则表达式 Hello World 后面的");
		StringBuffer sbr = new StringBuffer();
		int i = 0; // 计数器
		while (matcher.find()) {
			matcher.appendReplacement(sbr, "Java" + ++i);
			System.out.println(i);
		}
		matcher.appendTail(sbr);
		System.out.println(sbr.toString());
	}

	/**
	 * ◆验证是否为邮箱地址
	 * @author wangzz-a
	 * @date 2015年10月9日 下午3:46:34
	 */
	@Test
	public void test8() {
		String str = "ceponline@yahoo.com.cn";
		Pattern pattern = Pattern.compile("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		System.out.println(matcher.matches());
	}

	/**
	 * ◆去除html标记
	 * 
	 * @author wangzz-a
	 * @date 2015年10月9日 下午3:46:34
	 */
	@Test
	public void test9() {
		// .+?表示最小匹配
		// 举例说明.+?与.+的区别
		// <a href="xxx"><span>
		// 如果用<.+>匹配，则匹配结果是
		// <a href="xxx"><span>
		// 如果用<.+?>匹配，则匹配结果是
		// <a href="xxx">
		// 也就是.+?只要匹配就返回了，不会再接着往下找了
		// “.”表示任意字符.“+”表示前面表达式一次乃至多次.“?”表示匹配模式是非贪婪的.
		Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
		String string = matcher.replaceAll("");
		System.out.println(string);

	}

	/**
	 * ◆查找html中对应条件字符串
	 * 
	 * @author wangzz-a
	 * @date 2015年10月9日 下午3:46:34
	 */
	@Test
	public void test10() {
		Pattern pattern = Pattern.compile("href=\"(.+?)\"");
		// Pattern pattern = Pattern.compile("<(.+?)>");
		Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
		while (matcher.find()) {
			System.out.println(matcher.group());
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
		}
	}

	/**
	 * ◆截取http://地址
	 * 
	 * @author wangzz-a
	 * @date 2015年10月9日 下午3:46:34
	 */
	@Test
	public void test11() {
		// 截取url
		// Pattern pattern = Pattern.compile("(http://|https://){1}[\\w\\.\\-/:]+");
		Pattern pattern = Pattern.compile("(https?://){1}[\\w\\.\\-/:]+");
		Matcher matcher = pattern.matcher("百度<http://www.baidu.com>  优酷<https://www.youku.com.cn:8080>fdf");

		StringBuffer buffer = new StringBuffer();
		while (matcher.find()) {
			buffer.append(matcher.group());
			buffer.append("\r\n");
		}
		System.out.println(buffer.toString());
	}

	/**
	 * ◆替换指定{}中文字
	 * 
	 * @author wangzz-a
	 * @date 2015年10月9日 下午3:46:34
	 */
	@Test
	public void test12() {
		String str = "Java目前的发展史是由{0}年-{1}年";
		String[][] object = { new String[] { "\\{0\\}", "1995" }, new String[] { "\\{1\\}", "2007" } };
		System.out.println(replace(str, object));
	}

	public static String replace(final String sourceString, Object[] object) {
		String temp = sourceString;
		for (int i = 0; i < object.length; i++) {
			String[] result = (String[]) object[i];
			Pattern pattern = Pattern.compile(result[0]);
			Matcher matcher = pattern.matcher(temp);
			temp = matcher.replaceAll(result[1]);
		}
		return temp;
	}

	/**
	 * 1.appendReplacement() 2.appendTail()
	 * 
	 * @author wangzz-a
	 * @date 2015年10月10日 下午3:03:15
	 */
	@Test
	public void test13() {
		// 生成Pattern对象并且编译一个简单的正则表达式"Kelvin"
		Pattern p = Pattern.compile("Kelvin");
		// 用Pattern类的matcher()方法生成一个Matcher对象
		Matcher m = p.matcher("Kelvin Li and Kelvin Chan are both working in Kelvin Chen's KelvinSoftShop company");
		StringBuffer sb = new StringBuffer();
		int i = 0;
		// 使用find()方法查找第一个匹配的对象
		boolean result = m.find();
		// 使用循环将句子里所有的kelvin找出并替换再将内容加到sb里
		while (result) {
			i++;
			m.appendReplacement(sb, "XiaoMing");
			System.out.println("第" + i + "次匹配后sb的内容是：" + sb); // 继续查找下一个匹配对象
			result = m.find();
		}
		// 最后调用appendTail()方法将最后一次匹配后的剩余字符串加到sb里； m.appendTail(sb);
		System.out.println("调用m.appendTail(sb)后sb的最终内容是:" + sb.toString());
	}
	
	/**
	 * group()/group(int group)/groupCount()用法
	 * @author wangzz-a
	 * @date 2015年10月10日 下午4:26:15
	 */
	@Test
	public void test14() {
		Pattern p = Pattern.compile("(ca.+),\\w+\\s+(ca..)");
		Matcher m = p.matcher("one cat,two cats in the yard");
		StringBuffer sb = new StringBuffer();
		while(m.find()){
			System.out.println("该次查找获得匹配组的数量为：" + m.groupCount());
			for (int i = 1; i <= m.groupCount(); i++) {
				sb.append(m.group(i)+" ");
				System.out.println("第" + i + "组的子串内容为： " + m.group(i));
			}
			//此正则获取的所有的内容
			System.out.println("当前查找而获得的字符串和组匹配的所有子串内容:"+m.group());
		}
		System.out.println("组装匹配组中的数据："+sb.toString());
	}

	/**
	 * 过滤非数字字符
	 */
	public void test15(){
		String attr = "4.asdfsad8%%43%分04分";
		attr = attr.replaceAll("[^\\d.]", "");
		System.out.println(attr);
	}
	
}

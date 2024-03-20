package patternTest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest {

    public static void main(String[] args) {
            /*String str = "/sdf/sdf/sdfsdf_temp.jpg";
			str = str.replaceAll("_temp", "");
			System.out.println(str);

			List<Map<String,Long>> countsList = new ArrayList<Map<String,Long>>();
			Map<String,Long> temp = new HashMap<String,Long>();
			temp.put("ownCount", 1l);
			temp.put("logCount", 2l);
			countsList.add(temp);
			temp.put("ownCount", 3l);
			temp.put("logCount", 4l);
			countsList.add(temp);
			temp.put("ownCount", 5l);
			temp.put("logCount", 6l);
			countsList.add(temp);
			temp.put("ownCount", 7l);
			temp.put("logCount", 8l);
			countsList.add(temp);
			System.out.println(countsList.toString());*/

        //删除 所有的<>标签和其中的内容
        String s = "<font style=\"color:red;\">萨瓦迪卡，红色的字</font>";
        String s2 = "dsadsadas<peter>dsadasdas<lionel>\"www.163.com\"<kenny><> &n呵呵123bsp;";
        int i1 = s.indexOf("<");
        int i2 = s.indexOf(">");
        System.out.println(i2);
        System.out.println(s2.replaceAll("(<[^>]*>)", ""));
        System.out.println(s2.replaceAll("(&[^;]*;)", "")); //过滤以&开头;结尾的字符串
        //System.out.println(s2.replaceAll("(<[^>]*>)|\\r\\n|&nbsp;", ""));
        System.out.println(s2.replaceAll("(<[^>]*>)|\\r\\n|(&[^;]*;)", ""));

        String s3 = "荧光灯、汽车金属卤化物灯、高压钠灯、紫外线灯电子镇流器研发和生产的高新技术企业。\r\n\r\n高新技术企业";
        s3 = s3.replaceAll("\\r\\n", "");
        System.out.println("s3=" + s3);

			/*String s = "dsadsadas<peter>dsadasdas<lionel>\"www.163.com\"<kenny><>";
			Pattern p = Pattern.compile("(<[^>]*>)");
			Matcher m = p.matcher(s);
			List<String> result=new ArrayList<String>();
			while(m.find()){
				result.add(m.group());
			}
			for(String s1:result){
				System.out.println(s1);
			}*/

	        /*Pattern pattern = Pattern.compile("b*g");
	        Matcher matcher = pattern.matcher("bbg");
	        System.out.println(matcher.matches());
	        System.out.println(pattern.matches("b*g","bbg"));
	        //验证邮政编码
	        System.out.println(pattern.matches("[0-9]{6}", "200038"));
	        System.out.println(pattern.matches("//d{6}", "200038"));
	        //验证电话号码
	        System.out.println(pattern.matches("[0-9]{3,4}//-?[0-9]+", "02178989799"));*/


    }

    @Test
    public void test1() {
        List<String> list = new ArrayList<String>();
        list.add("hello");
        list.add("你");
        list.add("号");
        list.add("啊");
        list.add("！");
        String str = list.toString();
        str = str.replaceAll("[\\[\\]\\s]", "");
        System.out.println(str);
        String[] split = str.split(",");
    }

    @Test
    public void test2() {
        //用正则删除json字符串中的某个字段
        String str = "{\"buyoutId\":null,\"arrivalDate\":\"2016-10-28 16:00:00\",\"combineDetailList\":null," +
                "\"virtualQuantity\":-1}";
        str = str.replaceAll("\"arrivalDate\".+?,", "");
        System.out.println(str);
    }


    @Test
    public void test3() {
        String url = "/emss/emss-cuc-dataasdfsd/c000/f01";
        //String regex = "rvNoNum\":(.+?),";
        String regex = "/(emss-(.+?))/";
        Matcher matcher = Pattern.compile(regex).matcher(url);
        String aaa = "";
        while (matcher.find()) {
            aaa = matcher.group(1);
            String ret = matcher.group(1);
            //System.out.println("提取出来的值：" + ret);
        }
        System.out.println("提取出来的值：" + aaa);
    }


}

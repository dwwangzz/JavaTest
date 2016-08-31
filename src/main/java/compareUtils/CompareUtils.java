package compareUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class CompareUtils {

	public static void main(String[] args) {
		String ss = "1,2,3,4,5";
		String[] ssArr = ss.split(",");
		System.out.println("".length());
		List<String> list = new ArrayList<String>();
		
		list.add("a");
		list.add("a");
		list.add("a");
		list.add("a");
		String[] aa = (String[]) list.toArray(new String[list.size()]);
		String aaa = Arrays.toString(aa).replaceAll(" ","");
		System.out.println(aaa.length());
		System.out.println(aaa);
		System.out.println(list.toString());
		
		String str = "sf,s	d  s  f";
		str = str.replaceAll("\\[|\\]|\\s","");
//		str = str.substring(1, str.length()-1);
		System.out.println("Str="+str);
		
		String yixuan = "1,2,2,2,3,4,5";
		String rex = "2,3,4,2";
		list = compareSameStringArr(yixuan.split(","), rex.split(","));
		System.out.println("xiangtong="+list.toString());
		list = compareADelB(rex.split(","),yixuan.split(",") );
		System.out.println("A-B="+list);
		
	}
	/**
	 * 比较两个字符串数组  返回两个数组不同的元素
	 * @author wangzz-a
	 * @param list1
	 * @param list2
	 * @return List<String>
	 * @date 2014年12月3日 下午12:51:38
	 */
	public static List<String> compareDistinceStringArr(String[] list1,String[] list2){
		if(list1==null||list2==null){
			return new ArrayList<String>();
		}
		List<String> collection1 = new ArrayList<String>();
		List<String> collection2 = new ArrayList<String>();
		Collections.addAll(collection1,list1);
		Collections.addAll(collection2,list2);
		List<String> a = new ArrayList<String>(collection1);
		List<String> b = new ArrayList<String>(collection2);
		a.removeAll(collection2);
		b.removeAll(collection1);
		List<String> result = new ArrayList<String>();
		result.addAll(a);
		result.addAll(b);
		return result;
	}
	/**
	 * 比较两个字符串数组 返回两个数组中相同的元素
	 * @author wangzz-a
	 * @param list1
	 * @param list2
	 * @return
	 * @date 2014年12月3日 下午2:53:21
	 */
	public static List<String> compareSameStringArr(String[] list1,String[] list2){
		if(list1==null||list2==null){
			return new ArrayList<String>();
		}
		//不同的元素
		List<String> butong = compareDistinceStringArr(list1, list2);
		List<String> collectionAll = new ArrayList<String>();
		Collections.addAll(collectionAll,list1);
		collectionAll.removeAll(butong);
		List<String> result = new ArrayList<String>();
		result.addAll(collectionAll);
		return result;
	}
	/**
	 * 返回A中有B中没有的元素
	 * @author wangzz-a
	 * @return
	 * @date 2014年12月3日 下午2:58:54
	 */
	public static List<String> compareADelB(String[] a,String[] b){
		List<String> collectionA = new ArrayList<String>();
		Collections.addAll(collectionA, a);
		List<String> same = compareSameStringArr(a, b);
		collectionA.removeAll(same);
		return collectionA;
	}
	/**
	 * 比较两个字符串数组  返回两个数组不同的元素
	 * @author wangzz-a
	 * @param list1
	 * @param list2
	 * @return List<String>
	 * @date 2014年12月3日 下午12:51:38
	 */
	public static List<String> compareStringArr(String[] arr1,String[] arr2){
		if(arr1==null||arr2==null){
			return new ArrayList<String>();
		}
		List<String> collection1 = new ArrayList<String>();
		List<String> collection2 = new ArrayList<String>();
		Collections.addAll(collection1,arr1);
		Collections.addAll(collection2,arr2);
		List<String> a = new ArrayList<String>(collection1);
		List<String> b = new ArrayList<String>(collection2);
		a.removeAll(collection2);
		b.removeAll(collection1);
		List<String> result = new ArrayList<String>();
		result.addAll(a);
		result.addAll(b);
		//删除集合中重复元素
		result = removeDuplicate(result);
		return result;
	}
	/**
	 * 删除list中重复元素
	 * @author wangzz-a
	 * @param list
	 * @return
	 * @date 2014年12月3日 下午3:15:29
	 */
	public static List<String> removeDuplicate(List<String> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(j).equals(list.get(i))) {
					list.remove(j);
				}
			}
		}
		return list;
	}
	/**
	 * 比较两个字符串，返回不同
	 * 如：str1="1,2,3";str2="1,2" -> 返回 3
	 * @author wangzz-a
	 * @param str1
	 * @param str2
	 * @return
	 * @date 2014年12月3日 下午1:53:02
	 */
	public static String compareString(String str1,String str2){
		//为空的话就赋值为空字符串""
		str1 = str1==null?"":str1;
		str2 = str2==null?"":str2;
		//如果str1或str2为空
		if(str1.length()==0||str2.length()==0){
			if(str1.length()==0 && str2.length()==0){
				return "";
			}
			if(str1.length()==0&&str2.length()!=0)
				return str2;
			return str1;
		}
		String[] str1Arr = str1.split(",");
		String[] str2Arr = str2.split(",");
		
		List<String> list = CompareUtils.compareStringArr(str1Arr, str2Arr);
		String result = list.toString();
		result = trimArr(result);
		return result;
	}
	/**
	 * 删除数组转换之后字符串的[]和空格
	 * 如 "[1, 2, 3]"->"1,2,3"
	 * @author wangzz-a
	 * @param str
	 * @return
	 * @date 2014年12月3日 下午1:47:14
	 */
	public static String trimArr(String str){
		str = str.replaceAll("\\[|\\]|\\s","");
		return str;
	}
}

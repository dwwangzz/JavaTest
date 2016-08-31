package compareUtils;

import java.util.*;
import java.util.Map.Entry;

public class CompareArrayUtil {
	public static void main(String[] args) {
		// 测试union
		String[] arr1 = { "abc", "df", "abc" };
		String[] arr2 = { "abc", "cc", "df", "d", "abc" };
		String[] result_union = union(arr1, arr2);
		System.out.println("求并集的结果如下：");
		for (String str : result_union) {
			System.out.println(str);
		}
		System.out.println("---------------------可爱的分割线------------------------");

		// 测试insect
		String[] result_insect = intersect(arr1, arr2);
		System.out.println("求交集的结果如下：");
		for (String str : result_insect) {
			System.out.println(str);
		}

		System.out.println("---------------------疯狂的分割线------------------------");
		// 测试minus
		String[] result_minus = minus(arr1, arr2);
		System.out.println("求差集的结果如下：");
		for (String str : result_minus) {
			System.out.println(str);
		}
		
		
		compareInt();
		
		String[] strArr = {"1","2","4","3"}; 
		String[] strArr2 = {"1","2","3","4"}; 
		// java代码两个集合不相同的部分
		List<String> collection1 = new ArrayList<String>();
		List<String> collection2 = new ArrayList<String>();
		Collections.addAll(collection1, strArr);
		Collections.addAll(collection2, strArr2);
		List<String> a = new ArrayList<String>(collection1);
		List<String> b = new ArrayList<String>(collection2);
		a.removeAll(collection2);
		b.removeAll(collection1);
		List<String> result = new ArrayList<String>();
		result.addAll(a);
		result.addAll(b);
		
//		System.out.println(result);
//
//		System.out.println("========="+equals(a, b));
//		
//		System.out.println(compareArr(strArr, strArr2).size()==0);
		
		System.out.println(compareString("1,2,3,4","1,2,3"));
	}

	// 求两个字符串数组的并集，利用set的元素唯一性
	public static String[] union(String[] arr1, String[] arr2) {
		Set<String> set = new HashSet<String>();
		for (String str : arr1) {
			set.add(str);
		}
		for (String str : arr2) {
			set.add(str);
		}
		String[] result = {};
		return set.toArray(result);
	}

	// 求两个数组的交集
	public static String[] intersect(String[] arr1, String[] arr2) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		LinkedList<String> list = new LinkedList<String>();
		for (String str : arr1) {
			if (!map.containsKey(str)) {
				map.put(str, Boolean.FALSE);
			}
		}
		for (String str : arr2) {
			if (map.containsKey(str)) {
				map.put(str, Boolean.TRUE);
			}
		}

		for (Entry<String, Boolean> e : map.entrySet()) {
			if (e.getValue().equals(Boolean.TRUE)) {
				list.add(e.getKey());
			}
		}

		String[] result = {};
		return list.toArray(result);
	}

	// 求两个数组的差集
	public static String[] minus(String[] arr1, String[] arr2) {
		LinkedList<String> list = new LinkedList<String>();
		LinkedList<String> history = new LinkedList<String>();
		String[] longerArr = arr1;
		String[] shorterArr = arr2;
		// 找出较长的数组来减较短的数组
		if (arr1.length > arr2.length) {
			longerArr = arr2;
			shorterArr = arr1;
		}
		for (String str : longerArr) {
			if (!list.contains(str)) {
				list.add(str);
			}
		}
		for (String str : shorterArr) {
			if (list.contains(str)) {
				history.add(str);
				list.remove(str);
			} else {
				if (!history.contains(str)) {
					list.add(str);
				}
			}
		}

		String[] result = {};
		return list.toArray(result);
	}
	
	
	
	//两个数组不相同的部分
	public static List<String> compareArr(String[] list1,String[] list2){
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

	//判断两个int数组是否相等，返回数组中 不同的元素
	private static void compareInt() {
		List<Integer> collection1 = new ArrayList<Integer>();
		List<Integer> collection2 = new ArrayList<Integer>();
		Collections.addAll(collection1, 1, 2, 3, 4, 5, 6);
		Collections.addAll(collection2, 3, 4, 5, 7, 8);
		List<Integer> a = new ArrayList<Integer>(collection1);
		List<Integer> b = new ArrayList<Integer>(collection2);

		a.removeAll(collection2);
		b.removeAll(collection1);
		List<Integer> result = new ArrayList<Integer>();
		result.addAll(a);
		result.addAll(b);
		System.out.println(result);
	}

	//判断两个集合是否相等
	public static <T> boolean equals(Collection<T> a, Collection<T> b) {
		if (a == null) {
			return false;
		}
		if (b == null) {
			return false;
		}
		if (a.isEmpty() && b.isEmpty()) {
			return true;
		}
		if (a.size() != b.size()) {
			return false;
		}
		List<T> alist = new ArrayList<T>(a);
		List<T> blist = new ArrayList<T>(b);
		Collections.sort(alist, new Comparator<T>() {
			public int compare(T o1, T o2) {
				return o1.hashCode() - o2.hashCode();
			}

		});
		Collections.sort(blist, new Comparator<T>() {
			public int compare(T o1, T o2) {
				return o1.hashCode() - o2.hashCode();
			}

		});
		return alist.equals(blist);
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
		
		List<String> list = compareArr(str1Arr, str2Arr);
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
		str = str.substring(1, str.length()-1).trim().replaceAll(" ","");
		return str;
	}

}

package ListUtils;

import kryo.User;

import java.util.*;


@SuppressWarnings({"unchecked","rawtypes"})
public class ListUtils {
	
	public static void main(String[] args) {
		//asList();
        List<User> users = new ArrayList<User>();
        for (int i=0; i<10; i++){
            User user = new User();
            user.setId(i);
            user.setName("小明"+i);
            user.setAge(8+i);
            users.add(user);
        }

        System.out.println(users.toString());
        User u1 = users.get(0);
        User u2 = users.get(1);
        User u3 = users.get(2);
        users.remove(u1);
        users.remove(u3);
        System.out.println(users.toString());

	}

	/**集合转数组*/
	public static void toArray(){
		List list = new ArrayList();
		list.add("小明");
		list.add("小华");
		
		//打印结果 ---> [小明, 小华]
		final int size =  list.size();
		String[] arr = (String[])list.toArray(new String[size]);
		printArr(arr);
		
		//打印结果 ---> [小明, 小华, null, null]
		String[] strArr = new String[4];
		String[] str = (String[])list.toArray(strArr);
		printArr(str);
		
		//打印结果 ---> [小明, 小华, null, d]
		String[] strArr2 = new String[]{"a","b","c","d"};
		String[] str2 = (String[])list.toArray(strArr2);
		printArr(str2);
		
		//打印结果 ---> [小明, 小华, null, d]
		String[] strArr3 = {"a","b","c","d"};
		String[] str3 = (String[])list.toArray(strArr3);
		printArr(str3);
		
		//打印结果 ---> [小明, 小华]
		Object[] objArr = list.toArray();
		printArr(objArr);
	}
	/**数组转集合*/
	public static void asList() {
		//声明数组的三种方式
		String[] strArr = new String[] {"a","b","c"};
		//String[] strArr2 = new String[3];
		//String[] strArr3 = {"a","b","c"};
		byte[] b = new byte[4];
		b[0] = -10;
		b[1] = 1;
		b[2] = 55;
		b[3] = 67;
		
		//打印数组
		//printArr(strArr);
		
		//数组转集合
		List<String> list = Arrays.asList("Larry", "Moe", "Curly");
		List<String> list2 = Arrays.asList(strArr);
		List<byte[]> list3 = Arrays.asList(b);
		System.out.println(list);
		System.out.println(list2);
		System.out.println(list3);
	}
	
	// 并集
	public static Collection union(Collection... collections) {
		if (EmptyUtil.isNotEmpty(collections)) {
			Set set = new LinkedHashSet();
			for (Collection collection : collections) {
				set.addAll(collection);
			}
			return set;
		}
		return null;
	};

	// 交集
	public static Collection intersection(Collection... collections) {
		if (EmptyUtil.isNotEmpty(collections)) {
			Set set = new LinkedHashSet();
			for (int i = 0; i < collections.length; i++) {
				if (i == 0 && EmptyUtil.isEmpty(set)) {
					set.addAll(collections[i]);
				} else {
					set.retainAll(collections[i]);
				}
			}
			return set;
		}
		return null;
	}

	// 差集
	public static Collection difference(Collection... collections) {
		if (EmptyUtil.isNotEmpty(collections)) {
			// 并集-交集
			Set union = (Set) union(collections);
			Set intersection = (Set) intersection(collections);
			union.removeAll(intersection);
			return union;
		}
		return null;
	};
	/**
	 * list去重
	 * @author wangzz-a
	 * @param lon
	 * @return
	 * @date 2015年3月21日 上午11:59:43
	 */
	public static List<Long> getDistinctList(List<Long> lon){
		List<Long> result = new ArrayList<Long>();
		if(lon==null || lon.size()==0)
			return result;
		for(Long l : lon){
			if(!result.contains(l))
				result.add(l);
		}
		return result;
	}
	
	/**
	 * 打印数组
	 * @author wangzz-a
	 * @param bytes
	 * @date 2015年11月10日 上午9:04:39
	 */
	public static String printArr(Object[] bytes){
		String result = null; 
		if(bytes==null||bytes.length==0)
			return result;
		System.out.print("[");
		result = "[";
		for (int i = 0; i < bytes.length; i++) {
			if(i+1==bytes.length){
				System.out.print(bytes[i]);
				result+=bytes[i];
			}else{
				System.out.print(bytes[i]+", ");
				result+=bytes[i]+", ";
			}
		}
		System.out.println("]");
		result+="]";
		return result;
	}
	
}

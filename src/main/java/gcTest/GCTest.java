package gcTest;

import java.util.*;

public class GCTest {

	public static void main(String[] args) {
		System. out .println( " 内存信息 :" + toMemoryInfo ());
		oom();
	}
	
	private static void oom(){
        List<Map<String,Student>> list = new ArrayList<Map<String,Student>>();
        while(true){
        	Map<String, Student> map = new HashMap<String, Student>();
            for(long j=0;j<=10000000;j++){
            	Student stu = new Student(new Date().toString()+"name"+j, j++);
            	map.put("key"+j, stu);
            	System.out.println(j);
            	System. out .println( " 内存信息 :" + toMemoryInfo ());
            }
            list.add(map);
        }
    }
	/**获取当前 jvm 的内存信息*/
    public static String toMemoryInfo() {
        Runtime currRuntime = Runtime.getRuntime ();
        int nFreeMemory = ( int ) (currRuntime.freeMemory() / 1024 / 1024);
        int nTotalMemory = ( int ) (currRuntime.totalMemory() / 1024 / 1024);
        return nFreeMemory + "M/" + nTotalMemory + "M(free/total)" ;
     }
}

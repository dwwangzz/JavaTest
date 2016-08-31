package ListUtils;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class EmptyUtil {
	
	public static boolean isNull(Object obj){
		return obj == null ? true : false;
	}
	
	public static boolean isNotNull(Object obj){
		return !isNull(obj);
	}
	
	public static boolean isNotEmpty(Object obj){
		//数组类型、集合类型、值对象类型、字符串类型
		if(isNull(obj)){
			return false;
		}
		if(obj.getClass().isArray()){
			return Array.getLength(obj) > 0 ? true : false;
		}
		if(obj instanceof Collection){
			return ((Collection<?>) obj).size() > 0 ? true : false;
		}
		if(obj instanceof Map){
			return ((Map<?, ?>) obj).size() > 0 ? true : false;
		}
		if(obj instanceof String){
			return obj.toString().trim().length() > 0 ? true : false;
		}
		if(obj instanceof File){
			return ((File) obj).exists();
		}
		return true;
	}
	
	public static boolean isEmpty(Object obj){
		return ! isNotEmpty(obj);
	}
	
	
	public static String getUUID(){
	    UUID uuid = UUID.randomUUID();
	    return uuid.toString();
	}
}

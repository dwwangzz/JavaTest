package JsonUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.*;

public class JsonPars {

	public static void main(String[] args) {

		/*String jsonStr = "{\"code\":200,\"data\":[{\"account\":\"ssss\",\"infos\":[{\"rightType\":12,\"beginDate\":\"2013-05-20\"},{\"rightType\":12}]},{\"account\":\"ddd\",\"infos\":[{\"rightType\":22},{\"rightType\":22}]}]}";

		JSONObject param = JSONObject.fromObject(jsonStr);
		
		JSONArray testJson = JSONArray.fromObject(param.get("data").toString());
		
		List<Test> result = new ArrayList<Test>();
		
		for(Object test : testJson){
			Test temp = (Test) JSONObject.toBean((JSONObject)test, Test.class);
			JSONArray infosTemp =  ((JSONObject)test).getJSONArray("infos");
			List<Infos> infos = (List<Infos>) infosTemp.toCollection(infosTemp, Infos.class);
			temp.setInfos(infos);
			result.add(temp);
		}
		Test test1 = result.get(0);
		Test test2 = result.get(1);
		System.out.println(test1.getAccount()+"++++"+test1.getInfos().get(0).getBeginDate());
		System.out.println(result.toString());*/
		
		//实体转json
		//paresJson();
		
		//集合转json
		//listToJson();
		
		
		
		//map转json
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("aaa","你好啊，小明");
		map.put("bbb",123);
		JSONObject json = JSONObject.fromObject(map);
		System.out.println(json.toString());
		
		
	
	}
	/**
	 * 集合转json
	 * @author wangzz-a
	 * @date 2015年7月3日 下午3:53:11
	 */
	public static void listToJson() {
		Infos info1 = new Infos();
		info1.setProductName("钢筋1");
		info1.setBeginDate(new Date().toString());
		info1.setRightType(1);
		Infos info2 = new Infos();
		info2.setProductName("钢筋2");
		info2.setBeginDate(new Date().toString());
		info2.setRightType(2);
		Infos info3 = new Infos();
		info3.setProductName("钢筋3");
		info3.setBeginDate(new Date().toString());
		info3.setRightType(3);
		List<Infos> list = new ArrayList<Infos>();
		list.add(info1);
		list.add(info2);
		list.add(info3);
		JSONArray jsonObj = JSONArray.fromObject(list);
		System.out.println(jsonObj);
	}
	/**
	 * 实体转json
	 * @author wangzz-a
	 * @date 2015年7月3日 下午3:38:00
	 */
	public static void paresJson() {
		Infos info = new Infos();
		info.setProductName("钢筋");
		info.setBeginDate(new Date().toString());
		info.setRightType(9);
		Infos info2 = new Infos();
		info2.setProductName("钢筋2");
		info2.setBeginDate(new Date().toString());
		info2.setRightType(2);
		Test test = new Test();
		test.setAccount("testAccount");
		List<Infos> list = new ArrayList<Infos>();
		list.add(info);
		list.add(info2);
		test.setInfos(list);
		//JSONObject jsonObj = JSONObject.fromObject(info);
		JSONObject jsonObj = JSONObject.fromObject(test);
		System.out.println(jsonObj);
	}
	
	/**
	 * 解析单个实体
	 * @author wangzz-a
	 * @date 2015年6月26日 下午7:00:06
	 */
	@org.junit.Test
	public void jsonPars1(){
		
		//json对象本身就是一个实体类
		String jsonStr = "{\"rightType\":12,\"beginDate\":\"2013-05-20\"}";
		//先把json字符串转换成JSONObject实体
		JSONObject jsonObj = JSONObject.fromObject(jsonStr);
		//把JSONObject对象强转为对应实体
		Infos info = (Infos) JSONObject.toBean(jsonObj, Infos.class);
		System.out.println("info="+info.toString());
		
		
		//json对象在map中的data属性中
		String jsonStr2 = "{\"code\":200,\"data\":{\"rightType\":22,\"beginDate\":\"2015-05-22\",\"productName\":\"钢筋\"}}";
		//先把json字符串转换成JSONObject实体
		JSONObject jsonObj2 = JSONObject.fromObject(jsonStr2);
		jsonObj2 = (JSONObject) jsonObj2.get("data");
		//把JSONObject对象强转为对应实体
		Infos info2 = (Infos) JSONObject.toBean(jsonObj2, Infos.class);
		System.out.println("info2="+info2.toString());
		
	}
	
	/**
	 * 解析 实体集合
	 * @author wangzz-a
	 * @date 2015年6月26日 下午7:00:06
	 */
	@org.junit.Test
	public void jsonPars2(){
		
		//json对象集合本身就是一个实体类集合
		String jsonStr = "[{\"rightType\":1,\"beginDate\":\"2013-05-20\",\"productName\":\"第一个产品\"},{\"rightType\":2,\"beginDate\":\"2015-05-22\",\"productName\":\"第二个产品\"}]";
		//先把json字符串转换成JSONArray实体
		JSONArray jsonInfos = JSONArray.fromObject(jsonStr);
		//把JSONArray对象强转为对应实体集合
		List<Infos> infos = (List<Infos>) JSONArray.toCollection(jsonInfos, Infos.class);
		System.out.println("info="+infos.get(0).toString()+">>>>>>>>>>>>>> \n\r" +infos.get(1).toString());
		
		
		//json对象集合在map中的data属性中
		String jsonStr2 = "{\"code\":200,\"data\":[{\"rightType\":1,\"beginDate\":\"2013-05-20\",\"productName\":\"第一个产品\"},{\"rightType\":2,\"beginDate\":\"2015-05-22\",\"productName\":\"第二个产品\"}]}";
		//先把json字符串转换成JSONObject实体
		JSONObject jsonObj2 = JSONObject.fromObject(jsonStr2);
		//从jsonObj2实体中取出实体类集合
		JSONArray jsonInfos2 = jsonObj2.getJSONArray("data");
		//把JSONArray对象强转为对应实体集合
		List<Infos> infos2 = (List<Infos>) JSONArray.toCollection(jsonInfos2, Infos.class);
		System.out.println("info2="+infos2.get(0).toString()+">>>>>>>>>>>>>> \n\r" +infos.get(1).toString());
		
	}
	
	/**
	 * 解析 集合类中有集合类
	 * @author wangzz-a
	 * @date 2015年6月26日 下午7:00:06
	 */
	@org.junit.Test
	public void jsonPars3(){
		
		String jsonStr = "{\"code\":200,\"data\":[{\"account\":\"ssss\",\"infos\":[{\"rightType\":12,\"beginDate\":\"2013-05-20\"},{\"rightType\":12}]},{\"account\":\"ddd\",\"infos\":[{\"rightType\":22},{\"rightType\":22}]}]}";

		
		JSONObject param = JSONObject.fromObject(jsonStr);
		
		JSONArray testJson = JSONArray.fromObject(param.get("data").toString());
		
		List<Test> result = new ArrayList<Test>();
		
		for(Object test : testJson){
			
			Test temp = (Test) JSONObject.toBean((JSONObject)test, Test.class);
			
			JSONArray infosTemp =  ((JSONObject)test).getJSONArray("infos");
			
			List<Infos> infos = (List<Infos>) infosTemp.toCollection(infosTemp, Infos.class);
			
			temp.setInfos(infos);
			
			result.add(temp);
			
		}
		
		Test test1 = result.get(0);
		Test test2 = result.get(1);
		
		System.out.println(test1.getAccount()+"++++"+test1.getInfos().get(0).getBeginDate());
		System.out.println(result.toString());
		
	}
	
	
	
}

package solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import solr.entity.FullTextSearchData;
import solr.entity.FullTextSearchForWeb;
import solr.entity.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public abstract class SolrClient {
	
	protected static HttpSolrClient solrClient = null;
	
	/**
	 * @Description 方法描述说明
	 * @author liuy-8
	 * @date 2015年7月3日 下午3:04:40 
	 * @param solrClient solr http 客户端
	 * @param collection 查询的core名字
	 * @param objects 数据实体列表
	 */
	@SuppressWarnings("unused")
	public void add(HttpSolrClient solrClient, String collection, List<?> objects){
		try {
			UpdateResponse updateResponse = solrClient.addBeans(collection, objects);
			solrClient.commit(collection);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @Description 方法描述说明
	 * @author liuy-8
	 * @date 2015年7月3日 下午3:04:40 
	 * @param solrClient solr http 客户端
	 * @param collection 查询的core名字
	 * @param objects 数据实体列表
	 */
	@SuppressWarnings("unused")
	public void add(HttpSolrClient solrClient, String collection, Object object){
		try {
			UpdateResponse updateResponse = solrClient.addBean(collection, object);
			solrClient.commit(collection);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @Description 方法描述说明
	 * @author liuy-8
	 * @date 2015年7月3日 下午2:24:03 
	 * @param collection 查询的core名字
	 * @param solrQuery 查询方案
	 * @param beanClass 返回实体的class，用于bean转换
	 * @return 结果集，包括查询到的对象列表，查询到的数据总数量
	 */
	protected Map<String, Object> query(HttpSolrClient solrClient, String collection, SolrQuery solrQuery, Class<?> beanClass){
		//结果集
		Map<String, Object> result = new HashMap<String, Object>();
		List<?> list = null;
		try {
			//查询结果
			QueryResponse queryResponse = solrClient.query(collection, solrQuery);
			list = queryResponse.getBeans(beanClass);
			//查询出总数量
			result.put("numFound", queryResponse.getResults().getNumFound());
			//返回列表对象
			result.put("datas", list);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static void add(){
		long start = System.currentTimeMillis();
		String url = "http://172.16.231.230:8081/solr/caigou_search";
		HttpSolrClient solrClient = new HttpSolrClient(url);
		List<Test> list = new ArrayList<Test>();
		for(int i = 1; i < 10000; i++){
			Test obj = new Test();
			obj.setTitle("1");
			obj.setContent("2");
			obj.setId("刘洋无敌的免费书籍"+i);
			obj.setPeopleName("liuy-8"+i);
			list.add(obj);
		}
		try {
			UpdateResponse updateResponse = solrClient.addBeans(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//索引优化，可以不加，应该会自动优化
			//solrClient.optimize();
			//重建索引？？
			solrClient.commit();
			solrClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(1);
	}
	
	public static void delete(String collection){
		long start = System.currentTimeMillis();
		String url = "http://172.16.231.230:8081/solr/" + collection;
		HttpSolrClient solrClient = new HttpSolrClient(url);
		
		try {
			solrClient.deleteByQuery("companyId:*");
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			solrClient.commit();
			solrClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		System.out.println(2);
	}
	
	private static void query(String key){

		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("searchField:(透气帽)");
		List<FullTextSearchData> list = null;
		try {
			long start = System.currentTimeMillis();
			QueryResponse queryResponse = solrClient.query(solrQuery);
			System.out.println(queryResponse.getResults().getNumFound());
			list = queryResponse.getBeans(FullTextSearchData.class);
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (SolrServerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for(FullTextSearchData test : list){
			System.out.println(test.getPrNames());
			System.out.println();
		}
		try {
			solrClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(3);
	}
	
	/**
	 * 
	 * @Description 删除索引
	 * @author huangqw
	 * @date 2015年8月24日 下午8:41:58 
	 * @param collection
	 * @param solrClient
	 * @param uniqueKeyId
	 */
	public static void deleteIndex(String collection,HttpSolrClient solrClient) {
		
		try {
			solrClient.deleteByQuery(collection,"*:*");
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			solrClient.commit(collection);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Description 根据唯一id：uniqueKeyId删除对象
	 * @author huangqw
	 * @date 2015年8月21日 下午5:04:04 
	 * @param core
	 */
//	public static void delete(String core,String uniqueKeyId) {
	public static void delete(String collection,HttpSolrClient solrClient,String uniqueKeyId) {
		
//		String url = "http://172.16.231.230:8081/solr/" + core;
//		HttpSolrClient solrClient = new HttpSolrClient(url);
		
		try {
			solrClient.deleteById(collection,uniqueKeyId);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			solrClient.commit(collection);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @Description 重点标记或取消重点标记
	 * @author huangqw
	 * @date 2015年8月23日 下午4:13:05 
	 * @param core
	 * @param uniqueKeyId：唯一索引
	 * @param isImportant：1进行重点标记，0取消重点标记
	 */
	public static void updateForIsImportant(String collection,HttpSolrClient solrClient,String uniqueKeyId,int isImportant) {
	
//		String url = "http://172.16.231.230:8081/solr/" + core;
//		HttpSolrClient solrClient = new HttpSolrClient(url);
		
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("uniqueKeyId:" + uniqueKeyId);
		FullTextSearchForWeb obj = null;
		
		try {
			QueryResponse queryResponse = solrClient.query(collection,solrQuery);
			System.out.println(queryResponse.getResults().getNumFound());
			obj = queryResponse.getBeans(FullTextSearchForWeb.class).get(0);
			obj.setIsImportant(isImportant);
			solrClient.addBean(collection,obj);
		} catch (SolrServerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			solrClient.commit(collection);
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @Description 重点标记或取消重点标记
	 * @author huangqw
	 * @date 2015年8月23日 下午4:13:05 
	 * @param core
	 * @param uniqueKeyId：唯一索引
	 * @param isImportant：1进行重点标记，0取消重点标记
	 */
	public void update(HttpSolrClient solrClient, String collection, List<?> objects) {
		add(solrClient, collection, objects);
	}
	
	public void update(HttpSolrClient solrClient, String collection, Object object) {
		add(solrClient, collection, object);
	}
	
	/**
	 * 
	 * @Description 添加或者是编辑对象
	 * @author huangqw
	 * @date 2015年8月23日 下午4:20:39 
	 * @param core
	 * @param fullTextSearchForWeb
	 * @return
	 */
	public static boolean updateObject(String collection,HttpSolrClient solrClient,FullTextSearchForWeb fullTextSearchForWeb) {
		
//		String url = "http://172.16.231.230:8081/solr/" + core;
//		HttpSolrClient solrClient = new HttpSolrClient(url);
		
		boolean flag = true;
		try {
			solrClient.addBean(collection,fullTextSearchForWeb);
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		} catch (SolrServerException e) {
			flag = false;
			e.printStackTrace();
		}
		
		try {
			solrClient.commit(collection);
		} catch (SolrServerException e) {
			flag = false;
			e.printStackTrace();
		} catch (IOException e) {
			flag = false;
			e.printStackTrace();
		}
		
		return flag;
	}
	
	
	/**
	 * 
	 * @Description 查询和编辑的测试程序
	 * @author huangqw
	 * @date 2015年8月23日 下午4:21:36 
	 * @param core
	 * @param isImportant
	 */
	public static void query2(String core,int isImportant) {
		
		//String url = "http://172.16.231.230:8081/solr/" + core;
		//HttpSolrClient solrClient = new HttpSolrClient(url);
		
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setQuery("uniqueKeyId:2M");
		FullTextSearchForWeb obj = null;
		
		try {
			QueryResponse queryResponse = solrClient.query(solrQuery);
			System.out.println(queryResponse.getResults().getNumFound());
			obj = queryResponse.getBeans(FullTextSearchForWeb.class).get(0);
			obj.setIsImportant(isImportant);
			solrClient.addBean(obj);
		} catch (SolrServerException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
			try {
				solrClient.commit();
			} catch (SolrServerException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
//		delete("caigou_search_web","3001M");
		/*
		String url = "http://172.16.231.230:8081/solr/caigou_search_web";
		HttpSolrClient solrClient = new HttpSolrClient(url);
		FullTextSearchForWeb obj = new FullTextSearchForWeb();
		obj.setUniqueKeyId("65521G");
		obj.setBrand("123123");*/
//		update("caigou_search_web","65521G",1);
//		query2("caigou_search_web",1);
		/*
		try {
			solrClient.addBean(obj);
			//solrClient.deleteById("6551G");
			//solrClient.deleteByQuery("uniqueKeyId:6547G");
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			solrClient.commit();
			solrClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}*/
	}
	
}

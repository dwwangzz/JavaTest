package solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import java.util.List;
import java.util.Map;

public class CaigouAppSolrSearch extends SolrClient {
	
	/**  全文检索地址 */
	public static final String CAIGOU_CORE_NAME = "caigou_search";
	/**  全文检索地址_web前端 */
	public static final String CAIGOU_CORE_NAME_WEB = "caigou_search_web";
	
	private HttpSolrClient solrClient;
	
	//物资经理app全文检索对应的core名称
	private final String collection = CAIGOU_CORE_NAME;
	
	private final String web = CAIGOU_CORE_NAME_WEB;

	/**
	 * @Description 向solr服务器中增加数据
	 * @author liuy-8
	 * @date 2015年7月3日 下午3:03:52 
	 * @param objects 数据实体列表
	 */
	public void add(List<?> objects){
		add(solrClient, collection, objects);
	}
	
	/**
	 * @Description 向solr服务器中增加数据
	 * @author liuy-8
	 * @date 2015年7月3日 下午3:03:52 
	 * @param objects 数据实体列表
	 */
	public void add_web(List<?> objects){
		add(solrClient, web, objects);
	}
	
	/**
	 * @Description 方法描述说明
	 * @author liuy-8
	 * @date 2015年7月3日 下午3:02:50 
	 * @param collection 查询的core名字
	 * @param solrQuery 查询方案
	 * @param beanClass 返回实体的class，用于bean转换
	 * @return 结果集，包括查询到的对象列表，查询到的数据总数量
	 */
	public Map<String, Object> query(String collection, SolrQuery solrQuery, Class<?> beanClass){
		return query(solrClient, collection, solrQuery, beanClass);
	}
	
	
	/**
	 * 
	 * @Description app删除索引
	 * @author huangqw
	 * @date 2015年8月24日 下午8:53:30 
	 * @param collection
	 */
	public void deleteIndex() {
		deleteIndex(collection, solrClient);
	}
	
	/**
	 * @Description 方法描述说明
	 * @author liuy-8
	 * @date 2015年7月3日 下午3:02:20 
	 * @param searchKey 搜索关键词
	 * @param pageNum 页数
	 * @param pageSize 每页大小
	 * @param beanClass 返回实体的class，用于bean转换
	 * @return 结果集，包括查询到的对象列表，查询到的数据总数量
	 */
	public Map<String, Object> caigouAppSearch(String operateCategory,String provinceCode,String cityCode, String searchKey, int pageNum, int pageSize, Class<?> beanClass){
		//查询对象
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.set("defType", "edismax");
		//查询字段
		solrQuery.set("pf", "mainCategories companyName contactPerson contactPhone brandName prNames prSepecifications prBrands prTypenames");
		//字段权重 1为本来权重
		solrQuery.set("qf", "mainCategories^5 companyName^5 contactPerson^100 contactPhone brandName^5 prNames^1 prSepecifications^1 prBrands^1 prTypenames^1");
		//积分影响排序
		solrQuery.set("bf", "sum(div(companyCredit,100000))");
		
		//搜索空字符串，默认搜索全部
		if("".equals(searchKey.trim()))
			searchKey = "*";
		
		//设置搜索词
		solrQuery.setQuery("(" + searchKey + ")");
		if(null != cityCode && !"".equals(cityCode)){
			//过滤城市
			solrQuery.addFilterQuery("locationAreaCode:" + cityCode);
		}
		if(null != provinceCode && !"".equals(provinceCode)){
			//过滤省份
			solrQuery.addFilterQuery("expandAreaCode:" + provinceCode);
		}
		if(null != operateCategory && !"".equals(operateCategory)){
			//过滤类别
			solrQuery.addFilterQuery("operateCategory:" + operateCategory);
		}
		//合作状态
		//solrQuery.addFilterQuery("cooperationStatus:cooperation");
		//是否已删除
		//solrQuery.addFilterQuery("isDelete:0");
		
		//起始记录
		solrQuery.setStart((pageNum-1) * pageSize);
		//每页大小
		solrQuery.setRows(pageSize);
		
		return query(collection, solrQuery, beanClass);
	}

	/**
	 * 
	 * @Description 根据唯一id删除对象
	 * @author huangqw
	 * @date 2015年8月23日 下午4:26:15 
	 * @param uniqueKeyId
	 */
	public void deleteForWeb(String uniqueKeyId){
//		delete(web, uniqueKeyId);
		delete(web,solrClient, uniqueKeyId);
	}
	
	
	/**
	 * 
	 * @Description 重点标记或者是取消重点标记
	 * @author huangqw
	 * @date 2015年8月23日 下午4:27:48 
	 * @param uniqueKeyId
	 * @param isImportant
	 */
	public void updateForIsImportantForWeb(String uniqueKeyId,int isImportant) {
//		updateForIsImportant(web, uniqueKeyId, isImportant);
		updateForIsImportant(web,solrClient, uniqueKeyId, isImportant);
	}
	
	
	
	/**
	 * @Description 方法描述说明
	 * @author liuy-8
	 * @date 2015年7月3日 下午3:02:20 
	 * @param searchKey 搜索关键词
	 * @param cityCode 城市code
	 * @param userId 用户id
	 * @param isImportant 是否重点标记：-1表示不过滤
	 * @param tabMark 哪个标签：-1表示不过滤
	 * @param pageNum 页数
	 * @param pageSize 每页大小
	 * @param beanClass 返回实体的class，用于bean转换
	 * @return 结果集，包括查询到的对象列表，查询到的数据总数量
	 */
	public Map<String, Object> caigouWebSearch(String searchKey, String cityCode, String userId, int isImportant, int tabMark, int pageNum, int pageSize, Class<?> beanClass){
		//查询对象
		SolrQuery solrQuery = new SolrQuery();
 		solrQuery.set("defType", "edismax");
		//查询字段
		solrQuery.set("pf", "mainCategories companyName contactPerson contactPhone brand prNames");
		//字段权重 1为本来权重
		solrQuery.set("qf", "mainCategories^5 companyName^5 contactPerson^5 contactPhone brand^5 prNames^1 ");
		//积分影响排序
		solrQuery.set("bf", "sum(product(isImportant,100000))");
		
		//搜索空字符串，默认搜索全部
		if (null == searchKey) {
			searchKey = "";
		}
		if("".equals(searchKey.trim())){
			searchKey = "*";
		}
		
		//设置搜索词
		solrQuery.setQuery("(" + searchKey + ")");
		solrQuery.addFilterQuery("userId:" + userId);
		solrQuery.addFilterQuery("isDelete:0");
		if(null != cityCode && !"".equals(cityCode)){
			//过滤城市
			solrQuery.addFilterQuery("cityCode:" + cityCode);
		}
		if (-1 != isImportant) {
			solrQuery.addFilterQuery("isImportant:" + isImportant);
		}
		if (-1 != tabMark) {
			solrQuery.addFilterQuery("tabMark:" + tabMark);
		}
		
		//起始记录
		solrQuery.setStart((pageNum-1) * pageSize);
		//每页大小
		solrQuery.setRows(pageSize);
		
		return query(web, solrQuery, beanClass);
	}
}

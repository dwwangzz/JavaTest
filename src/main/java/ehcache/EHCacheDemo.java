package ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.constructs.blocking.BlockingCache;

import java.io.IOException;


public class EHCacheDemo {

	public static void main(String[] args) throws IOException {
		
		CacheManager cacheManager = null;
		cacheManager = CacheManager.create();
		// 或者
		//cacheManager = CacheManager.getInstance();
		// 或者
		//cacheManager = CacheManager.create("src/main/resources/ehcache.xml");
		// 或者
		//cacheManager = CacheManager.create("http://localhost:8080/test/ehcache.xml");
		//cacheManager = CacheManager.newInstance("/config/ehcache.xml");
		// 或者
		/*InputStream fis = new FileInputStream(new File("src/ehcache/ehcache.xml").getAbsolutePath());  
		try {  
			cacheManager = CacheManager.create(fis);  
			System.out.println(manager);
		} finally {  
			fis.close();  
		}  */

		// 获取ehcache配置文件中的一个cache
		Cache sample = cacheManager.getCache("sample");
		// 获取页面缓存
		BlockingCache cache = new BlockingCache(cacheManager.getEhcache("SimplePageCachingFilter"));
		// 添加数据到缓存中
		Element element = new Element("key", "val");
		sample.put(element);
		// 获取缓存中的对象，注意添加到cache中对象要序列化 实现Serializable接口
		Element result = sample.get("key");
		// 删除缓存
		sample.remove("key");
		sample.removeAll();

		// 获取缓存管理器中的缓存配置名称
		for (String cacheName : cacheManager.getCacheNames()) {
			System.out.println(cacheName);
		}
		// 获取所有的缓存对象
		for (Object key : cache.getKeys()) {
			System.out.println(key);
		}

		// 得到缓存中的对象数
		cache.getSize();
		// 得到缓存对象占用内存的大小
		cache.getMemoryStoreSize();
		// 得到缓存读取的命中次数
		cache.getStatistics().getCacheHits();
		// 得到缓存读取的错失次数
		cache.getStatistics().getCacheMisses();
	}

}

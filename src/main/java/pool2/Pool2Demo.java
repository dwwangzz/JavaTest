package pool2;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;


public class Pool2Demo {

	public static void main(String[] args) throws Exception {
		
		
		GenericObjectPoolConfig config = new GenericObjectPoolConfig(); 
        config.setMaxTotal(500); //整个池最大值  
        config.setBlockWhenExhausted(true) ; 
        config.setMaxWaitMillis(-1); //获取不到永远等待  
        config.setNumTestsPerEvictionRun(Integer.MAX_VALUE); // always test all idle objects  
        config.setTestOnBorrow(true);  
        config.setTestOnReturn(false); 
        config.setTestWhileIdle(false); 
        config.setTimeBetweenEvictionRunsMillis(1 * 60000L); //-1不启动。默认1min一次  
        config.setMinEvictableIdleTimeMillis(10 * 60000L); //可发呆的时间,10mins  
        config.setTestWhileIdle(false);  //发呆过长移除的时候是否test一下先 
        
        BaseObjectPoolableFactory baseObjectPoolableFactory = new BaseObjectPoolableFactory();
        
        GenericObjectPool<BaseObject> pool = new GenericObjectPool<BaseObject>(baseObjectPoolableFactory, config);
        
        for(int i=0; i<100; i++){
        	BaseObject obj = pool.borrowObject();
        	if(i%3==0){
        		pool.returnObject(obj);
        	}
        	System.out.println(obj.toString());
        }
        
        
		System.out.println("success");
	}
	
}

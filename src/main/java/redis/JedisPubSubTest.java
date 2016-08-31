package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

class JedisPubSubTest {

	public static JedisPool pool;

	static {

		JedisPoolConfig jedispool_config = new JedisPoolConfig();
		jedispool_config.setMinIdle(0);
		jedispool_config.setMaxWaitMillis(1000);
		jedispool_config.setTestOnBorrow(true);
		
		pool = new JedisPool(jedispool_config, "172.16.231.230", 6379);
		System.out.println("pool init success!");

	}

	public static void main(String[] args) throws InterruptedException {
		Jedis redisClient1 = pool.getResource();
		Jedis redisClient2 = pool.getResource();
		MyListener listener = new MyListener();

		Publisher pub = new Publisher();
		pub.publish(redisClient2); // 发布一个频道

		Subscriber sub = new Subscriber();
		sub.psub(redisClient1, listener); // 订阅一个频道

	}
}

class Subscriber {

	public void psub(final Jedis redisClient, final MyListener listener) {

		new Thread(new Runnable() {
			@Override
			public void run() {

				System.out.println("订阅：news.share");
				// 订阅得到信息在lister的onMessage(...)方法中进行处理

				// 订阅多个频道
				// redisClient.subscribe(listener, "news.share", "news.log");

				// redisClient.subscribe(listener, new String[]{"news.share","news.log"});
				redisClient.psubscribe(listener, new String[] { "news.share" });// 使用模式匹配的方式设置频道
			}
		}).start();

	}

}

class Publisher {

	public void publish(final Jedis redisClient) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("发布：news.share");
				redisClient.publish("news.share", "ok");
				redisClient.publish("news.share", "hello word");
			}
		}).start();

	}

}
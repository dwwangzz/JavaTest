package redis;

import redis.clients.jedis.JedisPubSub;

public class MyListener extends JedisPubSub {
	// 取得订阅的消息后的处理
	public void onMessage(String channel, String message) {
		System.out.println("wangzz-->消息已经获得："+channel + "：" + message);
	}

	// 初始化订阅时候的处理
	public void onSubscribe(String channel, int subscribedChannels) {
		System.out.println("wangzz-->初始化订阅处理信息："+channel + "：" + subscribedChannels);
	}

	// 取消订阅时候的处理
	public void onUnsubscribe(String channel, int subscribedChannels) {
		System.out.println("wangzz-->取消订阅处理信息："+channel + "：" + subscribedChannels);
	}

	// 初始化按表达式的方式订阅时候的处理
	public void onPSubscribe(String pattern, int subscribedChannels) {
		System.out.println("wangzz-->初始化按表达式的方式订阅时候的处理信息："+pattern + "：" + subscribedChannels);
	}

	// 取消按表达式的方式订阅时候的处理
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
		System.out.println("wangzz-->取消按表达式的方式订阅时候的处理信息："+pattern + "：" + subscribedChannels);
	}

	// 取得按表达式的方式订阅的消息后的处理
	public void onPMessage(String pattern, String channel, String message) {
		System.out.println("wangzz-->取得按表达式的方式订阅的消息后的处理信息："+pattern + "，" + channel + "：" + message);
	}
}

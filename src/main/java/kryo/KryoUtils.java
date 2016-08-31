package kryo;

import SerializableDemo.SerializableUtil;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KryoUtils {

	//private static Logger LOGGER = LoggerFactory.getLogger(KryoUtils.class);

	private final static Kryo kryo = new Kryo();

	/**
	 * 对象序列化为字节数组
	 * @author wangzz-a
	 * @param obj
	 * @return
	 * @throws IOException
	 * @date 2015年12月24日 下午2:34:37
	 */
	public static byte[] serialize(Object obj) throws IOException {
		Output output = null;
		try {
//			ByteArrayOutputStream baos = new ByteArrayOutputStream();
//			output = new Output(baos);
			output = new Output(4096);
			kryo.writeClassAndObject(output, obj);
			output.flush();
			byte[] s =  output.getBuffer();
			return s;
		} finally {
			if (output != null)
				output.close();
		}
	}

	/**
	 * 数组反序列化为Object对象
	 * @author wangzz-a
	 * @param bits
	 * @return
	 * @throws IOException
	 * @date 2015年12月24日 下午2:35:15
	 */
	public static Object deserialize(byte[] bits) throws IOException {
		if (bits == null || bits.length == 0)
			return null;
		Input ois = null;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(bits);
			ois = new Input(bais);
			return kryo.readClassAndObject(ois);
		} finally {
			if (ois != null)
				ois.close();
		}
	}

	/*private static ThreadLocal<Kryo> kryoLocal = new ThreadLocal<Kryo>() {
		@Override
		protected Kryo initialValue() {
			Kryo kryo = new Kryo();
			kryo.addDefaultSerializer(OffsetDateTime.class, KryoOffsetDateTimeSerializer.class);
			return kryo;
		}
	};

	@SuppressWarnings(value = "unchecked")
    public static <T> T deepClone(T t) {
        Kryo kryo = kryoLocal.get();
        try (Output output = new Output(new ByteArrayOutputStream())) {
            kryo.writeObject(output, t);
            try (Input input = new Input(output.getBuffer())) {
                return kryo.readObject(input, (Class<T>) t.getClass());
            }
        } catch (Exception e) {
            LOGGER.error("深度克隆失败", e);
        }
        return null;
    }
	
	private static ThreadLocal<Kryo> kryoLocal = new ThreadLocal<Kryo>() {
		@Override
		protected Kryo initialValue() {
			Kryo kryo = new Kryo();
			kryo.addDefaultSerializer(OffsetDateTime.class, KryoOffsetDateTimeSerializer.class);
			return kryo;
		}
	};

    public static <T> T deepClone(T t) {
        Kryo kryo = kryoLocal.get();
        try (Output output = new Output(new ByteArrayOutputStream())) {
            kryo.writeObject(output, t);
            try (Input input = new Input(output.getBuffer())) {
                return kryo.readObject(input, (Class<T>) t.getClass());
            }
        } catch (Exception e) {
            LOGGER.error("深度克隆失败", e);
        }
        return null;
    }*/

	public static void main(String[] args) throws Exception {
		Classes classes = new Classes();
		classes.setCno(1);
		classes.setName("一班");
		List<User> users = new ArrayList<User>();
		for (int i = 1; i < 100; i++) {
			User user = new User();
			user.setId(i);
			user.setAge(18+i);
			user.setName("小明"+i);
			user.setSex("男"+i);
			users.add(user);
		}
		classes.setUsers(users);
		
		serialize(classes);
		SerializableUtil.encodeObject(classes);
		
		long c1 = System.currentTimeMillis();
		serialize(classes);
		System.out.println("kryo 序列化时间:"+(System.currentTimeMillis()-c1)+" ms");
		long c2 = System.currentTimeMillis();
		SerializableUtil.encodeObject(classes);
		System.out.println("java 序列化时间:"+(System.currentTimeMillis()-c2)+" ms");
		
		User user = new User();
		user.setId(1);
		user.setAge(18);
		user.setName("小明");
		user.setSex("男");
		users.add(user);
		byte[] bites = serialize(user);
		User user2 = (User) deserialize(bites);
		System.out.println(user2.toString());

		
		
		
		//Arrays.asList返回的是接口类型，所以不能序列化
//		List<String> obj = Arrays.asList("OSChina.NET", "Team@OSC", "Git@OSC", "Sonar@OSC");
//		byte[] bits = serialize(obj);
//		for (byte b : bits) {
//			System.out.print(Byte.toString(b) + " ");
//		}
//		System.out.println();
//		System.out.println(bits.length);
//		System.out.println(deserialize(bits));
//
//		List<String> list = Arrays.asList("");
//
//		List<String> stringList = new ArrayList<String>();
//
//		System.out.println((list instanceof ArrayList) ? "list is ArrayList" : "list not ArrayList?");
//
//		System.out.println((stringList instanceof ArrayList) ? "list is ArrayList" : "list not ArrayList?");
		
	}

}

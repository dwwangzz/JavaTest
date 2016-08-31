package kryo;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.minlog.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class KryoDemo {

	public static void main(String[] args) throws Exception {
		
		Log.TRACE();
		
		Kryo kryo = new Kryo();
		
		
		
		File file = new File("D:/1.bin");
		Output output = new Output(new FileOutputStream(file));
		User user = new User();
		user.setId(1);
		user.setAge(18);
		user.setName("小明");
		user.setSex("男");
		kryo.writeObject(output, user);
		output.close();
		
		
		Input input = new Input(new FileInputStream(file));
		User userObject = kryo.readObject(input, User.class);
		//Object userObject2 = kryo.readClassAndObject(input);
		input.close();
		System.out.println(userObject.toString());
		System.out.println("=========================");
		//System.out.println(userObject2.toString());
		
	}

}

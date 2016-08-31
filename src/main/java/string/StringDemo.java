package string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * �й��ַ�������ϰ
 * ����������ݵĴ洢�ʹ��䶼���Զ����Ƶ���ʽ�� ��
 * ���룺���ַ�ת���ֽ� 
 * ���룺���ֽڰ���һ���ı����ʽ��װ���ַ� 
 * @author wangzz
 *
 */
public class StringDemo 
{
	public static void main(String[] args) throws Exception {
		/*//String str = "[s f,s	d  s  f]";
		String str = "sf,s	d  s  f";
		str = str.replaceAll("\\[|\\]|\\s","");
		//str = str.substring(1, str.length()-1);
		System.out.println("Str="+str);*/
		
		
		//String str = "�й�";//��ǰ���ַ�Ĭ�ϱ�����UTF-8
		String str = "中国";
		
		//��  str ת���ֽ���  ��ǰĬ�ϲ����utf-8�����
		byte[] bytes = str.getBytes();
		
		//��ǰĬ�ϱ���(utf-8)���ֽ���������װ���ַ�
		String result1 = new String(bytes);
		
		//ʹ�ô������gbk����
		String result2 = new String(bytes,"gbk");
		
		//ʹ�ô������utf-8����
		String result3 = new String(bytes,"utf-8");
		
		//ʹ�ô������iso-8859-1����
		String result4 = new String(bytes,"iso-8859-1");
		
		System.out.println(result1+"===="+result2+"===="+result3+"===="+result4);
		
		
		
		
		
	}
	/**
	 * @author wangzz
	 * ���������ʽ
	 */
	@Test
	public void test1() throws UnsupportedEncodingException
	{
		String str = "�й�";//��ǰ���ַ�Ĭ�ϱ�����UTF-8
		
		//��  str ת���ֽ���  ��ǰĬ�ϲ����utf-8�����
		byte[] bytes = str.getBytes();
		
		
		//��ǰĬ�ϱ���(utf-8)���ֽ���������װ���ַ�
		String result1 = new String(bytes);
		
		//ʹ�ô������gbk����
		String result2 = new String(bytes,"gbk");
		
		//ʹ�ô������iso-8859-1����
		String result3 = new String(bytes,"iso-8859-1");
		//ʹ���������֮�� ��ô�����  
		//1.���½���iso-8859-1�������ַ�iso-8859-1�����ת���ֽ��� 
		byte[] bytes2 = result3.getBytes("iso-8859-1");
		//2.��������ȷ���(utf-8)���±���
		String newResult3 = new String(bytes2,"utf-8");
		
		System.out.println(result1+"==="+result2+"==="+result3+"==="+newResult3);
	}
	/**
	 * �������ν��
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void test2() throws UnsupportedEncodingException{
		/*
		 * ��ȷ���� -28,-72,-83,-27,-101,-67     �й� (utf-8)
		 * �����  -42,-48,-71,-6  �й�  (gbk)
		 * �����  63,63   ?? (iso-8859-1)�������û�����ģ�����ʶ���ʱ��͸�һ��ͨ�õı���63��Ҳ���� ?
		 * �����������Ľ��б����ʱ�����������iso-8859-1��,��˵���ֽ����Ѿ�����˴���ģ���������ȷ������ 
		 */
		
		String str = "�й�";
		
		//�ô��˱����(gbk)
		byte[] bytes = str.getBytes("gbk");
		printArr(bytes);
		//�����ʱ��Ĭ��ʹ�õ���gbk
		str = new String(bytes,"gbk");
		System.out.println("str="+str);
		
		//�ô��˱����(iso-8859-1)
		byte[] bytes2 = str.getBytes("iso-8859-1");
		printArr(bytes2);
		//�����ʱ��Ĭ��ʹ�õ���iso-8859-1
		String str2 = new String(bytes,"iso-8859-1");
		System.out.println("str2="+str2);
		
	}
	
	//��ӡbyte[]����
	public void printArr(byte[] bytes){
		System.out.print("[");
		for(byte b:bytes){
			System.out.print(b+",");
		}
		System.out.print("]");
	}
}

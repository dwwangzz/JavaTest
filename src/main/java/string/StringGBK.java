package string;



/**
 * ���ı��ļ��ı����ʽ��GBK
 * @author wangzz-a
 * @version $Id: StringGBK.java, v 0.1 2015��11��10�� ����4:51:14 wangzz-a Exp $
 */
public class StringGBK {

	public static void main(String[] args) throws Exception {
		
		String str = "�й�";
		
		byte[] b = str.getBytes();
		printArr(b);
		
		//utf-8�ġ��й������ֽ��룺[-28, -72, -83, -27, -101, -67]
		//GBK�ġ��й������ֽ��룺[-42, -48, -71, -6]
		
		byte[] z = {-42,-48};
		System.out.println(new String(z,"gbk"));
		
		byte[] z2 = {-28, -72, -83};
		System.out.println(new String(z2,"utf-8"));
		
		
		System.out.println("++++++++++++++++++++++++++");
		test();
		System.out.println("++++++++++++++++++++++++++");
		
	}
	
	/**
	 * ���������� by����
	 * 
	 * 1.���ı�(��java�ļ�)��GBK�����ʽ�ġ�
	 * 2.���������ֱ����ʽ������"�й�"����ַ�����ֻҪ���ձ������������ʽ�ٽ��룬�Ͳ����������
	 * �磺str.getBytes("gbk"); //[-42, -48, -71, -6]
	 * 	 str.getBytes("utf-8"); //[-28, -72, -83, -27, -101, -67]
	 * 	 str.getBytes("iso8859-1");//[63, 63]
	 * �������ǿ�������ӣ�
	 * 	"�й�"����ַ�����gbk����Ϊ[-42, -48, -71, -6]
	 * 	"�й�"����ַ�����utf-8����Ϊ[-28, -72, -83, -27, -101, -67]
	 * 	"�й�"����ַ�����iso8859-1����Ϊ[63, 63] --> ??
	 * 	
	 * */
	public static void test() throws Exception{
		
		String str = "�й�";
		
		//��ȡ�й���GBK�������ֽ���
		//byte[] bb = {-42, -48, -71, -6};
		byte[] bb = str.getBytes("gbk");
		
		//ʹ��iso8859-1���½��� //��������--> ???��
		str = new String(bb,"iso8859-1");
		System.out.println(str);//???��
		
		//�������ǻ�ȡ�������iso8859-1���ֽ���  
		//���֣���һ��str.getBytes("iso8859-1")���Ի�ȡ����ȷ��GBK����
		//	      �ڶ���"???��".getBytes("iso8859-1")��ȡ�����Ǵ���GBK�ı���
		printArr(str.getBytes("iso8859-1"));
		printArr("???��".getBytes("iso8859-1"));
		
		str = new String(str.getBytes("iso8859-1"),"gbk");
		System.out.println(str);
		
		//��ӡ"�й�"gbk������ֽ���
		//printArr(str.getBytes("gbk"));//[-42, -48, -71, -6]
	}
	
	public static void printArr(byte[] bytes){

		if(bytes==null||bytes.length==0)
			return ;
		System.out.print("[");
		for (int i = 0; i < bytes.length; i++) {
			if(i+1==bytes.length){
				System.out.print(bytes[i]);
			}else{
				System.out.print(bytes[i]+", ");
			}
		}
		System.out.println("]");
	}
}

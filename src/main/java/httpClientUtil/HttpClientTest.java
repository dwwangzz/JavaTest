package httpClientUtil;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientTest {

    public static void main(String args[]) {
        //创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //HttpClient_wangzz
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        //String url = "https://rate.taobao.com/user-rate-UvCxGOmHuOF8u.htm";
        String url = "http://125.64.210.190:8080/znitPlatform/TaskPerson/infos?dealingId=856A57346256945CA5863321461A3F0A&&taskId=02b366d4f6fc46cba11064bdf7cb05eb&&idcards=512534197407295029,370102198003130037,511528199209051817,511321199310236458,532101199102104619,511523198502010612,511528199301151853,511528198701010414";
        HttpGet httpGet = new HttpGet(url);
        System.out.println(httpGet.getRequestLine());
        try {
            //执行get请求  
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            //获取响应消息实体  
            HttpEntity entity = httpResponse.getEntity();
            //响应状态  
            System.out.println("status:" + httpResponse.getStatusLine());
            //判断响应实体是否为空  
            if (entity != null) {
                System.out.println("contentEncoding:" + entity.getContentEncoding());
                String htmlContent = EntityUtils.toString(entity);
                //htmlContent = new String(htmlContent.getBytes("utf-8"),"gbk");
                System.out.println("response content: \r\n" + htmlContent);
                //File file = new File("D:\\韩都衣舍.html");
                // 创建一个FileWriter对象，该对象一被初始化，必须要明确被错左的文件
                //FileWriter fw = new FileWriter(file);
                //fw.write(htmlContent);
                //fw.flush();
                //fw.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭流并释放资源
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

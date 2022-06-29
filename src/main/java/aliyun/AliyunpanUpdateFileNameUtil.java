/*
package aliyun;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sai.util.FileUtil;
import com.sai.util.Mapz;
import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * 阿里云盘修改文件名 此代码需再sai项目中运行
 * @author: wangzz
 * @date: 2022年05月06日 19:58
 *//*

public class AliyunpanUpdateFileNameUtil {

    public static ObjectMapper mapper = JsonUtil.getMapper();

    public static String buildName(String fileName) {
        return "乡村爱情.S14E" + fileName;
        //return fileName.replace("13 (2021)", "").replace(" -4K.60FPS", ".4K.60FPS");
    }

    @SneakyThrows
    public static void main(String[] args) {
        String json = FileUtil.readFile("D:\\json.txt");
        // 只处理带这个关键词的
        String keyword = "";
        Mapz map = mapper.readValue(json, Mapz.class);
        List<Map> items = (List<Map>) map.get("items");
        for (Map item : items) {
            // 抽取参数
            String drive_id = (String) item.get("drive_id");
            String file_id = (String) item.get("file_id");
            String name = (String) item.get("name");
            String file_extension = (String) item.get("file_extension");

            if (name.indexOf(keyword) < 0) {
                continue;
            }
            // 构建参数
            Map param = new HashMap(4);
            param.put("drive_id", drive_id);
            param.put("file_id", file_id);
            param.put("check_name_mode", "refuse");
            param.put("name", buildName(name));
            //System.out.println(drive_id + "," + file_id + "," + name + "," + file_extension);
            System.out.println(param.get("name"));
            //if (true) continue;

            Map headers = new HashMap(4);
            String token = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOiI0YWM0MTFmNmY2MzY0OGM2OWY4NTQ2NjNhYjJlZDc5OCIsImN1c3RvbUpzb24iOiJ7XCJjbGllbnRJZFwiOlwiMjVkelgzdmJZcWt0Vnh5WFwiLFwiZG9tYWluSWRcIjpcImJqMjlcIixcInNjb3BlXCI6W1wiRFJJVkUuQUxMXCIsXCJTSEFSRS5BTExcIixcIkZJTEUuQUxMXCIsXCJVU0VSLkFMTFwiLFwiVklFVy5BTExcIixcIlNUT1JBR0UuQUxMXCIsXCJTVE9SQUdFRklMRS5MSVNUXCIsXCJCQVRDSFwiLFwiT0FVVEguQUxMXCIsXCJJTUFHRS5BTExcIixcIklOVklURS5BTExcIixcIkFDQ09VTlQuQUxMXCIsXCJTWU5DTUFQUElORy5MSVNUXCJdLFwicm9sZVwiOlwidXNlclwiLFwicmVmXCI6XCJodHRwczovL3d3dy5hbGl5dW5kcml2ZS5jb20vXCIsXCJkZXZpY2VfaWRcIjpcImEyMWM5MmRmMTRlZDQ2ZmQ5Mjk2NWQ4YzQ3NzljZThmXCJ9IiwiZXhwIjoxNjUxODQzMTkwLCJpYXQiOjE2NTE4MzU5MzB9.ZyxECbKiFXTcOWcOYCtHXFDTfKbba1XrTv8uYv7KJEhUHmMlT5uaWkla0PYq0Raz1-zvhcpDJZ_XnPxQ2f7FZM0dQZca69ybuLOBuNkojAG4sgjT9G9Qb1cg5qo8OmNepPpEMNFldLceLMXOpKpb4w-qZ8XKMxKiGuutgElxEwA";
            headers.put("Authorization", "Bearer " + token);
            headers.put("Content-Type", "application/json");

            OkHttpClient okHttpClient = new OkHttpClient();
            //OkHttpClient okHttpClient = buildOKHttpClient().build();
            Request request = new Request.Builder()
                    .addHeader("content-type", "application/json")
                    .addHeader("authorization", "Bearer " + token)
                    .url("https://api.aliyundrive.com/v3/file/update")
                    .post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), mapper.writeValueAsString(param)))
                    .build();
            try {
                String result = okHttpClient.newCall(request).execute().body().string();
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //HttpUtil.post()
    }

    public static OkHttpClient.Builder buildOKHttpClient() {
        try {
            TrustManager[] trustAllCerts = buildTrustManagers();
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());

            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier((hostname, session) -> true);
            return builder;
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
            return new OkHttpClient.Builder();
        }
    }

    private static TrustManager[] buildTrustManagers() {
        return new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new java.security.cert.X509Certificate[]{};
                    }
                }
        };
    }
}
*/

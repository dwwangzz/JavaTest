package httpClientUtil;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import utils.EmptyUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 
 * @Description Http 请求工具类
 * @author (作者) youps-a
 * @date (开发日期) 2015年11月26日 上午9:55:38
 * @company (开发公司) 广联达软件股份有限公司
 * @copyright (版权) 本文件归广联达软件股份有限公司所有
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) 1.7
 * @modify (修改) 第N次修改：时间、修改人;修改说明
 * @Review (审核人) 审核人名称
 */
public class HttpUtil {
    
    /**私有化构造函数*/
    private HttpUtil(){
        
    }
    
    /** 连接超时时间*/
    private static final int TIMEOUT = 6000;
    
    /** 字符编码*/
    private static final String UTF_8 = "UTF-8";
    
        
    /**
     * 
     * @Description http get 请求
     * @author youps-a
     * @date 2015年11月26日 上午11:40:37
     * @param url       请求地址url
     * @return HttpResponseInfo         请求返回信息实体，包含请求状态、结果、结果原因短语
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static HttpResponseInfo HttpDoGet(String url) throws ClientProtocolException, IOException{
        HttpGet httpGet = new HttpGet(url);
        return HttpDoGet(httpGet);
    }
    
    /**
     * 
     * @Description http get 请求
     * @author youps-a
     * @date 2015年11月26日 上午11:41:42
     * @param uri           请求地址uri
     * @param paramsMap     请求参数map
     * @return HttpResponseInfo         请求返回信息实体，包含请求状态、结果、结果原因短语
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static HttpResponseInfo HttpDoGet(String uri,Map<String, String> paramsMap) throws ClientProtocolException, IOException{
        
        return HttpDoGet(uri, paramsMap, null);
    }
    
    /**
     * 
     * @Description http get 请求
     * @author youps-a
     * @date 2015年11月26日 下午2:06:11
     * @param uri           请求地址uri
     * @param headersMap     头信息
     * @param paramsMap     请求参数map
     * @return HttpResponseInfo         请求返回信息实体，包含请求状态、结果、结果原因短语
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static HttpResponseInfo HttpDoGet(String uri,Map<String, String> paramsMap,Map<String, String> headersMap) throws ClientProtocolException, IOException{
        String params = null;
        //组装参数
        if (null != paramsMap && !paramsMap.isEmpty()) {
            List<BasicNameValuePair> paramsList = new ArrayList<BasicNameValuePair>();
            for (Entry<String, String> entry : paramsMap.entrySet()) {
                paramsList.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
            params = URLEncodedUtils.format(paramsList, UTF_8);
        }
        if (StringUtils.isNotBlank(params)) {
            uri += "?" + params;
        }
        
        HttpGet httpGet = new HttpGet(uri);
        //设置头信息
        if (EmptyUtil.isNotEmpty(headersMap)) {
            for (Entry<String, String> entry : headersMap.entrySet()) {
                if (null != entry.getKey()) {
                    httpGet.setHeader(entry.getKey(), entry.getValue());
                }
            }
        }
        return HttpDoGet(httpGet);
    }

    /**
     *
     * @Description 执行get请求
     * @author youps-a
     * @date 2015年12月7日 下午3:04:54
     * @param httpGet
     * @return          请求返回信息实体，包含请求状态、结果、结果原因短语
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static HttpResponseInfo HttpDoGet(HttpGet httpGet) throws ClientProtocolException,IOException{
        HttpResponseInfo info = null;
        BufferedReader br = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 设置请求超时时间
        httpGet.setConfig(RequestConfig.custom().setConnectionRequestTimeout(TIMEOUT).setConnectTimeout(TIMEOUT).build());
        try {
            //执行请求，组装返回实体数据
            HttpResponse httpResponse = httpclient.execute(httpGet);
            info = new HttpResponseInfo();
            info.setStatusCode(httpResponse.getStatusLine().getStatusCode());
            info.setReasonPhrase(httpResponse.getStatusLine().getReasonPhrase());
            if (null != httpResponse.getEntity().getContent()) {
                String str = null;
                StringBuilder sb = new StringBuilder();
                br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), UTF_8));
                while ((str = br.readLine()) != null) {
                    sb.append(str.trim());
                }
                info.setContent(sb.toString());
            }
        } finally {
            IOUtils.closeQuietly(br);
            httpclient.close();
        }
        return info;
    }

    public static HttpResponseInfo HttpDoPost(String url) throws ClientProtocolException, IOException{
        return HttpDoPost(url, null, null);
    }

    /**
     *
     * @Description http post 请求
     * @author youps-a
     * @date 2015年11月26日 下午2:56:22
     * @param url       请求地址
     * @param paramsMap 请求参数
     * @return  HttpResponseInfo        请求返回信息实体，包含请求状态、结果、结果原因短语
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static HttpResponseInfo HttpDoPost(String url, Map<String, ? extends Object> paramsMap) throws ClientProtocolException, IOException {
        return HttpDoPost(url, paramsMap, null);
    }

    /**
     *
     * @Description http post 请求
     * @author youps-a
     * @date 2015年11月26日 下午2:57:00
     * @param url           请求地址
     * @param paramsMap     请求参数
     * @param headersMap     头信息
     * @return HttpResponseInfo         请求返回信息实体，包含请求状态、结果、结果原因短语
     * @throws ClientProtocolException
     * @throws IOException
     */
    @SuppressWarnings("deprecation")
    public static HttpResponseInfo HttpDoPost(String url, Map<String, ? extends Object> paramsMap,Map<String, String> headersMap) throws ClientProtocolException, IOException {
        HttpPost httpPost = new HttpPost(url);
        //设置头信息
        if (EmptyUtil.isNotEmpty(headersMap)) {
            for (Entry<String, String> entry : headersMap.entrySet()) {
                if (null != entry.getKey()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue());
                }
            }
        }
        
        //组装post 参数
        //用于String 类型参数封装
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        //用于文件类型参数封装
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create().setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        if (paramsMap != null && !paramsMap.isEmpty()) {
            int multSize = 0;
            for (Entry<String, ? extends Object> entry : paramsMap.entrySet()) {
                if (entry.getValue() instanceof File) {
                    multipartEntityBuilder.addBinaryBody(entry.getKey(), (File) entry.getValue());
                    multSize++;
                } else {
                    multipartEntityBuilder.addTextBody(entry.getKey(), entry.getValue().toString(), ContentType.create("text/plain", UTF_8));
                    params.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
                }
            }
            // 校验如果有文件数据则使用 multipartEntityBuilder，如果没有使用UrlEncoded，
            // 如使用 multipartEntityBuilder 方式拦截器内无法获取相应参数值
            if (0 < multSize) {
                httpPost.setEntity(multipartEntityBuilder.setCharset(Consts.UTF_8).build());
                params = null;
            }else {
                httpPost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));
                multipartEntityBuilder = null;
            }
        }
        
        return HttpDoPost(httpPost);
    }
    
    /**
     * 
     * @Description http post 请求
     * @author youps-a
     * @date 2015年11月26日 下午2:57:44
     * @param httpPost      HttpPost对象
     * @return HttpResponseInfo         请求返回信息实体，包含请求状态、结果、结果原因短语
     * @throws ClientProtocolException
     * @throws IOException
     */
    public static HttpResponseInfo HttpDoPost(HttpPost httpPost) throws ClientProtocolException, IOException {
        HttpResponseInfo info = null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        BufferedReader br = null;
        
        // 设置请求超时时间
        httpPost.setConfig(RequestConfig.custom().setConnectionRequestTimeout(TIMEOUT).setConnectTimeout(TIMEOUT).build());
        try {
            //执行请求，组装返回实体数据
            HttpResponse httpResponse = httpclient.execute(httpPost);
            info = new HttpResponseInfo();
            info.setStatusCode(httpResponse.getStatusLine().getStatusCode());
            info.setReasonPhrase(httpResponse.getStatusLine().getReasonPhrase());
            if (null != httpResponse.getEntity().getContent()) {
                String str = null;
                StringBuilder sb = new StringBuilder();
                br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(), UTF_8));
                while ((str = br.readLine()) != null) {
                    sb.append(str.trim());
                }
                info.setContent(sb.toString());
            }
            
        } finally{
            IOUtils.closeQuietly(br);
            httpclient.close();
        }
        return info;
    }
    
    
    public static void main(String[] args) {
        try {
            String url = "http://202.107.207.164:7480/purOrder/list";
            Map<String, String> paramMap = new HashMap<String, String>();
            paramMap.put("userName", "123456");
            paramMap.put("verifyInfo", "cabb9e436314f2a67951626785835a86");
            Map<String, String> headMap = new HashMap<String, String>();
            headMap.put("content-type","application/json");
            HttpResponseInfo info = HttpDoPost("http://172.16.231.51:9090/postTestFile", paramMap, headMap);
            System.out.println(info.getContent());
            System.out.println(info.getStatusCode());
            System.out.println(info.getReasonPhrase());
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }

}

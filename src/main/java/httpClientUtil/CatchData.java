package httpClientUtil;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzz on 2016/8/10.
 */
public class CatchData {

    /**
     * 连接超时时间
     */
    private static final int TIMEOUT = 60000;

    /**
     * 字符编码
     */
    private static final String UTF_8 = "UTF-8";
    private static final String GBK = "gbk";

    private static String url = "https://tosp.taobao.com/json/refundIndex.htm?shopId=73217422&businessType=0&_ksTS=1471224526233_129&callback=jsonp130";

    public static void main(String[] args) throws IOException, SAXException {
        //jsoup();
        httpGetMethod();
        //httpunit();
    }

    public static void httpunit() throws IOException, SAXException {
        /** HtmlUnit请求web页面 */
        System.out.println("直接获取网页内容：");
        // 建立一个WebConversqation实例
        WebConversation wc = new WebConversation();
        //设置是否解析js
        HttpUnitOptions.setScriptingEnabled(true);
        HttpUnitOptions.setExceptionsThrownOnScriptError(false);

        // 向指定的URL发出请求，获取响应
        //WebResponse demo = wc.getResponse("http://www.meterware.com");
        //System.out.println(demo.getText());
        WebResponse wr = wc.getResponse("https://rate.taobao.com/user-rate-UvFNyvCgyvCQuvgTT.htm");
        String[] cookieNames = wc.getCookieNames();
        //WebResponse wr = wc.getResponse("http://www.baidu.com.cn");
        // 用getText方法获取相应的全部内容
        // 用System.out.println将获取的内容打印在控制台上
        System.out.println(wr.getText());
    }

    public static void httpGetMethod() throws IOException {

        HttpResponseInfo info = null;
        //创建client的几种方式
        //CloseableHttpClient httpclient = HttpClients.createDefault();
        //此方法可以用来获取cookie
        BasicCookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();


        String sulvUrl = "https://sulv.tmall.com/?spm=a1z0b.7.1997427721.d4918089.58wFnM";
        HttpGet sulvGet = new HttpGet(sulvUrl);
        HttpResponse sulvRes = httpclient.execute(sulvGet);
        String sulvContent = null;
        BufferedReader br0 = null;
        if (null != sulvRes.getEntity().getContent()) {
            String str = null;
            StringBuilder sb = new StringBuilder();
            br0 = new BufferedReader(new InputStreamReader(sulvRes.getEntity().getContent(), GBK));
            while ((str = br0.readLine()) != null) {
                sb.append(str.trim());
            }
            sulvContent = sb.toString();
        }


        //1.请求主页面，获取uc1,v,cookie2,t几个cookie
        String rateUrl = "https://rate.taobao.com/user-rate-UvFNyvCgyvCQuvgTT.htm";
        HttpGet rateGet = new HttpGet(rateUrl);
        // 设置请求超时时间
        rateGet.setConfig(RequestConfig.custom().setConnectionRequestTimeout(TIMEOUT).setConnectTimeout(TIMEOUT).build());
        BufferedReader br = null;
        //执行请求，组装返回实体数据
        HttpResponse rateRes = httpclient.execute(rateGet);
        int rateStatus = rateRes.getStatusLine().getStatusCode();
        String ratePhrase = rateRes.getStatusLine().getReasonPhrase();
        String rateContent = null;
        if (null != rateRes.getEntity().getContent()) {
            String str = null;
            StringBuilder sb = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(rateRes.getEntity().getContent(), GBK));
            while ((str = br.readLine()) != null) {
                sb.append(str.trim());
            }
            rateContent = sb.toString();
        }
        //System.out.println(rateContent);
        List<Cookie> rateCookies = cookieStore.getCookies();

        //2.请求eg.js，获取cookie:cna
        String egUrl = "https://log.mmstat.com/eg.js";
        HttpGet egGet = new HttpGet(egUrl);
        HttpResponse egRes = httpclient.execute(egGet);
        List<Cookie> egCookies = cookieStore.getCookies();

        // 新建一个Cookie:l
        BasicClientCookie lCookie = new BasicClientCookie("l", "Aqys-ujy313m35s87om/9jqF/IDeZVAP");
        //BasicClientCookie lCookie = new BasicClientCookie("l", "Al1dawc16puy4eqv14beVtK27TNXYpHM");
        lCookie.setVersion(1);
        lCookie.setDomain(".taobao.com");
        lCookie.setPath("/");
        //lCookie.setExpiryDate(new Date(2030,02,01,00,00,00));
        cookieStore.addCookie(lCookie);
        // 新建一个Cookie:isg
        BasicClientCookie isgCookie = new BasicClientCookie("isg", "AlRUA84z_7b6RWv6DqEd5ZrOJZLn73iXta5Uj-414F9i2fQjFr1IJwpar2Y6");
        //BasicClientCookie isgCookie = new BasicClientCookie("isg", "Ai0t-E6eBj7aX-LSXvM-j2lhPMk1YGFc5MGdZG8ycUQz5k2YNtpxLHu-pg37");
        isgCookie.setVersion(1);
        isgCookie.setDomain(".taobao.com");
        isgCookie.setPath("/");
        //lCookie.setExpiryDate(new Date(2017, 02, 11, 03, 07, 54));
        cookieStore.addCookie(isgCookie);

        //3.请求login-api.php，获取cookie:thw
        String loginUrl = "https://www.taobao.com/go/app/tmall/login-api.php";
        HttpGet loginGet = new HttpGet(loginUrl);
        HttpResponse loginRes = httpclient.execute(loginGet);
        List<Cookie> loginCookies = cookieStore.getCookies();


        //4.请求获取json
        String jsonUrl = "https://tosp.taobao.com/json/refundIndex" +
                ".htm?shopId=73217422&businessType=0&_ksTS=1471230473981_129&callback=jsonp130";
        HttpGet jsonGet = new HttpGet(jsonUrl);
        HttpResponse jsonRes = httpclient.execute(jsonGet);
        String jsonContent = null;
        if (null != jsonRes.getEntity().getContent()) {
            String str = null;
            StringBuilder sb = new StringBuilder();
            br = new BufferedReader(new InputStreamReader(jsonRes.getEntity().getContent(), UTF_8));
            while ((str = br.readLine()) != null) {
                sb.append(str.trim());
            }
            jsonContent = sb.toString();
        }
        System.out.println(jsonContent);
        /*ResponseHandler<HashMap> rh = new ResponseHandler<HashMap>() {
            @Override
            public HashMap handleResponse(
                    final HttpResponse response) throws IOException {
                StatusLine statusLine = response.getStatusLine();
                HttpEntity entity = response.getEntity();
                if (statusLine.getStatusCode() >= 300) {
                    throw new HttpResponseException(
                            statusLine.getStatusCode(),
                            statusLine.getReasonPhrase());
                }
                if (entity == null) {
                    throw new ClientProtocolException("Response contains no content");
                }
                Gson gson = new GsonBuilder().create();
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                Reader reader = new InputStreamReader(entity.getContent(), charset);
                return gson.fromJson(reader, HashMap.class);
            }
        };
        HashMap jsonMap = httpclient.execute(jsonGet, rh);
        System.out.println(jsonMap);*/


    }

    public static void jsoup() throws IOException {

        Map<String, String> cookies = null;

        //1.请求主页面，获取uc1,v,cookie2,t几个cookie
        String rateUrl = "https://rate.taobao.com/user-rate-UvFNyvCgyvCQuvgTT.htm";
        Connection.Response rateRes = Jsoup.connect(rateUrl)
                .timeout(30000)
                .execute();
        //Map<String, String> headers = rateRes.headers();
        cookies = rateRes.cookies();
        System.out.println(rateRes.body());
        String body = Jsoup.connect(rateUrl).cookies(cookies).execute().body();
        System.out.println(body);
        //2.请求eg.js，获取cookie:cna
        String egUrl = "https://log.mmstat.com/eg.js";
        Connection.Response egRes = Jsoup.connect(egUrl)
                .timeout(30000)
                .execute();
        Map<String, String> egCookies = egRes.cookies();
        cookies.putAll(egCookies);

        //3.请求login-api.php，获取cookie:thw
        String loginUrl = "https://www.taobao.com/go/app/tmall/login-api.php";
        Connection.Response loginRes = Jsoup.connect(loginUrl)
                .cookies(cookies)
                .timeout(30000)
                .execute();
        Map<String, String> loginCookies = loginRes.cookies();
        cookies.putAll(loginCookies);

        //cookies =  new HashMap<String, String>();
        //cookies.put("t","67993aa5fb390a3bb82286b70eb5695a");
        //cookies.put("cna","Qwk4ED03i2oCAXyAytquTKj5");
        //cookies.put("thw","cn");
        //cookies.put("l","AuXl1qcNqXvMHMCk2cXGfYDuda8fIpm0");
        //cookies.put("isg","Anx8i8ONB75JSTNiHdgg8pGOTRq8nyCfD4W63Fb9iGdKIRyrfoXwL_LZd9Sx");
        //cookies.put("v","0");
        //cookies.put("cookie2","1ca5cdfe37b330a5a0fe6f1febdfcf04");
        //cookies.put("_tb_token_","e3d784d33e3e3");
        Connection.Response execute = Jsoup.connect(url)
                //.header(":authority", "tosp.taobao.com")
                //.header(":method", "GET")
                //.header(":path", "/json/refundIndex.htm?shopId=73217422&businessType=0&_ksTS=1471224526233_129&callback=jsonp130")
                //.header(":scheme", "https")
                //.header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8")
                //.header("accept-encoding", "gzip, deflate, sdch, br")
                //.header("accept-language", "zh-CN,zh;q=0.8")
                //.header("cache-control", "max-age=0")
                //.header("upgrade-insecure-requests", "1")
                //.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; " +
                //        "Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36")
                //.header("cookies", cookies.toString().replaceAll("[\\{\\}]", ""))
                .cookies(cookies)
                .timeout(30000)
                .execute();
        System.out.println(execute.body());
    }

}

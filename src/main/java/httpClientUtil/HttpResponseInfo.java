package httpClientUtil;

import java.io.Serializable;

/**
 * 
 * @Description http 请求返回结果封装
 * @author (作者) youps-a
 * @date (开发日期) 2015年11月26日 下午1:47:27
 * @company (开发公司) 广联达软件股份有限公司
 * @copyright (版权) 本文件归广联达软件股份有限公司所有
 * @version (版本) V1.0
 * @since (该版本支持的JDK版本) 1.7
 * @modify (修改) 第N次修改：时间、修改人;修改说明
 * @Review (审核人) 审核人名称
 */
public class HttpResponseInfo implements Serializable{

    /**  变量意义 */
    private static final long serialVersionUID = -6698028214978127544L;
    // 请求状态
    private int statusCode;
    // 请求返回结果
    private String content;
    // 结果原因短语
    private String reasonPhrase;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    @Override
    public String toString() {
        return "HttpResponseInfo{" +
                "statusCode=" + statusCode +
                ", content='" + content + '\'' +
                ", reasonPhrase='" + reasonPhrase + '\'' +
                '}';
    }
}

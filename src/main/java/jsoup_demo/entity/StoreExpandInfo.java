package jsoup_demo.entity;

import java.util.Date;

/**
 * Created by wangzz on 2016/8/11.
 * 店铺拓展信息
 */
public class StoreExpandInfo {

    //主键
    private Long id;
    //店铺id
    private Long storeId;

    //店铺半年内动态评分
    //宝贝与描述相符-评分
    private String descriptionMatchScore;
    //卖家的服务态度-评分
    private String sellerMannerScore;
    //物流服务的质量-评分
    private String logisticsMannerScore;
    //宝贝与描述相符-与同行业比较
    private String descriptionMatchCompare;
    //卖家的服务态度-同行业比较
    private String sellerMannerCompare;
    //物流服务的质量-同行业比较
    private String logisticsMannerCompare;
    //宝贝与描述相符-与同行业比较-是否更高
    private Boolean descriptionMatchIsTaller;
    //卖家的服务态度-同行业比较-是否更高
    private Boolean sellerMannerIsTaller;
    //物流服务的质量-同行业比较-是否更高
    private Boolean logisticsMannerIsTaller;

    //店铺28天内服务情况
    //退款完结时长 - 本店
    private String localRefundTime;
    //退款自主完结率 - 本店
    private String localRefundRate;
    //纠纷退款率 - 本店
    private String localDisputeRefundRate;
    //退款完结时长 - 行业均值
    private String averageRefundTime;
    //退款自主完结率 - 行业均值
    private String averageRefundRate;
    //纠纷退款率 - 行业均值
    private String averageDisputeRefundRate;

    //创建时间
    private Date created;
    //修改时间
    private Date modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getDescriptionMatchScore() {
        return descriptionMatchScore;
    }

    public void setDescriptionMatchScore(String descriptionMatchScore) {
        this.descriptionMatchScore = descriptionMatchScore;
    }

    public String getSellerMannerScore() {
        return sellerMannerScore;
    }

    public void setSellerMannerScore(String sellerMannerScore) {
        this.sellerMannerScore = sellerMannerScore;
    }

    public String getLogisticsMannerScore() {
        return logisticsMannerScore;
    }

    public void setLogisticsMannerScore(String logisticsMannerScore) {
        this.logisticsMannerScore = logisticsMannerScore;
    }

    public String getDescriptionMatchCompare() {
        return descriptionMatchCompare;
    }

    public void setDescriptionMatchCompare(String descriptionMatchCompare) {
        this.descriptionMatchCompare = descriptionMatchCompare;
    }

    public String getSellerMannerCompare() {
        return sellerMannerCompare;
    }

    public void setSellerMannerCompare(String sellerMannerCompare) {
        this.sellerMannerCompare = sellerMannerCompare;
    }

    public String getLogisticsMannerCompare() {
        return logisticsMannerCompare;
    }

    public void setLogisticsMannerCompare(String logisticsMannerCompare) {
        this.logisticsMannerCompare = logisticsMannerCompare;
    }

    public Boolean getDescriptionMatchIsTaller() {
        return descriptionMatchIsTaller;
    }

    public void setDescriptionMatchIsTaller(Boolean descriptionMatchIsTaller) {
        this.descriptionMatchIsTaller = descriptionMatchIsTaller;
    }

    public Boolean getSellerMannerIsTaller() {
        return sellerMannerIsTaller;
    }

    public void setSellerMannerIsTaller(Boolean sellerMannerIsTaller) {
        this.sellerMannerIsTaller = sellerMannerIsTaller;
    }

    public Boolean getLogisticsMannerIsTaller() {
        return logisticsMannerIsTaller;
    }

    public void setLogisticsMannerIsTaller(Boolean logisticsMannerIsTaller) {
        this.logisticsMannerIsTaller = logisticsMannerIsTaller;
    }

    public String getLocalRefundTime() {
        return localRefundTime;
    }

    public void setLocalRefundTime(String localRefundTime) {
        this.localRefundTime = localRefundTime;
    }

    public String getLocalRefundRate() {
        return localRefundRate;
    }

    public void setLocalRefundRate(String localRefundRate) {
        this.localRefundRate = localRefundRate;
    }

    public String getLocalDisputeRefundRate() {
        return localDisputeRefundRate;
    }

    public void setLocalDisputeRefundRate(String localDisputeRefundRate) {
        this.localDisputeRefundRate = localDisputeRefundRate;
    }

    public String getAverageRefundTime() {
        return averageRefundTime;
    }

    public void setAverageRefundTime(String averageRefundTime) {
        this.averageRefundTime = averageRefundTime;
    }

    public String getAverageRefundRate() {
        return averageRefundRate;
    }

    public void setAverageRefundRate(String averageRefundRate) {
        this.averageRefundRate = averageRefundRate;
    }

    public String getAverageDisputeRefundRate() {
        return averageDisputeRefundRate;
    }

    public void setAverageDisputeRefundRate(String averageDisputeRefundRate) {
        this.averageDisputeRefundRate = averageDisputeRefundRate;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "StoreExpandInfo{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", descriptionMatchScore='" + descriptionMatchScore + '\'' +
                ", sellerMannerScore='" + sellerMannerScore + '\'' +
                ", logisticsMannerScore='" + logisticsMannerScore + '\'' +
                ", descriptionMatchCompare='" + descriptionMatchCompare + '\'' +
                ", sellerMannerCompare='" + sellerMannerCompare + '\'' +
                ", logisticsMannerCompare='" + logisticsMannerCompare + '\'' +
                ", descriptionMatchIsTaller=" + descriptionMatchIsTaller +
                ", sellerMannerIsTaller=" + sellerMannerIsTaller +
                ", logisticsMannerIsTaller=" + logisticsMannerIsTaller +
                ", localRefundTime='" + localRefundTime + '\'' +
                ", localRefundRate='" + localRefundRate + '\'' +
                ", localDisputeRefundRate='" + localDisputeRefundRate + '\'' +
                ", averageRefundTime='" + averageRefundTime + '\'' +
                ", averageRefundRate='" + averageRefundRate + '\'' +
                ", averageDisputeRefundRate='" + averageDisputeRefundRate + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                '}';
    }
}

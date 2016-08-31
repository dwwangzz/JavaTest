package jsoup_demo.entity;

import java.util.Date;

/**
 * Created by wangzz on 2016/8/11.
 */
public class StoreExpandInfoConfig {

    //主键
    private Long id;
    //店铺id
    private Long storeId;
    //店铺地址
    private String scoreUrl;

    //评分-domId
    private String scoreDomId;
    //与同行业比较-domId
    private String compareDomId;
    //与同行业比较-是否更高-domId
    private String isTallerDomId;
    //本店服务数据-domId
    private String localDomId;
    //行业均值-domId
    private String averageDomId;

    //评分-dom节点的属性名称（如果此字段非空，就取此dom节点的此属性）
    private String scoreAttrName;
    //与同行业比较-dom节点的属性名称
    private String compareAttrName;
    // 与同行业比较-是否更高-dom节点的属性名称
    private String isTallerAttrName;
    //本店服务数据-dom节点的属性名称
    private String localAttrName;
    //行业均值-dom节点的属性名称
    private String averageAttrName;

    //创建时间
    private Date created;

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

    public String getScoreUrl() {
        return scoreUrl;
    }

    public void setScoreUrl(String scoreUrl) {
        this.scoreUrl = scoreUrl;
    }

    public String getScoreDomId() {
        return scoreDomId;
    }

    public void setScoreDomId(String scoreDomId) {
        this.scoreDomId = scoreDomId;
    }

    public String getCompareDomId() {
        return compareDomId;
    }

    public void setCompareDomId(String compareDomId) {
        this.compareDomId = compareDomId;
    }

    public String getIsTallerDomId() {
        return isTallerDomId;
    }

    public void setIsTallerDomId(String isTallerDomId) {
        this.isTallerDomId = isTallerDomId;
    }

    public String getLocalDomId() {
        return localDomId;
    }

    public void setLocalDomId(String localDomId) {
        this.localDomId = localDomId;
    }

    public String getAverageDomId() {
        return averageDomId;
    }

    public void setAverageDomId(String averageDomId) {
        this.averageDomId = averageDomId;
    }

    public String getScoreAttrName() {
        return scoreAttrName;
    }

    public void setScoreAttrName(String scoreAttrName) {
        this.scoreAttrName = scoreAttrName;
    }

    public String getCompareAttrName() {
        return compareAttrName;
    }

    public void setCompareAttrName(String compareAttrName) {
        this.compareAttrName = compareAttrName;
    }

    public String getIsTallerAttrName() {
        return isTallerAttrName;
    }

    public void setIsTallerAttrName(String isTallerAttrName) {
        this.isTallerAttrName = isTallerAttrName;
    }

    public String getLocalAttrName() {
        return localAttrName;
    }

    public void setLocalAttrName(String localAttrName) {
        this.localAttrName = localAttrName;
    }

    public String getAverageAttrName() {
        return averageAttrName;
    }

    public void setAverageAttrName(String averageAttrName) {
        this.averageAttrName = averageAttrName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "StoreExpandInfoConfig{" +
                "id=" + id +
                ", storeId=" + storeId +
                ", scoreUrl='" + scoreUrl + '\'' +
                ", scoreDomId='" + scoreDomId + '\'' +
                ", compareDomId='" + compareDomId + '\'' +
                ", isTallerDomId='" + isTallerDomId + '\'' +
                ", localDomId='" + localDomId + '\'' +
                ", averageDomId='" + averageDomId + '\'' +
                ", scoreAttrName='" + scoreAttrName + '\'' +
                ", compareAttrName='" + compareAttrName + '\'' +
                ", isTallerAttrName='" + isTallerAttrName + '\'' +
                ", localAttrName='" + localAttrName + '\'' +
                ", averageAttrName='" + averageAttrName + '\'' +
                ", created=" + created +
                '}';
    }
}

package solr.entity;


import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

public class FullTextSearchData {
	/*-------------companis表字段开始-----------------*/
	// 主键
	@Field 
	private String companyId;
	// 供应商名称
	@Field 
	private String companyName;
	// 公司地址
	@Field 
	private String address;
	// 联系人
	@Field 
	private String contactPerson;
	// 联系电话
	@Field 
	private String contactPhone;
	// 商标
	@Field 
	private String trademark;
	// 经营模式
	@Field 
	private String businessType;
	// 法人代表
	@Field 
	private String legalRepresentative;
	// 公司网址
	@Field 
	private String website;
	// 传真
	@Field 
	private String fax;
	// 邮编
	@Field 
	private String postcode;
	// 公司介绍
	@Field 
	private String introduction;
	// 创建时间
	@Field 
	private Date createdAt;
	// 更新时间
	@Field 
	private Date updatedAt;
	// 合作状态
	@Field 
	private String cooperationStatus;
	// 邮箱
	@Field 
	private String email;
	// qq
	@Field 
	private String qq;
	// 手机号
	@Field 
	private String mobilePhone;
	// 地区编码
	@Field 
	private String locationAreaCode;
	// 主营范围
	@Field 
	private String mainCategories;
	// 主营类别
	@Field 
	private int operateCategory;
	// 拓展地区
	@Field 
	private String expandAreaCode;
	// 报价说明
	@Field 
	private String priceNote;
	// 上级公司
	@Field 
	private String parentId;
	// 供应商级别
	@Field 
	private String level;
	// 供应商属性
	@Field 
	private String companyAttribute;
	// 公司电话
	@Field 
	private String phone;
	// 是否删除
	@Field 
	private int isDelete;
	// 经度
	@Field 
	private double longitude;
	// 纬度
	@Field 
	private double latitude;
	// 质量等级
	@Field 
	private int qualityGrade;
	// logo路径
	@Field 
	private String logo;
	// 设定协会认定企业
	@Field 
	private String assCertEnterprise;
	// 是否是第一次完成公司信息
	@Field 
	private int completeInfoFirst;
	/*-------------companis表字段结束-----------------*/
	//公司积分
	@Field
	private long companyCredit;
	//经营模式名称
	@Field 
	private String indentTypeName;
	//经营模式code
	@Field 
	private String indentTypeCode;
	//品牌名称
	@Field
	private String brandName;
	//类别名称
	@Field
	private String typeName;
	//类别Id
	@Field
	private int typeId;
	//推荐次数
	@Field
	private int recommendNum;
	//所有产品名称，逗号隔开
	@Field
	private String prNames;
	//所有产品规格，逗号隔开
	@Field
	private String prSepecifications;
	//所有产品品牌，逗号隔开
	@Field 
	private String prBrands;
	//所有产品类别名字，逗号隔开
	@Field 
	private String prTypenames;
	//座机
	@Field
	private String contactLandline;
	//c城市名
	@Field
	private String cityName;
	//省份名
	@Field
	private String provinceName;
	
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyId() {
		return this.companyId;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPerson() {
		return this.contactPerson;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactPhone() {
		return this.contactPhone;
	}

	public void setTrademark(String trademark) {
		this.trademark = trademark;
	}

	public String getTrademark() {
		return this.trademark;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessType() {
		return this.businessType;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public String getLegalRepresentative() {
		return this.legalRepresentative;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getWebsite() {
		return this.website;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFax() {
		return this.fax;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setCooperationStatus(String cooperationStatus) {
		this.cooperationStatus = cooperationStatus;
	}

	public String getCooperationStatus() {
		return this.cooperationStatus;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getQq() {
		return this.qq;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setLocationAreaCode(String locationAreaCode) {
		this.locationAreaCode = locationAreaCode;
	}

	public String getLocationAreaCode() {
		return this.locationAreaCode;
	}

	public void setMainCategories(String mainCategories) {
		this.mainCategories = mainCategories;
	}

	public String getMainCategories() {
		return this.mainCategories;
	}

	public void setOperateCategory(int operateCategory) {
		this.operateCategory = operateCategory;
	}

	public int getOperateCategory() {
		return this.operateCategory;
	}

	public void setExpandAreaCode(String expandAreaCode) {
		this.expandAreaCode = expandAreaCode;
	}

	public String getExpandAreaCode() {
		return this.expandAreaCode;
	}

	public void setPriceNote(String priceNote) {
		this.priceNote = priceNote;
	}

	public String getPriceNote() {
		return this.priceNote;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevel() {
		return this.level;
	}

	public void setCompanyAttribute(String companyAttribute) {
		this.companyAttribute = companyAttribute;
	}

	public String getCompanyAttribute() {
		return this.companyAttribute;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getIsDelete() {
		return this.isDelete;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setQualityGrade(int qualityGrade) {
		this.qualityGrade = qualityGrade;
	}

	public int getQualityGrade() {
		return this.qualityGrade;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setAssCertEnterprise(String assCertEnterprise) {
		this.assCertEnterprise = assCertEnterprise;
	}

	public String getAssCertEnterprise() {
		return this.assCertEnterprise;
	}

	public void setCompleteInfoFirst(int completeInfoFirst) {
		this.completeInfoFirst = completeInfoFirst;
	}

	public int getCompleteInfoFirst() {
		return this.completeInfoFirst;
	}

	public String getIndentTypeName() {
		return indentTypeName;
	}

	public void setIndentTypeName(String indentTypeName) {
		this.indentTypeName = indentTypeName;
	}

	public String getIndentTypeCode() {
		return indentTypeCode;
	}

	public void setIndentTypeCode(String indentTypeCode) {
		this.indentTypeCode = indentTypeCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public int getRecommendNum() {
		return recommendNum;
	}

	public void setRecommendNum(int recommendNum) {
		this.recommendNum = recommendNum;
	}

	public String getPrNames() {
		return prNames;
	}

	public void setPrNames(String prNames) {
		this.prNames = prNames;
	}

	public String getPrSepecifications() {
		return prSepecifications;
	}

	public void setPrSepecifications(String prSepecifications) {
		this.prSepecifications = prSepecifications;
	}

	public String getPrBrands() {
		return prBrands;
	}

	public void setPrBrands(String prBrands) {
		this.prBrands = prBrands;
	}

	public String getPrTypenames() {
		return prTypenames;
	}

	public void setPrTypenames(String prTypenames) {
		this.prTypenames = prTypenames;
	}

	public long getCompanyCredit() {
		return companyCredit;
	}

	public void setCompanyCredit(long companyCredit) {
		this.companyCredit = companyCredit;
	}

	public String getContactLandline() {
		return contactLandline;
	}

	public void setContactLandline(String contactLandline) {
		this.contactLandline = contactLandline;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
}

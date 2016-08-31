package solr.entity;


import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;

public class FullTextSearchForWeb {

//	主键
	@Field
	private int id;
	
//	唯一主键
	@Field
	private String uniqueKeyId;
	
//	供应商id
	@Field
	private long companyId;
	
//	供应商名称
	@Field
	private String companyName;
	
//	供应商所在省份code
	@Field
	private String provinceCode;
	
//	供应商所在市code
	@Field
	private String cityCode;
	
//	供应商所在地址
	@Field
	private String address;
	
//	联系人手机
	@Field
	private String contactMobilePhone;
	
//	联系人座机
	@Field
	private String contactTelephone;
	
//	经营类别
	@Field
	private int operateCategory;
	
//	经营类别名称
	@Field
	private String operateCategoryName;
	
//	经营模式
	@Field
	private String businessType;
	
//	经营模式名称
	@Field
	private String businessTypeName;

//	经营品牌
	@Field
	private String brand;
	
//	主营类别
	@Field
	private String mainCategories;
	
//	公司简介
	@Field
	private String introduction;
	
//	联系人
	@Field
	private String contactPerson;
	
//	电子邮箱
	@Field
	private String email;
	
//	职务
	@Field
	private String position;
	
//	用户id
	@Field
	private String userId;
	
//	添加时间（推荐时间）
	@Field
	private Date createTime;
	
//	更新时间
	@Field
	private Date updateTime;
	
//	是否删除
	@Field
	private int isDelete;
	
//	是否重点标记
	@Field
	private int isImportant;
	
//	qq
	@Field
	private String qq;
	
//	公司电话
	@Field
	private String companyPhone;	
	
//	数据来源（0表示数据来自pc后端，1表示数据来自app端，2表示来自pc前端）
	@Field
	private int original;
	
//	数据新增（0表示新增，1表示已推送）
	@Field
	private int isTheNew;
	
//	省份名称
	@Field
	private String provinceName;
	
//	城市名称
	@Field
	private String cityName;
	
//	所有产品名称，逗号隔开
	@Field
	private String prNames;
	
//	页签标识（1表示自有供应商、2表示广联达供应商）
	@Field
	private int tabMark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUniqueKeyId() {
		return uniqueKeyId;
	}

	public void setUniqueKeyId(String uniqueKeyId) {
		this.uniqueKeyId = uniqueKeyId;
	}

	public long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactMobilePhone() {
		return contactMobilePhone;
	}

	public void setContactMobilePhone(String contactMobilePhone) {
		this.contactMobilePhone = contactMobilePhone;
	}

	public String getContactTelephone() {
		return contactTelephone;
	}

	public void setContactTelephone(String contactTelephone) {
		this.contactTelephone = contactTelephone;
	}

	public int getOperateCategory() {
		return operateCategory;
	}

	public void setOperateCategory(int operateCategory) {
		this.operateCategory = operateCategory;
	}

	public String getOperateCategoryName() {
		return operateCategoryName;
	}

	public void setOperateCategoryName(String operateCategoryName) {
		this.operateCategoryName = operateCategoryName;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getBusinessTypeName() {
		return businessTypeName;
	}

	public void setBusinessTypeName(String businessTypeName) {
		this.businessTypeName = businessTypeName;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMainCategories() {
		return mainCategories;
	}

	public void setMainCategories(String mainCategories) {
		this.mainCategories = mainCategories;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getIsImportant() {
		return isImportant;
	}

	public void setIsImportant(int isImportant) {
		this.isImportant = isImportant;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public int getOriginal() {
		return original;
	}

	public void setOriginal(int original) {
		this.original = original;
	}

	public int getIsTheNew() {
		return isTheNew;
	}

	public void setIsTheNew(int isTheNew) {
		this.isTheNew = isTheNew;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getTabMark() {
		return tabMark;
	}

	public void setTabMark(int tabMark) {
		this.tabMark = tabMark;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

/**
 * glodon.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 * com.gcj.entity
 */
package excel.entity;

/**
 * 这里描述这个方法的作用
 * @author liuy-8 2014年11月27日 下午3:47:02
 */
public class ExcelCompany {
	//主键
	private int id;
	//供应商id
	private long companyId;
	
	//非数据库字段
	//供应商名称
	private int number;
	private String companyName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	

}

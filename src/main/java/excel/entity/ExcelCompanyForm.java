/**
 * glodon.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 * com.gcj.entity.from
 */
package excel.entity;

import java.util.List;


/**
 * 这里描述这个方法的作用
 * @author liuy-8 2014年11月27日 下午8:44:41
 */
public class ExcelCompanyForm {
	
	private List<ExcelCompany> excelCompanies;
	//导入数量
	private int importCount;

	public List<ExcelCompany> getExcelCompanies() {
		return excelCompanies;
	}

	public void setExcelCompanies(List<ExcelCompany> excelCompanies) {
		this.excelCompanies = excelCompanies;
	}

	public int getImportCount() {
		return importCount;
	}

	public void setImportCount(int importCount) {
		this.importCount = importCount;
	}
	
}

/**
 * glodon.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 * com.wzjl.util
 */
package excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * 这里描述这个方法的作用
 * @author liuy-8 2014年11月7日 下午3:18:28
 */
public class ParseExcel {


    /**
     * 返回10版excel所有工作表
     * @param path the path of the excel file
     * @return
     * @throws IOException
     */
    public List<XSSFSheet> readXlsx(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        // Read the Sheet
        List<XSSFSheet> xssfSheets = new ArrayList<XSSFSheet>();
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            xssfSheets.add(xssfSheet);
        }
        return xssfSheets;
    }
    
    /** 
     * 返回10版excel工作表中的所有行
     * @author liuy-8
     * @param xSSFSheet
     * @return
     * @date 2014年11月27日 下午3:22:41 
     */
    public List<XSSFRow> readSheet(XSSFSheet xSSFSheet){
    	List<XSSFRow> xSSFRows = new ArrayList<XSSFRow>();
    	for (int rowNum = 0; rowNum <= xSSFSheet.getLastRowNum(); rowNum++) {
    		XSSFRow xssfRow = xSSFSheet.getRow(rowNum);
    		xSSFRows.add(xssfRow);
    	}
    	return xSSFRows;
    }

    /**
     * 返回03版excel所有工作表
     * @param path the path of the Excel
     * @return
     * @throws IOException
     */
    public List<HSSFSheet> readXls(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<HSSFSheet> hssfSheets = new ArrayList<HSSFSheet>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet != null)
            	hssfSheets.add(hssfSheet);

        }
            // Read the Row
//            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
//                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
//                if (hssfRow != null && hssfRow.getCell(0) != null) {
//                    Supplier = new Supplier();
//                    Supplier.setName(getValue(hssfRow.getCell(0)));
//                    Supplier.setLocation(getValue(hssfRow.getCell(2)));
//                    Supplier.setAddress(getValue(hssfRow.getCell(3)));
//                    Supplier.setMobile(getValue(hssfRow.getCell(4)));
//                    Supplier.setOperate(getValue(hssfRow.getCell(5)));
//                    Supplier.setBusinessType(getValue(hssfRow.getCell(6)));
//                    Supplier.setBrand(getValue(hssfRow.getCell(7)));
//                    Supplier.setIntroduction(getValue(hssfRow.getCell(8)));
//                    Supplier.setContactPerson(getValue(hssfRow.getCell(9)));
//                    Supplier.setContactPhone(getValue(hssfRow.getCell(10)));
//                    Supplier.setPosition(getValue(hssfRow.getCell(11)));
//                    Supplier.setEmail(getValue(hssfRow.getCell(12)));
//                    Supplier.setRemark(getValue(hssfRow.getCell(13)));
//                    list.add(Supplier);
//                }
//            }
//        }
        return hssfSheets;
    }
    
    /** 
     * 返回03版excel工作表中的所有行
     * @author liuy-8
     * @param hssfSheet
     * @return
     * @date 2014年11月27日 下午3:22:41 
     */
    public List<HSSFRow> readSheet(HSSFSheet hssfSheet){
    	List<HSSFRow> xssfRows = new ArrayList<HSSFRow>();
    	for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
    		HSSFRow xssfRow = hssfSheet.getRow(rowNum);
    		xssfRows.add(xssfRow);
    	}
    	return xssfRows;
    }

    @SuppressWarnings("static-access")
    public static String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    @SuppressWarnings("static-access")
    public static String getValue(HSSFCell hssfCell) {
    	if(hssfCell==null)
    		return "";
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}

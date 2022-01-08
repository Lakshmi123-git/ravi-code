package com.crm.qa.utility;

import java.io.FileInputStream;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public  class xlsx_reader
{
		public String path;
		public static FileInputStream fs=null;
		public static  XSSFWorkbook workbook=null;
		public static  XSSFSheet sheet=null;
		public static XSSFRow row=null;
		public static XSSFCell cell=null;
		public xlsx_reader(String path)
		{
			this.path=path;
			try
			{
				fs=new FileInputStream(path);
				workbook=new XSSFWorkbook(fs);
				sheet=workbook.getSheetAt(0);
				fs.close();
			 }
			catch(Exception e) {
				e.printStackTrace();
			}
	    }
			public static int rowcount(String sheetname)
			{
				int index=workbook.getSheetIndex(sheetname);
				if(index==-1) {
					return 0;
				}
				else
				{
					sheet=workbook.getSheetAt(index);
					int num=sheet.getLastRowNum()+1;
				//	System.out.println(num);
					return num; 
				}
			}
			public static String getcelldata(String sheetname,int rownum,int cellnum)
			{
				if(rownum<=0)
				{
					return "";
				}
				int index=workbook.getSheetIndex(sheetname);
				if(index==-1) {
					return "";
				}
				sheet=workbook. getSheetAt(index);
				row=sheet.getRow(rownum-1);
				if(row==null) {
					return "";
				}
				cell=row.getCell(cellnum);
				if(cell==null)
				{
					return "";
				}
				if(cell.getCellType().name().equalsIgnoreCase("string"))
				{
					return cell.getStringCellValue();
			    }
			else if((cell.getCellType().name().equals("NUMERIC"))||cell.getCellType().name().equals("FORMULA"))
			{
				//System.out.println(cell.getNumericCellValue());
				String	celltext=String.valueOf((long)cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					Calendar cal=Calendar.getInstance();
					double d=cell.getNumericCellValue();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					celltext=(String.valueOf(cal.get(Calendar.YEAR)));
					celltext=cal.get(Calendar.MONTH)+1+"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+celltext;
					}
				return (celltext);   		
			}
			else if(cell.getCellType().name().equals("BOOLEAN")) {
				return String.valueOf(cell.getBooleanCellValue());
			}
			else {
				return "";
			}
			
			}
			public static String getcelldata(String sheetname,int rownum,String colname)
			{
				if(rownum<=0)
				{
					return "";
				}
				int index=workbook.getSheetIndex(sheetname);
				if(index==-1) {
					return "";
				}
				sheet=workbook.getSheetAt(index);
				row=sheet.getRow(0);
				int colnum=-1;
				for(int i=0;i<=row.getLastCellNum()-1;i++)
				{
					if(row.getCell(i).getStringCellValue().trim().equals(colname.trim())){
						colnum=i;
					}
				}
				if(colnum==-1)
				{
					return "";
				}
				row=sheet.getRow(rownum-1);
				if(row==null) {
					return "";
				}
				cell=row.getCell(colnum); 
				if(cell==null)
				{
					return ""; 
				}
				if(cell.getCellType().name().equalsIgnoreCase("string"))
				{
					return cell.getStringCellValue();
			    }
			else if((cell.getCellType().name().equals("NUMERIC"))||cell.getCellType().name().equals("FORMULA"))
			{
				//System.out.println(cell.getNumericCellValue());
				String	celltext=String.valueOf((long)cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					Calendar cal=Calendar.getInstance();
					double d=cell.getNumericCellValue();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					celltext=(String.valueOf(cal.get(Calendar.YEAR)));
					celltext=cal.get(Calendar.MONTH)+1+"/"+cal.get(Calendar.DAY_OF_MONTH)+"/"+celltext;
					}
				return (celltext);   		
			}
			else if(cell.getCellType().name().equals("BOOLEAN"))
			{
				return String.valueOf(cell.getBooleanCellValue());
			}
			else {
				return "";
			}
			
			}
			 }




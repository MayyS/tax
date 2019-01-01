package gdpu.tax.util;

import java.io.OutputStream;


import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

import gdpu.tax.entity.User;

public class ExcelUtil {
	
	public static void exportExcel(List<User> dataList,OutputStream os) throws Exception{
		
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("用户列表");
		sheet.setDefaultColumnWidth(20);
		
		//-------------生成首行标题----------------
		CellRangeAddress region=new CellRangeAddress(0,0,0,6);
		sheet.addMergedRegion(region);
		HSSFRow titleRow=sheet.createRow(0);
		HSSFCell titleCell=titleRow.createCell(0);
		HSSFCellStyle titleStyle=createCellStyle(wb, (short)16);
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue("用户列表");
		
		
		//-------------生成列名标题-----------------
		String[] columns = {"姓名","所属部门","账号","生日","性别","手机号码","邮箱"};
		HSSFRow colRow=sheet.createRow(1);
		HSSFCellStyle colStyle=createCellStyle(wb, (short)12);
		for(int i=0; i<columns.length; i++) {
			HSSFCell colCell=colRow.createCell(i);
			colCell.setCellStyle(colStyle);
			colCell.setCellValue(columns[i]);
		}
		
		//----------------生成用户列表-------------------
		//生成日期格式对象
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		HSSFRow dataRow = null;
		if(dataList!=null){
			for(int j=0;j<dataList.size();j++){
				try {
					dataRow = sheet.createRow(j+2);//从第三行开始,生成数据列
					dataRow.createCell(0).setCellValue(dataList.get(j).getName());//姓名
					dataRow.createCell(1).setCellValue(dataList.get(j).getDept());//部门
					dataRow.createCell(2).setCellValue(dataList.get(j).getAccount());//账号
					dataRow.createCell(3).setCellValue(df.format(dataList.get(j).getBirthday()));//生日
					dataRow.createCell(4).setCellValue(dataList.get(j).getGender()?"男":"女");//性别，true时为男
					dataRow.createCell(5).setCellValue(dataList.get(j).getMobile());//手机
					dataRow.createCell(6).setCellValue(dataList.get(j).getEmail());//邮箱
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//输出数据
		wb.write(os);
		
		//测试用代码
		//wb.write(new FileOutputStream("E:\\国税协同平台\\poi_test\\用户列表.xls"));
	}
	
	/**
	 * 创建单元格样式
	 * @param wb 工作簿对象
	 * @param fontSize 字体大小
	 * @return 单元格样式
	 */
	public static HSSFCellStyle createCellStyle(HSSFWorkbook wb, short fontSize){
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);//水平居中
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//垂直居中
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints(fontSize);//设置字体大小
		font.setBold(true);;//加粗
		cellStyle.setFont(font);
		return cellStyle;
	}
	
}

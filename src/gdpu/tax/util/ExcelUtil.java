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
		HSSFSheet sheet=wb.createSheet("�û��б�");
		sheet.setDefaultColumnWidth(20);
		
		//-------------�������б���----------------
		CellRangeAddress region=new CellRangeAddress(0,0,0,6);
		sheet.addMergedRegion(region);
		HSSFRow titleRow=sheet.createRow(0);
		HSSFCell titleCell=titleRow.createCell(0);
		HSSFCellStyle titleStyle=createCellStyle(wb, (short)16);
		titleCell.setCellStyle(titleStyle);
		titleCell.setCellValue("�û��б�");
		
		
		//-------------������������-----------------
		String[] columns = {"����","��������","�˺�","����","�Ա�","�ֻ�����","����"};
		HSSFRow colRow=sheet.createRow(1);
		HSSFCellStyle colStyle=createCellStyle(wb, (short)12);
		for(int i=0; i<columns.length; i++) {
			HSSFCell colCell=colRow.createCell(i);
			colCell.setCellStyle(colStyle);
			colCell.setCellValue(columns[i]);
		}
		
		//----------------�����û��б�-------------------
		//�������ڸ�ʽ����
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		HSSFRow dataRow = null;
		if(dataList!=null){
			for(int j=0;j<dataList.size();j++){
				try {
					dataRow = sheet.createRow(j+2);//�ӵ����п�ʼ,����������
					dataRow.createCell(0).setCellValue(dataList.get(j).getName());//����
					dataRow.createCell(1).setCellValue(dataList.get(j).getDept());//����
					dataRow.createCell(2).setCellValue(dataList.get(j).getAccount());//�˺�
					dataRow.createCell(3).setCellValue(df.format(dataList.get(j).getBirthday()));//����
					dataRow.createCell(4).setCellValue(dataList.get(j).getGender()?"��":"Ů");//�Ա�trueʱΪ��
					dataRow.createCell(5).setCellValue(dataList.get(j).getMobile());//�ֻ�
					dataRow.createCell(6).setCellValue(dataList.get(j).getEmail());//����
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//�������
		wb.write(os);
		
		//�����ô���
		//wb.write(new FileOutputStream("E:\\��˰Эͬƽ̨\\poi_test\\�û��б�.xls"));
	}
	
	/**
	 * ������Ԫ����ʽ
	 * @param wb ����������
	 * @param fontSize �����С
	 * @return ��Ԫ����ʽ
	 */
	public static HSSFCellStyle createCellStyle(HSSFWorkbook wb, short fontSize){
		HSSFCellStyle cellStyle = wb.createCellStyle();
		cellStyle.setAlignment(HorizontalAlignment.CENTER);//ˮƽ����
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);//��ֱ����
		HSSFFont font = wb.createFont();
		font.setFontHeightInPoints(fontSize);//���������С
		font.setBold(true);;//�Ӵ�
		cellStyle.setFont(font);
		return cellStyle;
	}
	
}

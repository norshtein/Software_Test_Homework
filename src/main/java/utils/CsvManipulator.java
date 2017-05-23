package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;

public class CsvManipulator {

	private Workbook wb;
	private FileInputStream fis;
	private Sheet st;
	private String path;
	private final String prefix = "copy_";
	
	public CsvManipulator(String path) throws FileNotFoundException, IOException
	{
		fis = new FileInputStream(new File(path));
		wb = new HSSFWorkbook(fis);
		st = wb.getSheetAt(0);
		this.path = path;
		
	}
	
	public CsvManipulator(String path,int sheetIndex) throws FileNotFoundException, IOException
	{
		fis = new FileInputStream(new File(path));
		wb = new HSSFWorkbook(fis);
		st = wb.getSheetAt(sheetIndex);
		this.path = path;
	}
	
	public void write(int row,int col,String content) 
	{
		Row r = st.getRow(row);
		Cell c = r.getCell(col);
		if(c == null)
			c = r.createCell(col);
		c.setCellType(CellType.STRING);
		c.setCellValue(content);
	}
	
	public String read(int row,int col)
	{
		return new DataFormatter().formatCellValue(st.getRow(row).getCell(col));
	}
	
	//return download path
	public String close() throws IOException 
	{
		fis.close();
		String outputFilename = getOutputFileName();
		File outputFile = new File(outputFilename);
		outputFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(outputFile);
		wb.write(fos);
		fos.close();
		wb.close();
		
		return outputFilename;
	}
	
	public int getRows()
	{
		return st.getLastRowNum() + 1;
	}
	
	private String getOutputFileName()
	{
		String[] s = path.split("\\\\");
		s[s.length - 1] = prefix + s[s.length - 1];
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i < s.length;i++)
			sb.append(s[i] + (i == s.length - 1 ? "" : "\\\\"));
		
		System.out.println(sb.toString());
		return sb.toString();
	}
}

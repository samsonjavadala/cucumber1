package actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.cucumber.datatable.DataTable;

public class ExcelReader {
	
	public static  List<Map<String, String>> getDataTable(String path,String sheetName) throws IOException{
       
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        List<Map<String, String>> dataList = new ArrayList<>();

        Row headerRow = sheet.getRow(0);
        int numRows = sheet.getPhysicalNumberOfRows();
        int numCols = headerRow.getPhysicalNumberOfCells();

        for (int i = 1; i < numRows; i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            Map<String, String> dataMap = new HashMap<>();
            for (int j = 0; j < numCols; j++) {
                Cell cell = row.getCell(j);
                String key = headerRow.getCell(j).toString();
                String value = (cell == null) ? "" : cell.toString();
                dataMap.put(key, value);
            }
            dataList.add(dataMap);
        }

        workbook.close();
        return dataList;
    }

}

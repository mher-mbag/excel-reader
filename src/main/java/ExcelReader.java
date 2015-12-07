import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader {

    public static Map<String, String> readOddTypesFromExcel(String path){

        Map<String, String> oddIdesMap = new HashMap<String, String>();

        try {
            XSSFWorkbook workBook = new XSSFWorkbook(new FileInputStream(path));
            Sheet sheet = workBook.getSheetAt(0);

            int first = sheet.getFirstRowNum();
            int last = sheet.getLastRowNum();

            DataFormatter df = new DataFormatter();
            for(int i = first + 1; i < last; i++){

                XSSFRow row = (XSSFRow) sheet.getRow(i);
                XSSFCell cell_2 = row.getCell(2);
                String value = df.formatCellValue(cell_2);
                XSSFCell cell_1 = row.getCell(1);
                String value_1 = df.formatCellValue(cell_1);
                if (!oddIdesMap.containsKey(value)) {
                    oddIdesMap.put(value, value_1);
                }
            }


        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return oddIdesMap;
    }

    public static Map<String, Map<String, String>> readOddOutcomesFromExcel(String path){

        Map<String, Map<String, String>> oddIdesMap = new HashMap<String, Map<String, String>>();

        try {
            XSSFWorkbook workBook = new XSSFWorkbook(new FileInputStream(path));

            for (int i = 0; i < workBook.getNumberOfSheets(); i++) {
                Sheet sheet = workBook.getSheetAt(i);

                int first = sheet.getFirstRowNum();
                int last = sheet.getLastRowNum();

                Map<String, String> outcomesMap;

                DataFormatter df = new DataFormatter();
                for(int j = first + 1; j < last - 1; j++){

                    XSSFRow row = (XSSFRow) sheet.getRow(j);
                    XSSFCell cell_0 = row.getCell(0);
                    String value = df.formatCellValue(cell_0);
                    XSSFCell cell_4 = row.getCell(2);
                    String value_4 = df.formatCellValue(cell_4);
                    XSSFCell cell_6 = row.getCell(3);
                    String value_6 = df.formatCellValue(cell_6);
                    if (oddIdesMap.containsKey(value)) {
                        outcomesMap = oddIdesMap.get(value);
                    } else {
                        outcomesMap = new HashMap<String, String>();
                    }

                    outcomesMap.put(value_4, value_6);
                    oddIdesMap.put(value, outcomesMap);

                }
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return oddIdesMap;
    }
}



import java.io.*;
import java.util.List;

public class CSVRunner {

    private static final String userHome = System.getProperty("user.home");
    private static final String userDir = System.getProperty("user.dir");

    private static final String CSV_SEMICOLON_SEPARATOR = ";";

    public CSVRunner() {
    }

    public enum CsvFileDataType {
        TOURNAMENTS("tournaments"),
        PLAYERS("players");

        private String value;

        CsvFileDataType(String val) {
            this.value = val;
        }
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "CsvFileDataType{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        CSVRunner runner = new CSVRunner();

        ExcelReader.readOddTypesFromExcel(selectDirectory("email_list/"));
    }

    private static String selectDirectory(String path) {

        // try current folder first
        String fullPath = userDir + path;
        File file = new File(fullPath);
        if (!file.exists()) {
            System.out.println("File: " + fullPath + " does not exist, switching to User Home folder.");
            // now try user home folder
            fullPath = userHome + path;
            file = new File(fullPath);
            if (!file.exists()) {
                System.out.println("File: " + fullPath + " does not exist");
                return null;
            }
        }

        System.out.println("The selected folder is : " + fullPath);
        return fullPath;
    }




}

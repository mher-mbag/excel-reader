

import java.io.*;
import java.util.List;

public class CSVRunner {

    private static final String userHome = System.getProperty("user.home");
    private static final String userDir = System.getProperty("user.dir");


    public CSVRunner() {
    }

    public static void main(String[] args) {


        ExcelReader.readOddTypesFromExcel("C:\\Users\\Gebruiker\\Desktop\\email_list\\nodups.xlsx");
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

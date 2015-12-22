package com.university.main;

import com.university.util.WordReader;

import java.io.*;
import java.util.List;

/**
 * http://www.pretechsol.com/2013/11/springdata-jpa-with-mysql-example.html#.VnlFwvl96Uk
 */
public class CSVRunner {

    private static final String userHome = System.getProperty("user.home");
    private static final String userDir = System.getProperty("user.dir");


    public CSVRunner() {
    }

    public static void main(String[] args) {

        //List<String> getDuplicateEmails = com.university.util.ExcelReader.readDuplicateEmailsFromExcel("C:\\Users\\Mher\\Desktop\\word_list\\nodups.xlsx");
        //com.university.util.ExcelReader.removeDuplicatesAndValidateExcel("C:\\Users\\Mher\\Desktop\\word_list\\Lumi.xlsx", getDuplicateEmails);

        WordReader.readWordDocument("C:\\Users\\Gebruiker\\Desktop\\word-list\\sample.docx");
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

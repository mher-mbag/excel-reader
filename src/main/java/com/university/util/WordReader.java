package com.university.util;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * https://svn.apache.org/repos/asf/poi/trunk/src/examples/src/org/apache/poi/xwpf/usermodel/SimpleTable.java
 * http://www.programcreek.com/java-api-examples/index.php?api=org.apache.poi.xwpf.usermodel.XWPFDocument
 * http://www.concretepage.com/apache-api/apache-poi-xwpf-read-ms-word-docx-header-footer-paragraph-table-example
 * Created by Mher on 12/16/2015.
 */
public class WordReader {

    public static void readWordDocument(String path) {
        try {
            FileInputStream fis = new FileInputStream(path);

            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));

            Iterator<IBodyElement> bodyElementIterator = xdoc.getBodyElementsIterator();
            while(bodyElementIterator.hasNext()) {
                IBodyElement element = bodyElementIterator.next();
                if("TABLE".equalsIgnoreCase(element.getElementType().name())) {
                    List<XWPFTable> tableList =  element.getBody().getTables();
                    for (XWPFTable table: tableList){
                        System.out.println("Total Number of Rows of Table:"+table.getNumberOfRows());
                        System.out.println(table.getText());
                    }
                }
            }

            fis.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

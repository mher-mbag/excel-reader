package com.university.util;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

/**
 * http://www.docspal.com/
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

            FileWriter f0 = new FileWriter("C:\\Users\\Gebruiker\\Desktop\\word-list\\output.txt");

            while(bodyElementIterator.hasNext()) {
                IBodyElement element = bodyElementIterator.next();
                if("TABLE".equalsIgnoreCase(element.getElementType().name())) {
                    List<XWPFTable> tableList =  element.getBody().getTables();
                    for (XWPFTable table: tableList){
                        int rowsCount = table.getNumberOfRows();
                        List<XWPFTableRow> row = table.getRows();
                        for (XWPFTableRow xwpfTableRow : row) {
                            List<XWPFTableCell> cell = xwpfTableRow.getTableCells();
                            for (XWPFTableCell xwpfTableCell : cell) {
                                if(xwpfTableCell!=null)
                                {
                                    System.out.println(xwpfTableCell.getText());
                                    List<XWPFTable> itable = xwpfTableCell.getTables();
                                    if(itable.size()!=0)
                                    {
                                        for (XWPFTable xwpfiTable : itable) {
                                            List<XWPFTableRow> irow = xwpfiTable.getRows();
                                            for (XWPFTableRow xwpfiTableRow : irow) {
                                                List<XWPFTableCell> icell = xwpfiTableRow.getTableCells();
                                                for (XWPFTableCell xwpfiTableCell : icell) {
                                                    if(xwpfiTableCell!=null)
                                                    {
                                                        System.out.println(xwpfiTableCell.getText());
                                                        f0.write(xwpfiTableCell.getText() + "\n");
                                                        f0.write(String.format("%n"));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        //System.out.println(rowsCount);
                        //System.out.println(table.getText());

                    }
                }
            }

            fis.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    public static void readDocFile(String fileName) {

        try {
            File file = new File(fileName);
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file.getAbsolutePath()));
            HWPFDocument doc = new HWPFDocument(fs);

            WordExtractor we = new WordExtractor(doc);

            String[] paragraphs = we.getParagraphText();

            System.out.println("Total no of paragraph "+paragraphs.length);
            for (String para : paragraphs) {
                System.out.println(para.toString());
            }
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

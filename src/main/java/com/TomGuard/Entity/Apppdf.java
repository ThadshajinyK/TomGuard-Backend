package com.TomGuard.Entity;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class Apppdf {
   // List to hold all Application
    private List<ApplicationEntity> applicationEntityList;

    public void generate(HttpServletResponse response) throws DocumentException, IOException {

        // Creating the Object of Document
        Document document = new Document(PageSize.A4);

        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());

        // Opening the created document to modify it
        document.open();

        // Creating font
        // Setting font style and size
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);

        // Creating paragraph
        Paragraph paragraph = new Paragraph("Applications Details", fontTitle);

        // Aligning the paragraph in document
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding the created paragraph in document
        document.add(paragraph);

        // Creating a table of 10 columns
        PdfPTable table = new PdfPTable(5);



        // Setting width of table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] {1,1,1,1,1});
        table.setSpacingBefore(5);

        // Create Table Cells for table header
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding
        cell.setBackgroundColor(new Color(46, 100, 128));
        cell.setPadding(5);

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);

        // Adding headings in the created table cell/ header
        // Adding Cell to table


        cell.setPhrase(new Phrase("Application Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("state", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Path", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("App Type", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Client Name", font));
        table.addCell(cell);


        // Iterating over the list of clients
        for (ApplicationEntity applicationEntity : applicationEntityList) {


            table.addCell(applicationEntity.getApplicationName());
            table.addCell(applicationEntity.getState());
            table.addCell(applicationEntity.getPath());
            table.addCell(applicationEntity.getAppType());
            table.addCell(applicationEntity.getClientName());


        }
        // Adding the created table to document
        document.add(table);

        // Closing the document
        document.close();

    }

    public void setapplist(List<ApplicationEntity>applicationEntityList){
        this.applicationEntityList=applicationEntityList;
    }
}

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

public class ServerPdf {

    // List to hold all Server
    private List<ServerEntity> serverEntityList;

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
        Paragraph paragraph = new Paragraph("List Of Servers", fontTitle);

        // Aligning the paragraph in document
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding the created paragraph in document
        document.add(paragraph);

        // Creating a table of 10 columns
        PdfPTable table = new PdfPTable(8);



        // Setting width of table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] {2,2,2,2,2,2,2,2});
        table.setSpacingBefore(5);

        // Create Table Cells for table header
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding
        cell.setBackgroundColor(new Color(105, 46, 73));;
        cell.setPadding(5);

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);

        // Adding headings in the created table cell/ header
        // Adding Cell to table


        cell.setPhrase(new Phrase("Hostname", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Ip Address", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("UpTime", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Availability", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Os", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Os Version", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Os Architecture", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Jvm Version", font));
        table.addCell(cell);

        // Iterating over the list of servers
        for (ServerEntity serverEntity : serverEntityList) {

            table.addCell(serverEntity.getHostName());
            table.addCell(serverEntity.getIpAddress());
            table.addCell(String.valueOf(serverEntity.getUptime()));
            table.addCell(serverEntity.getAvailability());
            table.addCell(serverEntity.getOsName());
            table.addCell(serverEntity.getOsVersion());
            table.addCell(serverEntity.getOsArchitecture());
            table.addCell(serverEntity.getJvmVersion());


        }
        // Adding the created table to document
        document.add(table);

        // Closing the document
        document.close();

    }
    public void setserverlist(List<ServerEntity> serverEntityList) {
        this.serverEntityList = serverEntityList;
    }
}

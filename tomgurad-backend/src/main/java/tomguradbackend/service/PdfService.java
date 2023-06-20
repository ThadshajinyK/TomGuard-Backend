package tomguradbackend.service;
import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import org.springframework.stereotype.Service;
import tomguradbackend.entity.Server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PdfService {
    // List to hold all Servers
    private List<Server> serverList;

    public byte[] generate() throws DocumentException, IOException {

        // Creating the Object of Document
        Document document = new Document(PageSize.A4);

        // Creating a ByteArrayOutputStream to hold the PDF content
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, outputStream);

        // Opening the created document to modify it
        document.open();

        // Creating font
        // Setting font style and size
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);

        // Creating paragraph
        Paragraph paragraph = new Paragraph("List Of Top Servers", fontTitle);

        // Aligning the paragraph in the document
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding the created paragraph in the document
        document.add(paragraph);

        // Creating a table of 6 columns
        PdfPTable table = new PdfPTable(6);

        // Setting width of the table, its columns, and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[]{3, 3, 3, 3, 3, 3});
        table.setSpacingBefore(5);

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);

        // Creating table cells for the table header
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding
        cell.setBackgroundColor(CMYKColor.MAGENTA);
        cell.setPadding(5);

        // Adding headings in the created table cell/header
        // Adding cell to table
        cell.setPhrase(new Phrase("Server ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Client", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Location", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("IP Address", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Status", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("App", font));
        table.addCell(cell);

        // Iterating over the list of servers
        for (Server server : serverList) {
            // Adding server ID
            table.addCell(String.valueOf(server.getServerid()));
            // Adding client name
            table.addCell(server.getClient());
            // Adding server location
            table.addCell(server.getLocation());
            table.addCell(server.getIpAddress());
            table.addCell(server.getStatus());
            table.addCell(server.getApp());
        }
        // Adding the created table to the document
        document.add(table);

        // Closing the document
        document.close();

        // Returning the generated PDF content as a byte array
        return outputStream.toByteArray();
    }

    public void setServerList(List<Server> serverList) {
        this.serverList = serverList;
    }
}
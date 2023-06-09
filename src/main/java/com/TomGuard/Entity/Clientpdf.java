package com.TomGuard.Entity;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Clientpdf {

    // List to hold all client
    private List<ClientEntity> clientEntityList;

    public void generate(HttpServletResponse response) throws DocumentException, IOException {

        // Creating the Object of Document
        Document document = new Document(PageSize.A4.rotate());

        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());

        // Opening the created document to modify it
        document.open();

        // Creating font
        // Setting font style and size
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);

        // Creating the company name
        Paragraph companyNameParagraph = new Paragraph("© Eleos Pvt Ltd");
        companyNameParagraph.setAlignment(Element.ALIGN_LEFT);
        companyNameParagraph.setSpacingBefore(10);
        companyNameParagraph.setSpacingAfter(10);
        document.add(companyNameParagraph);

        // Creating paragraph
        Paragraph paragraph = new Paragraph("Clients Details", fontTitle);

        // Aligning the paragraph in document
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        // Adding the created paragraph in document
        document.add(paragraph);

        // Creating a table of 10 columns
        PdfPTable table = new PdfPTable(10);



        // Setting width of table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] {1,1,1,1,1,1,1,1,1,1});
        table.setSpacingBefore(5);

        // Create Table Cells for table header
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding
        cell.setBackgroundColor(new Color(82, 107, 161));
        cell.setPadding(5);

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);

        // Adding headings in the created table cell/ header
        // Adding Cell to table


//        cell.setPhrase(new Phrase("Client ID", font));
//        table.addCell(cell);
        cell.setPhrase(new Phrase("Company Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Contact Person", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Email", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Telephone No", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Business Type", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Project Type", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Project Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Scope", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Target Audience", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Expected features", font));
        table.addCell(cell);

        // Iterating over the list of clients
        for (ClientEntity clientEntity : clientEntityList) {

//            table.addCell(String.valueOf(clientEntity.getId()));
            table.addCell(clientEntity.getCompanyName());
            table.addCell(clientEntity.getContactPerson());
            table.addCell(clientEntity.getEmailAddress());
            table.addCell(clientEntity.getPhoneNumber());
            table.addCell(clientEntity.getBusinessType());
            table.addCell(clientEntity.getProjectType());
            table.addCell(clientEntity.getProjectName());
            table.addCell(clientEntity.getProjectScope());
            table.addCell(clientEntity.getTargetAudience());
            table.addCell(clientEntity.getExpectedFeatures());


        }
        // Adding the created table to document
        document.add(table);

        // Adding the device name and location to the top right side
        Font deviceNameFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
        String deviceName = getDeviceName();
        String deviceLocation = getDeviceLocation();
        String osName = System.getProperty("os.name");
        String ipAddress = InetAddress.getLocalHost().getHostAddress();
        String deviceInfo = "Generated on: " + getCurrentDateTime() + " | Device: " + deviceName +" | OS: "+ osName +" | IP ADDRESS: "+ipAddress;
        Paragraph deviceNameParagraph = new Paragraph(deviceInfo, deviceNameFont);
        deviceNameParagraph.setAlignment(Paragraph.ALIGN_RIGHT);
        document.add(deviceNameParagraph);

        // Closing the document
        document.close();

    }
    private static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }

    private String getDeviceName() {
        try {
            InetAddress localMachine = InetAddress.getLocalHost();
            return localMachine.getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "";
    }


    private String getDeviceLocation() {
        try {
            String ipAddress = "192.168.8.225"; // Replace with the actual IP address of the device
            String url = "https://ipstack.com/" + ipAddress + "604bce82b755bd1d124feebe33a482a0";
            JSONObject json = readJsonFromUrl(url);
            String city = json.getString("city");
            String region = json.getString("region_name");
            String country = json.getString("country_name");
            return city + ", " + region + ", " + country;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Srilanka";
    }

    private JSONObject readJsonFromUrl(String url) throws IOException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            String jsonText = sb.toString();
            return new JSONObject(jsonText);
        } finally {
            is.close();
        }


    }

            public void setclientlist(List<ClientEntity>clientEntityList){
                this.clientEntityList=clientEntityList;
            }
}

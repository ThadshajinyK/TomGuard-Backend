package com.TomGuard.Entity;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.net.InetAddress;


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

        // Creating the company name
        Paragraph companyNameParagraph = new Paragraph("© Eleos Pvt Ltd");
        companyNameParagraph.setAlignment(Element.ALIGN_LEFT);
        companyNameParagraph.setSpacingBefore(10);
        companyNameParagraph.setSpacingAfter(10);
        document.add(companyNameParagraph);

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
//
//        // Adding the device name to the top right side
//        Font deviceNameFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
//        String deviceName = getDeviceName();
//        Paragraph deviceNameParagraph = new Paragraph("Generated on: " + getCurrentDateTime() + " | Device: " + deviceName, deviceNameFont);
//        deviceNameParagraph.setAlignment(Paragraph.ALIGN_RIGHT);
//        document.add(deviceNameParagraph);

        // Adding the device name and location to the top right side
        Font deviceNameFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
        String deviceName = getDeviceName();
        String deviceLocation = getDeviceLocation();
        String osName = System.getProperty("os.name");
        String ipAddress = InetAddress.getLocalHost().getHostAddress();
        String deviceInfo = "Generated on: " + getCurrentDateTime() + " | Device: " + deviceName +" | OS: "+ osName +" | IP ADDRESS: "+ipAddress+ " (" + deviceLocation + ")";
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




    public void setserverlist(List<ServerEntity> serverEntityList) {
        this.serverEntityList = serverEntityList;
    }
}

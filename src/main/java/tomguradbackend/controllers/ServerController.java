package tomguradbackend.controllers;

import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tomguradbackend.entity.Server;
import tomguradbackend.repository.ServerRepository;
import tomguradbackend.service.EmailService;
import tomguradbackend.service.PdfService;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")

public class ServerController {

@Autowired

   private ServerRepository severRepository;
@Autowired
private PdfService pdfService;

    @Autowired
    private EmailService emailService;

 @GetMapping("server-list")
 public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {

     response.setContentType("application/pdf");
     DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
     String currentDateTime = dateFormat.format(new Date());
     String headerkey = "Content-Disposition";
     String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
     response.setHeader(headerkey, headervalue);

     List<Server> serverList = severRepository.findAll();
     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
     pdfService.setServerList(serverList);
     pdfService.generate(byteArrayOutputStream);

     // Get the generated PDF file as a byte array
     byte[] pdfBytes = byteArrayOutputStream.toByteArray();


     pdfService.setserverlist(serverList);
     byte[] pdfBytes = response.getOutputStream();
     emailService.sendResetEmail("lionishapremajeyanthan2000@gmail.com","link","link",pdfService.generate(response));
     pdfService.generate(response);


 }


}

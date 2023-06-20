package tomguradbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tomguradbackend.entity.Server;
import tomguradbackend.repository.ServerRepository;

@SpringBootApplication
public class TomguradBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TomguradBackendApplication.class, args);
	}
	@Autowired
	ServerRepository severRepository;
	@Override
	public void run(String... args) throws Exception {
		this.severRepository.save(new Server(1,"Ceylon Theaters","Sri lanka","192.168.2.1","Active","Bookmyshow.lk"));
		this.severRepository.save(new Server(2,"Srilankan Railway","Sri lanka","192.168.2.4","Active","railway.gov.lk"));
		this.severRepository.save(new Server(3,"Alibaba","China","192.168.2.15","Active","Daraz.lk"));
		this.severRepository.save(new Server(4,"SpiceJet Ltd","India","192.168.2.34","Active","spicejet.com"));

	}




}

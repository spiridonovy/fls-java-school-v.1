package fls.fin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class FinApplication {
	public static final SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
	public static final SimpleDateFormat sdfwt = new SimpleDateFormat("dd.MM.yyyy hh:mm");

	public static void main(String[] args) {
		SpringApplication.run(FinApplication.class, args);
	}

}

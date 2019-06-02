package com.flslecturefinalalpinx;

import com.flslecturefinalalpinx.Repositories.IDoctorRepository;

import com.flslecturefinalalpinx.Repositories.IPatientRepository;
import com.flslecturefinalalpinx.Repositories.IProcedureRepository;
import com.flslecturefinalalpinx.Repositories.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	private	IPatientRepository patientRepository;
	private	IProcedureRepository procedureRepository;
	private	IDoctorRepository doctorRepository;
	private IRoomRepository roomRepository;

	@Autowired
	public Application(IPatientRepository patientRepository,
					   IProcedureRepository procedureRepository,
					   IDoctorRepository doctorRepository,
					   IRoomRepository roomRepository) {
		this.patientRepository = patientRepository;
		this.procedureRepository = procedureRepository;
		this.doctorRepository = doctorRepository;
		this.roomRepository = roomRepository;
	}


	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}

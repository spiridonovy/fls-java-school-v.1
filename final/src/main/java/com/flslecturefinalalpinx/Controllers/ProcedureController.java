package com.flslecturefinalalpinx.Controllers;

import com.flslecturefinalalpinx.Exceptions.NoContentException;
import com.flslecturefinalalpinx.Models.Procedure;
import com.flslecturefinalalpinx.Models.Requests.ProcedureRequest;
import com.flslecturefinalalpinx.Repositories.IDoctorRepository;
import com.flslecturefinalalpinx.Repositories.IPatientRepository;
import com.flslecturefinalalpinx.Repositories.IProcedureRepository;
import com.flslecturefinalalpinx.Repositories.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class ProcedureController {

    private IDoctorRepository doctorRepository;
    private IPatientRepository patientRepository;
    private IProcedureRepository procedureRepository;
    private IRoomRepository roomRepository;

    @Autowired
    public ProcedureController(
            IDoctorRepository doctorRepository,
            IPatientRepository patientRepository,
            IProcedureRepository procedureRepository,
            IRoomRepository roomRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.procedureRepository = procedureRepository;
        this.roomRepository = roomRepository;

    }

    @PostMapping("/procedure")
    @ResponseBody
    public Procedure Create(@RequestBody() ProcedureRequest request) {
        return procedureRepository.save(
                new Procedure(
                        request.patient,
                        request.description,
                        request.status,
                        request.starttime,
                        request.endtime,
                        request.doctor,
                        request.room));
    }

    @PutMapping("/procedure/{id}")
    @ResponseBody
    public Procedure Update(@PathVariable int id, @RequestBody() ProcedureRequest request) {
        var procedure = procedureRepository.findById(id);
        //request.patient.or().ifPresent();
        if (request.patient != null) procedure.patient = request.patient;
        if (request.description != null) procedure.description = request.description;
        if (request.status != null) procedure.status = request.status;
        if (request.starttime != null) procedure.starttime = request.starttime;
        if (request.endtime != null) procedure.endtime = request.endtime;
        if (request.doctor != null) procedure.doctor = request.doctor;
        if (request.room != null) procedure.room = request.room;

        return procedureRepository.save(procedure);
    }

    @GetMapping("/procedure/{id}")
    @ResponseBody
    public Procedure FindById(@PathVariable int id) {
        var procedure = procedureRepository.findById(id);
        if (procedure == null) {
            throw new NoContentException();
        }
        return procedure;
    }

    @GetMapping("/procedure/getByDoctor")
    @ResponseBody
    public ArrayList<Procedure> FindByDoctor(@RequestParam(name = "name") String name) {
        var doctors = doctorRepository.findByName(name);
        if (doctors == null || doctors.isEmpty()) throw new NoContentException();
        var procedures = new ArrayList<Procedure>();
        for (var doctor : doctors) {
            procedures.addAll(procedureRepository.findByDoctor(doctor.getId()));
        }
        return procedures;
    }

    @GetMapping("/procedure/getByPatient")
    @ResponseBody
    public ArrayList<Procedure> FindByPatient(@RequestParam(name = "name") String name) {
        var patients = patientRepository.findByName(name);
        if (patients == null || patients.isEmpty()) throw new NoContentException();
        var procedures = new ArrayList<Procedure>();
        for (var patient : patients) {
            procedures.addAll(procedureRepository.findByPatient(patient.getId()));
        }
        return procedures;
    }

    @GetMapping("/procedure/getByRoom")
    @ResponseBody
    public ArrayList<Procedure> FindByRoom(@RequestParam(name = "name") String name) {
        var rooms = roomRepository.findByName(name);
        if (rooms == null || rooms.isEmpty()) throw new NoContentException();
        var procedures = new ArrayList<Procedure>();
        for (var room : rooms) {
            procedures.addAll(procedureRepository.findByRoom(room.getId()));
        }
        return procedures;
    }
}

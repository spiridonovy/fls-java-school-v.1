package com.flslecturefinalalpinx.Controllers;

import com.flslecturefinalalpinx.Exceptions.NoContentException;
import com.flslecturefinalalpinx.Models.Procedure;
import com.flslecturefinalalpinx.Models.Requests.ProcedureRequest;
import com.flslecturefinalalpinx.Repositories.IDoctorRepository;
import com.flslecturefinalalpinx.Repositories.IPatientRepository;
import com.flslecturefinalalpinx.Repositories.IProcedureRepository;
import com.flslecturefinalalpinx.Repositories.IRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
                        request.date,
                        request.doctor,
                        request.room));
    }

    @PutMapping("/procedure/{id}")
    @ResponseBody
    public Procedure Update(@PathVariable int id, @RequestBody() ProcedureRequest request) {
        var procedure = procedureRepository.findById(id);

        if (request.patient != null) procedure.setPatient(request.patient);
        if (request.description != null) procedure.setDescription(request.description);
        if (request.status != null) procedure.setStatus(request.status);
        if (request.starttime != null) procedure.setStarttime(request.starttime);
        if (request.endtime != null) procedure.setEndtime(request.endtime);
        if (request.date != null) procedure.setDate(request.date);
        if (request.doctor != null) procedure.setDoctor(request.doctor);
        if (request.room != null) procedure.setRoom(request.room);

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

    @GetMapping("/procedure/findAll")
    @ResponseBody
    public ArrayList<Procedure> FindAll() {
        var procedure = procedureRepository.findAll();
        if (procedure == null || procedure.isEmpty()) throw new NoContentException();
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

    @DeleteMapping("/procedure/{id}")
    @ResponseBody
    public HttpStatus Delete(@PathVariable Integer id) {
        var procedure = procedureRepository.findById(id);
        if (procedure.isEmpty()) {
            throw new NoContentException();
        }
        procedureRepository.deleteById(procedure.get().getId());
        return HttpStatus.OK;
    }
}

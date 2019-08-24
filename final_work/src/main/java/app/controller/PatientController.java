package app.controller;

import app.entity.Patient;
import app.exception.NoEntityException;
import app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    private PatientService service;

    @Autowired
    public PatientController(PatientService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Patient geById(@PathVariable(value = "id") Long id) throws NoEntityException {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Long id , @RequestBody Patient patient) throws NoEntityException {
        return service.update(id, patient);
    }

    @PostMapping("/new")
    public Patient add(@RequestBody Patient patient){
        return service.add(new Patient.Builder(patient.getName())
                .setSex(patient.getSex())
                .setDayOfBirth(patient.getDayOfBirth())
                .build());
    }

    @DeleteMapping("/doctors/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

package app.controller;

import app.entity.Status;
import app.entity.Study;
import app.exception.NoEntityException;
import app.service.StudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/study")
public class StudyController {

    private StudyService service;

    @Autowired
    public StudyController(StudyService service){
        this.service = service;
    }

    @PutMapping("/patient/{id}")
    public Study updatePatient(@PathVariable Long id, @RequestBody Long patientId) throws NoEntityException {
        return service.updatePatient(id, patientId);
    }

    @PutMapping("/status/{id}")
    public Study updateStatus(@PathVariable Long id, @RequestBody Status status) throws NoEntityException {
        return service.updateStatus(id, status);
    }

    @PutMapping("/end_date/{id}")
    public Study updateEndDate(@PathVariable Long id, @RequestBody Date endDate) throws NoEntityException {
        return service.updateEndDate(id, endDate);
    }

    @GetMapping("/all")
    public List getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Study geById(@PathVariable(value = "id") Long id) throws NoEntityException {
        return service.getById(id);
    }

    @PostMapping("/new")
    public Study add(@RequestBody Study study){
        return service.add(Study.builder()
                .patientId(study.getPatientId())
                .description(study.getDescription())
                .status(study.getStatus())
                .startTime(study.getStartTime())
                .endTime(study.getEndTime())
                .build()
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }


}

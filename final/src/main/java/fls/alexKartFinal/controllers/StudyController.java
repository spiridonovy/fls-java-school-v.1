package fls.alexKartFinal.controllers;

import fls.alexKartFinal.services.*;
import fls.alexKartFinal.entities.*;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class StudyController {

    private StudyService studyService;

    @GetMapping("/studies")
    public List getAll() {
        return studyService.getAllStudies();
    }

    @PostMapping("/studies")
    public Study addStudy(@Valid @RequestBody Study study) {
        return studyService.addStudy(study);
    }

    @PutMapping("/studies/{id}/planned")
    public Study updateStudyPlanned(@PathVariable Long id) {
        return studyService.updateStudy(id, "PLANNED");
    }

    @PutMapping("/studies/{id}/progress")
    public Study updateStudyProgress(@PathVariable Long id) {
        return studyService.updateStudy(id, "PROGRESS");
    }

    @PutMapping("/studies/{id}/finished")
    public Study updateStudyFinished(@PathVariable Long id) {
        return studyService.updateStudy(id, "FINISHED");
    }

}

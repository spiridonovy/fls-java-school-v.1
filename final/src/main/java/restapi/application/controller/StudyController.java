package restapi.application.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Study;
import restapi.application.service.interf.StudyService;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class StudyController {

    final private StudyService studyService;

    @GetMapping("/studies")
    public List getAll() throws NoContentException {
        return studyService.getAll();
    }

    @GetMapping("/studies/{id}")
    public Study getStudyById(@PathVariable(value = "id") Long studyId) throws ItemNotFoundException {
        return studyService.getStudyById(studyId);
    }

    @PostMapping("/studies")
    public Study addStudy(@Valid @RequestBody Study study) {
        return studyService.addStudy(study);
    }

    @PutMapping("/studies/{id}/planned")
    public Study updateStudyPlanned(@PathVariable Long id) throws ItemNotFoundException {
        return studyService.updateStudy(id, "PLANNED");
    }

    @PutMapping("/studies/{id}/progress")
    public Study updateStudyProgress(@PathVariable Long id) throws ItemNotFoundException {
        return studyService.updateStudy(id, "PROGRESS");
    }

    @PutMapping("/studies/{id}/finished")
    public Study updateStudyFinished(@PathVariable Long id) throws ItemNotFoundException {
        return studyService.updateStudy(id, "FINISHED");
    }

}

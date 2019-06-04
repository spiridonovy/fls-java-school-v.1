package application.controllers;

import application.models.Study;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import application.services.StudyService;

import java.util.List;

@RestController
public class StudyController {

    public static final Logger logger=LoggerFactory.getLogger(StudyController.class);

    private StudyService studyService;

    public StudyController(StudyService studyService) {
        this.studyService = studyService;
    }

    @GetMapping(value = "/studies")
    public List<Study> getAllStudies(){
        return studyService.getAllStudies();
    }

    @PostMapping(value = "/studies")
    public Study addStudy(Study study){
        logger.info("Creating Study: {}", study);
        return  studyService.addStudy(study);
    }

    @PutMapping("/studies/{id}/status")
    public Study updateStudy(Long id,String status){
        return studyService.updateStudy(id,status);
    }
}

package fls.alexKartFinal.services;

import fls.alexKartFinal.repos.*;
import fls.alexKartFinal.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudyService {

    @Autowired
    private StudyRepository studyRepository;

    public List getAllStudies() {
        return studyRepository.findAll();
    }

    public Study addStudy(Study study) {

        return this.studyRepository.save(study);
    }

    public Study updateStudy(Long id, String status) {
        Study study=this.studyRepository.findById(id).get();
        study.setStatus(status);
        return this.studyRepository.save(study);
    }
}

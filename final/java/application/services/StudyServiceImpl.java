package application.services;

import application.models.Study;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import application.repositories.StudyRepository;

import java.util.List;

@Service
public class StudyServiceImpl implements StudyService{

    public static final Logger logger = LoggerFactory.getLogger(StudyServiceImpl.class);

    @Autowired
    private StudyRepository studyRepository;

    @Override
    public List getAllStudies() {
        logger.debug("Returning list of all the studies.");
        return studyRepository.findAll();
    }

    @Override
    public Study addStudy(Study study) {
        logger.info("Study called {} was added.", study);
        return this.studyRepository.save(study);
    }

    @Override
    public Study updateStudy(Long id, String status) {
        Study study=this.studyRepository.findById(id).get();
        study.setStatus(status);
        return this.studyRepository.save(study);
    }
}

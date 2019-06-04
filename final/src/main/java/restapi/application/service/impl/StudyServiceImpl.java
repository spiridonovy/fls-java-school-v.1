package restapi.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Study;
import restapi.application.repository.StudyRepository;
import restapi.application.service.interf.StudyService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudyServiceImpl implements StudyService {

    final private StudyRepository studyRepository;

    @Override
    public List getAll() throws NoContentException {
        List list = studyRepository.findAll();
        if (list.isEmpty()) throw new NoContentException();
        return list;
    }

    @Override
    public Study getStudyById(Long id) throws ItemNotFoundException {
        return studyRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public Study addStudy(Study study) {
        return studyRepository.save(study);
    }

    @Override
    public Study updateStudy(Long id, String status) throws ItemNotFoundException {
        Study study = studyRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
        study.setStatus(status);
        return studyRepository.save(study);
    }
}

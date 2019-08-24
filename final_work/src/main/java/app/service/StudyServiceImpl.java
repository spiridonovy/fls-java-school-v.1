package app.service;

import app.entity.Status;
import app.entity.Study;
import app.exception.NoEntityException;
import app.repository.StudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StudyServiceImpl implements StudyService {

    @Autowired
    private StudyRepository repository;

    @Override
    public Study updatePatient(Long id, Long patientId) throws NoEntityException {
        Study oldStudy = repository.findById(id)
                .map(study -> {
                    study.setPatientId(patientId);
                    return repository.save(study);
                }).orElseThrow(() -> new NoEntityException(id));
        return oldStudy;
    }

    @Override
    public Study updateStatus(Long id, Status newStatus) throws NoEntityException {
        Study oldStudy = repository.findById(id)
                .map(study -> {
                    study.setStatus(newStatus);
                    return repository.save(study);
                }).orElseThrow(() -> new NoEntityException(id));
        return oldStudy;
    }

    @Override
    public Study updateEndDate(Long id, Date endDate) throws NoEntityException {
        Study oldStudy = repository.findById(id)
                .map(study -> {
                    study.setEndTime(endDate);
                    return repository.save(study);
                }).orElseThrow(() -> new NoEntityException(id));
        return oldStudy;
    }

    @Override
    public Study add(Study study) {
        return repository.save(study);
    }

    @Override
    public Study getById(Long id) throws NoEntityException {
        return repository.findById(id)
                .orElseThrow(() -> new NoEntityException(id));
    }

    @Override
    public List getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}

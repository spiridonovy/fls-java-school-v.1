package app.service;

import app.entity.Status;
import app.entity.Study;
import app.exception.NoEntityException;

import java.util.Date;
import java.util.List;

public interface StudyService {

    Study updatePatient(Long id, Long patientId) throws NoEntityException;

    Study updateStatus(Long id, Status newStatus) throws NoEntityException;

    Study updateEndDate(Long id, Date endDate) throws NoEntityException;

    Study add(Study study);

    Study getById(Long id) throws NoEntityException;

    List getAll();

    void delete(Long id);
}

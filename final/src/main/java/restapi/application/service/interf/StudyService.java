package restapi.application.service.interf;

import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Study;

import java.util.List;

public interface StudyService {
    List getAll() throws NoContentException;

    Study getStudyById(Long id) throws ItemNotFoundException;

    Study addStudy(Study study);

    Study updateStudy(Long id, String status) throws ItemNotFoundException;
}

package application.services;

import application.models.Study;

import java.util.List;

public interface StudyService {
    List getAllStudies();

    Study addStudy(Study study);

    Study updateStudy(Long id,String status);
 }

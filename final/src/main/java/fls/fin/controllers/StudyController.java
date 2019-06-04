package fls.fin.controllers;

import fls.fin.api.StudyRepository;
import fls.fin.entity.Study;
import fls.fin.lib.Status;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class StudyController {
    private StudyRepository repo;

    @GetMapping("/studies/{id}")
    @ResponseBody
    public Study findById(@PathVariable Long id) {
        try {
            Optional<Study> study = repo.findById(id);
            return study.get();
        } catch (Exception e) {
            System.out.println("Could not get the study by id");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/studies")
    @ResponseBody
    public ArrayList<Study> findByName(@RequestParam String name) {
        try {
            return repo.findByName(name);
        } catch (Exception e) {
            System.out.println("Could not get studies by name");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @GetMapping("/studies")
    @ResponseBody
    public ArrayList<Study> findAll() {
        try {
            return repo.findAll();
        } catch (Exception e) {
            System.out.println("Could not get studies");
            System.out.println("Cause: " + e.getMessage());
        }
        return null;
    }

    @PostMapping("/studies")
    @ResponseBody
    public Study saveStudy(@RequestBody Study study) {
        return repo.save(study);
    }

    @PostMapping("/studies")
    @ResponseBody
    public Study scheduleStudy(@RequestBody Study study) {
        return repo.save(study);
    }

    @PostMapping("/studies")
    @ResponseBody
    public Study updateStudy(@RequestBody Study study) {
        return repo.save(study);
    }

    @PostMapping("/studies")
    @ResponseBody
    public Study updateStudyStatusById(@PathVariable Long id, Status status) {
        Study aimStudy = findById(id);
        aimStudy.setStatus(status);
        return updateStudy(aimStudy);
    }

    @PostMapping("/studies/{id}")
    @ResponseBody
    public Study updateStadyStatus(@RequestBody Study study, Status status) {
        study.setStatus(status);
        return updateStudy(study);
    }

    @DeleteMapping("/studies/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    @DeleteMapping("/studies")
    public void delete(@RequestBody Study study) {
        repo.delete(study);
    }
}

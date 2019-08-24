package app.service;

import app.entity.Doctor;
import app.exception.NoEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository repository;

    @Override
    public Doctor update(Long id, Doctor newDoctor) throws NoEntityException {
        Doctor oldDoctor = repository.findById(id)
                .map(doctor -> {
                    doctor.setName(newDoctor.getName());
                    return repository.save(doctor);
                })
                .orElseGet(() -> {
                    newDoctor.setId(id);
                    return repository.save(newDoctor);
                });
        return oldDoctor;
    }

    @Override
    public Doctor add(Doctor doctor) {
        return repository.save(doctor);
    }

    @Override
    public Doctor getById(Long id) throws NoEntityException {
        return  repository.findById(id).
                orElseThrow(() -> new NoEntityException(id));
    }

    @Override
    public List getAll()  {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}


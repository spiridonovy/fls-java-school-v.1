package restapi.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import restapi.application.exception.ItemNotFoundException;
import restapi.application.exception.NoContentException;
import restapi.application.model.Doctor;
import restapi.application.repository.DoctorRepository;
import restapi.application.service.interf.DoctorService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DoctorServiceImpl implements DoctorService {

    final private DoctorRepository doctorRepository;

    @Override
    public List getAll() throws NoContentException {
        List list = doctorRepository.findAll();
        if (list.isEmpty()) throw new NoContentException();
        return list;
    }

    @Override
    public Doctor getDoctorById(Long id) throws ItemNotFoundException {
        return doctorRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}

package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import app.entity.Doctor;
import app.exception.NoEntityException;
import org.springframework.web.bind.annotation.*;
import app.service.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private DoctorService service;

    @Autowired
    public DoctorController(DoctorService doctorService){
        this.service = doctorService;
    }

    @GetMapping("/all")
    public List getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Doctor geById(@PathVariable(value = "id") Long id) throws NoEntityException {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Doctor update(@PathVariable Long id , @RequestBody String name) throws NoEntityException {
        return service.update(id, new Doctor(name));
    }

    @PostMapping("/new")
    public Doctor add(@RequestBody String name){
        return service.add(new Doctor(name));
    }

    @DeleteMapping("/doctors/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}

package com.projectSchool.projectSchool.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.projectSchool.projectSchool.exception.NotFoundException;
import com.projectSchool.projectSchool.model.Faculty;
import com.projectSchool.projectSchool.repository.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private static final Logger logger = LoggerFactory.getLogger(FacultyService.class);
    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty getById(Long id) {
        logger.info("invoked method getById");
        return facultyRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Collection<Faculty> getAll() {
        logger.info("invoked method getAll");
        return facultyRepository.findAll();
    }

    public Collection<Faculty> getByColor(String color) {
        logger.info("invoked method getByColor");
        return facultyRepository.findAllByColor(color);
    }

    public Collection<Faculty> getByColorOrName(String color, String name) {
        logger.info("invoked method getByColorOrName");
        return facultyRepository.findAllByColorIgnoreCaseOrNameIgnoreCase(color, name);
    }

    public Faculty create(Faculty faculty) {
        logger.info("invoked method create");
        return facultyRepository.save(faculty);
    }

    public Faculty update(Long id, Faculty faculty) {
        logger.info("invoked method update");

        Faculty existingFaculty = facultyRepository.findById(id).orElseThrow(NotFoundException::new);
        if (faculty.getColor() != null) {
            existingFaculty.setColor(faculty.getColor());
        }
        if (faculty.getName() != null) {
            existingFaculty.setName(faculty.getName());
        }
        return facultyRepository.save(existingFaculty);
    }
    public Faculty remove(Long id) {
        logger.info("invoked method remove");
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(NotFoundException::new);

        facultyRepository.delete(faculty);
        return faculty;
    }

    public Faculty getByStudentId(Long studentId) {
        logger.info("invoked method getByStudentId");
        return facultyRepository.findByStudent_Id(studentId).orElseThrow(NotFoundException::new);

    }


}

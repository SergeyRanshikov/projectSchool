package com.projectSchool.projectSchool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.projectSchool.projectSchool.model.Faculty;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    List<Faculty> findAllByColor(String Color);

    List<Faculty> findAllByColorIgnoreCaseOrNameIgnoreCase(String color, String name);


    Optional<Faculty> findByStudent_Id(Long studentId);
}

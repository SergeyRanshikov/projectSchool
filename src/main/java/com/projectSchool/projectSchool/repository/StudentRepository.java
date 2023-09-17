package com.projectSchool.projectSchool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.projectSchool.projectSchool.model.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByAge(Integer Age);

    List<Student> findAllByAgeBetween(int win, int max);
    List<Student> findAllByFaculty_Id(Long facultyId);

    @Query(value = "select count(*) from student", nativeQuery = true)
    long countStudents();

    @Query(value = "select avg(age) from student", nativeQuery = true)
    double averageAge();

    @Query(value = "select * from student order by id desc limit :quantity", nativeQuery = true)
    List<Student> findLastStudents(@Param("quantity") int n);

}

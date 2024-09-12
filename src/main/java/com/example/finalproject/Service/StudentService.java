package com.example.finalproject.Service;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.DTO.StudentDTO;
import com.example.finalproject.Model.Student;
import com.example.finalproject.Model.User;
import com.example.finalproject.Repository.AuthRepository;
import com.example.finalproject.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final AuthRepository authRepository;
    private final StudentRepository studentRepository;


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void studentRegister(StudentDTO studentDTO) {
        User user = new User();

       // user.setName(studentDTO.getName());
        user.setUsername(studentDTO.getUsername());
        user.setPassword(studentDTO.getPassword());
       // user.setPassword(new BCryptPasswordEncoder().encode(studentDTO.getPassword()));
        user.setEmail(studentDTO.getEmail());
        user.setRole("STUDENT");
        //user.setRole(studentDTO.getRole());
        user.setAge(studentDTO.getAge());
        user.setGender(studentDTO.getGender());
        user.setEducation_level(studentDTO.getEducation_level());
        user.setDateOfBirth(studentDTO.getDateOfBirth());
        user.setRegistrationDate(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());



        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
         // student.setEnrolled(studentDTO.isEnrolled());
        //student.setEnrollmentDate(LocalDate.now());


        student.setUser(user);
        user.setStudent(student);

        studentRepository.save(student);
        authRepository.save(user);
    }


    public void updateStudent (StudentDTO studentDTO ,Integer auth_id){
        User user = authRepository.findUserById(auth_id);
        if(user == null){
            throw new ApiException("Student id not found");
        }
        user.setUsername(studentDTO.getUsername());
        user.setPassword(studentDTO.getPassword());
        // user.setPassword(new BCryptPasswordEncoder().encode(studentDTO.getPassword()));
        user.setEmail(studentDTO.getEmail());
        user.setEmail(studentDTO.getEmail());
        user.setAge(studentDTO.getAge());
        user.setGender(studentDTO.getGender());
        user.setEducation_level(studentDTO.getEducation_level());
        user.setDateOfBirth(studentDTO.getDateOfBirth());
        user.setUpdatedAt(LocalDate.now());

        user.getStudent().setFirstName(studentDTO.getFirstName());
        user.getStudent().setLastName(studentDTO.getLastName());
        user.getStudent().setPhoneNumber(studentDTO.getPhoneNumber());
       // user.getStudent().setEnrolled(studentDTO.isEnrolled());

        user.getStudent().setUser(user);

        authRepository.save(user);
    }

    public void deleteStudent(Integer auth_id){
        User user = authRepository.findUserById(auth_id);
        Student student =  studentRepository.findStudentById(auth_id);

        if(user.getId() != auth_id){
            throw new ApiException("Student id doesn't match");
        }
        authRepository.delete(user);
        studentRepository.delete(student);
    }



}

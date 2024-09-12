package com.example.finalproject.Service;


import com.example.finalproject.Api.ApiException;
import com.example.finalproject.DTO.TutorDTO;
import com.example.finalproject.Model.Tutor;
import com.example.finalproject.Model.User;
import com.example.finalproject.Repository.AuthRepository;
import com.example.finalproject.Repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorService {
    private final TutorRepository tutorRepository;
    private final AuthRepository authRepository;

    public List<Tutor> getAllTutors() {
        return tutorRepository.findAll();
    }

    public void registerTutor(TutorDTO tutorDTO) {
        User user = new User();

        user.setUsername(tutorDTO.getUsername());
        user.setPassword(tutorDTO.getPassword());
        // user.setPassword(new BCryptPasswordEncoder().encode(studentDTO.getPassword()));
        user.setEmail(tutorDTO.getEmail());
        user.setRole("TUTOR");
       // user.setRole(tutorDTO.getRole());
        user.setAge(tutorDTO.getAge());
        user.setGender(tutorDTO.getGender());
        user.setEducation_level(tutorDTO.getEducation_level());
        user.setDateOfBirth(tutorDTO.getDateOfBirth());
        user.setRegistrationDate(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());


        Tutor tutor = new Tutor();
        tutor.setFirstName(tutorDTO.getFirstName());
        tutor.setLastName(tutorDTO.getLastName());
        tutor.setPhoneNumber(tutorDTO.getPhoneNumber());
        tutor.setMajor(tutorDTO.getMajor());
        tutor.setSubject(tutorDTO.getSubject());
        tutor.setGpa(tutorDTO.getGpa());
        tutor.setWorkPermit_id(tutorDTO.getWorkPermit_id());
        tutor.setBio(tutorDTO.getBio());
       // tutor.setHasRecommendations(tutorDTO.isHasRecommendations());

        tutor.setUser(user);
        user.setTutor(tutor);

        authRepository.save(user);
        tutorRepository.save(tutor);
    }

    public void updateTutor(TutorDTO tutorDTO, Integer auth_id) {
        User user = authRepository.findUserById(auth_id);
        if (user == null) {
            throw new ApiException("Tutor id  not found");
        }
        user.setUsername(tutorDTO.getUsername());
        user.setPassword(tutorDTO.getPassword());
        user.setEmail(tutorDTO.getEmail());
        user.setAge(tutorDTO.getAge());
        user.setGender(tutorDTO.getGender());
        user.setEducation_level(tutorDTO.getEducation_level());
        user.setDateOfBirth(tutorDTO.getDateOfBirth());
        user.setUpdatedAt(LocalDate.now());

        user.getTutor().setFirstName(tutorDTO.getFirstName());
        user.getTutor().setLastName(tutorDTO.getLastName());
        user.getTutor().setPhoneNumber(tutorDTO.getPhoneNumber());
        user.getTutor().setMajor(tutorDTO.getMajor());
        user.getTutor().setSubject(tutorDTO.getSubject());
        user.getTutor().setGpa(tutorDTO.getGpa());
        user.getTutor().setWorkPermit_id(tutorDTO.getWorkPermit_id());
        user.getTutor().setBio(tutorDTO.getBio());


        authRepository.save(user);
    }

    public void deleteTutor(Integer auth_id) {
        User user = authRepository.findUserById(auth_id);
        Tutor tutor = tutorRepository.findTutorById(auth_id);
        if(user.getId() != auth_id){
            throw new ApiException("Tutor id not found");
        }
        authRepository.delete(user);
        tutorRepository.delete(tutor);
    }



}

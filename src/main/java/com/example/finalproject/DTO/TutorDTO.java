package com.example.finalproject.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class TutorDTO {


    @NotEmpty(message = "First name should not be empty!")
    @Column(columnDefinition = "varchar(20) not null")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty!")
    @Column(columnDefinition = "varchar(20) not null")
    private String lastName;

    @NotEmpty(message = "username should not be EMPTY!")
    @Size(min=4 , max=10 , message = "user name size should be between 4 - 10")
    private String username;


    @NotEmpty(message = "password should not be empty!")
    private String password;

    @NotEmpty(message ="Phone number cannot be null")
    private String phoneNumber;

    @Email
    @NotEmpty(message = "Email should not be EMPTY!")
    private String email;

    @NotNull(message = "Age should not be Null!")
    private int age;

    @NotNull(message = "Date of birth date should not be Empty!")
    @JsonFormat(pattern= "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate dateOfBirth;


    @NotEmpty(message = "Gender should not be Empty!")
    @Pattern(regexp = "^(Male|Female)$", message = "Two valid inputs only, Male or Female" )
    private String gender;


   // @NotEmpty(message = "Role should not be EMPTY!")
    @Pattern(regexp = "^(STUDENT|TUTOR|ADMIN)$", message = "Role has 3 valid inputs only(STUDENT,TUTOR,ADMIN).")
    private String role;

    @NotEmpty(message = "Education level should not be EMPTY!")
    private String education_level; //UnderGraduate


    private LocalDate registrationDate;

    //updated_at: Timestamp for the last profile update.
    private LocalDate updatedAt;


    @NotEmpty(message = "major should not be empty!")
    private String major;

    @NotEmpty(message = "subject should not be empty!")
    private String subject;

    @NotNull(message = "Gpa should not be null!")
    private double gpa;

    @NotEmpty(message = "WorkPermit id should not be empty!")
    private String workPermit_id;

    @NotEmpty(message = "Bio should not be empty!")
    private String bio;

    //@AssertFalse
    private boolean hasRecommendations;





}

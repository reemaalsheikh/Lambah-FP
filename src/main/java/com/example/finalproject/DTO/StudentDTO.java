package com.example.finalproject.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StudentDTO {

    @NotEmpty(message = "First name should not be empty!")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty!")
    private String lastName;


    @NotEmpty(message = "username should not be EMPTY!")
    private String username;


    @NotEmpty(message = "password should not be empty!")
    private String password;


    @NotEmpty(message ="Phone number cannot be null")
    private String phoneNumber;

    @Email
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


    //@NotEmpty(message = "Role should not be EMPTY!")
    @Pattern(regexp = "^(STUDENT|TUTOR|ADMIN)$", message = "Role has 3 valid inputs only(STUDENT,TUTOR,ADMIN).")
    private String role;

    @NotEmpty(message = "Education level should not be EMPTY!")
    private String education_level; //UnderGraduate


    private LocalDate registrationDate;

    //updated_at: Timestamp for the last profile update.
    private LocalDate updatedAt;


    @AssertFalse
    private boolean isEnrolled;

    private LocalDate enrollmentDate;







}

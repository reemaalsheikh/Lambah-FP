package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Tutor {

    @Id
    private Integer id;

    @NotEmpty(message = "First name should not be empty!")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty!")
    private String lastName;

    @NotEmpty(message = "major should not be empty!")
    @Size(min=2 , max = 20, message = "Length must be between 2 and 20 characters")
    @Column(columnDefinition = "varchar(50) not null")
    private String major;

    @NotEmpty(message ="Phone number cannot be null")
    @Pattern(regexp = "^(05|0)[0-9]{8}$" ,message = " Phone number Must start with 05, consists of exactly 10 digits")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String phoneNumber;

    @NotEmpty(message = "subject should not be empty!")
    @Size(min=2 , max = 20, message = "Length must be between 2 and 20 characters")
    @Column(columnDefinition = "varchar(50) not null")
    private String subject;

    @NotNull(message = "Gpa should not be null!")
    @Column(columnDefinition = "DOUBLE not null")
    private double gpa;

    @NotEmpty(message = "WorkPermit id should not be empty!")
    @Column(columnDefinition = "varchar(50) not null")
    private String workPermit_id;

    @NotEmpty(message = "Bio should not be empty!")
    @Column(columnDefinition = "varchar(100) not null")
    private String bio;

    //@AssertFalse
    @Column(columnDefinition = "boolean default false")
    private boolean hasRecommendations;


    //Relations
    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;


    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    private Set<Course> courses;


//    @OneToMany(mappedBy = "tutor")
//    private List<Session> sessions;
//
//    @OneToMany(mappedBy = "tutor")
//    private List<Exam> exams;


}

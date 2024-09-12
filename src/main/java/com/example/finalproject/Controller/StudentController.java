package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.DTO.StudentDTO;
import com.example.finalproject.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getAllStudents(){
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }

    @PostMapping("/register")
    public ResponseEntity studentRegister(@RequestBody @Valid StudentDTO studentDTO){
        studentService.studentRegister(studentDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Student registered successfully!"));

    }
    @PutMapping("/update/{auth_id}")
    public ResponseEntity updateStudent(@RequestBody @Valid StudentDTO studentDTO , @PathVariable Integer auth_id){
       studentService.updateStudent(studentDTO, auth_id);
       return ResponseEntity.status(200).body(new ApiResponse("Student updated successfully!"));
    }

    @DeleteMapping("/delete/{auth_id}")
    public ResponseEntity deleteStudent( @PathVariable Integer auth_id){
        studentService.deleteStudent(auth_id);
        return ResponseEntity.status(200).body(new ApiResponse("Student deleted successfully!"));
    }


}

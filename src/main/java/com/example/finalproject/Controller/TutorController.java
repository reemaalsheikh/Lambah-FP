package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.DTO.TutorDTO;
import com.example.finalproject.Repository.TutorRepository;
import com.example.finalproject.Service.TutorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tutor")
@RequiredArgsConstructor
public class TutorController {
    private final TutorService tutorService;

    @GetMapping("/get")
    public ResponseEntity getAllTutors(){
        return ResponseEntity.status(200).body(tutorService.getAllTutors());
    }

    @PostMapping("/register")
    public ResponseEntity tutorRegister(@RequestBody @Valid TutorDTO tutorDTO){
        tutorService.registerTutor(tutorDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Tutor registered successfully!"));
    }

    @PutMapping("/update/{auth_id}")
    public ResponseEntity updateTutors(@RequestBody @Valid TutorDTO tutorDTO, @PathVariable Integer auth_id){
        tutorService.updateTutor(tutorDTO,auth_id);
        return ResponseEntity.status(200).body(new ApiResponse("Tutor updated successfully!"));
    }

    @DeleteMapping("/delete/{auth_id}")
    public ResponseEntity deleteTutors( @PathVariable Integer auth_id){
        tutorService.deleteTutor(auth_id);
        return ResponseEntity.status(200).body(new ApiResponse("Tutor deleted successfully!"));
    }


}

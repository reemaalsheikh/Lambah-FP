package com.example.finalproject.Service;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.Model.Course;
import com.example.finalproject.Model.Tutor;
import com.example.finalproject.Repository.CourseRepository;
import com.example.finalproject.Repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TutorRepository tutorRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    //assign course to tutor
    public void addCourse(Course course, Integer tutor_id) {
    Tutor tutor = tutorRepository.findTutorById(tutor_id);
    if (tutor == null) {
        throw  new ApiException("Customer not found");
    }
    course.setTutor(tutor);
    courseRepository.save(course);

    }

    public void updateCourse(Course course, Integer course_id) {
        Course course1 = courseRepository.findCourseById(course_id);
        if (course1 == null) {
            throw  new ApiException("Course not found");
        }
        course1.setName(course.getName());
        course1.setDescription(course.getDescription());
        course1.setDuration(course.getDuration());
        course1.setLearningMethod(course.getLearningMethod());
        course1.setSubject(course.getSubject());
        courseRepository.save(course1);

    }
    public void deleteCourse(Integer course_id) {
        Course course = courseRepository.findCourseById(course_id);
        if (course == null) {
            throw  new ApiException("Course not found");
        }
        courseRepository.delete(course);
    }

}

package com.devvali.cruddemo.entity.dao;

import com.devvali.cruddemo.entity.Course;
import com.devvali.cruddemo.entity.Instructor;
import com.devvali.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findInstructorbyId(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);


    void deleteInstructorDetailbyId(int theId);


    List<Course>findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);



}

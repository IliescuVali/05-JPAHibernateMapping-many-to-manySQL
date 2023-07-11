package com.devvali.cruddemo;

import com.devvali.cruddemo.entity.Course;
import com.devvali.cruddemo.entity.Instructor;
import com.devvali.cruddemo.entity.InstructorDetail;
import com.devvali.cruddemo.entity.dao.AppDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner->{
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);

			//findInstructorDetail(appDAO);

			//deleteInstructorDetail(appDAO);

			//createInstructorWithCourses(appDAO);

			//findInstructorWithCourses(appDAO);

			findCoursesForInstructor(appDAO);



		};
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theID=1;
		//find instructor
		System.out.println("Finding instructor id " +theID);

		Instructor tempInstructor= appDAO.findInstructorbyId(theID);

		System.out.println("tempInstructor: " +tempInstructor);

		//find courses for instructor
		System.out.println("Finding courses for instructor id: " +theID);

		List<Course> courses=appDAO.findCoursesByInstructorId(theID);

		//associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theID=1;
		System.out.println("Finding instructor id " +theID);
		Instructor tempInstructor= appDAO.findInstructorbyId(theID);
		System.out.println("tempInstructor: " +tempInstructor);
		System.out.println("the assciated courses: " +tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=new Instructor
				("Susan", "Public", "susan@gmail.com");

		//create the instructor detail
		InstructorDetail tempInstructorDetail=
				new InstructorDetail(
						"http://www.youtube.com", "Video Games");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//create some courses
		Course tempCourse1=new Course("Air Guitar-The Ultmate Guide");
		Course tempCourse2=new Course("The Pinball MasterClass");
		Course tempCourse3=new Course("Spring MAsterClass");

		//add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		//save the instructor
		//
		//NOTE: this will ALSO save the courses
		//because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor: " +tempInstructor);
		System.out.println("The courses: " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=3;
		System.out.println("Deleting instructor detail id:" +theId);
		appDAO.deleteInstructorDetailbyId(theId);
		System.out.println("Done");

	}

	private void findInstructorDetail(AppDAO appDAO) {
		//get the instructor detail object

		int theId=2;
		InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailById(theId);

		//print the instructor detail

		System.out.println("tempInstructorDetail" +tempInstructorDetail);

		//print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
		System.out.println("Done!");

	}

	private void deleteInstructor(AppDAO appDAO) {

		int theId=1;
		System.out.println("Deleting instructor id: " +theId);
		appDAO.deleteInstructorById(theId);

		System.out.println("Done");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId=2;
		System.out.println("Finding instructor id : " +theId);

		Instructor tempInstructor=appDAO.findInstructorbyId(theId);
		System.out.println("tempInstructor: " +tempInstructor);
		System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

		/*
		//create the instructor
		Instructor tempInstructor=new Instructor
				("Nicola", "Tesla", "tesla@gmail.com");

		//create the instructor detail
		InstructorDetail tempInstructorDetail=
				new InstructorDetail(
						"http://www.youtube.com", "code");
		//associate the objects


		 */
		Instructor tempInstructor=new Instructor
				("Madhu", "Petel", "madhu@gmail.com");

		//create the instructor detail
		InstructorDetail tempInstructorDetail=
				new InstructorDetail(
						"http://www.youtube.com", "Guitar");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		//save the instructor
		//
		//NOTE: this will ALSO save the detail object
		//because of CascadeType.ALL

		System.out.println("Saving instructor: " +tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");

	}

}

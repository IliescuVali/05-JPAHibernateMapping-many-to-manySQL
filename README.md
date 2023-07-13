# 05-JPAHibernateMapping-many-to-manySQL
Here we have an app with Students, Instructors, Instructors Details, Courses, Reviews for Courses, and also the alocated Courses for Each Student. 
Steps to run this app:
1.Create a connection in workbench with user and password: springstudent
2.run the script from hb-05-many to many in Workbanch.
Take a look at the diagram:
![many_to_many](https://github.com/IliescuVali/05-JPAHibernateMapping-many-to-manySQL/assets/122371102/7628d0d2-09d3-428f-9df9-dd8dd34bb282)



3.run the code in your IDE, verify in the application.properties if you have the same connection for the SQL.
After that, follow the implementation from :
@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner->{

			//createCourseAndStudents(appDAO);

			//findCourseAndStudents(appDAO);

			//findStudentandCourses(appDAO);

			//addMoreCoursesForStudent(appDAO);

			//deleteCourse(appDAO);

			deleteStudent(appDAO).

   4.You can uncomment every action and you can verify also the implementation for every method.

   

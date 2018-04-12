package Model;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database {

    private static List<Student> students = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();
    private static List<Grade> grades = new ArrayList<>();


    public Database(){

        courses.add(new Course("Gościowanie", "Karol Karolek"));
        courses.add(new Course("Pomidor", "Smarki smark"));
        courses.add(new Course("Duze elo bęc", "Tiger Bonzo"));


        grades.add(new Grade((float)3, getCourseById(1)));
        grades.add(new Grade((float)4, getCourseById(2)));
        grades.add(new Grade((float)5, getCourseById(3)));

        students.add(new Student("Kamik", "Kamilek", new Date(1995, 11, 21), grades));


//        students.add(new Student("Kuba", "Kubalski", new Date(1995, 12, 24), grades));
//        students.add(new Student("Kajetan", "Kajetanowicz", new Date(1994, 4, 1), grades));



    }

    public List<Student> getStudents(){
        return students;
    }

    public Student getStudentByIndex(int index){
        for(Student student : students) {
            if (student.getIndex() == index) return student;
        }
        return null;
    }

    public List<Grade> getGradesOfStudent(int index) {
        for(Student student : students) {
            if(student.getIndex() == index)
                return student.getGrades();
        }
        return null;
    }

    public Grade getGradeofStudent(int index, int id){
        for (Student student : students) {
            if (student.getIndex() == index){
                for( Grade grade : grades) {
                    if (grade.getId() == id) return grade;
                }
            }
        }
        return null;
    }

    public void postStudent(Student student){
        students.add(student);
    }

    public javax.ws.rs.core.Response putStudent(int index, Student newStudent){
        for (Student student : students) {
            if (student.getIndex() == index){
                student.setFirstname(newStudent.getFirstname());
                student.setLastname(newStudent.getLastname());
                student.setBirthday(newStudent.getBirthday());
                student.setIndex(newStudent.getIndex());
                student.setGrades(newStudent.getGrades());
                return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.OK).build();
            }
        }
        students.add(newStudent);
        return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.CREATED).build();
    }

    public javax.ws.rs.core.Response deleteStudent(int index) {
        if(students.remove(getStudentByIndex(index))){
            return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.OK).build();
        }else return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.NO_CONTENT).build();
    }

    public static List<Course> getCourses() {
        return courses;
    }

    public Course getCourseById(int id){
        for (Course course : courses) {
            if(course.getId() == id) return course;
        }
        return null;
    }

    private Course getCourseByName(String name){
        for (Course course : courses) {
            if (course.getName() == name) return course;
        }
        return null;
    }

    public void postCourse (Course course) {
        courses.add(course);
    }

    public javax.ws.rs.core.Response putCourse(int id, Course newCourse) {
        for (Course course : courses) {
            if (course.getId() == id) {
                course.setName(newCourse.getName());
                course.setLecturer(newCourse.getLecturer());
                course.setId(newCourse.getId());
                return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.OK).build();
            }
        }
        courses.add(newCourse);
        return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.CREATED).build();
    }


    public javax.ws.rs.core.Response deleteCourse(int id){
        if (courses.remove(getCourseById(id)))
            return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.OK).build();
        else return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.NO_CONTENT).build();
    }


    public void postGrade(int index, Grade grade){
        for (Student student : students) {
            if (student.getIndex() == index) {
                List<Grade> _grades = student.getGrades();
                _grades.add(grade);
                student.setGrades(_grades);
            }
        }
    }

    public javax.ws.rs.core.Response putGrade(int index, int id, Grade newGrade) {
        for(Student student : students) {
            if (student.getIndex() == index) {
                for (Grade grade : student.getGrades()){
                    if (grade.getId() == id){
                        grade.setValue(newGrade.getValue());
                        grade.setCourse(newGrade.getCourse());
                        grade.setDate(newGrade.getDate());
                        grade.setId(newGrade.getId());
                        return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.OK).build();
                    }
                }

                List<Grade> _grades = student.getGrades();
                _grades.add(newGrade);
                student.setGrades(_grades);
                return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.CREATED).build();
            }
        }
        return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.NO_CONTENT).build();
    }

    public javax.ws.rs.core.Response deleteGrade(int index, int id){
        for(Student student : students){
            if (student.getIndex() == index){
                if(student.getGrades().remove(getGradeofStudent(index, id)))
                    return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.OK).build();
                else
                    return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.NO_CONTENT).build();
            }
        }
        return javax.ws.rs.core.Response.status(javax.ws.rs.core.Response.Status.NO_CONTENT).build();
    }

}


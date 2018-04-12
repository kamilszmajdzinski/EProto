package Main;

//

import Model.Course;
import Model.Database;
import Model.Grade;
import Model.Student;

import javax.ws.rs.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class Service {

    private final Database dataBase = new Database();
    private final List<Student> studentList = dataBase.getStudents();

    @GET
    @Path("/students")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> getStudents(){
        try{
            return studentList;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @GET
    @Path("/students/{index}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Student getStudentByIndex(@PathParam("index") int index){
        return dataBase.getStudentByIndex(index);
    }

    @GET
    @Path("/students/{index}/grades")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Grade> getStudentGrades(@PathParam("index") int index){
        return dataBase.getGradesOfStudent(index);
    }
    @GET
    @Path("/students/{index}/grades/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Grade getStudentGrade(@PathParam("index") int index, @PathParam("id") int id){
        return dataBase.getGradeofStudent(index, id);
    }

    @GET
    @Path("/courses")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Course> getCourses(){
        return dataBase.getCourses();
    }

    @GET
    @Path("/courses/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Course getCourses(@PathParam("id") int id){
        return dataBase.getCourseById(id);
    }


    ////////////////////////////////////////
    @POST
    @Path("/students")
    public Response postStudent(Student student){
        dataBase.postStudent(student);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/courses")
    public Response postCourse(Course course){
        dataBase.postCourse(course);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/students/{index}/grades")
    public Response postGrade(@PathParam("index") int index, Grade grade){
        dataBase.postGrade(index, grade);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("students/{index}")
    public Response putStudent(@PathParam("index") int index, Student student){
        return dataBase.putStudent(index, student);
    }

    @PUT
    @Path("courses/{id}")
    public Response putStudent(@PathParam("id") int id, Course course){
        return dataBase.putCourse(id, course);
    }

    @PUT
    @Path("/students/{index}/grades/{id}")
    public Response putGrade(@PathParam("index") int index, @PathParam("id") int id, Grade grade){
        return dataBase.putGrade(index, id, grade);
    }

    @DELETE
    @Path("/students/{index}")
    public Response deleteStudent(@PathParam("index") int index){
        return dataBase.deleteStudent(index);
    }

    @DELETE
    @Path("/courses/{id}")
    public Response deleteCourse(@PathParam("id") int id){
        return dataBase.deleteCourse(id);
    }

    @DELETE
    @Path("/students/{index}/grades/{id}")
    public Response deleteGrade(@PathParam("index") int index, @PathParam("id") int id){
        return dataBase.deleteGrade(index, id);
    }

}


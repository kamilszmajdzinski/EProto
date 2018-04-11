package Model;

import java.util.concurrent.atomic.AtomicInteger;

public class Course {
    private static final AtomicInteger count = new AtomicInteger(0);
    private String name;
    private String lecturer;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course(){
        this.id = count.incrementAndGet();
    }

    public Course(String name, String lecturer){
        this.name = name;
        this.lecturer = lecturer;
        this.id = count.incrementAndGet();
    }

}

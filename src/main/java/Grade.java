import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Grade {
    private float value;
    private Date date;
    private Course course;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;


    public float getValue() {
        return value;
    }

    public Date getDate() {
        return date;
    }

    public Course getCourse() {
        return course;
    }

    public int getId() {
        return id;
    }

    public Grade(){
        this.id = count.incrementAndGet();
        this.date = new Date();
    }

    public Grade(float value, Course course) {
        this.value = value;
        this.date = new Date();
        this.course = course;
        this.id = count.incrementAndGet();
    }

}
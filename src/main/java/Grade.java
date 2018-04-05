import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Grade {
    private float value;
    private Date date;
    private Course course;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;


    public Grade(float value, Date date, Course course) {
        this.value = value;
        this.date = new Date();
        this.course = course;
        this.id = count.incrementAndGet();
    }

}
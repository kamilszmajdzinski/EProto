package Model;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@XmlRootElement
public class Grade {
    private float value;
    private Date date;
    private Course course;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int studentIndex;
    private int id;

    @InjectLinks({
            @InjectLink(value = "/students/{studentIndex}/grades/{id}", rel = "self"),
            @InjectLink(value = "/students/{studentIndex}/grades", rel = "parent")
    })
    @XmlElement(name = "link")
    @XmlElementWrapper(name = "links")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    List<Link> links;

    public void setValue(float value) {
        this.value = value;
    }

    @XmlTransient
    public int getStudentIndex() {
        return studentIndex;
    }

    public void setStudentIndex(int studentIndex) {
        this.studentIndex = studentIndex;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Grade(float value, Course course, int studentIndex) {
        this.value = value;
        this.date = new Date();
        this.course = course;
        this.id = count.incrementAndGet();
        this.studentIndex = studentIndex;
    }

}
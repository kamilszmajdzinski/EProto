package Model;

import org.glassfish.jersey.linking.InjectLink;
import org.glassfish.jersey.linking.InjectLinks;
import org.mongodb.morphia.annotations.Entity;

import javax.ws.rs.core.Link;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@XmlRootElement
@Entity("students")
public class Student {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int index;
    private String firstname;
    private String lastname;
    private Date birthday;
    private List<Grade> grades = new ArrayList<>();


    @InjectLinks({
            @InjectLink(value = "/students/{index}", rel = "self"),
            @InjectLink(value = "/students", rel = "parent"),
            @InjectLink(value = "/students/{index}/grades", rel = "grades")
    })
    @XmlElement(name = "link")
    @XmlElementWrapper(name = "links")
    @XmlJavaTypeAdapter(Link.JaxbAdapter.class)
    List<Link> links;

    public Student(){

    }


    public Student(String firstname, String lastname, Date birthday, List<Grade> grades) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.index = count.incrementAndGet();
        this.grades = grades;

    }
@XmlAttribute
    public int getIndex() {
        return index;
    }
@XmlElement
    public List<Grade> getGrades() {
        return grades;
    }

    public void setIndex(int index) {this.index = index;}

    public void setGrades(List<Grade> grades) { this.grades = grades; }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    @XmlElement
    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    @XmlElement
    public String getLastname() {
        return lastname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    @XmlElement
    public Date getBirthday() {
        return birthday;
    }

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

}


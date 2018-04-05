import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int index;
    private String firstname;
    private String lastname;
    private Date birthday;
    private List<Grade> grades = new ArrayList<Grade>();

    public Student(String firstname, String lastname, Date birthday) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;

    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return birthday;
    }
}

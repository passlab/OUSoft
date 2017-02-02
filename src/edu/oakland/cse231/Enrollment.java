package edu.oakland.cse231;

/**
 * Created by yy8 on 2/2/17.
 */
public class Enrollment {
    Student student;
    Course course;
    Enrollment link;

    public Enrollment(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.link = null;
    }

    public Enrollment getLink() {
        return link;
    }

    public void setLink(Enrollment link) {
        this.link = link;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
}

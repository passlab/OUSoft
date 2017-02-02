package edu.oakland.cse231;

/**
 * Created by yy8 on 2/2/17.
 */
public class OUSoft {
    int maxNumStudents = 40000;
    int maxNumInstructors = 2000;
    int maxNumCourses = 10000;
    int lastStudent = -1;
    int lastInstructor = -1;
    int lastCourse = -1;

    Student [] allStudents;
    Instructor[] allInstructors;
    Course[] allCourses;

    Enrollment allEnrollments;

    public OUSoft() {
        allStudents = new Student[maxNumStudents];
        allCourses = new Course[maxNumCourses];
        allInstructors = new Instructor[maxNumInstructors];

        allEnrollments = null;
    }

    void addStudent(Student st) {
        lastStudent++;
        allStudents[lastStudent] = st;
    }

    boolean addStudent(String firstName, String lastName, int id) {
        int i = 0;
        while (i<=lastStudent) {
            if (allStudents[i].getId() == id) {
                /* report exception that a student with the same id already exists in the database */
                return false;
            }
        }

        addStudent(new Student(firstName, lastName, id));

        return true;
    }

    void removeStudent(Student st) {
        int i = 0;
        while (i<=lastStudent) {
            if (allStudents[i] == st) {
                allStudents[i] = allStudents[lastStudent];
                lastStudent --;
                return;
            }
        }
    }

    /* precondition: Student is a valid student object
       course is a valid course object

       erro checking: if student is already enrolled, we will not put another object
     */
    boolean enroll(Student student, Course course) {
        Enrollment currNode = allEnrollments;

        while (currNode != null) {

            if (currNode.getCourse() == course && currNode.getStudent() == student) {
                return false; /* not a meaning return to the caller */
                /* better to raise exception */
            }
            currNode = currNode.getLink();
        }

        Enrollment en = new Enrollment(student, course);

        en.setLink(allEnrollments);
        allEnrollments = en;
        return true;
    }

    boolean withdraw(Student student, Course course) {
        Enrollment toBeRemoved = allEnrollments;
        Enrollment prevNode = null;

        if (toBeRemoved.getCourse() == course && toBeRemoved.getStudent() == student) {
            allEnrollments = allEnrollments.getLink();
            return true;
        }


        while (toBeRemoved != null) {

            if (toBeRemoved.getCourse() == course && toBeRemoved.getStudent() == student) {
                /* found the node to be removed */
                prevNode.setLink(toBeRemoved.getLink());
                return true;
            }
            /* before updating */
            prevNode = toBeRemoved;
            toBeRemoved = toBeRemoved.getLink();
        }

        return false;
    }

    int numEnrollment(Course course) {
        Enrollment currNode = allEnrollments;

        int count = 0;
        while (currNode != null) {

            if (currNode.getCourse() == course) {
                count ++;
                /* better to raise exception */
            }
            currNode = currNode.getLink();
        }
        return count;
    }

    void printCourses(Student student) {
        Enrollment currNode = allEnrollments;
        System.out.print("All the courses enrolle by " + student.toString());

        while (currNode != null) {

            if (currNode.getStudent() == student) {
                System.out.print(currNode.getCourse());
                /* better to raise exception */
            }
            currNode = currNode.getLink();
        }

    }



}

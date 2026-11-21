import java.util.ArrayList;
import java.util.List;

public class RegistrationSystem {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();

    public boolean addStudent(Student s) {
        if (findStudent(s.getId()) != null) return false; // duplicate ID
        students.add(s);
        return true;
    }

    public boolean addCourse(Course c) {
        if (findCourse(c.getCode()) != null) return false; // duplicate code
        courses.add(c);
        return true;
    }

    public void displayAvailableCourses() {
        boolean any = false;
        for (Course c : courses) {
            if (c.isAvailable()) {
                System.out.println(c);
                any = true;
            }
        }
        if (!any) System.out.println("No available courses.");
    }

    public String registerStudent(int studentId, String courseCode) {
        Student s = findStudent(studentId);
        Course c = findCourse(courseCode);
        if (s == null) return "Student not found.";
        if (c == null) return "Course not found.";
        if (s.isRegisteredIn(c)) return "Student is already registered in this course.";
        if (!c.isAvailable()) return "Course is full.";
        s.addCourse(c);
        c.enroll();
        return "Registration successful.";
    }

    public void displayRegisteredCourses(int studentId) {
        Student s = findStudent(studentId);
        if (s == null) {
            System.out.println("Student not found.");
            return;
        }
        if (s.getRegisteredCourses().isEmpty()) {
            System.out.println(s.getName() + " has no registered courses.");
            return;
        }
        for (Course c : s.getRegisteredCourses()) {
            System.out.println(c);
        }
    }

    private Student findStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    private Course findCourse(String code) {
        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) return c;
        }
        return null;
    }
}

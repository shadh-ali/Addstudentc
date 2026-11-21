import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static String readText(String prompt) {
        System.out.print(prompt);
        return in.nextLine().trim();
    }

    public static void main(String[] args) {
        RegistrationSystem system = new RegistrationSystem();
        int choice;

        do {
            System.out.println("\n=== Student Course Registration System ===");
            System.out.println("1. Add student");
            System.out.println("2. Add course");
            System.out.println("3. Display available courses");
            System.out.println("4. Register student in course");
            System.out.println("5. Display student's registered courses");
            System.out.println("0. Exit");
            choice = readInt("Choice: ");

            switch (choice) {
                case 1:
                    int id = readInt("Student ID: ");
                    String name = readText("Name: ");
                    String major = readText("Major: ");
                    System.out.println(system.addStudent(new Student(id, name, major))
                            ? "Student added." : "Student ID already exists.");
                    break;
                case 2:
                    String code = readText("Course code: ");
                    String cname = readText("Course name: ");
                    int hours = readInt("Credit hours: ");
                    int cap = readInt("Capacity: ");
                    System.out.println(system.addCourse(new Course(code, cname, hours, cap))
                            ? "Course added." : "Course code already exists.");
                    break;
                case 3:
                    system.displayAvailableCourses();
                    break;
                case 4:
                    int sid = readInt("Student ID: ");
                    String ccode = readText("Course code: ");
                    System.out.println(system.registerStudent(sid, ccode));
                    break;
                case 5:
                    int rid = readInt("Student ID: ");
                    system.displayRegisteredCourses(rid);
                    break;
                case 0:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}

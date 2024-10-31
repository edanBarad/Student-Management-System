import java.util.ArrayList;

public class StudentManagementSystem {
    public static void main(String[] args) {
        // Create StudentManagement instance with an empty list of students
        StudentManagement management = new StudentManagement(new ArrayList<Student>());
        
        // Add some students
        Student student1 = new Student("Alice", 1, new ArrayList<>());
        Student student2 = new Student("Bob", 2, new ArrayList<>());
        management.addStudent(student1);
        management.addStudent(student2);

        // Add grades to students
        student1.addGrade(85);
        student1.addGrade(90);
        student2.addGrade(78);
        student2.addGrade(82);

        // Display all students
        System.out.println(management);

        // Search for a student
        Student searchedStudent = management.searchStudent(1);
        System.out.println("Searched Student: " + searchedStudent);

        // Remove a student
        management.removeStudent(2);

        // Display all students after removal
        System.out.println("After removal:");
        System.out.println(management);
    }
}

class Student {
    String name;
    int studentID;
    ArrayList<Integer> grades;

    Student(String name, int studentID, ArrayList<Integer> grades) {
        this.name = name;
        this.studentID = studentID;
        this.grades = grades;
    }

    void addGrade(int grade) {
        this.grades.add(grade);
    }

    double calculateAverage() {
        int sum = 0;
        for (int num : grades) {
            sum += num;
        }
        return grades.isEmpty() ? 0 : (double) sum / grades.size();
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", ID: " + this.studentID + ", Grades: " + grades + ", Average: " + calculateAverage();
    }
}

class StudentManagement {
    ArrayList<Student> students;

    StudentManagement(ArrayList<Student> students) {
        this.students = students;
    }

    void addStudent(Student student) {
        this.students.add(student);
    }

    void removeStudent(int studentId) {
        students.removeIf(student -> student.studentID == studentId);
    }

    Student searchStudent(int studentId) {
        for (Student student : this.students) {
            if (student.studentID == studentId) {
                return student;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("All Students:\n");
        for (Student student : students) {
            sb.append(student).append("\n");
        }
        return sb.toString();
    }
}
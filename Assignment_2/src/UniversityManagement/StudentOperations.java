package UniversityManagement;

public interface StudentOperations {
    void addStudent(Student student) throws InvalidInputException;
    void displayStudents();
    void removeStudent(String studentID) throws InvalidInputException;
    Student searchStudent(String studentID) throws InvalidInputException;
    void sortStudentsByMarks();
    void countStudentsCourseWise();
    void displayAllCourses();
}
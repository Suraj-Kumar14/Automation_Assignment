package UniversityManagement;

public class Student {
	private String studentID;
    private String name;
    private String course;
    private double marks;

    public Student(String studentID, String name, String course, double marks) {
        this.studentID = studentID;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return "ID: " + studentID + ", Name: " + name + ", Course: " + course + ", Marks: " + marks;
    }
}

package UniversityManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

class StudentManager implements StudentOperations {
    private ArrayList<Student> studentList;
    private Vector<Student> studentVector;
    private Stack<Student> studentStack;
    private HashMap<String, Student> studentMap;
    private Hashtable<String, Student> studentTable;
    private TreeMap<String, Student> studentTree;

    private Set<String> courses; // unique courses

    public StudentManager() {
        studentList = new ArrayList<>();
        studentVector = new Vector<>();
        studentStack = new Stack<>();
        studentMap = new HashMap<>();
        studentTable = new Hashtable<>();
        studentTree = new TreeMap<>();
        courses = new HashSet<>();
    }

    // Regex validation for ID, name, course
    private void validateStudent(Student s) throws InvalidInputException {
        if (!s.getStudentID().matches("^S\\d{3}$")) {
            throw new InvalidInputException("Invalid Student ID! Format: SXXX");
        }
        if (!s.getName().matches("^[A-Za-z ]+$")) {
            throw new InvalidInputException("Invalid Name! Only letters allowed");
        }
        if (!s.getCourse().matches("^[A-Za-z ]+$")) {
            throw new InvalidInputException("Invalid Course Name!");
        }
        if (s.getMarks() < 0 || s.getMarks() > 100) {
            throw new InvalidInputException("Marks must be between 0 and 100");
        }
        if (studentMap.containsKey(s.getStudentID())) {
            throw new InvalidInputException("Student ID already exists!");
        }
    }

    @Override
    public void addStudent(Student s) throws InvalidInputException {
        validateStudent(s);

        studentList.add(s);
        studentVector.add(s);
        studentStack.push(s);
        studentMap.put(s.getStudentID(), s);
        studentTable.put(s.getStudentID(), s);
        studentTree.put(s.getStudentID(), s);
        courses.add(s.getCourse());

        System.out.println("Student added successfully!");
    }

    @Override
    public void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students to display!");
            return;
        }
        System.out.println("\n=== Students (ArrayList) ===");
        studentList.forEach(System.out::println);
        System.out.println("\n=== Students (Vector) ===");
        studentVector.forEach(System.out::println);
        System.out.println("\n=== Students (Stack) ===");
        studentStack.forEach(System.out::println);
        System.out.println("\n=== Students (HashMap) ===");
        studentMap.forEach((k,v) -> System.out.println(v));
        System.out.println("\n=== Students (Hashtable) ===");
        studentTable.forEach((k,v) -> System.out.println(v));
        System.out.println("\n=== Students (TreeMap, sorted by ID) ===");
        studentTree.forEach((k,v) -> System.out.println(v));
    }

    @Override
    public void removeStudent(String studentID) throws InvalidInputException {
        Student s = searchStudent(studentID); // throws exception if not found

        studentList.remove(s);
        studentVector.remove(s);
        studentStack.remove(s);
        studentMap.remove(studentID);
        studentTable.remove(studentID);
        studentTree.remove(studentID);

        System.out.println("Student removed successfully!");
    }

    @Override
    public Student searchStudent(String studentID) throws InvalidInputException {
        Student s = studentMap.get(studentID);
        if (s == null) {
            throw new InvalidInputException("Student ID not found!");
        }
        return s;
    }

    @Override
    public void sortStudentsByMarks() {
        studentList.sort((s1, s2) -> Double.compare(s2.getMarks(), s1.getMarks()));
        System.out.println("Students sorted by marks (descending):");
        studentList.forEach(System.out::println);
    }

    @Override
    public void countStudentsCourseWise() {
        Map<String, Integer> courseCount = new HashMap<>();
        for (Student s : studentList) {
            courseCount.put(s.getCourse(), courseCount.getOrDefault(s.getCourse(), 0) + 1);
        }
        System.out.println("Students count per course:");
        courseCount.forEach((k,v) -> System.out.println(k + ": " + v));
    }

    @Override
    public void displayAllCourses() {
        System.out.println("All unique courses:");
        courses.forEach(System.out::println);
    }

    public void convertHashMapToTreeMap() {
        TreeMap<String, Student> tree = new TreeMap<>(studentMap);
        System.out.println("Converted HashMap to TreeMap (sorted by ID):");
        tree.forEach((k,v) -> System.out.println(v));
    }
}
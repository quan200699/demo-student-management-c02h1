package com.codegym;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement implements IGeneralInterface<Student> {
    private List<Student> students;

    public StudentManagement(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void showAll() {
        for (Student student :
                students) {
            System.out.println(student);
        }
    }

    @Override
    public Student create(Student student) {
        this.students.add(student);
        return student;
    }

    @Override
    public Student update(int index, Student student) {
        this.students.set(index, student);
        return student;
    }

    @Override
    public void remove(int index) {
        this.students.remove(index);
    }

    public int findStudentById(String id) {
        int index = -1;
        for (int i = 0; i < this.students.size(); i++) {
            String studentId = this.students.get(i).getId();
            if (studentId.equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void sortStudentListUsingBubbleSort() {
        for (int i = 0; i < this.students.size(); i++) {
            for (int j = this.students.size() - 1; j > i; j--) {
                Student firstStudent = this.students.get(j);
                Student secondStudent = this.students.get(j - 1);
                if (firstStudent.getMark() < secondStudent.getMark()) {
                    Student temp = firstStudent;
                    firstStudent = secondStudent;
                    secondStudent = temp;
                    this.students.set(j, firstStudent);
                    this.students.set(j - 1, secondStudent);
                }
            }
        }
    }

    public int findStudentByIdUsingBinarySearch(int left, int right, String id) {
        this.sortStudentListUsingBubbleSort();
        int middle = (left + right) / 2;
        if (left <= right) {
            if (students.get(middle).getId().equals(id)) {
                return middle;
            } else if (students.get(middle).getId().compareTo(id) < 0) {
                return findStudentByIdUsingBinarySearch(left, middle - 1, id);
            } else {
                return findStudentByIdUsingBinarySearch(middle + 1, right, id);
            }
        } else {
            return -1;
        }
    }

    public int countNumberOfStudentInClass(String className) {
        int count = 0;
        for (Student student : students) {
            if (student.getClasses().equals(className)) {
                count++;
            }
        }
        return count;
    }

    public List<String> getClassList() {
        List<String> classes = new ArrayList<>();
        for (Student student : students) {
            if (!classes.contains(student.getClasses())) {
                classes.add(student.getClasses());
            }
        }
        return classes;
    }

    public void showNumberOfStudentInAllClass() {
        List<String> classes = getClassList();
        for (String class1 : classes) {
            System.out.println("Lớp" + class1 + " có " + countNumberOfStudentInClass(class1));
        }
    }

    public void writeStudentListToFile() throws IOException {
        OutputStream outputStream = new FileOutputStream("student.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(students);
    }

    public void readStudentListFromFile() throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream("student.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        this.students = (List<Student>) objectInputStream.readObject();
    }
}

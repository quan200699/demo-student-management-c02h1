package com.codegym;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("001", "Quan", "HN", "C02H1", 9));
        students.add(new Student("002", "Duyet", "HN", "C02H1", 9));
        students.add(new Student("003", "Hieu", "HN", "C02H1", 9));
        students.add(new Student("004", "Thanh", "HN", "C02H1", 9));
        students.add(new Student("005", "Long", "HN", "C02H1", 9));
        StudentManagement studentManagement = new StudentManagement(students);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            menu();
            System.out.println("Nhập lựa chọn của bạn:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    studentManagement.showAll();
                    break;
                }
                case 2: {
                    createStudent(studentManagement, scanner);
                    break;
                }
                case 3: {
                    updateStudentInfo(studentManagement, scanner);
                    break;
                }
                case 4: {
                    deleteStudent(studentManagement, scanner);
                    break;
                }
                case 5: {
                    sortStudentList(studentManagement);
                    break;
                }
                case 6: {
                    findStudentUsingBinarySearch(studentManagement, scanner);
                    break;
                }
                case 7: {
                    studentManagement.showNumberOfStudentInAllClass();
                    break;
                }
                case 8: {
                    try {
                        studentManagement.readStudentListFromFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                }
                case 9:{
                    try {
                        studentManagement.writeStudentListToFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        } while (choice != 0);
    }

    private static void findStudentUsingBinarySearch(StudentManagement studentManagement, Scanner scanner) {
        System.out.println("Nhập mã sinh viên mà bạn muốn tìm");
        String id = scanner.nextLine();
        int index = studentManagement.findStudentByIdUsingBinarySearch(0, studentManagement.getStudents().size(), id);
        if (index == -1) {
            System.out.println("Không tìm thấy");
        } else {
            System.out.println(studentManagement.getStudents().get(index));
        }
    }

    private static void sortStudentList(StudentManagement studentManagement) {
        System.out.println("Danh sách sinh viên sau khi sắp xếp");
        studentManagement.sortStudentListUsingBubbleSort();
        studentManagement.showAll();
    }

    private static void deleteStudent(StudentManagement studentManagement, Scanner scanner) {
        System.out.println("Nhập mã sinh viên mà bạn muốn xóa");
        String id = scanner.nextLine();
        int index = studentManagement.findStudentById(id);
        if (index != -1) {
            studentManagement.remove(index);
        } else {
            System.out.println("Không tìm thấy mã sinh viên này");
        }
    }

    private static void createStudent(StudentManagement studentManagement, Scanner scanner) {
        Student student = inputStudentInfo(scanner);
        studentManagement.create(student);
    }

    private static void updateStudentInfo(StudentManagement studentManagement, Scanner scanner) {
        System.out.println("Nhập mã sinh viên bạn muốn chỉnh sửa:");
        String id = scanner.nextLine();
        int index = studentManagement.findStudentById(id);
        if (index != -1) {
            Student newStudent = inputStudentInfo(scanner);
            studentManagement.update(index, newStudent);
        } else {
            System.out.println("Không tìm thấy mã sinh viên này");
        }
    }

    private static Student inputStudentInfo(Scanner scanner) {
        System.out.println("Nhập thông tin sinh viên:");
        System.out.println("Nhập mã sinh viên:");
        String id = scanner.nextLine();
        System.out.println("Nhập tên:");
        String name = scanner.nextLine();
        System.out.println("Nhập quê quán:");
        String address = scanner.nextLine();
        System.out.println("Nhập lớp:");
        String classes = scanner.nextLine();
        System.out.println("Nhập điểm:");
        double mark = scanner.nextDouble();
        Student student = new Student(id, name, address, classes, mark);
        return student;
    }

    private static void menu() {
        System.out.println("Quản lý sinh viên");
        System.out.println("1. Hiển thị danh sách sinh viên");
        System.out.println("2. Thêm mới một sinh viên");
        System.out.println("3. Cập nhật thông tin sinh viên");
        System.out.println("4. Xóa thông tin sinh viên");
        System.out.println("5. Sắp xếp điểm giảm dần");
        System.out.println("6. Tìm kiếm sinh viên theo mã sinh viên");
        System.out.println("7. Thông kê sinh viên mỗi lớp");
        System.out.println("8. Đọc file");
        System.out.println("9. Ghi file");
        System.out.println("0. Thoát chương trình");
    }
}

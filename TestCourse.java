/*
 *@ (#) TestCourse.java     1.0  8/29/2024
 *Copyright (c) 2024 IUH  . All right reserved.
*/

package fit.iuh.se;

import java.util.Scanner;
import java.util.List;
/*
 *@description:
 *@author:Nguyen Tran Phi Hoang
 *@date:    8/29/2024
 *version:  1.0
*/    
public class TestCourse {
    private static CourseList courseList = new CourseList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- COURSE MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Course");
            System.out.println("2. Display All Courses");
            System.out.println("3. Remove Course");
            System.out.println("4. Find Course by ID");
            System.out.println("5. Find Courses by Title");
            System.out.println("6. Find Courses by Department");
            System.out.println("7. Sort Courses by Title");
            System.out.println("8. Find Courses with Max Credits");
            System.out.println("9. Find Department with Most Courses");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    displayAllCourses();
                    break;
                case 3:
                    removeCourse();
                    break;
                case 4:
                    findCourseById();
                    break;
                case 5:
                    findCoursesByTitle();
                    break;
                case 6:
                    findCoursesByDepartment();
                    break;
                case 7:
                    sortCoursesByTitle();
                    break;
                case 8:
                    findCoursesWithMaxCredits();
                    break;
                case 9:
                    findDepartmentWithMostCourses();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
    }
    private static void addCourse() {
        System.out.print("Enter Course ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Course Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Course Credits: ");
        int credits = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter Course Department: ");
        String department = scanner.nextLine();

        Course course = new Course(credits,department ,id ,title );
        if (courseList.addCourse(course)) {
            System.out.println("Course added successfully.");
        }
    }
    private static void displayAllCourses() {
        List<Course> courses = courseList.getCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
        } else {
            System.out.printf("%-10s %-30s %-10s %-20s\n", "ID", "Title", "Credits", "Department");
            System.out.println("--------------------------------------------------------------");
            for (Course c : courses) {
                System.out.println(c);
            }
        }
    }

    private static void removeCourse() {
        System.out.print("Enter Course ID to remove: ");
        String courseId = scanner.nextLine();
        if (courseList.removeCourse(courseId)) {
            System.out.println("Course removed successfully.");
        }
    }

    private static void findCourseById() {
        System.out.print("Enter Course ID to find: ");
        String courseId = scanner.nextLine();
        Course course = courseList.searchCourseById(courseId);
        if (course != null) {
            System.out.println("Course found: " + course);
        } else {
            System.out.println("Course not found.");
        }
    }

    private static void findCoursesByTitle() {
        System.out.print("Enter Course Title to search: ");
        String title = scanner.nextLine();
        List<Course> courses = courseList.searchCourse(title);
        if (courses != null) {
            System.out.printf("%-10s %-30s %-10s %-20s\n", "ID", "Title", "Credits", "Department");
            for (Course c : courses) {
                System.out.println(c);
            }
        } else {
            System.out.println("No courses found with the given title.");
        }
    }

    private static void findCoursesByDepartment() {
        System.out.print("Enter Department to search: ");
        String department = scanner.nextLine();
        List<Course> courses = courseList.searchCourseByDepartment(department);
        if (courses != null) {
            System.out.printf("%-10s %-30s %-10s %-20s\n", "ID", "Title", "Credits", "Department");
            for (Course c : courses) {
                System.out.println(c);
            }
        } else {
            System.out.println("No courses found for the given department.");
        }
    }

    private static void sortCoursesByTitle() {
        List<Course> sortedCourses = courseList.sortCourses();
        System.out.printf("%-10s %-30s %-10s %-20s\n", "ID", "Title", "Credits", "Department");
        for (Course c : sortedCourses) {
            System.out.println(c);
        }
    }

    private static void findCoursesWithMaxCredits() {
        List<Course> coursesWithMaxCredits = courseList.findMaxCreditCourse();
        if (!coursesWithMaxCredits.isEmpty()) {
            System.out.println("Courses with the maximum credits:");
            System.out.printf("%-10s %-30s %-10s %-20s\n", "ID", "Title", "Credits", "Department");
            for (Course c : coursesWithMaxCredits) {
                System.out.println(c);
            }
        } else {
            System.out.println("No courses available.");
        }
    }

    private static void findDepartmentWithMostCourses() {
        String department = courseList.findDepartmentWithMostCourses();
        if (department != null) {
            System.out.println("Department with the most courses: " + department);
        } else {
            System.out.println("No courses available.");
        }
    }
}


/*
 *@ (#) CourseList.java     1.0  8/29/2024
 *Copyright (c) 2024 IUH  . All right reserved.
 */

package fit.iuh.se;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@description:
 *@author:Nguyen Tran Phi Hoang
 *@date:    8/29/2024
 *version:  1.0
 */


public class CourseList {
    private List<Course> courses;

    public CourseList() {
        this.courses = new ArrayList<>();
    }

    // Phương thức thêm một khóa học vào danh sách
    public boolean addCourse(Course course) {
        for (Course c : courses) {
            if (c.getId().equals(course.getId())) {
                System.out.println("Error: Course ID already exists.");
                return false;
            }
        }
        courses.add(course);
        return true;
    }

    // Phương thức lấy danh sách các khóa học
    public List<Course> getCourses() {
        return new ArrayList<>(courses);
    }

    // Phương thức xóa một khóa học khỏi danh sách
    public boolean removeCourse(String courseId) {
        Course courseToRemove = null;
        for (Course c : courses) {
            if (c.getId().equals(courseId)) {
                courseToRemove = c;
            }
        }
        if (courseToRemove != null) {
            courses.remove(courseToRemove);
        } else {
            System.out.println("Error: Course ID not found.");
            return false;
        }
        return true;
    }

    // Phương thức tìm kiếm một khóa học theo mã khóa học
    public Course searchCourseById(String courseId) {
        for (Course c : courses) {
            if (c.getId().equals(courseId)) {
                return c;
            }
        }
        return null;
    }

    // Phương thức tìm kiếm các khóa học theo tên khóa học (tìm tương đối)
    public List<Course> searchCourse(String title) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(c);
            }
        }
        return result.isEmpty() ? null : result;
    }

    // Phương thức tìm kiếm các khóa học theo khoa phụ trách
    public List<Course> searchCourseByDepartment(String department) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getDepartment().equalsIgnoreCase(department)) {
                result.add(c);
            }
        }
        return result.isEmpty() ? null : result;
    }

    // Phương thức sắp xếp các khóa học theo tên khóa học
    public List<Course> sortCourses() {
        List<Course> sortedCourses = new ArrayList<>(courses);
        Collections.sort(sortedCourses, Comparator.comparing(Course::getTitle));
        return sortedCourses;
    }

    // Phương thức tìm các khóa học có số tín chỉ lớn nhất
    public List<Course> findMaxCreditCourse() {
        if (courses.isEmpty()) {
            return null;
        }

        int maxCredits = courses.get(0).getCredit();
        for (Course c : courses) {
            if (c.getCredit() > maxCredits) {
                maxCredits = c.getCredit();
            }
        }

        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getCredit() == maxCredits) {
                result.add(c);
            }
        }
        return result;
    }

    // Phương thức tìm khoa phụ trách có nhiều khóa học nhất
    public String findDepartmentWithMostCourses() {
        if (courses.isEmpty()) {
            return null;
        }

        Map<String, Integer> departmentCount = new HashMap<>();
        for (Course c : courses) {
            departmentCount.put(c.getDepartment(), departmentCount.getOrDefault(c.getDepartment(), 0) + 1);
        }

        String maxDepartment = null;
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : departmentCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxDepartment = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return maxDepartment;
    }
}

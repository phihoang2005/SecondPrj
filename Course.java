/*
 *@ (#) KhoaHoc.java     1.0  8/29/2024
 *Copyright (c) 2024 IUH  . All right reserved.
 */

package fit.iuh.se;

/*
 *@description:
 *@author:Nguyen Tran Phi Hoang
 *@date:    8/29/2024
 *version:  1.0
 */
public class Course{
    private int credit;
    private String department;
    private String id;
    private String title;


    public Course(){
        credit = 2;
        department = "Cong Nghe Thong Tin";
        id="1234";
        title="Lap Trinh HDT";
    }
    public Course(int credit, String department, String id, String title){

        if (id == null || !id.matches("[a-zA-Z0-9]+") || id.length() < 3) {
            throw new IllegalArgumentException("Course ID must be alphanumeric and at least 3 characters long.");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Course title cannot be empty.");
        }
        if (credit <= 0) {
            throw new IllegalArgumentException("Credit must be greater than 0.");
        }
        this.credit = credit;
        this.department = department;
        this.id = id;
        this.title = title;
    }


    public int getCredit(){
        return credit;
    }
    public String getDepartment() {
        return department;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }


    public void setCredit(int credit) {
        if(credit <= 0){
            throw new IllegalArgumentException("Credit must be greater than 0");
        }
        else {
            this.credit = credit;
        }
    }
    public void setDepartment(String department) {
            this.department = department;
    }
    public void setId(String id) {
       if(id == null || !id.matches("[a-zA-Z0-9]+") || id.length() < 3) {
           throw new IllegalArgumentException("ID must have at least 3 characters\n" +
                   "ID must contain only letters or digits\n");
       }
       else {
           this.id = id;
       }
    }
    public void setTitle(String title) {
        if(title == null ) {
            throw new IllegalArgumentException("Title must not be null");
        }
        this.title = title;
    }
}

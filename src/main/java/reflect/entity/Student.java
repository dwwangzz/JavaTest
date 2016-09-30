package reflect.entity;

import java.io.Serializable;

/**
 * Created by wangzz on 2016/9/29.
 */
public class Student extends Person implements ISuperMan, Serializable {

    private String className;

    private String studentNo;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNo='" + studentNo + '\'' +
                ", className='" + className + '\'' +
                '}';
    }

    @Override
    public void fly() {
        System.out.println("you can you up, I can fly! 55555555555555555555");
    }
}

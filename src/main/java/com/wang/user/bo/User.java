package com.wang.user.bo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Component
public class User {
    //员工id
    private int id;
    //姓名
    private String name;
    //密码
    private String password;
    //薪资
    private double salary;
    //部门
    private String department;
    //岗位
    private String classify;
    //工作信条
    private String sign;
    //城市
    private String city;
    //性别
    private String sex;
    //绩效
    private String score;
    //入职日期
    private Date joinDate;
    //毕业院校
    private String university;



    /**
     * User属性的Getter和Setter方法
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", classify='" + classify + '\'' +
                ", sign='" + sign + '\'' +
                ", city='" + city + '\'' +
                ", sex='" + sex + '\'' +
                ", score='" + score + '\'' +
                ", joinDate=" + joinDate +
                ", university='" + university + '\'' +
                '}';
    }
}

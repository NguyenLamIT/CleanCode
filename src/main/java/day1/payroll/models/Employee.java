package day1.payroll.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
    private final static double INCRE_MULTI_NUMBER = 0.06;
    private String name;
    private String dob;
    private Role role;
    private String startDate;
    private double startSal;

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setStartSal(float startSal) {
        this.startSal = startSal;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public Role getRole() {
        return role;
    }

    public String getStartDate() {
        return startDate;
    }

    public double getStartSal() {
        return startSal;
    }

    private int getAge() {
        Calendar start = new GregorianCalendar();
        Calendar end = new GregorianCalendar();
        try {
            start.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(dob));
            end.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(new Date().toString()));
        } catch (ParseException e) {
            System.out.println("getAge->" + e.getMessage());
        }
        return end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
    }

    private double getSalary() {
        long month = getWorkMonth();
        if (month >= 12) {
            return startSal + INCRE_MULTI_NUMBER * startSal;
        }

        return startSal;
    }

    private long getWorkMonth() {
        Calendar start = new GregorianCalendar();
        Calendar end = new GregorianCalendar();
        try {
            start.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(startDate));
            end.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(new Date().toString()));
        } catch (ParseException e) {
            System.out.println("getWorkMonth->" + e.getMessage());
        }
        int diffYear = end.get(Calendar.YEAR) - start.get(Calendar.YEAR);
        return diffYear * 12 + end.get(Calendar.MONTH) - start.get(Calendar.MONTH);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dob='" + dob + '\'' +
                ", role=" + role +
                ", startDate='" + startDate + '\'' +
                ", startSal=" + startSal +
                ", age=" + getAge() +
                ", salary=" + getSalary() +
                ", workMonth=" + getWorkMonth() +
                '}';
    }
}

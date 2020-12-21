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
    private final static int ONE_YEAR = 12;
    private final static String WORK_MONTH_IN_USER_LANG = "%d năm %d tháng";
    private String name;
    private Date dob;
    private Role role;
    private Date startDate;
    private double startSal;

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setStartSal(float startSal) {
        this.startSal = startSal;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public Role getRole() {
        return role;
    }

    public Date getStartDate() {
        return startDate;
    }

    public double getStartSal() {
        return startSal;
    }

    private int getAge() {
        Calendar now = getNow();
        Calendar birthday = new GregorianCalendar();
        birthday.setTime(dob);
        return now.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);
    }

    private double getSalary() {
        long month = getWorkMonth();
        int salaryMonth = (int)(month / ONE_YEAR);
        double result = startSal;
        for (int i = 1; i <= salaryMonth; i++) {
            result += INCRE_MULTI_NUMBER * result;
        }

        return result;
    }

    private Calendar getNow() {
        Calendar now = new GregorianCalendar();
        now.setTime(new Date());

        return now;
    }

    private int getWorkMonth() {
        Calendar start = new GregorianCalendar();
        start.setTime(startDate);
        Calendar now = getNow();
        int diffYear = now.get(Calendar.YEAR) - start.get(Calendar.YEAR);
        return diffYear * ONE_YEAR + now.get(Calendar.MONTH) - start.get(Calendar.MONTH);
    }

    private String getWorkMonthInUserLang() {
        Calendar start = new GregorianCalendar();
        start.setTime(startDate);
        Calendar now = getNow();
        int diffYear = now.get(Calendar.YEAR) - start.get(Calendar.YEAR);
        int diffMonth = now.get(Calendar.MONTH) - start.get(Calendar.MONTH);

        return String.format(WORK_MONTH_IN_USER_LANG, diffYear, diffMonth);
    }


    @Override
    public String toString() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return "Employee{" +
                "name='" + name + '\'' +
                ", dob='" + formatter.format(dob) + '\'' +
                ", role=" + role +
                ", startDate='" + formatter.format(startDate) + '\'' +
                ", startSal=" + startSal +
                ", age=" + getAge() +
                ", salary=" + getSalary() +
                ", workMonth='" + getWorkMonthInUserLang() + '\'' +
                '}';
    }
}

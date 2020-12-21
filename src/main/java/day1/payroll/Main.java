package day1.payroll;

import day1.payroll.files.Csv;
import day1.payroll.files.IReadFile;
import day1.payroll.models.Employee;

import java.util.List;

public class Main {
    public static final String RESOURCE_PATH = System.getProperty("user.dir") + "/src/main/resources/";
    public static void main(String[] args) {
        String filePath = RESOURCE_PATH + "input_payroll.txt";
        IReadFile readFile = new Csv();
        List<Employee> employees = readFile.readEmployee(filePath);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}

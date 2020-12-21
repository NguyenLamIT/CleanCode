package day1.payroll.files;

import day1.payroll.models.Employee;

import java.util.List;

public interface IReadFile {
    List<Employee> readEmployee(String filePath);
}

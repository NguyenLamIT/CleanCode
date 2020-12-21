package day1.payroll.files;

import day1.payroll.models.Employee;
import day1.payroll.models.Role;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Csv implements IReadFile {
    public List<Employee> readEmployee(String filePath) {
        Reader reader = null;
        List<Employee> res = new ArrayList();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            if (myReader.hasNextLine()) myReader.nextLine(); //remove first row. First rowis header
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                res.add(parseToEmployee(data));
            }
            myReader.close();

            return res;
        }catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private Employee parseToEmployee(String line) {
        String[] properties = line.split(",");
        Employee employee = new Employee();
        employee.setName(properties[0].trim());
        employee.setDob(properties[1].trim());
        employee.setRole(Role.getRoleFromName(properties[2].trim()));
        employee.setStartDate(properties[3].trim());
        try {
            employee.setStartSal(Float.parseFloat(properties[4].trim()));
        } catch (NumberFormatException e) {
            employee.setStartSal(0);
        }

        return employee;
    }
}

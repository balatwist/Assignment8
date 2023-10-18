package Prob2;

import java.util.List;

public class Statistics {
    /**
     * Polymorphically computes and returns the sum
     * of all the salaries of all the staff/teachers in the list.
     */

    public static double computeSumOfSalaries(List<EmployeeData> aList) {
        double totalSalary = 0.0;
        for (EmployeeData employee : aList) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
    }
    }


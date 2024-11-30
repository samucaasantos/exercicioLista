package application;

import entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("How many employees will be registered? ");
        int quantity = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 1; i <= quantity; i++) {
            System.out.println("Employee #" + i + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();
            for (int j = 0; j < employees.size(); j++) {
                if (id == employees.get(j).getId()) {
                    System.out.println("Id already taken, please try again");
                    System.out.print("Id: ");
                    id = sc.nextInt();
                }
            }
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            Employee employee = new Employee(id, name, salary);
            employees.add(employee);

        }

        System.out.print("Enter the employee id that will have salary increase:  ");
        int employeeId = sc.nextInt();
        Employee employee = employees.stream().filter(x -> x.getId() == employeeId).findFirst().orElse(null);
        if (employee != null) {
            System.out.print("Enter percentage: ");
            double percentage = sc.nextDouble();
            employee.increaseSalary(percentage);
        }else {
            System.out.println("This id does not exist!");
        }

        System.out.println("List of Employees:");
        for (Employee obj : employees) {
            System.out.println(obj);
        }
        sc.close();
    }

}

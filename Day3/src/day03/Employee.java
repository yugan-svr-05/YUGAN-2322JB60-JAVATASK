package day03;

import java.util.Scanner;

public class Employee extends Person {
    private double hourlyRate;
    private int hoursWorked;

    public Employee(String name, int age, double hourlyRate, int hoursWorked) {
        super(name, age);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d, Hourly Rate: $%.2f, Hours Worked: %d, Total Salary: $%.2f",
                             getName(), getAge(), hourlyRate, hoursWorked, calculateSalary());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee's age: ");
        int age = scanner.nextInt();

        System.out.print("Enter hourly rate: ");
        double hourlyRate = scanner.nextDouble();

        System.out.print("Enter hours worked: ");
        int hoursWorked = scanner.nextInt();

        Employee employee = new Employee(name, age, hourlyRate, hoursWorked);

        System.out.println("\nEmployee Details:");
        System.out.println(employee);

        scanner.close();
    }
}

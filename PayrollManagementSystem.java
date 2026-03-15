
import java.util.ArrayList;
import java.util.Scanner;

class Employee {

    int empId;
    String name;
    String designation;
    double basicSalary;

    double hra;
    double da;
    double grossSalary;
    double deductions;
    double netSalary;

    // Constructor
    Employee(int empId, String name, String designation, double basicSalary) {

        this.empId = empId;
        this.name = name;
        this.designation = designation;
        this.basicSalary = basicSalary;

        calculateSalary();
    }

    // Method to calculate salary
    void calculateSalary() {

        hra = 0.20 * basicSalary;
        da = 0.10 * basicSalary;

        grossSalary = basicSalary + hra + da;

        deductions = 0.08 * grossSalary;

        netSalary = grossSalary - deductions;
    }

    // Method to display employee payroll
    void display() {

        System.out.println("\n------ Employee Payroll Details ------");
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Basic Salary: Rs" + basicSalary);
        System.out.println("HRA (20%): Rs" + hra);
        System.out.println("DA (10%): Rs" + da);
        System.out.println("Gross Salary: Rs" + grossSalary);
        System.out.println("Deductions (8%): Rs" + deductions);
        System.out.println("Net Salary: Rs" + netSalary);
        System.out.println("--------------------------------------");
    }
}

public class PayrollManagementSystem {

    static ArrayList<Employee> employees = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Find employee by ID
    static Employee findEmployee(int id) {

        for (Employee e : employees) {
            if (e.empId == id) {
                return e;
            }
        }

        return null;
    }

    // Add employee
    static void addEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findEmployee(id) != null) {
            System.out.println("Employee with this ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Designation: ");
        String desig = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        double salary = sc.nextDouble();

        Employee newEmployee = new Employee(id, name, desig, salary);
        employees.add(newEmployee);

        System.out.println("Employee Added & Salary Calculated Successfully!");
    }

    // View one employee
    static void viewEmployee() {

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        Employee e = findEmployee(id);

        if (e != null) {
            e.display();
        } else {
            System.out.println("Employee Not Found!");
        }
    }

    // View all employees
    static void viewAllEmployees() {

        if (employees.isEmpty()) {
            System.out.println("No Employees Found.");
            return;
        }

        System.out.println("\n===== All Employee Payroll Records =====");

        for (Employee e : employees) {
            e.display();
        }
    }

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n====== Employee Payroll Management System ======");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employee Payroll");
            System.out.println("3. View All Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployee();
                    break;

                case 3:
                    viewAllEmployees();
                    break;

                case 4:
                    System.out.println("Exiting Program...");
                    break;

                default:
                    System.out.println("Invalid Choice! Try Again.");
            }

        } while (choice != 4);

    }
}

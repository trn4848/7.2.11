import java.util.ArrayList;
import java.util.function.Predicate;

public class Employee {
    String name;
    String department;
    int salary;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

class TestEmployee {
    void printEmployee(Employee e) {
        System.out.println("Имя: " + e.name + "," + "департамент: " + e.department + "," + "зарплата: " + e.salary);
    }

    void filtraciyaRabonikov(ArrayList<Employee> al, Predicate<Employee> p) {
        for (Employee e : al) {
            if (p.test(e)) {
                printEmployee(e);
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Employee> al = new ArrayList<>();
        Employee emp1 = new Employee("Masha", "Buh", 1000);
        Employee emp2 = new Employee("Kolya", "IT", 2000);
        Employee emp3 = new Employee("Sveta", "Oper", 3000);
        Employee emp4 = new Employee("Maxim", "Hoz", 4000);
        Employee emp5 = new Employee("Sergey", "IT", 150);
        al.add(emp1);
        al.add(emp2);
        al.add(emp3);
        al.add(emp4);
        al.add(emp5);

        TestEmployee te = new TestEmployee();

        te.filtraciyaRabonikov(al,(Employee al1) -> al1.department == "IT" && al1.salary >= 200);

    }
}
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PayrollSystem {
    public static void main(String[] args) {
        // 1. Build the list
        List<Employee> employees = new ArrayList<>();
        employees.add(new FullTimeEmployee("F001", "Ahmed", 3000, LocalDate.of(2018, 3, 15), 800));
        employees.add(new FullTimeEmployee("F002", "Sara", 4500, LocalDate.of(2015, 9, 1), 1200));
        employees.add(new ContractorEmployee("C001", "Omar", LocalDate.of(2022, 1, 10), 40, 120));
        employees.add(new ContractorEmployee("C002", "Laila", LocalDate.of(2020, 6, 20), 55, 150));
        employees.add(new FullTimeEmployee("F003", "Youssef", 2500, LocalDate.of(2021, 11, 5), 500));

        // 2. Natural sort (Comparable): net salary, descending
        Collections.sort(employees);
        System.out.println("=== Sorted by net salary (descending) ===");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // 3. Custom Comparator: seniority (earliest join date first)
        Comparator<Employee> bySeniority = Comparator.comparing(Employee::getJoinDate);
        employees.sort(bySeniority);
        System.out.println("\n=== Sorted by seniority (earliest first) ===");
        for (Employee e : employees) {
            System.out.println(e);
        }

        // 4. Totals via polymorphism (no downcasting)
        double performanceScore = 4.5;
        double totalTax = 0;
        double totalBonus = 0;
        for (Employee e : employees) {
            totalTax += e.calculateTax();
            totalBonus += e.calculateBonus(performanceScore);
        }
        System.out.printf("%nTotal tax: %.2f%n", totalTax);
        System.out.printf("Total bonuses (score %.1f): %.2f%n", performanceScore, totalBonus);
    }
}

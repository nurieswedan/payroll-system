import java.time.LocalDate;

public abstract class Employee implements Taxable, BonusCalculable, Comparable<Employee> {
    private final String id;
    private final String name;
    protected double baseSalary;
    private final LocalDate joinDate;

    public Employee(String id, String name, double baseSalary, LocalDate joinDate) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
        this.joinDate = joinDate;
    }

    public abstract double calculateNetSalary();

    @Override
    public abstract double calculateBonus(double performanceScore);

    @Override
    public double calculateTax() {
        return calculateNetSalary() * TAX_RATE;
    }

    // Natural order: highest net salary first (descending)
    @Override
    public int compareTo(Employee other) {
        return Double.compare(other.calculateNetSalary(), this.calculateNetSalary());
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }
    public LocalDate getJoinDate() { return joinDate; }

    @Override
    public String toString() {
        return String.format("%s[id=%s, name=%s, joinDate=%s, net=%.2f]",
                getClass().getSimpleName(), id, name, joinDate, calculateNetSalary());
    }
}

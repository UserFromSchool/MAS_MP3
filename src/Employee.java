import java.time.LocalDate;

/**
 * An employee hired by the real estate company. Can have expertize in selling or analytics.
 * Has a given amount of experience in the real-estate field.
 */
public abstract class Employee {

    final private String name;
    final private String surname;
    final private LocalDate employedAt;

    /**
     * Creates a new employee instance. Requires employee details for the system.
     * @param name The name of the employee.
     * @param surname The surname of the employee.
     * @param employedAt The date, at which employee was employed.
     */
    public Employee(String name, String surname, LocalDate employedAt) {
        this.name = name;
        this.surname = surname;
        this.employedAt = employedAt;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getEmployedAt() {
        return employedAt;
    }

    /**
     * Employees can prepare property for the final sale. Each employee
     * will do different actions to prepare the property.
     * @param property Property, which should be prepared.
     */
    public abstract void prepareProperty(Property property);

    protected String getSignature() {
        return getName() + " " + getSurname();
    }
}

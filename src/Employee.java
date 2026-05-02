

/**
 * An employee hired by the real estate company. Can have expertize in selling or analytics.
 * Has a given amount of experience in the real-estate field.
 */
public abstract class Employee {

    final private String name;
    final private String surname;
    final private int yearsOfExperience;

    /**
     * Creates a new employee instance. Requires employee details for the system.
     * @param name The name of the employee.
     * @param surname The surname of the employee.
     * @param yearsOfExperience The amount of experience employee has.
     */
    public Employee(String name, String surname, int yearsOfExperience) {
        this.name = name;
        this.surname = surname;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public String getSignature() {
        return getName() + " " + getSurname();
    }

    public void createPortfolio() {
        System.out.println(getSignature() + " is creating a portfolio.");
    }

}

import java.time.LocalDate;

/**
 * Vendor is responsible for selling properties.
 */
public class Vendor extends Employee {

    private double totalGeneratedIncome;

    /**
     * Creates a new vendor employee instance. Requires employee details and total generated income
     * by the vendor (in most cases initially it will be 0).
     * The income can be increased (only).
     * @param name The name of the employee.
     * @param surname The surname of the employee.
     * @param yearsOfExperience The amount of experience employee has.
     * @param totalGeneratedIncome The total generated income by the vendor for the company.
     */
    public Vendor (String name, String surname, LocalDate employedAt, double totalGeneratedIncome) {
        super(name, surname, employedAt);
        this.totalGeneratedIncome = totalGeneratedIncome;
    }

    public double getTotalGeneratedIncome() {
        return totalGeneratedIncome;
    }

    public void increaseTotalGeneratedIncome(double byValue) {
        totalGeneratedIncome += byValue;
    }

    public void prepareDeal(Property property) {
        System.out.println(getSignature() + " prepares a deal for a property " + property.getName());
    }

    @Override
    public void prepareProperty(Property property) {
        prepareDeal(property);
    }

}

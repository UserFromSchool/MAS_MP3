/**
 * Analytic is responsible for performing analysis of the properties
 * and constructing analytical internal portfolios. He is the key for deep
 * understanding of the real-estate market.
 */
public class Analytic extends Employee implements IAnalytic {

    private String expertizeDescription;

    /**
     * Creates a new analytic employee instance. Requires employee details and his detailed expertize description.
     * The expertize can be updated later.
     * @param name The name of the employee.
     * @param surname The surname of the employee.
     * @param yearsOfExperience The amount of experience employee has.
     * @param expertizeDescription The description of the analytical expertize.
     */
    public Analytic(String name, String surname, int yearsOfExperience, String expertizeDescription) {
        super(name, surname, yearsOfExperience);
        this.expertizeDescription = expertizeDescription;
    }

    public String getExpertizeDescription() {
        return expertizeDescription;
    }

    public void setExpertizeDescription(String expertizeDescription) {
        this.expertizeDescription = expertizeDescription;
    }

    public void performAnalysis(Property property) {
        System.out.println(getSignature() + " is performing analysis on the property called " + property.getName());
    }

}

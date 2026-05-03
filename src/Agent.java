import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Agent is a special employee capable of both selling properties and analyzing them. Therefore,
 * he inherits from both Vendor and Analytic classes (implicitely due to Java language contraints).
 * Agent has a unique skill of valuating property thanks to its experience in selling and analytical
 * capabilties. Each agent has his own pricing principles and strategies, which he uses for valuating
 * a property.
 */
public class Agent extends Vendor implements IAnalytic {

    private String expertizeDescription;
    private final List<String> pricingPrinciples;

    /**
     * Creates a new analytic employee instance. Requires employee details and his detailed expertize description.
     * The expertize can be updated later.
     * @param name The name of the employee.
     * @param surname The surname of the employee.
     * @param yearsOfExperience The amount of experience employee has.
     * @param totalGeneratedIncome The total generated income by the vendor for the company.
     * @param expertizeDescription The description of the analytical expertize.
     */
    public Agent(String name, String surname, int yearsOfExperience, double totalGeneratedIncome, String expertizeDescription, List<String> pricingPrinciples) {
        super(name, surname, yearsOfExperience, totalGeneratedIncome);
        this.expertizeDescription = expertizeDescription;
        this.pricingPrinciples = new ArrayList<>(pricingPrinciples);
    }

    public void makePropertyValuation(Property property) {
        System.out.println(getSignature() + " valuates property " + property.getName() + " at " + new Random().nextDouble() * property.getArea() * 10_000);
        System.out.println("His general pricing principles used for valuations are:\n" + String.join("\n", pricingPrinciples));
    }

    public List<String> getPricingPrinciples() {
        return pricingPrinciples.stream().toList();
    }

    public void addPricingPrinciple(String principle) {
       pricingPrinciples.add(principle);
    }

    public void removePricingPrincple(String principle) {
        pricingPrinciples.removeIf(p -> p.equals(principle));
    }

    public String getExpertizeDescription() {
        return expertizeDescription;
    }

    public void setExpertizeDescription(String expertizeDescription) {
        this.expertizeDescription = expertizeDescription;
    }

    public void prepareAnalysis(Property property) {
        System.out.println(getSignature() + " is performing analysis on the property called " + property.getName());
    }

    public void prepareValuation(Property property) {
        System.out.println(getSignature() + " is preparing the valuation for the property called " + property.getName());
    }

    @Override
    public void prepareProperty(Property property) {
        prepareAnalysis(property);
        prepareValuation(property);
        super.prepareDeal(property);
    }

}

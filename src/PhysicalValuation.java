import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Physical Valuation assumes, that the value of a property is the same as how much it was spent on building it, plus
 * the inflation rate and the rate of neighborhood improvement.
 */
public class PhysicalValuation extends Valuation {

    final private double constructionPrice;
    final private double inflationRate;
    final private double neighborhoodImprovementRate;

    public PhysicalValuation(String description, LocalDate valuationDate, double constructionPrice, double inflationRate, double neighborhoodImprovementRate) {
        super(description, valuationDate);
        this.constructionPrice = constructionPrice;
        this.inflationRate = inflationRate;
        this.neighborhoodImprovementRate = neighborhoodImprovementRate;

        if (inflationRate < 0 || inflationRate > 1) {
            throw new IllegalArgumentException("The rate must be a percentage value represented within range 0-1.");
        }
        if (neighborhoodImprovementRate < 0 || neighborhoodImprovementRate > 1) {
            throw new IllegalArgumentException("The rate must be a percentage value represented within range 0-1.");
        }
    }

    public double calculate(LocalDate forDate) {
        System.out.println("Performing physical valuation...");
        double years = (double)ChronoUnit.YEARS.between(getValuationDate(), forDate);
        if (years < 0) throw new IllegalArgumentException("Valuation does not support dates before the original valuation date.");
        double inflationTerm = years != 0.0 ? constructionPrice * (Math.pow(1 + inflationRate, years) - 1) : 0.0;
        double neighborhoodTerm = years != 0.0 ? constructionPrice * (Math.pow(1 + neighborhoodImprovementRate, years) - 1) : 0.0;
        return constructionPrice + inflationTerm + neighborhoodTerm;
    }

}

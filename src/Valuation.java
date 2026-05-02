import java.time.LocalDate;

/**
 * Defines a property valuation process. There are many approaches to valuate a property.
 * All of them share the same base, which is a brief description of how the creator approached
 * valuating a given property and a valuation date, which he had in mind. Nonetheless, valuations
 * can be run for any dates as they are meant to be a general reusable process.
 */
public abstract class Valuation {

    final private String description;
    final private LocalDate valuationDate;

    public Valuation(String description, LocalDate valuationDate) {
        this.description = description;
        this.valuationDate = valuationDate;
    }

    /**
     * Runs the valuation calculations assuming a different valuation date.
     * @param forDate The date, at which the valuation is assumed to be.
     * @return The value, which the valuation has calculated based on assumptions.
     */
    public abstract double calculate(LocalDate forDate);

    public double calculate() {
        return calculate(valuationDate);
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getValuationDate() {
        return valuationDate;
    }

}

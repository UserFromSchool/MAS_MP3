import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Market Valuation is a valuation, which uses the market conditions, at the given
 * time to compare the property and create an estimate value based on competition.
 */
public class MarketValuation extends Valuation {

    final private double marketBaseValue;
    final private double marketAdvantageRate;

    public MarketValuation(String description, LocalDate valuationDate, double marketBaseValue, double marketAdvantageRate) {
        super(description, valuationDate);
        this.marketBaseValue = marketBaseValue;
        this.marketAdvantageRate = marketAdvantageRate;

        if (marketAdvantageRate < 0 || marketAdvantageRate > 1) {
            throw new IllegalArgumentException("The rate must be a percentage value represented within range 0-1.");
        }
    }

    @Override
    public double calculate(LocalDate forDate) {
        System.out.println("Performing market valuation...");
        double years = (double)ChronoUnit.YEARS.between(getValuationDate(), forDate);
        if (years < 0) throw new IllegalArgumentException("Valuation does not support dates before the original valuation date.");
        return marketBaseValue + (years != 0.0 ? marketBaseValue * (Math.pow(1 + marketAdvantageRate, years) - 1) : 0.0);
    }

}

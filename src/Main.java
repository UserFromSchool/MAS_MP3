import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] argv) {

        List<Valuation> valuations = new ArrayList<>();
        valuations.add(new MarketValuation(
                "Valuation demo market",
                LocalDate.of(2023, 12, 31),
                1_000_000,
                0.03)
        );
        valuations.add(new PhysicalValuation(
                "Valuation demo physical",
                LocalDate.of(2023, 12, 31),
                965_000,
                0.07,
                0.01)
        );

        for (Valuation valuation : valuations) {
            System.out.println();
            System.out.println(
                    "Valuation [" + valuation.getDescription() + "]\nEstimates "
                    + valuation.calculate() + " for the original valuation date.\nEstimates "
                    + valuation.calculate(LocalDate.now()) + " for the today's date."
            );
        }

    }

}

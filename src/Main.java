import enums.InfrastructureType;
import enums.ZoningType;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] argv) {

        System.out.println("======================= POLYMORPHISM SHOWCASE =======================");
        System.out.println();
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
            System.out.println(
                    "Valuation [" + valuation.getDescription() + "]\nEstimates "
                    + valuation.calculate() + " for the original valuation date.\nEstimates "
                    + valuation.calculate(LocalDate.now()) + " for the today's date."
            );
            System.out.println();
        }
        System.out.println();


        System.out.println("======================= OVERLAPPING INHERITANCE SHOWCASE =======================");
        System.out.println();
        Property mixedProperty = new Property(
                "Warsaw Tower", 10_000, "ul. Puławska 415",
                new Property.CommercialPropertyParams(InfrastructureType.Office, ZoningType.Services),
                new Property.ResidentialPropertyParams(1_000, List.of("Central Heating", "Elevator", "Big Parking"))
        );
        Property residentialProperty = new Property(
                "Warsaw Tower", 10_000, "al. Jerozolimskie 203B",
                new Property.ResidentialPropertyParams(154, List.of("Central Heating", "Elevator", "Garage", "Green Space"))
        );
        Property commercialProperty = new Property(
                "Warsaw Tower", 10_000, "ul. Jana Pawła 60C-1",
                new Property.CommercialPropertyParams(InfrastructureType.Warehouse, ZoningType.SoftIndustrial)
        );
        System.out.println("Mixed property max occupants " + mixedProperty.getMaxOccupants());
        System.out.println("Mixed property infrastructure type " + mixedProperty.getInfrastructureType().name());
        System.out.println("Residential property max occupants " + residentialProperty.getMaxOccupants());
        System.out.println("Commercial property infrastructure type " + commercialProperty.getInfrastructureType());
        try {
            System.out.println("Residential property infrastructure type " + residentialProperty.getInfrastructureType());
        } catch (IllegalStateException ex) {
            System.out.println("Residential property has returned an error (EXPECTED BEHAVIOR) : " + ex.getMessage());
        }
        try {
            System.out.println("Commercial property infrastructure type " + commercialProperty.getMaxOccupants());
        } catch (IllegalStateException ex) {
            System.out.println("Commercial property has returned an error (EXPECTED BEHAVIOR) : " + ex.getMessage());
        }
        System.out.println();
        System.out.println();


        System.out.println("======================= MULTI-INHERITANCE SHOWCASE =======================");
        System.out.println();
        Employee vendor = new Vendor("Jacob", "Plaza", LocalDate.now(), 11_111);
        Employee analytic = new Analytic("Jacob", "Braza", LocalDate.now(), "Is amazing at skyscrapers analysis.");
        Employee agent =  new Agent(
                "Jacob", "Ghaza", LocalDate.now(),
                50_000, "Great experience in residential buildings analysis.",
                List.of("Likes to use market valuations rather than physical.", "The price can be never smaller than construction.")
        );
        System.out.println("Now each employee is preparing the property for the final sale according to his field of expertize...");
        System.out.println("Firstly vendor:");
        vendor.prepareProperty(mixedProperty);
        System.out.println("Secondly analytic:");
        analytic.prepareProperty(mixedProperty);
        System.out.println("Lastly agent");
        agent.prepareProperty(mixedProperty);
        System.out.println();
        System.out.println();


        System.out.println("======================= DYNAMIC INHERITANCE SHOWCASE =======================");
        System.out.println();
        System.out.println("Example on use case. We start with creating an internal portfolio for storing properties near Warsaw center.");
        Portfolio portfolio = new Portfolio(
                "Warsaw Center Residential Buildings",
                "Set of residential buildings near Warsaw city center.",
                "Analyze the common factors among the utilities offered close to the city center in residential properties."
        );
        System.out.println(portfolio);
        System.out.println("Analytics were working on this portfolio's properties and made a few reports etc.");
        System.out.println("Afterwards, it was decided to be made a marketing portfolio due to high interest.");
        portfolio.toMarketingPortfolio(
                "This is the best and most breath-taking set of residential buildings from the city center.",
                "Richer clients with higher budgets. Usually looking for good locations with high accessibility, not minding the city noise."
        );
        System.out.println(portfolio);
        System.out.println("Lastly, the portfolio was not selling that well so it was put back for fixture analysis.");
        portfolio.toInternalPortfolio("Inspect the poor attractiveness of the portfolio's properties.");
        System.out.println(portfolio);
        System.out.println();
        System.out.println();


        System.out.println("======================= MULTI-ASPECT INHERITANCE SHOWCASE =======================");
        System.out.println();
        Contract b2bRollingContract = new RollingContract(
                LocalDate.now(),
                LocalDate.of(2028, 12, 31),
                new Contract.BusinessToBusinessContractParams("Something Sp. z.o.o.", "02-04-05-06", "22323124312"),
                3,
                6_500
        );
        Contract b2cFixedLContract = new FixedContract(
                LocalDate.now(),
                LocalDate.of(2028, 12, 31),
                new Contract.BusinessToConsumerContractParams(
                        "Jacob",
                        "Braza",
                        "ul. Włomiana 2",
                        "04-222342"
                ),
                146_000
        );
        System.out.println("The rolling B2B contract details:");
        System.out.println(b2bRollingContract);
        System.out.println("The fixed B2C contract details:");
        System.out.println(b2cFixedLContract);

    }

}

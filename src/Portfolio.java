import enums.PortfolioType;

import java.util.EnumSet;

/**
 * Stores list of properties with a shared common set of features.
 * Has a qualified association with property and A basic association with the Employee (portfolio owner).
 */
public class Portfolio {

    private PortfolioType type;
    final private String name;
    private String description;
    private String purpose;
    private String narrative;
    private String targetClientProfile;

    private Portfolio(String name, String description, PortfolioType type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    /**
     * Creates an internal portfolio.
     * @param name The portfolio's name.
     * @param description The brief description of the portfolio.
     * @param purpose The internal profile of the portfolio explaining its purpose and details relevant to company internal processes.
     */
    public Portfolio(String name, String description, String purpose) {
        this(name, description, PortfolioType.InternalPortfolio);
        this.purpose = purpose;
    }

    /**
     * Creates a marketing portfolio.
     * @param name The portfolio's name.
     * @param description The brief description of the portfolio.
     * @param narrative The marketing narrative used to display for clients to read about this portfolio.
     * @param targetClientProfile The profile description of the client type targeted by this portfolio.
     */
    public Portfolio(String name, String description, String narrative, String targetClientProfile) {
        this(name, description, PortfolioType.MarketingPortfolio);
        this.narrative = narrative;
        this.targetClientProfile = targetClientProfile;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNarrative() {
        if (type != PortfolioType.MarketingPortfolio) throw new IllegalStateException("An internal portfolio does not have a narrative.");
        return narrative;
    }

    public String getTargetClientProfile() {
        if (type != PortfolioType.MarketingPortfolio) throw new IllegalStateException("An internal portfolio does not have a target client profile.");
        return targetClientProfile;
    }

    public String getPurpose() {
        if (type != PortfolioType.InternalPortfolio) throw new IllegalStateException("A marketing portfolio does not have a purpose specification.");
        return purpose;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void toInternalPortfolio(String purpose) {
        this.narrative = null;
        this.targetClientProfile = null;
        this.purpose = purpose;
        this.type = PortfolioType.InternalPortfolio;
    }

    public void toMarketingPortfolio(String narrative, String targetClientProfile) {
        this.purpose = null;
        this.narrative = narrative;
        this.targetClientProfile = targetClientProfile;
        this.type = PortfolioType.MarketingPortfolio;
    }

    @Override
    public String toString() {
        if (type == PortfolioType.MarketingPortfolio) {
            return "Marketing Portfolio" + '\n' +
            "Name: " + name + '\n' +
            "Description: " + description + '\n' +
            "Narrative: " + narrative + '\n' +
            "Target client profile: " + targetClientProfile;
        } else {
            return "Internal Portfolio" + '\n' +
            "Name: " + name + '\n' +
            "Description: " + description + '\n' +
            "Purpose: " + purpose;
        }
    }

}

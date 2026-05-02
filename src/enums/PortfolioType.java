package enums;

/**
 * Portfolios can be of two distinct types.
 * <p>
 * Internal portfolios are made for employees to gather properties with similar set of features.
 * The also contain a detailed analysis. They are used for both managing already leased properties
 * and gathering assets for comparisons, valuations and general analysis.
 * </p>
 * <p>
 * Marketing portfolios are made specifically for clients with a nicely written narrative and rich
 * offer matching a given client's profile. They are usually made by agents, sometimes by sellers.
 * </p>
 * <p>
 * Internal portfolios can be turned into marketing portfolios after e.g. a successful analysis with a commercial purpose.
 * On the other hand after a longer time of low attractiveness a marketing portfolio can be changed to internal one
 * for analysis.
 * </p>
 */
public enum PortfolioType {
    InternalPortfolio,
    MarketingPortfolio
}

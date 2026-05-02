import java.time.LocalDate;

/**
 * Represents a lease contract with a fixed paid term. Such contract assumes upfront payment (usually on preferable price)
 * covering the whole leasing period.
 */
public class FixedContract extends Contract {

    final private double paidAmount;

    /**
     * Creates a new B2B contract for the specified period.
     * @param startDate The date, at which contract starts.
     * @param endDate The date, at which contract expires.
     * @param businessToBusinessParams The parameters required to be filled for B2B contract draft.
     * @param paidAmount The amount paid for the whole lease period on the fixed contract.
     */
    public FixedContract(LocalDate startDate, LocalDate endDate, BusinessToBusinessContractParams businessToBusinessParams, double paidAmount) {
        super(startDate, endDate, businessToBusinessParams);
        this.paidAmount = paidAmount;
    }

    /**
     * Creates a new B2C contract for the specified period.
     * @param startDate The date, at which contract starts.
     * @param endDate The date, at which contract expires.
     * @param businessToConsumerParams The parameters required to be filled for B2C contract draft.
     * @param paidAmount The amount paid for the whole lease period on the fixed contract.
     */
    public FixedContract(LocalDate startDate, LocalDate endDate, BusinessToConsumerContractParams businessToConsumerParams, double paidAmount) {
        super(startDate, endDate, businessToConsumerParams);
        this.paidAmount = paidAmount;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

}

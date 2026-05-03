import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Represents a lease contract with a rolling payment. Such contract assumes a monthly rent
 * paid for the lease during the whole leasing period. This allowed customers to lease with
 * smaller initial capital, yet is less worthwhile by the end of the lease due to interest rates.
 */
public class RollingContract extends Contract {

    final private int noticePeriodInMonths;
    final private double monthlyRent;

    /**
     * Creates a new B2B contract for the specified period.
     * @param startDate The date, at which contract starts.
     * @param endDate The date, at which contract expires.
     * @param businessToBusinessParams The parameters required to be filled for B2B contract draft.
     * @param noticePeriodInMonths The amount of months required from the buying entity to give the company before terminating the contract.
     * @param monthlyRent The fixed monthly rent agreed to be paid every month during the whole leasing period.
     */
    public RollingContract(
            LocalDate startDate, LocalDate endDate, Contract.BusinessToBusinessContractParams businessToBusinessParams,
            int noticePeriodInMonths, double monthlyRent
    ) {
        super(startDate, endDate, businessToBusinessParams);
        this.noticePeriodInMonths = noticePeriodInMonths;
        this.monthlyRent = monthlyRent;
    }

    /**
     * Creates a new B2C contract for the specified period.
     * @param startDate The date, at which contract starts.
     * @param endDate The date, at which contract expires.
     * @param businessToConsumerParams The parameters required to be filled for B2C contract draft.
     * @param noticePeriodInMonths The amount of months required from the buying entity to give the company before terminating the contract.
     * @param monthlyRent The fixed monthly rent agreed to be paid every month during the whole leasing period.
     */
    public RollingContract(
            LocalDate startDate, LocalDate endDate, Contract.BusinessToConsumerContractParams businessToConsumerParams,
            int noticePeriodInMonths, double monthlyRent
    ) {
        super(startDate, endDate, businessToConsumerParams);
        this.noticePeriodInMonths = noticePeriodInMonths;
        this.monthlyRent = monthlyRent;
    }

    public double getNoticePeriodInMonths() {
        return noticePeriodInMonths;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    @Override
    public double getTotalValue() {
        long months = ChronoUnit.MONTHS.between(this.getStartDate(), this.getEndDate());
        return monthlyRent * (double)months;
    }

    @Override
    public String toString() {
        return "Rolling Term " + super.toString();
    }

}

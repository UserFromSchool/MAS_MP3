import java.time.LocalDate;

/**
 * A lease contract signed for the given property by an entity. Contract
 * holds payment details and leasing entity details.
 */
public abstract class Contract {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final BusinessToConsumerContract b2cContract;
    private final BusinessToBusinessContract b2bContract;

    /**
     * Creates a new B2B contract for the specified period.
     * @param startDate The date, at which contract starts.
     * @param endDate The date, at which contract expires.
     * @param businessToBusinessParams The parameters required to be filled for B2B contract draft.
     */
    public Contract(LocalDate startDate, LocalDate endDate, BusinessToBusinessContractParams businessToBusinessParams) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.b2bContract = new BusinessToBusinessContract(
                businessToBusinessParams.businessName,
                businessToBusinessParams.businessPublicId,
                businessToBusinessParams.businessTaxId
        );
        this.b2cContract = null;
    }

    /**
     * Creates a new B2C contract for the specified period.
     * @param startDate The date, at which contract starts.
     * @param endDate The date, at which contract expires.
     * @param businessToConsumerParams The parameters required to be filled for B2C contract draft.
     */
    public Contract(LocalDate startDate, LocalDate endDate, BusinessToConsumerContractParams businessToConsumerParams) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.b2cContract = new BusinessToConsumerContract(
                businessToConsumerParams.consumerName,
                businessToConsumerParams.consumerSurname,
                businessToConsumerParams.consumerAddress,
                businessToConsumerParams.consumerPersonalId
        );
        this.b2bContract = null;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getBusinessName() {
        if (b2bContract == null) throw new IllegalArgumentException("The B2C contract does not store a business name.");
        return b2bContract.businessName;
    }

    public String getBusinessPublicId() {
        if (b2bContract == null) throw new IllegalArgumentException("The B2C contract does not store a business public id.");
        return b2bContract.businessPublicId;
    }

    public String getBusinessTaxId() {
        if (b2bContract == null) throw new IllegalArgumentException("The B2C contract does not store a business tax id.");
        return b2bContract.businessTaxId;
    }

    public String getConsumerName() {
        if (b2cContract == null) throw new IllegalArgumentException("The B2B contract does not store a consumer name.");
        return b2cContract.consumerName;
    }

    public String getConsumerSurame() {
        if (b2cContract == null) throw new IllegalArgumentException("The B2B contract does not store a consumer surname.");
        return b2cContract.consumerSurname;
    }

    public String getConsumerAddress() {
        if (b2cContract == null) throw new IllegalArgumentException("The B2B contract does not store a consumer address.");
        return b2cContract.consumerAddress;

    }

    public String getConsumerPersonalId() {
        if (b2cContract == null) throw new IllegalArgumentException("The B2B contract does not store a consumer personal id.");
        return b2cContract.consumerPersonalId;
    }

    /**
     * Stores parameters required to create a business-to-business contract.
     * @param businessName The name of the business (buyer) signing the contract.
     * @param businessPublicId The governmental public id of the business (buyer) unique within the country.
     * @param businessTaxId The governmental tax id of the business (buyer) unique within the country. Required for invoices and contract processing details.
     */
    public record BusinessToBusinessContractParams(String businessName, String businessPublicId, String businessTaxId) {}

    /**
     * Stores parameters required to create a business-to-consumer contract.
     * @param consumerName The consumer real name.
     * @param consumerSurname The consumer real surname.
     * @param consumerAddress The consumer real residence address.
     * @param consumerPersonalId The consumer governmental personal id.
     */
    public record BusinessToConsumerContractParams(String consumerName, String consumerSurname, String consumerAddress, String consumerPersonalId) {}

    /**
     * Defines a contract between two businesses (B2B) and its
     * characteristics.
     */
    public class BusinessToBusinessContract {
        final private String businessName;
        final private String businessPublicId;
        final private String businessTaxId;

        private BusinessToBusinessContract(String businessName, String businessPublicId, String businessTaxId) {
            this.businessName = businessName;
            this.businessPublicId = businessPublicId;
            this.businessTaxId = businessTaxId;
        }
    }

    /**
     * Defines a contract between a business and a consumer (B2C) and its
     * characteristics.
     */
    public class BusinessToConsumerContract {
        final private String consumerName;
        final private String consumerSurname;
        final private String consumerAddress;
        final private String consumerPersonalId;

        private BusinessToConsumerContract(String consumerName, String consumerSurname, String consumerAddress, String consumerPersonalId) {
            this.consumerName = consumerName;
            this.consumerSurname = consumerSurname;
            this.consumerAddress = consumerAddress;
            this.consumerPersonalId = consumerPersonalId;
        }

    }

}

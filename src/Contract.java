import enums.ContractType;
import java.time.LocalDate;

/**
 * A lease contract signed for the given property by an entity. Contract
 * holds payment details and leasing entity details.
 */
public abstract class Contract {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final ContractType type;

    private final String businessName;
    private final String businessPublicId;
    private final String businessTaxId;

    private final String consumerName;
    private final String consumerSurname;
    private final String consumerAddress;
    private final String consumerPersonalId;

    /**
     * Creates a new B2B contract for the specified period.
     * @param startDate The date, at which contract starts.
     * @param endDate The date, at which contract expires.
     * @param businessToBusinessParams The parameters required to be filled for B2B contract draft.
     */
    public Contract(LocalDate startDate, LocalDate endDate, BusinessToBusinessContractParams businessToBusinessParams) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = ContractType.B2B;
        this.businessName = businessToBusinessParams.businessName;
        this.businessPublicId = businessToBusinessParams.businessPublicId;
        this.businessTaxId = businessToBusinessParams.businessTaxId;
        this.consumerName = null;
        this.consumerSurname = null;
        this.consumerAddress = null;
        this.consumerPersonalId = null;
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
        this.type = ContractType.B2C;
        this.consumerName = businessToConsumerParams.consumerName;
        this.consumerSurname = businessToConsumerParams.consumerSurname;
        this.consumerAddress = businessToConsumerParams.consumerAddress;
        this.consumerPersonalId = businessToConsumerParams.consumerPersonalId;
        this.businessName = null;
        this.businessPublicId = null;
        this.businessTaxId = null;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Calculates the total value, which this contract is for. This can depend on the contract's payment
     * agreements and schedules.
     */
    public abstract double getTotalValue();

    public String getBusinessName() {
        if (type != ContractType.B2B) throw new IllegalStateException("The B2C contract does not store a business name.");
        return businessName;
    }

    public String getBusinessPublicId() {
        if (type != ContractType.B2B) throw new IllegalStateException("The B2C contract does not store a business public id.");
        return businessPublicId;
    }

    public String getBusinessTaxId() {
        if (type != ContractType.B2B) throw new IllegalStateException("The B2C contract does not store a business tax id.");
        return businessTaxId;
    }

    public String getConsumerName() {
        if (type != ContractType.B2C) throw new IllegalStateException("The B2B contract does not store a consumer name.");
        return consumerName;
    }

    public String getConsumerSurame() {
        if (type != ContractType.B2C) throw new IllegalStateException("The B2B contract does not store a consumer surname.");
        return consumerSurname;
    }

    public String getConsumerAddress() {
        if (type != ContractType.B2C) throw new IllegalStateException("The B2B contract does not store a consumer address.");
        return consumerAddress;

    }

    public String getConsumerPersonalId() {
        if (type != ContractType.B2C) throw new IllegalStateException("The B2B contract does not store a consumer personal id.");
        return consumerPersonalId;
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

    @Override
    public String toString() {
        if (type == ContractType.B2B) {
            return "Contract B2B" + '\n' +
                    "Business entity name: " + businessName + '\n' +
                    "Business entity public id: " + businessPublicId + '\n' +
                    "Business entity tax id: " + businessTaxId + '\n' +
                    "Expected income from the contract by the term's end: " + getTotalValue();
        } else {
            return "Contract B2C" + '\n' +
                    "Consumer entity name: " + consumerName + '\n' +
                    "Consumer entity surname: " + consumerSurname + '\n' +
                    "Consumer entity address: " + consumerAddress + '\n' +
                    "Consumer entity personal id: " + consumerPersonalId + '\n' +
                    "Expected income from the contract by the term's end: " + getTotalValue();
        }
    }

}

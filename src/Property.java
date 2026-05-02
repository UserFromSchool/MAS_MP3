import enums.InfrastructureType;
import enums.ZoningType;
import java.util.List;

/**
 * Property stores metadata about the given real-estate property.
 */
public class Property {

    final private String name;
    final private double area;
    final private String address;
    final private CommercialProperty commercialProperty;
    final private ResidentialProperty residentialProperty;

    /**
     * Creates a new property of the given type.
     * @param name What the property is called.
     * @param area The area of the property in square meters .
     * @param address The address of the property.
     * @param commercialParams In case of commercial purpose, the parameters defining the commercial property.
     * @param residentialParams In case of residential purpose, the parameters defining the residential property.
     */
    public Property(
            String name,
            double area,
            String address,
            CommercialPropertyParams commercialParams,
            ResidentialPropertyParams residentialParams
    ) {
        this.name = name;
        this.area = area;
        this.address = address;

        if (commercialParams == null && residentialParams == null) {
            throw new IllegalArgumentException("Can't create an instance of a naked property. Property requires to be at least one of its types - Commercial / Residential.");
        }

        if (commercialParams != null) {
            this.commercialProperty = new CommercialProperty(
                    commercialParams.infrastructureType,
                    commercialParams.zoningType
            );
        } else {
            this.commercialProperty = null;
        }

        if (residentialParams != null) {
            this.residentialProperty = new ResidentialProperty(
                    residentialParams.maxOccupants,
                    residentialParams.utilities
            );
        } else {
            this.residentialProperty = null;
        }
    }

    public String getName() {
        return this.name;
    }

    public double getArea() {
        return area;
    }

    public String getAddress() {
        return address;
    }

    public InfrastructureType getInfrastructureType() {
        if (this.commercialProperty == null) throw new IllegalArgumentException("Infrastructure type is only set on commercial properties.");
        return this.commercialProperty.infrastructureType;
    }

    public ZoningType getZoningType() {
        if (this.commercialProperty == null) throw new IllegalArgumentException("Zoning type is only set on commercial properties.");
        return this.commercialProperty.zoningType;
    }

    public int getMaxOccupants() {
        if (this.residentialProperty == null) throw new IllegalArgumentException("Max occupants are only set on residential properties.");
        return this.residentialProperty.maxOccupants;
    }

    public List<String> getUtilities() {
        if (this.residentialProperty == null) throw new IllegalArgumentException("Utilities are only set on residential properties.");
        return this.residentialProperty.utilities.stream().toList();
    }

    /**
     * Record defining the required set of parameters for registering a commercial property.
     * @param infrastructureType What type of infrastructure the commercial property has.
     * @param zoningType What zoning laws were assigned to the property.
     */
    public record CommercialPropertyParams (InfrastructureType infrastructureType, ZoningType zoningType) {}

    /**
     * Record defining the required set of parameters for registering a residential property.
     * @param maxOccupants What is the maximal amount of tenants allowed in the property.
     * @param utilities What are the general utilities offered for the tenants by the building.
     */
    public record ResidentialPropertyParams (int maxOccupants, List<String> utilities) {}

    /**
     * Commercial property is designed specifically for a given type of business use.
     */
    public class CommercialProperty {

        final private InfrastructureType infrastructureType;
        final private ZoningType zoningType;

        private CommercialProperty(InfrastructureType infrastructureType, ZoningType zoningType) {
            this.infrastructureType = infrastructureType;
            this.zoningType = zoningType;
        }
    }

    /**
     * Commercial property is designed specifically for a given type of business use.
     */
    public class ResidentialProperty {

        final private int maxOccupants;
        final private List<String> utilities;

        private ResidentialProperty(int maxOccupants, List<String> utilities) {
            this.maxOccupants = maxOccupants;
            this.utilities = utilities.stream().toList();
        }
    }

}

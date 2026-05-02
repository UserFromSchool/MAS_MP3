/**
 * Interface for employee classes having analytical skills (the bypass for the multi-inheritance in Java lanugage).
 */
public interface IAnalytic {

    /**
     * Returns the current experitze description of the analytic.\
     */
    String getExpertizeDescription();

    /**
     * Sets the analytic's expertize description in case of new skills gained.
     * @param expertizeDescription The expertize description.
     */
    void setExpertizeDescription(String expertizeDescription);

}

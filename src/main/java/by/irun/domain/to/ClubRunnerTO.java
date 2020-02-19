package by.irun.domain.to;

/**
 * This class provides object for transfer club`s runners data between entity-layer and viz-layer
 * @author A.Dubovik
 */
public class ClubRunnerTO {

	private long runnerId;
	private String firstName;
	private String lastName;
	private String avatarPath;
	/**
	 * @return the runnerId
	 */
	public long getRunnerId() {
		return runnerId;
	}
	/**
	 * @param runnerId the runnerId to set
	 */
	public void setRunnerId(long runnerId) {
		this.runnerId = runnerId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the avatarPath
	 */
	public String getAvatarPath() {
		return avatarPath;
	}
	/**
	 * @param avatarPath the avatarPath to set
	 */
	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}
	
}

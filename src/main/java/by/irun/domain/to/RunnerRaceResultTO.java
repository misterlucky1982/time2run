package by.irun.domain.to;

import java.sql.Date;

public class RunnerRaceResultTO {
	
	private Integer position;
	private String firstName;
	private String lastName;
	private String club;
	private Date dateOfBirth;
	private Integer timeInSeconds;
	private Long runnerId;
	private String smallAvatar;
	/**
	 * @return the position
	 */
	public Integer getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(Integer position) {
		this.position = position;
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
	 * @return the club
	 */
	public String getClub() {
		return club;
	}
	/**
	 * @param club the club to set
	 */
	public void setClub(String club) {
		this.club = club;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the timeInSeconds
	 */
	public Integer getTimeInSeconds() {
		return timeInSeconds;
	}
	/**
	 * @param timeInSeconds the timeInSeconds to set
	 */
	public void setTimeInSeconds(Integer timeInSeconds) {
		this.timeInSeconds = timeInSeconds;
	}
	/**
	 * @return the runnerId
	 */
	public Long getRunnerId() {
		return runnerId;
	}
	/**
	 * @param runnerId the runnerId to set
	 */
	public void setRunnerId(Long runnerId) {
		this.runnerId = runnerId;
	}
	/**
	 * @return the smallAvatar
	 */
	public String getSmallAvatar() {
		return smallAvatar;
	}
	/**
	 * @param smallAvatar the smallAvatar to set
	 */
	public void setSmallAvatar(String smallAvatar) {
		this.smallAvatar = smallAvatar;
	}
	
	
}

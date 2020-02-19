package by.irun.domain.to;

import java.sql.Date;
/**
 * Provides information about runner`s result for transfer data from entity-layer to viz-layer
 * @author A.Dubovik
 *
 */
public class RaceClubResultTO {
	
	private long raceId;
	private Date date;
	private String parkName;
	private String runnerFirstName;
	private String runnerLastName;
	private long runnerId;
	private int timeInSeconds;
	private int absPosition;
	private int positionInGenderGroup;
	/**
	 * @return the raceId
	 */
	public long getRaceId() {
		return raceId;
	}
	/**
	 * @param raceId the raceId to set
	 */
	public void setRaceId(long raceId) {
		this.raceId = raceId;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the parkName
	 */
	public String getParkName() {
		return parkName;
	}
	/**
	 * @param parkName the parkName to set
	 */
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	/**
	 * @return the runnerFirstName
	 */
	public String getRunnerFirstName() {
		return runnerFirstName;
	}
	/**
	 * @param runnerFirstName the runnerFirstName to set
	 */
	public void setRunnerFirstName(String runnerFirstName) {
		this.runnerFirstName = runnerFirstName;
	}
	/**
	 * @return the runnerLastName
	 */
	public String getRunnerLastName() {
		return runnerLastName;
	}
	/**
	 * @param runnerLastName the runnerLastName to set
	 */
	public void setRunnerLastName(String runnerLastName) {
		this.runnerLastName = runnerLastName;
	}
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
	 * @return the timeInSeconds
	 */
	public int getTimeInSeconds() {
		return timeInSeconds;
	}
	/**
	 * @param timeInSeconds the timeInSeconds to set
	 */
	public void setTimeInSeconds(int timeInSeconds) {
		this.timeInSeconds = timeInSeconds;
	}
	/**
	 * @return the absPosition
	 */
	public int getAbsPosition() {
		return absPosition;
	}
	/**
	 * @param absPosition the absPosition to set
	 */
	public void setAbsPosition(int absPosition) {
		this.absPosition = absPosition;
	}
	/**
	 * @return the positionInGenderGroup
	 */
	public int getPositionInGenderGroup() {
		return positionInGenderGroup;
	}
	/**
	 * @param positionInGenderGroup the positionInGenderGroup to set
	 */
	public void setPositionInGenderGroup(int positionInGenderGroup) {
		this.positionInGenderGroup = positionInGenderGroup;
	}

}

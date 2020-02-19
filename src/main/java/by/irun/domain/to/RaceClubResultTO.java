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
	protected long getRaceId() {
		return raceId;
	}
	/**
	 * @param raceId the raceId to set
	 */
	protected void setRaceId(long raceId) {
		this.raceId = raceId;
	}
	/**
	 * @return the date
	 */
	protected Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	protected void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the parkName
	 */
	protected String getParkName() {
		return parkName;
	}
	/**
	 * @param parkName the parkName to set
	 */
	protected void setParkName(String parkName) {
		this.parkName = parkName;
	}
	/**
	 * @return the runnerFirstName
	 */
	protected String getRunnerFirstName() {
		return runnerFirstName;
	}
	/**
	 * @param runnerFirstName the runnerFirstName to set
	 */
	protected void setRunnerFirstName(String runnerFirstName) {
		this.runnerFirstName = runnerFirstName;
	}
	/**
	 * @return the runnerLastName
	 */
	protected String getRunnerLastName() {
		return runnerLastName;
	}
	/**
	 * @param runnerLastName the runnerLastName to set
	 */
	protected void setRunnerLastName(String runnerLastName) {
		this.runnerLastName = runnerLastName;
	}
	/**
	 * @return the runnerId
	 */
	protected long getRunnerId() {
		return runnerId;
	}
	/**
	 * @param runnerId the runnerId to set
	 */
	protected void setRunnerId(long runnerId) {
		this.runnerId = runnerId;
	}
	/**
	 * @return the timeInSeconds
	 */
	protected int getTimeInSeconds() {
		return timeInSeconds;
	}
	/**
	 * @param timeInSeconds the timeInSeconds to set
	 */
	protected void setTimeInSeconds(int timeInSeconds) {
		this.timeInSeconds = timeInSeconds;
	}
	/**
	 * @return the absPosition
	 */
	protected int getAbsPosition() {
		return absPosition;
	}
	/**
	 * @param absPosition the absPosition to set
	 */
	protected void setAbsPosition(int absPosition) {
		this.absPosition = absPosition;
	}
	/**
	 * @return the positionInGenderGroup
	 */
	protected int getPositionInGenderGroup() {
		return positionInGenderGroup;
	}
	/**
	 * @param positionInGenderGroup the positionInGenderGroup to set
	 */
	protected void setPositionInGenderGroup(int positionInGenderGroup) {
		this.positionInGenderGroup = positionInGenderGroup;
	}

}

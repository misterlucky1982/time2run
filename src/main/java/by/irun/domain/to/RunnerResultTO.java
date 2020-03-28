package by.irun.domain.to;

import java.sql.Date;
/**
 * This class provides object for transfer data between entity-layer and viz-layer
 * @author A.Dubovik
 *
 */
public class RunnerResultTO {
	
	private int absPosition;
	private int positionInGenderGroup;
	private long clubId;
	private String clubName;
	private String clubLogo;
	private long raceId;
	private Date raceDate;
	private String parkName;
	private int time;
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
	/**
	 * @return the clubId
	 */
	public long getClubId() {
		return clubId;
	}
	/**
	 * @param clubId the clubId to set
	 */
	public void setClubId(long clubId) {
		this.clubId = clubId;
	}
	/**
	 * @return the clubName
	 */
	public String getClubName() {
		return clubName;
	}
	/**
	 * @param clubName the clubName to set
	 */
	public void setClubName(String clubName) {
		this.clubName = clubName;
	}
	/**
	 * @return the clubLogo
	 */
	public String getClubLogo() {
		return clubLogo;
	}
	/**
	 * @param clubLogo the clubLogo to set
	 */
	public void setClubLogo(String clubLogo) {
		this.clubLogo = clubLogo;
	}
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
	 * @return the raceDate
	 */
	public Date getRaceDate() {
		return raceDate;
	}
	/**
	 * @param raceDate the raceDate to set
	 */
	public void setRaceDate(Date raceDate) {
		this.raceDate = raceDate;
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
	 * @return the time
	 */
	public int getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}
	
	

}

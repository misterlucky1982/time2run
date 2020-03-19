package by.irun.viz.to.racepage;

import by.irun.viz.to.InfoTO;
/**
 * This class provides object for front-end representation of the runner`s race result in particular race
 * @author A.Dubovik
 *
 */
public class RunnerResultInfoTO implements InfoTO{
	
	private String position;
	private String name;
	private String linkToRunner;
	private String club;
	private String clubLogo;
	private String altLogo;
	private String linkToClub;
	private String dateOfBirth;
	private String time;
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the linkToRunner
	 */
	public String getLinkToRunner() {
		return linkToRunner;
	}
	/**
	 * @param linkToRunner the linkToRunner to set
	 */
	public void setLinkToRunner(String linkToRunner) {
		this.linkToRunner = linkToRunner;
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
	 * @return the linkToClub
	 */
	public String getLinkToClub() {
		return linkToClub;
	}
	/**
	 * @param linkToClub the linkToClub to set
	 */
	public void setLinkToClub(String linkToClub) {
		this.linkToClub = linkToClub;
	}
	
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the altLogo
	 */
	public String getAltLogo() {
		return altLogo;
	}
	/**
	 * @param altLogo the altLogo to set
	 */
	public void setAltLogo(String altLogo) {
		this.altLogo = altLogo;
	}
	
}

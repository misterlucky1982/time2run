package by.irun.viz.to;

/**
 * Provides information about race result
 * <p>
 *  in the list of  another club`s results 
 *  <p>
 *  for front-end representation
 * @author A.Dubovik
 */
public class ClubResultInfoTO implements InfoTO {

	private String position;
	private String raceName;
	private String runnerName;
	private String time;
	private String linkToRace;
	private String linkToRunner;
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
	 * @return the raceName
	 */
	public String getRaceName() {
		return raceName;
	}
	/**
	 * @param raceName the raceName to set
	 */
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	/**
	 * @return the runnerName
	 */
	public String getRunnerName() {
		return runnerName;
	}
	/**
	 * @param runnerName the runnerName to set
	 */
	public void setRunnerName(String runnerName) {
		this.runnerName = runnerName;
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
	 * @return the linkToRace
	 */
	public String getLinkToRace() {
		return linkToRace;
	}
	/**
	 * @param linkToRace the linkToRace to set
	 */
	public void setLinkToRace(String linkToRace) {
		this.linkToRace = linkToRace;
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
	
	
}

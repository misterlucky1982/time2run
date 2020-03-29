package by.irun.viz.to.raceselectpage;

import java.util.Map;

/**
 * This class provides transfer-object for RaceSelectView
 * @author A.Dubovik
 *
 */
public class RaceSelectPageViewTO {

	private String eventTitle;
	private String lastRaceName;
	private String lastRaceDate;
	private String lastRacePark;
	private String linkToLastRace;
	private Map<String,String> parksMap;
	/**
	 * @return the lastRaceName
	 */
	public String getLastRaceName() {
		return lastRaceName;
	}
	/**
	 * @param lastRaceName the lastRaceName to set
	 */
	public void setLastRaceName(String lastRaceName) {
		this.lastRaceName = lastRaceName;
	}
	/**
	 * @return the lastRaceDate
	 */
	public String getLastRaceDate() {
		return lastRaceDate;
	}
	/**
	 * @param lastRaceDate the lastRaceDate to set
	 */
	public void setLastRaceDate(String lastRaceDate) {
		this.lastRaceDate = lastRaceDate;
	}
	/**
	 * @return the lastRacePark
	 */
	public String getLastRacePark() {
		return lastRacePark;
	}
	/**
	 * @param lastRacePark the lastRacePark to set
	 */
	public void setLastRacePark(String lastRacePark) {
		this.lastRacePark = lastRacePark;
	}
	/**
	 * @return the linkToLastRace
	 */
	public String getLinkToLastRace() {
		return linkToLastRace;
	}
	/**
	 * @param linkToLastRace the linkToLastRace to set
	 */
	public void setLinkToLastRace(String linkToLastRace) {
		this.linkToLastRace = linkToLastRace;
	}
	/**
	 * @return the parksMap
	 */
	public Map<String, String> getParksMap() {
		return parksMap;
	}
	/**
	 * @param parksMap the parksMap to set
	 */
	public void setParksMap(Map<String, String> parksMap) {
		this.parksMap = parksMap;
	}
	/**
	 * @return the eventTitle
	 */
	public String getEventTitle() {
		return eventTitle;
	}
	/**
	 * @param eventTitle the eventTitle to set
	 */
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	
}

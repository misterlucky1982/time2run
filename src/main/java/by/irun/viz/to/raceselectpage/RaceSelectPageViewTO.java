package by.irun.viz.to.raceselectpage;

import java.util.Map;

/**
 * This class provides transfer-object for RaceSelectView
 * @author A.Dubovik
 *
 */
public class RaceSelectPageViewTO {

	private RaceInfoVizTO raceInfoVizTO;
	private Map<String,String> parksMap;
	/**
	 * @return the lastRaceName
	 */
	/**
	 * @return the raceInfoVizTO
	 */
	public RaceInfoVizTO getRaceInfoVizTO() {
		return raceInfoVizTO;
	}
	/**
	 * @param raceInfoVizTO the raceInfoVizTO to set
	 */
	public void setRaceInfoVizTO(RaceInfoVizTO raceInfoVizTO) {
		this.raceInfoVizTO = raceInfoVizTO;
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
	
	
}

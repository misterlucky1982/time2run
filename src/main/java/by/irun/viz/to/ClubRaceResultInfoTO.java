package by.irun.viz.to;

import java.util.List;

public class ClubRaceResultInfoTO implements InfoTO{

	private String RaceName;
	private String linkToRace;
	private List<RunnerResultInfoTO>menResults;
	private List<RunnerResultInfoTO>womenResults;
	/**
	 * @return the raceName
	 */
	public String getRaceName() {
		return RaceName;
	}
	/**
	 * @param raceName the raceName to set
	 */
	public void setRaceName(String raceName) {
		RaceName = raceName;
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
	 * @return the menResults
	 */
	public List<RunnerResultInfoTO> getMenResults() {
		return menResults;
	}
	/**
	 * @param menResults the menResults to set
	 */
	public void setMenResults(List<RunnerResultInfoTO> menResults) {
		this.menResults = menResults;
	}
	/**
	 * @return the womenResults
	 */
	public List<RunnerResultInfoTO> getWomenResults() {
		return womenResults;
	}
	/**
	 * @param womenResults the womenResults to set
	 */
	public void setWomenResults(List<RunnerResultInfoTO> womenResults) {
		this.womenResults = womenResults;
	}
	
	
}

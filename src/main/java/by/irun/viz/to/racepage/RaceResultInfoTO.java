package by.irun.viz.to.racepage;

import java.util.List;

/**
 * This class provides object for information about race for front-end representation
 * @author A.Dubovik
 *
 */
public class RaceResultInfoTO {
	
	private String raceName;
	private List<RunnerResultInfoTO>menResult;
	private List<RunnerResultInfoTO>womenResult;
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
	 * @return the menResult
	 */
	public List<RunnerResultInfoTO> getMenResult() {
		return menResult;
	}
	/**
	 * @param menResult the menResult to set
	 */
	public void setMenResult(List<RunnerResultInfoTO> menResult) {
		this.menResult = menResult;
	}
	/**
	 * @return the womenResult
	 */
	public List<RunnerResultInfoTO> getWomenResult() {
		return womenResult;
	}
	/**
	 * @param womenResult the womenResult to set
	 */
	public void setWomenResult(List<RunnerResultInfoTO> womenResult) {
		this.womenResult = womenResult;
	}
	
	
}

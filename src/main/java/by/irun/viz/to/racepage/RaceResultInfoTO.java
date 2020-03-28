package by.irun.viz.to.racepage;


/**
 * This class provides object for information about race for front-end representation
 * @author A.Dubovik
 *
 */
public class RaceResultInfoTO {
	
	private String raceName;
	private by.irun.util.List<RunnerResultInfoTO>menResult;
	private by.irun.util.List<RunnerResultInfoTO>womenResult;
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
	public by.irun.util.List<RunnerResultInfoTO> getMenResult() {
		return menResult;
	}
	/**
	 * @param menResult the menResult to set
	 */
	public void setMenResult(by.irun.util.List<RunnerResultInfoTO> menResult) {
		this.menResult = menResult;
	}
	/**
	 * @return the womenResult
	 */
	public by.irun.util.List<RunnerResultInfoTO> getWomenResult() {
		return womenResult;
	}
	/**
	 * @param womenResult the womenResult to set
	 */
	public void setWomenResult(by.irun.util.List<RunnerResultInfoTO> womenResult) {
		this.womenResult = womenResult;
	}
	
}

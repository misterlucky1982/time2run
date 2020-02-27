package by.irun.viz.to;

/**
 * Provides transfer-object for front-end representation runners`s result among others club`s result
 * <p>
 * Screen: club-info
 * 
 * @author A.Dunovik
 *
 */
public class ClubRunnerResultInfoTO {

	private String name;
	private String position;
	private String time;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time
	 *            the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

}

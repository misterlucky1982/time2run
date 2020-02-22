package by.irun.viz.to;

/**
 * Provides information about runner in the list of  club`s runners for front-end representation
 * @author A.Dubovik
 */
public class ClubRunnerInfoTO {

	private String name;
	private String avatarPath;
	private String linkToPage;
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
	 * @return the avatarPath
	 */
	public String getAvatarPath() {
		return avatarPath;
	}
	/**
	 * @param avatarPath the avatarPath to set
	 */
	public void setAvatarPath(String avatarPath) {
		this.avatarPath = avatarPath;
	}
	/**
	 * @return the linkToPage
	 */
	public String getLinkToPage() {
		return linkToPage;
	}
	/**
	 * @param linkToPage the linkToPage to set
	 */
	public void setLinkToPage(String linkToPage) {
		this.linkToPage = linkToPage;
	}
	
	
}

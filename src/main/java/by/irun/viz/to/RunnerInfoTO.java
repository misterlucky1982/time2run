package by.irun.viz.to;

import java.util.List;
/**
 * This class provides information about runner for front-end representation
 * @author A.Dubovik
 *
 */
public class RunnerInfoTO {
	
	private String avatar;
	private String name;
	private String city;
	private String dateOfBirth;
	private String clubName;
	private String clubLogo;
	private String clubLink;
	private List<RunnerResultInfoTO>races;
	/**
	 * @return the avatar
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * @param avatar the avatar to set
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
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
	 * @return the clubLink
	 */
	public String getClubLink() {
		return clubLink;
	}
	/**
	 * @param clubLink the clubLink to set
	 */
	public void setClubLink(String clubLink) {
		this.clubLink = clubLink;
	}
	/**
	 * @return the races
	 */
	public List<RunnerResultInfoTO> getRaces() {
		return races;
	}
	/**
	 * @param races the races to set
	 */
	public void setRaces(List<RunnerResultInfoTO> races) {
		this.races = races;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

}

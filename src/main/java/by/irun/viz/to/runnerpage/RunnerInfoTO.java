package by.irun.viz.to.runnerpage;

import java.util.List;

import by.irun.viz.to.InfoTO;

/**
 * This class provides information about runner for front-end representation
 * @author A.Dubovik
 *
 */
public class RunnerInfoTO implements InfoTO {
	
	private String avatar;
	private String name;
	private String city;
	private String dateOfBirth;
	private String clubName;
	private String clubLink;
	private int numberOfRaces;
	private String racesRequest;
	private List<RunnerResultInfoTO> racesList;
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
	/**
	 * @return the numberOfRaces
	 */
	public int getNumberOfRaces() {
		return numberOfRaces;
	}
	/**
	 * @param numberOfRaces the numberOfRaces to set
	 */
	public void setNumberOfRaces(int numberOfRaces) {
		this.numberOfRaces = numberOfRaces;
	}
	/**
	 * @return the racesRequest
	 */
	public String getRacesRequest() {
		return racesRequest;
	}
	/**
	 * @param racesRequest the racesRequest to set
	 */
	public void setRacesRequest(String racesRequest) {
		this.racesRequest = racesRequest;
	}
	/**
	 * @return the racesList
	 */
	public List<RunnerResultInfoTO> getRacesList() {
		return racesList;
	}
	/**
	 * @param racesList the racesList to set
	 */
	public void setRacesList(List<RunnerResultInfoTO> racesList) {
		this.racesList = racesList;
	}

	
}

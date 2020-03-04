package by.irun.viz.to;

import java.util.List;

public class ClubInfoTO implements InfoTO{
	
	private String clubLogo;
	private String clubName;
	private String email;
	private String phone;
	private String city;
	private int amountOfRunners;
	private String firstRace;
	private String linkToFirstRace;
	private List<ParkBestResultInfoTO>parkBestResults;
	private int numberOfRaces;
	private int numberOfRunnersInHistory;
	private List<ClubRunnerInfoTO> currentRunners;
	private List<ExtendedInfoTOList<NamedInfoTOList<ClubRunnerResultInfoTO>>> raceResults;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the amountOfRunners
	 */
	public int getAmountOfRunners() {
		return amountOfRunners;
	}
	/**
	 * @param amountOfRunners the amountOfRunners to set
	 */
	public void setAmountOfRunners(int amountOfRunners) {
		this.amountOfRunners = amountOfRunners;
	}
	/**
	 * @return the firstRace
	 */
	public String getFirstRace() {
		return firstRace;
	}
	/**
	 * @param firstRace the firstRace to set
	 */
	public void setFirstRace(String firstRace) {
		this.firstRace = firstRace;
	}
	/**
	 * @return the linkToFirstRace
	 */
	public String getLinkToFirstRace() {
		return linkToFirstRace;
	}
	/**
	 * @param linkToFirstRace the linkToFirstRace to set
	 */
	public void setLinkToFirstRace(String linkToFirstRace) {
		this.linkToFirstRace = linkToFirstRace;
	}
	/**
	 * @return the parkBestResults
	 */
	public List<ParkBestResultInfoTO> getParkBestResults() {
		return parkBestResults;
	}
	/**
	 * @param parkBestResults the parkBestResults to set
	 */
	public void setParkBestResults(List<ParkBestResultInfoTO> parkBestResults) {
		this.parkBestResults = parkBestResults;
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
	 * @return the numberOfRunnersInHistory
	 */
	public int getNumberOfRunnersInHistory() {
		return numberOfRunnersInHistory;
	}
	/**
	 * @param numberOfRunnersInHistory the numberOfRunnersInHistory to set
	 */
	public void setNumberOfRunnersInHistory(int numberOfRunnersInHistory) {
		this.numberOfRunnersInHistory = numberOfRunnersInHistory;
	}
	/**
	 * @return the currentRunners
	 */
	public List<ClubRunnerInfoTO> getCurrentRunners() {
		return currentRunners;
	}
	/**
	 * @param currentRunners the currentRunners to set
	 */
	public void setCurrentRunners(List<ClubRunnerInfoTO> currentRunners) {
		this.currentRunners = currentRunners;
	}
	public List<ExtendedInfoTOList<NamedInfoTOList<ClubRunnerResultInfoTO>>> getRaceResults() {
		return raceResults;
	}
	public void setRaceResults(List<ExtendedInfoTOList<NamedInfoTOList<ClubRunnerResultInfoTO>>> raceResults) {
		this.raceResults = raceResults;
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

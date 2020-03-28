package by.irun.viz.utils;

import java.sql.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import by.irun.controller.ControllerConstants;
import by.irun.domain.Gender;
import by.irun.domain.to.RaceClubResultTO;
import by.irun.domain.to.RunnerResultTO;
import by.irun.domain.to.RunnerTO;
import by.irun.locale.AppLocales;
import by.irun.locale.Internationalizer;
import by.irun.locale.Translator;
import by.irun.viz.to.RunnerInfoTO;
import by.irun.viz.to.RunnerResultInfoTO;

/**
 * this class provides utility methods for front-end representation
 * 
 * @author A.Dubovik
 */
public class VizUtils implements Translator{
	
	
	public static final String EMPTY_LINK = "#";
	private static final Map<Gender, Map<Locale, String>> AVATAR_MAP;
	static {
		AVATAR_MAP = new HashMap<>();
		Map<Locale, String> m = new HashMap<>();
		Map<Locale, String> w = new HashMap<>();
		m.put(AppLocales.BY, VizConstants.NO_FOTO_AVATAR_MAN_BY);
		m.put(AppLocales.RU, VizConstants.NO_FOTO_AVATAR_MAN_RU);
		m.put(AppLocales.EN, VizConstants.NO_FOTO_AVATAR_MAN_EN);
		w.put(AppLocales.BY, VizConstants.NO_FOTO_AVATAR_WOMAN_BY);
		w.put(AppLocales.RU, VizConstants.NO_FOTO_AVATAR_WOMAN_RU);
		w.put(AppLocales.EN, VizConstants.NO_FOTO_AVATAR_WOMAN_EN);
		AVATAR_MAP.put(Gender.MALE, m);
		AVATAR_MAP.put(Gender.FEMALE, w);
	}
	
	private static final String CLUB_NO_LOGO = "clubNoLogo";
	private static final String WITHOUT_CLUB_LOGO = "withoutClubLogo";
	
	private static final Map<Locale, Map<String, String>> PATH_MAP;
	static {
		PATH_MAP = new HashMap<>();
		Map<String, String> en = new HashMap<>();
		Map<String, String> ru = new HashMap<>();
		Map<String, String> by = new HashMap<>();
		en.put(CLUB_NO_LOGO, VizConstants.CLUBLOGO_IS_NOT_UPLOADED_EN);
		ru.put(CLUB_NO_LOGO, VizConstants.CLUBLOGO_IS_NOT_UPLOADED_RU);
		by.put(CLUB_NO_LOGO, VizConstants.CLUBLOGO_IS_NOT_UPLOADED_BY);
		en.put(WITHOUT_CLUB_LOGO, VizConstants.NO_CLUB_LOGO_EN);
		ru.put(WITHOUT_CLUB_LOGO, VizConstants.NO_CLUB_LOGO_RU);
		by.put(WITHOUT_CLUB_LOGO, VizConstants.NO_CLUB_LOGO_BY);
		PATH_MAP.put(AppLocales.BY, by);
		PATH_MAP.put(AppLocales.RU, ru);
		PATH_MAP.put(AppLocales.EN, en);
	}
	
	public static final String UNKNOWN_DATE = "???";
	
	/**
	 * Converts amount of seconds into String representation of time
	 * @param seconds
	 * @return String representation of time
	 */
	public static String convertNumberOfSecondsToTimeRepresentation(int seconds){
		StringBuilder sb = new StringBuilder();
		if(seconds>3600){
			int hours = seconds/3600;
			seconds = seconds%3600;
			sb.append(Integer.toString(hours)+":");
		}
		if(seconds>60){
			int minutes = seconds/60;
			seconds = seconds%60;
			sb.append(minutes<10&&sb.length()>0?"0"+Integer.toString(minutes):sb.length()>0?"0"+Integer.toString(minutes):Integer.toString(minutes));
			sb.append(":");
		}else sb.append(sb.length()==0?"0:":"00:");
		sb.append(seconds>=10&&sb.length()>0?Integer.toString(seconds):"0"+Integer.toString(seconds));
		return sb.toString();
	}
	
	/**
	 * Converts {@java.sql.Date} into String representation like DD.MM.YYYY'
	 * @param seconds
	 * @return String representation of time
	 */
	public static String convertSqlDateToFrontEndRepresentation(Date date){
		if(date==null)return UNKNOWN_DATE;
		String[]dt = date.toString().split("-");
		return dt[2]+"."+dt[1]+"."+dt[0];
	}
	/**
	 * sets avatar path to RunnerInfoTO
	 * <p>
	 * if runner`s avatar is null sets default value for given locale
	 * @param to
	 * @param runner
	 * @param locale
	 */
	@Deprecated
	public static void resolveAvatarPathForRunner(RunnerInfoTO to, RunnerTO runner, Locale locale) {
		if (runner.getAvatar() != null) {
			to.setAvatar(runner.getAvatar());
		} else
			to.setAvatar(AVATAR_MAP.get(runner.getGender()).get(locale));
	}
	
	/**
	 * resolves avatar path for given gender and locale
	 * @param avatar
	 * @param gender
	 * @param locale
	 * @return
	 */
	public static String getAvatarForAvatarPathAndGender(String avatar, Gender gender, Locale locale){
		return avatar!=null?avatar:AVATAR_MAP.get(gender).get(locale);
	}
	
	public static RunnerResultInfoTO convert(RunnerResultTO to, Locale locale){
		RunnerResultInfoTO infoTO = new RunnerResultInfoTO();
		infoTO.setAbsPositionInfo(Integer.toString(to.getAbsPosition()));
		infoTO.setClubLogo(to.getClubLogo());
		infoTO.setClubName(resolveClubName(to.getClubName(),locale));
		infoTO.setLinkToClub(resolveClubLink(to.getClubId()));
		infoTO.setLinkToRace(resolveRaceLink(to.getRaceId()));
		infoTO.setPosInOwnGenderInfo(Integer.toString(to.getPositionInGenderGroup()));
		infoTO.setRaceInfo(Internationalizer.translate(to.getRaceDate(), locale)+" "+to.getParkName());
		infoTO.setTime(convertNumberOfSecondsToTimeRepresentation(to.getTime()));
		return infoTO;
	}
	
	/**
	 * provides link to club`s page for given club id
	 * @param id
	 * @return link
	 */
	public static String resolveClubLink(Long id){
		return !isValidId(id)?EMPTY_LINK:ControllerConstants.CLUB_LINK+id;
	}
	
	/**
	 * resolves clubName using given locale
	 * @param clubName
	 * @param locale
	 * @return
	 */
	public static String resolveClubName(String clubName, Locale locale){
		return clubName!=null?clubName:Internationalizer.translate(Internationalizer.KEY_WITHOUTCLUB, locale);
	}
	
	/**
	 * resolves link to race for given raceId
	 * @param id
	 * @return link to race
	 */
	public static String resolveRaceLink(Long id){
		return !isValidId(id)?EMPTY_LINK:ControllerConstants.RACE_LINK+id;
	}
	
	/**
	 * resolves city for frond-end representation
	 * @param city
	 * @param locale
	 * @return city
	 */
	public static String resolveCity(String city, Locale locale){
		return city!=null?city:Internationalizer.translate(Translator.KEY_UNKNOWN, locale);
	}
	
	/**
	 * Resolves club`s logo image path
	 * <p>
	 * If logo is not null returns the same logo
	 * <p>
	 * if logo is null returns image "no logo" using given locale
	 * 
	 * @param logo
	 * @param locale
	 * @return
	 */
	public static String resolveClubLogo(String logo, Locale locale) {
		return logo != null ? logo : PATH_MAP.get(locale).get(CLUB_NO_LOGO);
	}
	
	/**
	 * Concats full name for firstName and lastName
	 * @param firstName
	 * @param lastName
	 * @return String
	 */
	public static String concatName(String firstName, String lastName){
		return firstName+" "+lastName;
	}
	
	/**
	 * builds title of the race for given parameters
	 * @param raceName
	 * @param parkName
	 * @param raceDate
	 * @param locale
	 * @return
	 */
	public static String buildRaceName(String raceName, String parkName, Date raceDate, Locale locale){
		return raceName==null?parkName+" "+Internationalizer.translate(raceDate, locale):raceName;
	}
	
	/**
	 * Produces string representation of best result for given TO
	 * @param to
	 * @param locale
	 * @return String
	 */
	public static String buildRaceResultStringForBestResultReport(RaceClubResultTO to, Locale locale) {
		return Internationalizer.translate(to.getGender() == Gender.FEMALE ? KEY_AMONG_WOMEN : KEY_AMONG_MEN, locale)
				+ DUALPOINT + SPACE + concatName(to.getRunnerFirstName(), to.getRunnerLastName()) + SPACE + HYPHEN
				+ convertNumberOfSecondsToTimeRepresentation(to.getTimeInSeconds());
	}
	
	/**
	 * Returns link to runner`s page for given runner id
	 * @param runnerId
	 * @param locale
	 * @return String link
	 */
	public static String resolveRunnerPageLink(Long runnerId, Locale locale) {
		return !isValidId(runnerId) ? EMPTY_LINK : buildRunnerPagePath(runnerId, locale);
	}
	
	private static String buildRunnerPagePath(Long runnerId, Locale locale) {
		return ControllerConstants.RUNNER_LINK + runnerId;
	}
	
	/**
	 * Resolves source path for small club`s avatar
	 * 
	 * @param logo
	 * @return
	 */
	public static String resolveClubSmallLogo(String logo, String clubName, Long id, Locale locale) {
		return !isValidId(id) ? VizConstants.UNKNOWN_CLUB_LOGO
				: clubName != null ? (logo != null ? logo : null)
						: PATH_MAP.get(locale).get(WITHOUT_CLUB_LOGO);
	}


	/**
	 * 
	 * @param clubName
	 * @param runnerId
	 * @param locale
	 * @return
	 */
	public static String resolveClubName(String clubName, Long runnerId, Locale locale) {
		if (clubName == null) {
			if (!isValidId(runnerId)) {
				return Internationalizer.translate(KEY_UNKNOWN, locale);
			} else
				return Internationalizer.translate(KEY_WITHOUTCLUB, locale);
		} else
			return clubName;
	}
	
	/**
	 * id should be valid
	 * returns false if id<=0L or id==null and true if another
	 * @param id
	 * @return boolean
	 */
	public static boolean isValidId(Long id) {
		return id == null ? false : id <= 0 ? false : true;
	}
	
	/**
	 * returns String for default club`s logo
	 * <p>
	 * Returns first letters for one-word`s name
	 * <p>
	 * Or first letters for complex name
	 * Examples:
     * <blockquote><pre>
     * "MinskRun" - returns "Mi"
     * "Irun Brest" - returns "IB"
     * "Run 1990" - returns "Ru"
     * "Bi-2" - returns "B2"
     * </pre></blockquote>
	 * @param clubName
	 * @return
	 */
	public static String clubNameFirstLettersForClubClogo(String clubName) {
		if (clubName.length() <= 2)
			return clubName;
		String regex = clubName.indexOf("-") == -1 ? " " : "-";
		StringBuilder sb = new StringBuilder();
		String words[] = clubName.split(regex);
		if (words.length > 1) {
			sb.append(Character.toUpperCase(words[0].charAt(0)));
			sb.append(Character.isDigit(words[1].charAt(0)) && words[0].length() > 2
					? Character.toLowerCase(words[0].charAt(1)) : Character.toUpperCase(words[1].charAt(0)));
		} else
			sb.append(clubName.substring(0, 2));
		return sb.toString();
	}
	
	public static String resolveSmallAvatarForRaceResultPage(String avatar, Gender gender) {
		return avatar != null ? avatar
				: (gender == Gender.MALE ? VizConstants.RACE_RESULT_NO_AVATAR_MALE
						: VizConstants.RACE_RESULT_NO_AVATAR_FEMALE);
	}
	
}

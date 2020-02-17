package by.irun.viz.utils;

import java.sql.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import by.irun.controller.ControllerConstants;
import by.irun.domain.Gender;
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
public class VizUtils {
	
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
		sb.append(seconds>10&&sb.length()>0?Integer.toString(seconds):"0"+Integer.toString(seconds));
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
	public static void resolveAvatarPathForRunner(RunnerInfoTO to, RunnerTO runner, Locale locale) {
		if (runner.getAvatar() != null) {
			to.setAvatar(runner.getAvatar());
		} else
			to.setAvatar(AVATAR_MAP.get(runner.getGender()).get(locale));
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
		return id==null?EMPTY_LINK:ControllerConstants.CLUB_LINK+id;
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
		return id==null?EMPTY_LINK:ControllerConstants.RACE_LINK+id;
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
}

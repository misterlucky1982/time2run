package by.irun.viz.utils;

import java.sql.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import by.irun.domain.Gender;
import by.irun.domain.Runner;
import by.irun.locale.AppLocales;
import by.irun.viz.to.RunnerInfoTO;

/**
 * this class provides utility methods for front-end representation
 * 
 * @author A.Dubovik
 */
public class VizUtils {
	
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
	public static void resolveAvatarPathForRunner(RunnerInfoTO to, Runner runner, Locale locale) {
		if (runner.getAvatar() != null) {
			to.setAvatar(runner.getAvatar().getLocation());
		} else
			to.setAvatar(AVATAR_MAP.get(runner.getGender()).get(locale));
	}
}

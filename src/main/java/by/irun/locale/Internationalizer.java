package by.irun.locale;

import java.sql.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Provides methods for internationalization
 * 
 * @author A.Dubovik
 *
 */
public class Internationalizer {
	
	private static final Map<Locale,Map<String,String>> MOTH_TODATE_MAP;
	static{
		MOTH_TODATE_MAP = new HashMap<>();
		Map<String,String> by = new HashMap<>();
		Map<String,String> ru = new HashMap<>();
		Map<String,String> en = new HashMap<>();
		by.put("01", "студзеня");
		ru.put("01", "января");
		en.put("01", "January");
		by.put("02", "лютага");
		ru.put("02", "февраля");
		en.put("02", "February");
		by.put("03", "сакавіка");
		ru.put("03", "марта");
		en.put("03", "March");
		by.put("04", "красавіка");
		ru.put("04", "апреля");
		en.put("04", "April");
		by.put("05", "мая");
		ru.put("05", "мая");
		en.put("05", "May");
		by.put("06", "чэрвеня");
		ru.put("06", "июня");
		en.put("06", "June");
		by.put("07", "ліпеня");
		ru.put("07", "июля");
		en.put("07", "July");
		by.put("08", "жніўня");
		ru.put("08", "августа");
		en.put("08", "August");
		by.put("09", "верасня");
		ru.put("09", "сентября");
		en.put("09", "September");
		by.put("10", "кастрычніка");
		ru.put("10", "октября");
		en.put("10", "October");
		by.put("11", "лістапада");
		ru.put("11", "ноября");
		en.put("11", "November");
		by.put("12", "снежня");
		ru.put("12", "декабря");
		en.put("12", "December");
		MOTH_TODATE_MAP.put(AppLocales.BY, by);
		MOTH_TODATE_MAP.put(AppLocales.EN, en);
		MOTH_TODATE_MAP.put(AppLocales.RU, ru);
	}
	
	private Internationalizer(){}

	/**
	 * Translates {@link java.sql.Date} to String representation
	 * using given locale
	 * @param date
	 * @return String
	 */
	public static String translate(Date date, Locale locale){
		String[]lines = date.toString().split("-");
		StringBuilder sb = new StringBuilder();
		sb.append(date(lines[2]));
		sb.append(" ");
		sb.append(MOTH_TODATE_MAP.get(locale).get(lines[1]));
		sb.append(" ");
		sb.append(lines[0]);
		if(locale!=AppLocales.EN)sb.append("г.");
		return sb.toString();
	}
	
	/**
	 * Translates {@link java.sql.Date} to String representation
	 * using default {@link java.util.Locale}
	 * @param date
	 * @return String
	 */
	public static String translate(Date date){
		return translate(date,AppLocales.DEFAULT);
	}
	
	/**
	 * Cuts lead zeros from date`s String literal if it starts from zero
	 * <p>
	 * '01' -> '1'
	 * <p>
	 * '22' -> '22'
	 * 
	 * @param dateOfMonth
	 * @return String
	 */
	private static String date(String dateOfMonth){
		if(dateOfMonth.charAt(0)=='0')return dateOfMonth.substring(1);
		return dateOfMonth;
	}
	
}

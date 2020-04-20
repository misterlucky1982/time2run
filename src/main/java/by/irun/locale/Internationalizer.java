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
public class Internationalizer implements Translator{
	
	private static final Map<Locale,Map<String,String>> TRANSLATIONS;
	static{
		TRANSLATIONS = new HashMap<>();
		Map<String,String> by = new HashMap<>();
		Map<String,String> ru = new HashMap<>();
		Map<String,String> en = new HashMap<>();
		/*
		 * temporary solution
		 * until resoursebundle not implemented
		 */
		by.put(KEY_WITHOUTCLUB, "без клубу");
		ru.put(KEY_WITHOUTCLUB, "без клуба");
		en.put(KEY_WITHOUTCLUB, "no club");
		by.put(KEY_UNKNOWN, "невядома");
		ru.put(KEY_UNKNOWN, "неизвестно");
		en.put(KEY_UNKNOWN, "unknown");
		by.put(KEY_MENS_RESULTS, "вынікі мужчын");
		ru.put(KEY_MENS_RESULTS, "результаты мужчин");
		en.put(KEY_MENS_RESULTS, "men`s results");
		by.put(KEY_WOMENS_RESULTS, "вынікі жанчын");
		ru.put(KEY_WOMENS_RESULTS, "результаты женщин");
		en.put(KEY_WOMENS_RESULTS, "womens results");
		by.put(KEY_IN_PARK, "у парке");
		ru.put(KEY_IN_PARK, "в парке");
		en.put(KEY_IN_PARK, "in park");
		by.put(KEY_AMONG_MEN, "сярод мужчын");
		ru.put(KEY_AMONG_MEN, "среди мужчин");
		en.put(KEY_AMONG_MEN, "among men");
		by.put(KEY_AMONG_WOMEN, "сярод жанчын");
		ru.put(KEY_AMONG_WOMEN, "среди женщин");
		en.put(KEY_AMONG_WOMEN, "among women");
		by.put(KEY_UNKNOWN_PARTICIPANT, "Невядомы ўдзельнік");
		ru.put(KEY_UNKNOWN_PARTICIPANT, "Неизвестный участник");
		en.put(KEY_UNKNOWN_PARTICIPANT, "Unknown participant");
		by.put(KEY_LAST_EVENT, "апошняя падзея");
		ru.put(KEY_LAST_EVENT, "последнее событие");
		en.put(KEY_LAST_EVENT, "last event");
		by.put(KEY_RACE, "забег");
		ru.put(KEY_RACE, "забег");
		en.put(KEY_RACE, "race");
		by.put(KEY_SELECTED_RACE, "абраны забег");
		ru.put(KEY_SELECTED_RACE, "выбранный забег");
		en.put(KEY_SELECTED_RACE, "selected race");
		by.put(KEY_UNCOMPLETED_START_DATE_WARNING, "СКОНЧЫЦЕ ЗАПАЎНЕННЕ ПАЧАТКОВАЙ ДАТЫ");
		ru.put(KEY_UNCOMPLETED_START_DATE_WARNING, "ЗАВЕРШИТЕ ЗАПОЛНЕНИЕ НАЧАЛЬНОЙ ДАТЫ");
		en.put(KEY_UNCOMPLETED_START_DATE_WARNING, "COMPLETE THE FILLING OF START DATE");
		by.put(KEY_UNCOMPLETED_FINISH_DATE_WARNING, "СКОНЧЫЦЕ ЗАПАЎНЕННЕ КАНЧАТКОВАЙ ДАТЫ");
		ru.put(KEY_UNCOMPLETED_FINISH_DATE_WARNING, "ЗАВЕРШИТЕ ЗАПОЛНЕНИЕ КОНЕЧНОЙ ДАТЫ");
		en.put(KEY_UNCOMPLETED_FINISH_DATE_WARNING, "COMPLETE THE FILLING OF FINISH DATE");
		by.put(KEY_INCORRECT_DATE_PARAMS_WARNING, "НЕКАРЭКТНА ЗАПОЎНЕНЫ ПАРАМЕТРЫ ЧАСУ");
		ru.put(KEY_INCORRECT_DATE_PARAMS_WARNING, "ПАРАМЕТРЫ НАЧАЛЬНОЙ И КОНЕЧНОЙ ДАТ НЕКОРРЕКТНО ЗАПОЛНЕНЫ");
		en.put(KEY_INCORRECT_DATE_PARAMS_WARNING, "INCORRECT DATE`s PARAMS ENTERED");
		by.put(KEY_EVENTS_EMPTY_RESULT_MESSAGE, "ПА ЎВЕДЗЕНЫМ ПАРАМЕТРАМ ВЫНІКАЎ НЯМА");
		ru.put(KEY_EVENTS_EMPTY_RESULT_MESSAGE, "ПО ВВЕДЁННЫМ ПАРАМЕТРАМ РЕЗУЛЬТАТОВ НЕТ");
		en.put(KEY_EVENTS_EMPTY_RESULT_MESSAGE, "THERE ARE NO RACES FOR ENTERED PARAMS");
		
		TRANSLATIONS.put(AppLocales.BY, by);
		TRANSLATIONS.put(AppLocales.RU, ru);
		TRANSLATIONS.put(AppLocales.EN, en);
	}
	
	private static final Map<Locale,Map<String,String>> MONTH_TODATE_MAP;
	static{
		MONTH_TODATE_MAP = new HashMap<>();
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
		MONTH_TODATE_MAP.put(AppLocales.BY, by);
		MONTH_TODATE_MAP.put(AppLocales.EN, en);
		MONTH_TODATE_MAP.put(AppLocales.RU, ru);
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
		sb.append(MONTH_TODATE_MAP.get(locale).get(lines[1]));
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
	
	/**
	 * Translates given key using given locale
	 * @param key
	 * @param locale
	 * @return
	 */
	public static String translate(String key, Locale locale){
		return TRANSLATIONS.get(locale).get(key);
	}
	/**
	 * Translates given key using default locale
	 * @param key
	 * @return
	 */
	public static String translate(String key){
		return translate(key, AppLocales.DEFAULT);
	}
}

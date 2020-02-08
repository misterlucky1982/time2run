package by.irun.locale;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
/**
 * this class provides Locale constants that are used in application
 * @author A.Dubovik
 *
 */
public class AppLocales {
	
	public static final Locale BY = new Locale("by","BY");
	public static final Locale RU = new Locale("ru","RU");
	public static final Locale EN = new Locale("en","GB");
	public static final Locale DEFAULT = RU;
	private final static Map<String,Locale> LOCALES;
	static{
		LOCALES = new HashMap<>();
		LOCALES.put("BY", BY);
		LOCALES.put("RU", RU);
		LOCALES.put("EN", EN);
	}
	
	private AppLocales(){}

	/**
	 * returns Locale for given key
	 * <p>
	 * If there is no such Locale or key is null returns default locale for application scope
	 * @param key
	 * @return Locale
	 */
	public static Locale getLocale(String key){
		return key==null?DEFAULT:LOCALES.get(key.toUpperCase())!=null?LOCALES.get(key.toUpperCase()):DEFAULT;
	}
}

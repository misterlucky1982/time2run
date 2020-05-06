package by.irun.config;

import org.assertj.core.util.Arrays;

import by.irun.controller.ControllerConstants;
import by.irun.locale.AppLocales;

public class ConfigHelper {
	
	public static final String EVENTS_PAGE = "events";
	public static final String RACE_PAGE = "race";
	public static final String CLUB_PAGE = "club";
	public static final String RUNNER_PAGE = "runner";
	
	public static final String[] JS_UNSECURED_RESOURCES = {
			"scripts/**/*"
	};
	
	private ConfigHelper(){}
	
	public static String[] allPublicResourcesFor(String pageName){
		switch(pageName){
		case EVENTS_PAGE:
			return localePageResources(ControllerConstants.EVENTS_PAGE,ControllerConstants.EVENTS_RACEINFOREQUEST,ControllerConstants.EVENTS_RACEREQUEST, ControllerConstants.EVENTS_WARNING);
		case RACE_PAGE:
			return localePageResourcesWithParameters(ControllerConstants.RACE_PAGE);
		case CLUB_PAGE:
			return localePageResourcesWithParameters(ControllerConstants.CLUB_PAGE);
		case RUNNER_PAGE:
			return localePageResourcesWithParameters(ControllerConstants.RUNNER_PAGE);
		}
		return Arrays.array();
	}
	
	private static String[] localePageResources(String res, String... args) {
		String[] locales = AppLocales.mappings();
		String[] result = new String[args.length*(locales.length+1)];
		int index = 0;
		for(String s: locales){
			result[index++] = s+"/"+res;
		}
		for(String s:locales){
			for(String arg:args){
				result[index++]=s+"/"+arg;
			}
		}
		return result;
	}
	
	private static String[] localePageResourcesWithParameters(String... args) {
		String[] locales = AppLocales.mappings();
		String result[] = new String[locales.length * args.length];
		for (int i = 0; i < locales.length; i++) {
			for (int x = 0; x < args.length; x++) {
				result[i + x] = locales[i] + "/"+args[x];
			}
		}
		return result;
	}

}

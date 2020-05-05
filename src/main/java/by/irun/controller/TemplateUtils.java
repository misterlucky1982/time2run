package by.irun.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import by.irun.locale.Internationalizer;
import by.irun.locale.Translator;
import by.irun.viz.utils.VizConstants;

public class TemplateUtils {

	public static Map<String, String> resolveMapForRaceListWarningMessage(String paramValue, Locale locale) {
		Map<String, String> map = new HashMap<>();
		switch (paramValue) {
		case ControllerConstants.PARAM_FROM_DATE_WARNING_REQEST_PARAMVALUE:
			map.put(TemplateConstants.KEY_MESSAGE,
					Internationalizer.translate(Translator.KEY_UNCOMPLETED_START_DATE_WARNING, locale));
			break;
		case ControllerConstants.PARAM_FOR_DATE_WARNING_REQEST_PARAMVALUE:
			map.put(TemplateConstants.KEY_MESSAGE,
					Internationalizer.translate(Translator.KEY_UNCOMPLETED_FINISH_DATE_WARNING, locale));
			break;
		case ControllerConstants.PARAM_BOTH_FROM_FOR_DATE_WARNING_REQEST_PARAMVALUE:
			map.put(TemplateConstants.KEY_MESSAGE,
					Internationalizer.translate(Translator.KEY_INCORRECT_DATE_PARAMS_WARNING, locale));
		}
		map.put(TemplateConstants.KEY_CLASS, TemplateConstants.CLASS_WARNING_MESSAGE);
		map.put(TemplateConstants.KEY_SRC, VizConstants.WARNING_SRC);
		return map;
	}
}

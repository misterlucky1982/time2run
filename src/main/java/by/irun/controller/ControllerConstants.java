package by.irun.controller;


/**
 * This class provides constants that are used in Controller classes
 * <p>
 * Also its provides String variables for creation links on UI
 * @author A.Dubovik
 *
 */
public class ControllerConstants {
	
	private ControllerConstants(){}
	
	public static final String PARAM_FROM_DATE_WARNING_REQEST_PARAMVALUE = "from";
	public static final String PARAM_FOR_DATE_WARNING_REQEST_PARAMVALUE = "for";
	public static final String PARAM_BOTH_FROM_FOR_DATE_WARNING_REQEST_PARAMVALUE = "both";
	
	public static final String EVENTS_PAGE = "events";
	public static final String EVENTS_RACEREQUEST = EVENTS_PAGE+"/races";
	public static final String EVENTS_RACEINFOREQUEST = EVENTS_PAGE+"/races/info";
	public static final String EVENTS_WARNING = EVENTS_PAGE+"/warning";
	
	public static final String CLUB_PAGE = "clubs";
	public static final String CLUB_LINK = CLUB_PAGE+"?id=";
	
	public static final String RACE_PAGE = "race";
	public static final String RACE_LINK = RACE_PAGE+"?id=";
	
	public static final String RUNNER_PAGE = "runner";
	public static final String RUNNER_LINK = RUNNER_PAGE+"?id=";
	
}

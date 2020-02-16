package by.irun.controller;

import by.irun.config.ApplicationConstants;

/**
 * This class provides constants that are used in Controller classes
 * <p>
 * Also its provides String variables for creation links on UI
 * @author A.Dubovik
 *
 */
public class ControllerConstants {
	
	private ControllerConstants(){}

	public static final String CLUB_LINK = ApplicationConstants.URL+"/app/clubs?id=";
	public static final String RACE_LINK = ApplicationConstants.URL+"/app/races?id=";
}

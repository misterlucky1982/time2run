package by.irun.viz.utils;

public class JSUtils {
	
	public static String clickToRaceInRaceList(Long raceId){
		return clickToRaceInRaceList(Long.toString(raceId));
	}
	
	public static String clickToRaceInRaceList(String raceId){
		return "showRaceInfo("+raceId+")";
	}

}

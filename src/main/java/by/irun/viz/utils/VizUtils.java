package by.irun.viz.utils;

import java.sql.Date;

/**
 * this class provides utility methods for front-end representation
 * 
 * @author A.Dubovik
 */
public class VizUtils {
	
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
}

package by.irun.viz.utils;

public class JSHelper {
	
	private static final String PATH_ARGUMENT = "%";
	private static final String GO_TO_RUNNER_PAGE_FUNCTION = "goToRunnerPage(%)";
	public static final String NULL= "null";
	
	public static String goToRunnerPageFunction(String link){
		return GO_TO_RUNNER_PAGE_FUNCTION.replaceAll(PATH_ARGUMENT, link);
	}

	
}

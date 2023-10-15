package constants;

import utils.CommonUtils;

public class FileConstants {
	
	public static final String REPORT_PATH = System.getProperty("user.dir")+"/src/main/resources/reports/"
			+CommonUtils.getStringDateAndTimeStamp()+"_ECMT.html";
	
	public static final String SCREEN_SHOT_PATH= System.getProperty("user.dir")+"/src/main/resources/reports/"
			+CommonUtils.getStringDateAndTimeStamp()+"_ECMT.PNG";
}

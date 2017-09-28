package by.htp.news.controller.resource;

import java.util.ResourceBundle;

public class PropManager {
	private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("page");
	private PropManager() {}
	public static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}

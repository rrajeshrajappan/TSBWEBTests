package frameworkinterfaces;

import browserconfigurations.BrowserType;

public interface IconfigReader {
	public String getHomepage();
	public String getUsedMotorspage();
	public String getUsedcarsListingpage();
	public int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	public BrowserType getBrowser();
}

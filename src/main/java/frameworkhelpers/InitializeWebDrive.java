package frameworkhelpers;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import browserconfigurations.BrowserType;
import browserconfigurations.ChromeBrowser;
import browserconfigurations.IExploreBrowser;
import browserconfigurations.PhantomJsBrowser;
import configreader.PropertyFileReader;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import exceptionhandlers.NoSutiableDriverFoundException;
import frameworksettings.ObjectRepo;
import generichelpermethods.GenericHelper;
import loggerhelpers.LoggerHelper;

public class InitializeWebDrive {

	private Logger oLog = LoggerHelper.getLogger(InitializeWebDrive.class);

	public InitializeWebDrive(PropertyFileReader reader) {
		ObjectRepo.reader = reader;
	}

	public WebDriver standAloneStepUp(BrowserType bType) throws Exception {
		try {
			oLog.info(bType);

			switch (bType) {

			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());

			case Iexplorer:
				IExploreBrowser iExplore = IExploreBrowser.class.newInstance();
				return iExplore.getIExplorerDriver(iExplore
						.getIExplorerCapabilities());

			case PhantomJs:
				PhantomJsBrowser jsBrowser = PhantomJsBrowser.class
						.newInstance();
				return jsBrowser.getPhantomJsDriver(
						jsBrowser.getPhantomJsService(),
						jsBrowser.getPhantomJsCapability());

			default:
				throw new NoSutiableDriverFoundException(" Driver Not Found : "
						+ ObjectRepo.reader.getBrowser());
			}
		} catch (Exception e) {
			oLog.equals(e);
			throw e;
		}
	}
	
	@Before({"~@phantomjs","~@chrome","~@iexplorer"})
	public void before() throws Exception {
		setUpDriver(ObjectRepo.reader.getBrowser());
		oLog.info(ObjectRepo.reader.getBrowser());
	}

	@After({"~@chrome","~@phantomjs","~@iexplorer"})
	public void after(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}
	
	@Before(order=3,value={"@iexplorer"})
	public void beforeExplorer() throws Exception {
		setUpDriver(BrowserType.Iexplorer);
		oLog.info(BrowserType.Iexplorer);
	}

	@After(order=3,value={"@iexplorer"})
	public void afterExplorer(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	@Before(order=2,value={"@chrome"})
	public void beforeChrome() throws Exception {
		setUpDriver(BrowserType.Chrome);
		oLog.info(BrowserType.Chrome);
	}

	@After(order=2,value={"@chrome"})
	public void afterChrome(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	@Before(order=1,value={"@phantomjs"})
	public void beforePhantomjs() throws Exception {
		setUpDriver(BrowserType.PhantomJs);
		oLog.info(BrowserType.PhantomJs);
	}

	@After(order=1,value={"@phantomjs"})
	public void afterPhantomjs(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}

	public void setUpDriver(BrowserType bType) throws Exception {
		ObjectRepo.driver = standAloneStepUp(bType);
		oLog.debug("InitializeWebDrive : " + ObjectRepo.driver.hashCode());
		ObjectRepo.driver
				.manage()
				.timeouts()
				.pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(),
						TimeUnit.SECONDS);
		ObjectRepo.driver
				.manage()
				.timeouts()
				.implicitlyWait(ObjectRepo.reader.getImplicitWait(),
						TimeUnit.SECONDS);
		ObjectRepo.driver.manage().window().maximize();

	}

	public void tearDownDriver(Scenario scenario) throws Exception {
		
		try {
			if (ObjectRepo.driver != null) {
				
				if(scenario.isFailed())
					scenario.write(new GenericHelper(ObjectRepo.driver).takeScreenShot(scenario.getName()));
				
				ObjectRepo.driver.quit();
				ObjectRepo.reader = null;
				ObjectRepo.driver = null;
				oLog.info("Shutting Down the driver");
			}
		} catch (Exception e) {
			oLog.error(e);
			throw e;
		}
	}
}

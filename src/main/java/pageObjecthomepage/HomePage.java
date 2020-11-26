package pageObjecthomepage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import frameworksettings.ObjectRepo;
import loggerhelpers.LoggerHelper;
import pageObjectHelpers.PageBase;

public class HomePage extends PageBase {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/** Web Elements */
	
	@FindBy(how=How.XPATH,using="//*[@id=\"SearchTabs1_MotorsLink\"]")
	public WebElement motors;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"Control_Table\"]/tbody/tr[2]/td[1]/ul/li[1]/h2/a")
	public WebElement usedcars;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"Control_Table\"]/tbody/tr[2]/td[1]/ul/li[1]/ul/li[1]/a")
	public WebElement carsforsale;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"Control_Table\"]/tbody/tr[2]/td[1]/ul/li[1]/ul/li[1]/span")
	public WebElement count;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AdvancedCarSearchLink\"]")
	public WebElement advancedsearch;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"mainContent\"]/form/table/tbody/tr[1]/td/h1")
	public WebElement advancedsearchform;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"mainContent\"]/form/table/tbody/tr[3]/td[2]")
	public WebElement make;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"form_make\"]")
	public WebElement makelist;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"ListViewList\"]/li[1]")
	public WebElement listings;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AttributesDisplay_attributesSection\"]/ul/li[1]/div[1]/label")
	public WebElement Numberplate;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AttributesDisplay_attributesSection\"]/ul/li[2]/div[1]/label")
	public WebElement Kilometres;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AttributesDisplay_attributesSection\"]/ul/li[3]/div[1]/label")
	public WebElement Body;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AttributesDisplay_attributesSection\"]/ul/li[4]/div[1]/label")
	public WebElement Seats;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AttributesDisplay_attributesSection\"]/ul/li[5]/div[1]/label")
	public WebElement Fueltype;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AttributesDisplay_attributesSection\"]/ul/li[6]/div[1]/label")
	public WebElement Engine;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AttributesDisplay_attributesSection\"]/ul/li[7]/div[1]/label")
	public WebElement Transmission;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AttributesDisplay_attributesSection\"]/ul/li[8]/div[1]/label")
	public WebElement History;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AttributesDisplay_attributesSection\"]/ul/li[9]/div[1]/label")
	public WebElement Registrationexpires;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AttributesDisplay_attributesSection\"]/ul/li[10]/div[1]/label")
	public WebElement WoFexpires;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"AttributesDisplay_attributesSection\"]/ul/li[12]/div[1]/label")
	public WebElement Modeldetail;
			
	public WebDriver getDriver() {
		return this.driver;
	}
}

package StepDefinitions;

import org.openqa.selenium.Keys;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import frameworksettings.ObjectRepo;
import pageObjecthomepage.HomePage;

public class TMEMotorsSearchStepDfn {
	
	private HomePage hPage;
	
	@Given("^: I am at the Trademe home page$")
	public void i_am_at_the_Trademe_home_page() throws Throwable {
		
		ObjectRepo.driver.get(ObjectRepo.reader.getHomepage());
		hPage = new HomePage(ObjectRepo.driver);
		ObjectRepo.data.put("HomePage", hPage);
	}

	@When("^: I click on the motors link$")
	public void i_click_on_the_motors_link() throws Throwable {
		hPage.motors.click();
	}

	@Then("^: I should be at the Motors page$")
	public void i_should_be_at_the_Motors_page() throws Throwable {
		hPage.usedcars.isDisplayed();
	}

	@Then("^: I can see used_cars link with at least one listing$")
	public void i_can_see_used_cars_link_with_at_least_one_listing() throws Throwable {
		String cvalue = hPage.count.getText();
		String trimmedcvalue = cvalue.replaceFirst(".*?(\\d+).*", "$1");
		int count  = Integer.parseInt(trimmedcvalue);
		if (count > 1)
		{
		System.out.println("The no of listings are: " + count + "\nHurray .. We got more than 1 listings");
		}
		else System.out.println("We got no listings");
	}

	@Given("^: I am at the used_cars page$")
	public void i_am_at_the_used_cars_page() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getUsedMotorspage());
		hPage = new HomePage(ObjectRepo.driver);
		ObjectRepo.data.put("UsedMotorspage", hPage);
	}

	@When("^: I click on the Advanced_car_search link$")
	public void i_click_on_the_Advanced_car_search_link() throws Throwable {
		hPage.advancedsearch.click();
	}

	@Then("^: I should be at the Advanced_car_search form$")
	public void i_should_be_at_the_Advanced_car_search_form() throws Throwable {
		Assert.assertTrue(hPage.advancedsearchform.isDisplayed());
	}

	@And("^: Make list box should contains Kia$")
	public void make_list_box_should_contains_Kia() throws Throwable {
		hPage.makelist.sendKeys("Kia");
		hPage.makelist.sendKeys(Keys.ENTER);
		Assert.assertTrue(hPage.make.isDisplayed());
	}

	@When("^: I click on any existing_listings$")
	public void i_click_on_any_existing_listings() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getUsedcarsListingpage());
		hPage = new HomePage(ObjectRepo.driver);
		ObjectRepo.data.put("UsedcarsListingpage", hPage);
		hPage.listings.click();
	}

	@Then("^: I should be see the following Details on the listing page$")
	public void i_should_be_see_the_following_Details_on_the_listing_page(DataTable arg1) throws Throwable {
		Assert.assertEquals(true, hPage.Numberplate.isDisplayed());
		Assert.assertEquals(true, hPage.Kilometres.isDisplayed());
		Assert.assertEquals(true, hPage.Body.isDisplayed());
		Assert.assertEquals(true, hPage.Seats.isDisplayed());
		Assert.assertEquals(true, hPage.Fueltype.isDisplayed());
		Assert.assertEquals(true, hPage.Engine.isDisplayed());
		Assert.assertEquals(true, hPage.Transmission.isDisplayed());
		Assert.assertEquals(true, hPage.History.isDisplayed());
		Assert.assertEquals(true, hPage.Registrationexpires.isDisplayed());
		Assert.assertEquals(true, hPage.WoFexpires.isDisplayed());
		Assert.assertEquals(true, hPage.Modeldetail.isDisplayed());
	}
}

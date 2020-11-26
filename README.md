### BDD Framework with Cucumber for TMEUsedMotors feature

The framework has following features 

1. Modular Design
2. Maven based framework, Dependancy management through POM
3. Log4j enabled for logging
4. Report Generation (cucumber-reporting) 
5. Helper class to handle web component such as (Button,Link etc)
6. Centralized Configuration (Using Properties file)
7. Hooks for different browser support (using tag @chrome,@iexplorer...)

### Add the Feature file 
Add the feature file under `test\resources\featurefile`

```
Feature: UsedCars feature of the Trademe web page

  Scenario: Check there is at least one listing in the TradeMe UsedCars category
    Given : I am at the Trademe motors home page
    When : I click on the "Cars_for_sale" link
    Then : I should be at the "used_cars" page with at least one listing

  Scenario: Check that the make ‘Kia’ exists.
    Given : I am at the "used_cars" page
    When : I click on the "Advanced_car_search" link
    Then : I should be at the "Advanced_car_search" form 
    And : The make list box should contains "Kia" 

  Scenario: Query any existing Used Car listing and confirm that the following details are shown for that car
    Given : I am at the "used_cars" page
    When : I click on any "existing_listings" 
    Then : I should be see the following "Details" on the listing page
    |Details|
    |Number plate|
		|Kilometres|
		|Body|
		|Seats|
		|Fuel type|
		|Engine|
		|Transmission|
		|History|
		|Registration expires|
		|WoF expires|
		|Model detail|
```

### Create the Runner

```
package com.cucumber.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/TMEMotorsSearch.feature" }, glue = {
		"classpath:com.cucumber.framework.stepdefinition",
		"classpath:com.cucumber.framework.helper" }, plugin = { "pretty",
		"json:target/TMEMotorsSearchFeatureRunner.json" })
public class TMEMotorsSearchFeatureRunner extends AbstractTestNGCucumberTests {
}
```
 
### Use the testng.xml file to run the test cases

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite">
	<listeners>
		<listener
			class-name="com.cucumber.framework.listeners.reportlistener.CucumberReport" />
	</listeners>
	<test name="TMEUsedMotorsSearchTests">
		<classes>
			<class name="com.cucumber.framework.runner.TMEMotorsSearchFeatureRunner" />
		</classes>
	</test>
</suite> 
```

### To see this whole thing running simply checkout this project and run this command:

`mvn clean generate-sources test`




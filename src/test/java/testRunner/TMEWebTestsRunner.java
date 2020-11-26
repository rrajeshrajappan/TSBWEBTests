package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:featurefile/TMEWebTests.feature" }, glue = {
		"classpath:StepDefinitions", "classpath:frameworkhelpers" }, plugin = { "pretty",
		"json:target/TMEWebTestsRunner.json" })
public class TMEWebTestsRunner extends AbstractTestNGCucumberTests {
}

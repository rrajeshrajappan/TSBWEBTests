Overview:

- This TSBWebTests testing project covers the few of the trademe sandbox web application features
- Java/Selenium/TestNg/Cucumber BDD is used here to build this test framework

Framework flow:
src/main/java/
 - All ReusableMethods like helpers, utilities, web browser/element hanndlers added here
 - Pageobject classes contains the trademe web application object information like, web links, labels, list boxes...etc.,

src/main/resources/ 
- Contains all the framework configurations (application, logger configs), drivers (chrome, IE..)

src/test/java/
 - TMEMotorsSearchStepDfn.java (test validation class created aginst the requirements in the feature file)
 - TMEWebTestsRunner.java (test runner class)
 - testng.xml (helps to execute the tests)

src/test/resources/featurefile/
 - TMEWebTests.feature (feature file contains the requirements)

TSBWEBTests/test-output/Suite
 - TMEUsedMotorsSearchTests.html (contains the test results, please open with web browser)

How to Build this project?

- Install Eclipse/intelliJ or some java IDE
- Import this Gradle project from Github --> https://github.com/rrajeshrajappan/TSBWEBTests.git
- Setup the workspace in your IDE
- build the gradle project using build.gradle
- Run the tests from testng.xml (RunAs -> TestNg Suite)
- .html test reports generates under TSBWEBTests/test-output/Suite -> MEUsedMotorsSearchTests.html

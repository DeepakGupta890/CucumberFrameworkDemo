package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber", glue="framework.MavenStructuredFrameworkDesign.stepDefinations",
monochrome=true, tags= "@Regression" ,plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	
	
//tags is similar to groups in testng it will cause to run the test which is address in it otherwise
}

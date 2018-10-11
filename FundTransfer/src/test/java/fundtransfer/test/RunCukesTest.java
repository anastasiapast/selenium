package fundtransfer.test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/report/report.html",
	    "json:target/report/cucu_json_report.json",
	    "junit:target/report/cucumber_junit_report.xml"})

public class RunCukesTest {

}

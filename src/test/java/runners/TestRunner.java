package runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(features = "src/test/resources/features",
glue = {"steps","hooks"}, tags = "@petapitest")

public class TestRunner {

}

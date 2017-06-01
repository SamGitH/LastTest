package com.samTest.BDD;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Олег on 01.06.2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"json:target/reports/mainReport.json"},
        features = {"src/test/resources/Features"},
        glue = {"com.samTest.BDD"} )

public class Runner {
}

package com.saucedemo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    plugin = {
            "json:target/cucumber.json",
            "html:target/html-reports.html",
            "rerun:target/rerun.txt",
            "pretty"
    },
        features = "src/test/resources/feature",
        glue = "com/saucedemo/step_defs",
        dryRun = false,
        tags = "@wip"



)
public class Cukes_Runner {
}

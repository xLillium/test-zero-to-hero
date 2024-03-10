package fr.olympp.techtalk.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"fr.olympp.techtalk.cucumber"},
        plugin = {"json:target/cucumber-reports/Cucumber.json"},
        monochrome = true
)
public class GildedRoseTestRunner {
}

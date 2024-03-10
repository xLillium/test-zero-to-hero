package fr.olympp.techtalk.cucumber;

import fr.olympp.techtalk.GildedRose;
import fr.olympp.techtalk.Item;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseSteps {
    private Item[] items;
    private GildedRose gildedRose;

    @Given("a {string} with a sell-in of {int} and a quality of {int}")
    public void a_with_a_sell_in_of_and_a_quality_of(String itemName, int sellIn, int quality) {
        items = new Item[]{new Item(itemName, sellIn, quality)};
        gildedRose = new GildedRose(items);
    }

    @When("a day passes")
    public void aDayPasses() {
        gildedRose.updateQuality();
    }

    @Then("its quality should be {int}")
    public void itsQualityShouldBe(int expectedQuality) {
        assertThat(items[0].quality).isEqualTo(expectedQuality);
    }

    @And("its sell-in should be {int}")
    public void itsSellInShouldBe(int expectedSellin) {
        assertThat(items[0].sellIn).isEqualTo(expectedSellin);
    }

    @When("{int} day\\(s) pass")
    public void daysDaySPass(int days) {
        for (int i = 0; i < days; i++) {
            gildedRose.updateQuality();
        }
    }
}

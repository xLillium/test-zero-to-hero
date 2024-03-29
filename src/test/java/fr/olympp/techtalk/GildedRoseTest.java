package fr.olympp.techtalk;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GildedRoseTest {

    private GildedRose gildedRose;
    private GildedRoseGoldenMaster goldenMaster;

    @Before
    public void setUp() {
        Item[] testItems = TestData.getTestItems();
        gildedRose = new GildedRose(testItems);
        goldenMaster = new GildedRoseGoldenMaster(testItems.clone());
    }

    @Test
    public void shouldUpdateItemQualityAndSellInWhenUpdatingQualityOnce() {
        // Act
        gildedRose.updateQuality();

        // Assert
        assertThat(gildedRose.items).extracting("quality").containsExactly(19, 1, 6, 80, 80, 21, 50, 50);
        assertThat(gildedRose.items).extracting("sellIn").containsExactly(9, 1, 4, 0, -1, 14, 9, 4);
    }

    @Test
    public void shouldMatchGoldenMasterWhenUpdatingQuality100Times() {
        for (int i = 0; i < 100; i++) {
            // Act
            gildedRose.updateQuality();
            goldenMaster.updateQuality();

            // Assert
            assertThat(gildedRose.items).usingElementComparatorOnFields("quality", "sellIn").containsExactly(goldenMaster.items);
        }
    }

    @Test
    public void shouldIncreaseQualityByOneForAgedBrieJustBeforeSellInZero() {
        Item[] items = new Item[] { new Item(Constants.AGED_BRIE, 1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(11);
    }

    @Test
    public void shouldDecreaseQualityTwiceAsFastWhenSellInBelowZero() {
        Item[] items = new Item[] { new Item(Constants.ELIXIR_OF_THE_MONGOOSE, 0, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(8);
    }


    @Test
    public void shouldNotDecreaseQualityBelowZero() {
        Item[] items = new Item[] { new Item(Constants.ELIXIR_OF_THE_MONGOOSE, 5, 0) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(0);
    }


    @Test
    public void shouldIncreaseBackstagePassesQualityByThreeWhenSellInBelowSix() {
        Item[] items = new Item[] { new Item(Constants.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT, 5, 20) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(23);
    }

    @Test
    public void shouldDegradeConjuredItemsTwiceAsFast() {
        Item[] items = new Item[] { new Item(Constants.CONJURED_MANA_CAKE, 3, 6) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(4);
        assertThat(app.items[0].sellIn).isEqualTo(2);
    }

    @Test
    public void shouldDegradeConjuredItemsTwiceAsFastAfterSellInDate() {
        Item[] items = new Item[] { new Item(Constants.CONJURED_MANA_CAKE, 1, 10) };
        GildedRose app = new GildedRose(items);

        app.updateQuality();
        app.updateQuality();

        assertThat(app.items[0].quality).isEqualTo(4);
        assertThat(app.items[0].sellIn).isEqualTo(-1);
    }

}

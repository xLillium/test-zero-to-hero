package fr.olympp.techtalk;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class GildedRoseTest {

    @Test
    public void shouldUpdateItemQualityAndSellInWhenUpdatingQualityOnce() {
        // Arrange
        GildedRose gildedRose = new GildedRose(TestData.getTestItems());

        // Act
        gildedRose.updateQuality();

        // Assert
        assertThat(gildedRose.items).extracting("quality").containsExactly(19, 1, 6, 80, 80, 21, 50, 50);
        assertThat(gildedRose.items).extracting("sellIn").containsExactly(9, 1, 4, 0, -1, 14, 9, 4);
    }

    @Test
    public void shouldMatchGoldenMasterWhenUpdatingQuality100Times() {
        // Arrange
        GildedRose gildedRose = new GildedRose(TestData.getTestItems());
        GildedRoseGoldenMaster goldenMaster = new GildedRoseGoldenMaster(TestData.getTestItems());

        for (int i = 0; i < 100; i++) {
            // Act
            gildedRose.updateQuality();
            goldenMaster.updateQuality();

            // Assert
            assertThat(gildedRose.items).usingElementComparatorOnFields("quality", "sellIn").containsExactly(goldenMaster.items);
        }
    }

}

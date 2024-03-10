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

}

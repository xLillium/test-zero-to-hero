import fr.olympp.techtalk.GildedRose;
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
        assertThat(gildedRose.items).extracting("quality").containsExactly(0);
        assertThat(gildedRose.items).extracting("sellIn").containsExactly(0);
    }

}

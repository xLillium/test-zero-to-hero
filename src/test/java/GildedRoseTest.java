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
        assertThat(gildedRose.items).extracting("quality")
                .containsExactly(19, 1, 6, 80, 80, 21, 50, 50);
        assertThat(gildedRose.items).extracting("sellIn")
                .containsExactly(9, 1, 4, 0, -1, 14, 9, 4);
    }

}

package fr.olympp.techtalk;

public class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateSingleItem(item);
        }
    }

    private void updateSingleItem(Item item) {
        switch (item.name) {
            case Constants.AGED_BRIE:
                updateAgedBrie(item);
                break;
            case Constants.BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                updateBackstagePass(item);
                break;
            case Constants.SULFURAS_HAND_OF_RAGNAROS:
                break; // Sulfuras does not change
            case Constants.CONJURED_MANA_CAKE:
                updateConjuredItem(item);
                break;
            default:
                updateNormalItem(item);
                break;
        }
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        item.sellIn--;

        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void updateBackstagePass(Item item) {
        increaseQuality(item);

        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }

        item.sellIn--;

        if (item.sellIn < 0) {
            item.quality = Constants.MIN_QUALITY;
        }
    }

    private void updateConjuredItem(Item item) {
        decreaseQualityOfConjuredItem(item);
        item.sellIn--;

        if (item.sellIn < 0) {
            decreaseQualityOfConjuredItem(item);
        }
    }

    private void updateNormalItem(Item item) {
        decreaseQuality(item);
        item.sellIn--;

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < Constants.MAX_QUALITY) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > Constants.MIN_QUALITY) {
            item.quality--;
        }
    }

    private void decreaseQualityOfConjuredItem(Item item) {
        decreaseQuality(item);
        decreaseQuality(item);
    }
}

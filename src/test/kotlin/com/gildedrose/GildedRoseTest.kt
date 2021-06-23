package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun itemNameIsCorrect() {
        val item = GildedItem("foo", 0, 0)

        assertEquals("foo", item.name)
    }
    @Test
    fun agedBrieNameIsCorrect() {
        val item = AgedBrie(0, 0)

        assertEquals("Aged Brie", item.name)
    }
    @Test
    fun backstagePassNameIsCorrect() {
        val item = BackstagePass(0, 0)

        assertEquals("Backstage passes to a TAFKAL80ETC concert", item.name)
    }
    @Test
    fun sulfurasNameIsCorrect() {
        val item = Sulfuras(0, 0)

        assertEquals("Sulfuras, Hand of Ragnaros", item.name)
    }
    @Test
    fun conjuredNameIsCorrect() {
        val item = ConjuredItem("cheese", 0, 0)

        assertEquals("Conjured cheese", item.name)
    }

    @Test
    fun normalItemQualityNotNegativeFromZero() {
        val items = arrayOf<GildedItem>(GildedItem("normal", 10, 0))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun agedBrieQualityNeverIncreaseAboveFiftyFromFifty() {
        val items = arrayOf<GildedItem>(AgedBrie(10, 50))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun backstagePassQualityNeverIncreaseAboveFiftyFromFifty() {
        val items = arrayOf<GildedItem>(BackstagePass(2, 50))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun normalItemDecreasesInQualityByOneAfterOneDay() {
        val items = arrayOf<GildedItem>(GildedItem("normal", 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun normalItemDecreasesInQualityByTwoAfterSellByDay() {
        val items = arrayOf<GildedItem>(GildedItem("normal", -1, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun normalItemSellInDecreasesByOneAfterOneDay() {
        val items = arrayOf<GildedItem>(GildedItem("normal", 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun twoNormalItemsQualityDecreasesByOneAfterOneDay() {
        val items = arrayOf<GildedItem>(GildedItem("normal", 10, 12), GildedItem("normal", 10, 8))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(11, app.items[0].quality)
        assertEquals(7, app.items[1].quality)
    }

    @Test
    fun twoNormalItemsSellInDecreasesByOneAfterOneDay() {
        val items = arrayOf<GildedItem>(GildedItem("normal", 12, 10), GildedItem("normal", 8, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(11, app.items[0].sellIn)
        assertEquals(7, app.items[1].sellIn)
    }

    @Test
    fun agedBrieQualityIncreasesByOneAfterOneDay() {
        val items = arrayOf<GildedItem>(AgedBrie(10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(11, app.items[0].quality)
    }
    @Test
    fun agedBrieQualityIncreasesByTwoAfterSellByDay() {
        val items = arrayOf<GildedItem>(AgedBrie(-1, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun backstagePassQualityIncreasesByOneWithElevenSellInDays() {
        val items = arrayOf<GildedItem>(BackstagePass(11, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(11, app.items[0].quality)
    }

    @Test
    fun backstagePassQualityIncreasesByTwoWithTenSellInDays() {
        val items = arrayOf<GildedItem>(BackstagePass(10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun backstagePassQualityIncreasesByTwoWithSixSellInDays() {
        val items = arrayOf<GildedItem>(BackstagePass(6, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(12, app.items[0].quality)
    }

    @Test
    fun backstagePassQualityIncreasesByThreeWithFiveSellInDays() {
        val items = arrayOf<GildedItem>(BackstagePass(5, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun backstagePassQualityIncreasesByThreeWithOneSellInDay() {
        val items = arrayOf<GildedItem>(BackstagePass( 1, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(13, app.items[0].quality)
    }

    @Test
    fun backstagePassQualityIsZeroIfSellInIsZero() {
        val items = arrayOf<GildedItem>(BackstagePass(0, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun sulfurasQualityIsConstant() {
        val items = arrayOf<GildedItem>(Sulfuras( 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(10, app.items[0].quality)
    }

    @Test
    fun sulfurasSellInIsConstant() {
        val items = arrayOf<GildedItem>(Sulfuras(10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(10, app.items[0].sellIn)
    }

    @Test
    fun conjuredItemQualityDecreasesByTwoAfterOneDay() {
        val items = arrayOf<GildedItem>(ConjuredItem("normal", 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(8, app.items[0].quality)
    }
    @Test
    fun conjuredItemQualityDecreasesByFourAfterSellByDay() {
        val items = arrayOf<GildedItem>(ConjuredItem("normal", -10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(6, app.items[0].quality)
    }
}



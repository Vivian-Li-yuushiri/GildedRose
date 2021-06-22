package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun itemNameIsConstant() {
        val items = arrayOf<Item>(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)
    }
    @Test
    fun normalItemQualityNotNegativeFromZero() {
        val items = arrayOf<Item>(Item("normal", 10, 0))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(0, app.items[0].quality)
    }
    @Test
    fun AgedBrieQualityNeverIncreaseAboveFiftyFromFifty() {
        val items = arrayOf<Item>(Item("Aged Brie", 10, 50))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(50, app.items[0].quality)
    }
    @Test
    fun BackstackPassQualityNeverIncreaseAboveFiftyFromFifty() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 2, 50))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun normalItemDecreasesInQualityByOneAfterOneDay() {
        val items = arrayOf<Item>(Item("normal", 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(9, app.items[0].quality)
    }
    @Test
    fun normalItemDecreasesInQualityByTwoAfterSellByDay() {
        val items = arrayOf<Item>(Item("normal", -10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun normalItemSellInDecreasesByOneAfterOneDay() {
        val items = arrayOf<Item>(Item("normal", 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(9, app.items[0].sellIn)
    }

    @Test
    fun twoNormalItemsQualityDecreasesByOneAfterOneDay() {
        val items = arrayOf<Item>(Item("normal", 10, 12), Item("normal", 10, 8))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(11, app.items[0].quality)
        assertEquals(7, app.items[1].quality)
    }
    @Test
    fun twoNormalItemsSellInDecreasesByOneAfterOneDay() {
        val items = arrayOf<Item>(Item("normal", 12, 10), Item("normal", 8, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(11, app.items[0].sellIn)
        assertEquals(7, app.items[1].sellIn)
    }

    @Test
    fun AgedBrieQualityIncreasesByOneAfterOneDay() {
        val items = arrayOf<Item>(Item("Aged Brie", 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(11, app.items[0].quality)
    }
    @Test
    fun BackstagePassQualityIncreasesByOneWithTwentySellInDays() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 20, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(11, app.items[0].quality)
    }
    @Test
    fun BackstagePassQualityIncreasesByTwoWithSevenSellInDays() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 7, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(12, app.items[0].quality)
    }
    @Test
    fun BackstagePassQualityIncreasesByThreeWithThreeSellInDays() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", 3, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(13, app.items[0].quality)
    }
    @Test
    fun BackstagePassQualityIsZeroIfSellInIsNegative() {
        val items = arrayOf<Item>(Item("Backstage passes to a TAFKAL80ETC concert", -1, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun SulfurasQualityIsConstant() {
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(10, app.items[0].quality())
    }
    @Test
    fun SulfurasSellInIsConstant() {
        val items = arrayOf<Item>(Item("Sulfuras, Hand of Ragnaros", 10, 10))
        val app = GildedRose(items)

        app.updateQuality()

        assertEquals(10, app.items[0].sellIn)
    }
}



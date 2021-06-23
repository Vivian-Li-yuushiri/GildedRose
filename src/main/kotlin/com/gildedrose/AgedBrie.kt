package com.gildedrose

class AgedBrie(sellIn: Int, quality: Int): GildedItem("Aged Brie", sellIn, quality) {
    override fun setQuality() {
        quality += if (sellIn < 0) {2} else {1}
        checkQualityLimit()
    }
}
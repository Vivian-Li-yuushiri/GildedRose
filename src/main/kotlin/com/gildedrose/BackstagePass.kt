package com.gildedrose

class BackstagePass(sellIn: Int, quality: Int): GildedItem("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {
    override fun setQuality() {
        quality += if (sellIn > 10) {1} else {if (sellIn > 5) {2} else {3}}
        if (sellIn <= 0) {quality = 0}
        checkQualityLimit()
    }
}
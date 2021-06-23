package com.gildedrose

open class GildedItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality) {
    open fun age() {
        sellIn -= 1
    }
    open fun setQuality() {
        quality -= if (sellIn < 0) {2} else {1}
        if (quality < 0) {quality = 0}
    }
}

class AgedBrie(sellIn: Int, quality: Int): GildedItem("Aged Brie", sellIn, quality) {
    override fun setQuality() {
        quality += if (sellIn < 0) {2} else {1}
        if (quality > 50) {quality = 50}
    }
}
class BackstagePass(sellIn: Int, quality: Int): GildedItem("Backstage passes to a TAFKAL80ETC concert", sellIn, quality) {
    override fun setQuality() {
        quality += if (sellIn > 10) {1} else {if (sellIn > 5) {2} else {3}}
        quality = if (sellIn <= 0) {0} else {if (quality > 50) {50} else {quality}}
    }
}
class Sulfuras(sellIn: Int, quality: Int): GildedItem("Sulfuras, Hand of Ragnaros", sellIn, quality) {
    override fun age() {
        return
    }
    override fun setQuality() {
        return
    }
}
class ConjuredItem(name: String, sellIn: Int, quality: Int): GildedItem("Conjured $name", sellIn, quality) {
    override fun setQuality() {
        super.setQuality()
        super.setQuality()
    }
}

class GildedRose(var items: Array<GildedItem>) {

    fun updateQuality() {
        for (i in items.indices) {
            items[i].setQuality()
        }
        for (i in items.indices) {
            items[i].age()
        }
    }

}


package com.gildedrose

open class GildedItem(name: String, sellIn: Int, quality: Int): Item(name, sellIn, quality) {
    open fun age() {
        sellIn -= 1
    }
    open fun setQuality() {
        quality -= if (sellIn < 0) {2} else {1}
        if (quality < 0) {quality = 0}
    }
    fun checkQualityLimit() {
        if (quality > 50) {quality = 50}
        if (quality < 0) {quality = 0}
    }
}
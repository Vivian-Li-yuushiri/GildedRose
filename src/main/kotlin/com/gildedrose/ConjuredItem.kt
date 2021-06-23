package com.gildedrose

class ConjuredItem(name: String, sellIn: Int, quality: Int): GildedItem("Conjured $name", sellIn, quality) {
    override fun setQuality() {
        super.setQuality()
        super.setQuality()
    }
}
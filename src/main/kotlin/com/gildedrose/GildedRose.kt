package com.gildedrose

class GildedRose(var items: Array<GildedItem>) {

    fun updateQuality() {
        for (item in items) {
            item.setQuality()
            item.age()
        }
    }

}


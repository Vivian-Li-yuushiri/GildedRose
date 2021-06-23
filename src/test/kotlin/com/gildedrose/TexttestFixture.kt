package com.gildedrose

fun main(args: Array<String>) {

    println("OMGHAI!")

    val items = arrayOf(GildedItem("+5 Dexterity Vest", 10, 20), //
            AgedBrie( 2, 0), //
            GildedItem("Elixir of the Mongoose", 5, 7), //
            Sulfuras( 0, 80), //
            Sulfuras( -1, 80),
            BackstagePass( 15, 20),
            BackstagePass( 10, 49),
            BackstagePass( 5, 49),
            // this conjured item does not work properly yet
            ConjuredItem("Mana Cake", 3, 6))

    val app = GildedRose(items)

    var days = 2
    if (args.size > 0) {
        days = Integer.parseInt(args[0]) + 1
    }

    for (i in 0..days - 1) {
        println("-------- day $i --------")
        println("name, sellIn, quality")
        for (item in items) {
            println(item)
        }
        println()
        app.updateQuality()
    }


}

import { Item, GildedItem, AgedBrie, BackstagePass, Sulfuras, ConjuredItem, GildedRose} from '../app/gilded-rose';

const items = [
    new GildedItem("+5 Dexterity Vest", 10, 20), //
    new AgedBrie(2, 0), //
    new GildedItem("Elixir of the Mongoose", 5, 7), //
    new Sulfuras(0, 80), //
    new Sulfuras(-1, 80),
    new BackstagePass(15, 20),
    new BackstagePass(10, 49),
    new BackstagePass(5, 49),
    // this conjured item does not work properly yet
    new ConjuredItem("Mana Cake", 3, 6)];


const gildedRose = new GildedRose(items);
var days: number = 2;
for (let i = 0; i < days; i++) {
    console.log("-------- day " + i + " --------");
    console.log("name, sellIn, quality");
    items.forEach(element => {
        console.log(element.name + ' ' + element.sellIn + ' ' + element.quality);

    });
    console.log();
    gildedRose.updateQuality();
}
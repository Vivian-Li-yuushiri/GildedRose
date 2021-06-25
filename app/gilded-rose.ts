export class Item {
    name: string;
    sellIn: number;
    quality: number;

    constructor(name, sellIn, quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }
}

export class GildedItem extends Item {
    constructor(name, sellIn, quality) {
        super(name, sellIn, quality);
    }
    age():void {
        this.sellIn -= 1
    }
    setQuality():void {
        if (this.sellIn <= 0) {this.quality -= 2} else {this.quality -= 1}
        this.checkQualityLimit()
    }
    checkQualityLimit():void {
        if (this.quality > 50) {this.quality = 50}
        if (this.quality < 0) {this.quality = 0}
    }
}
export class AgedBrie extends GildedItem {
    constructor(sellIn, quality) {
        super("Aged Brie", sellIn, quality);
    }
    setQuality():void {
        if (this.sellIn <= 0) {this.quality += 2} else {this.quality += 1}
        this.checkQualityLimit();
    }
}
export class BackstagePass extends GildedItem {
    constructor(sellIn, quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }
    setQuality():void {
        if (this.sellIn > 10) {this.quality += 1} else {if (this.sellIn > 5) {this.quality += 2} else {this.quality += 3}}
        if (this.sellIn <= 0) {this.quality = 0}
        this.checkQualityLimit();
    }
}
export class Sulfuras extends GildedItem {
    constructor(sellIn, quality) {
        super("Sulfuras, Hand of Ragnaros", sellIn, quality);
    }
    age():void {
        return
    }
    setQuality():void {
        return
    }
}
export class ConjuredItem extends GildedItem {
    constructor(name, sellIn, quality) {
        super("Conjured " + name, sellIn, quality);
    }
    setQuality():void {
        super.setQuality()
        super.setQuality()
    }
}

export class GildedRose {
    items: Array<GildedItem>;

    constructor(items = [] as Array<GildedItem>) {
        this.items = items;
    }

    updateQuality() {
        for (var item of this.items) {
            item.setQuality();
            item.age();
        }
        return this.items;
    }
}

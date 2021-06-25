import { expect } from 'chai';
import { Item, GildedItem, AgedBrie, BackstagePass, Sulfuras, ConjuredItem, GildedRose } from '../app/gilded-rose';

describe('Gilded Rose', function () {

    it('normal item name is foo', function() {
        const gildedRose = new GildedRose([ new GildedItem('foo', 0, 0) ]);
        const items = gildedRose.updateQuality();
        expect(items[0].name).to.equal('foo');
    });
    it('aged brie name is "Aged Brie"', function() {
        const gildedRose = new GildedRose([ new AgedBrie(0, 0)]);
        const items = gildedRose.updateQuality();
        expect(items[0].name).to.equal('Aged Brie');
    });
    it('backstage pass name is "Backstage passes to a TAFKAL80ETC concert"', function() {
        const gildedRose = new GildedRose([ new BackstagePass(0, 0)]);
        const items = gildedRose.updateQuality();
        expect(items[0].name).to.equal('Backstage passes to a TAFKAL80ETC concert');
    });
    it('sulfuras name is "Sulfuras, Hand of Ragnaros"', function() {
        const gildedRose = new GildedRose([ new Sulfuras(0, 0)]);
        const items = gildedRose.updateQuality();
        expect(items[0].name).to.equal('Sulfuras, Hand of Ragnaros');
    });
    it('conjured item name starts with "Conjured"', function() {
        const gildedRose = new GildedRose([ new GildedItem('Conjured Mana Cake', 0, 0)]);
        const items = gildedRose.updateQuality();
        expect(items[0].name).to.equal('Conjured Mana Cake'); 
    });

    it('item quality never decreases below zero from zero', function() {
        const gildedRose = new GildedRose([ new GildedItem('normal', 10, 0)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(0);
    });
    it('aged brie quality never increases above fifty from fifty', function() {
        const gildedRose = new GildedRose([ new AgedBrie(10, 50)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(50);
    });
    it('backstage pass quality never increases above fifty from fifty', function() {
        const gildedRose = new GildedRose([ new BackstagePass(10, 50)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(50);
    });

    it('normal item quality decreases by one from ten to nine before sellby day', function() {
        const gildedRose = new GildedRose([ new GildedItem('normal', 1, 10)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(9);
    });
    it('normal item quality decreases by two from ten to eight after sellby day', function() {
        const gildedRose = new GildedRose([ new GildedItem('normal', 0, 10)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(8);
    });
    it('normal item sellin decreases by one to nine from ten', function() {
        const gildedRose = new GildedRose([ new GildedItem('normal', 10, 10)]);
        const items = gildedRose.updateQuality();
        expect(items[0].sellIn).to.equal(9);
    });
    it('two normal items quality decrease by one', function() {
        const gildedRose = new GildedRose([ new GildedItem('normal', 10, 10), new GildedItem('normal', 10, 11)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(9);
        expect(items[1].quality).to.equal(10);
    });
    it('two normal items sellin decrease by one', function() {
        const gildedRose = new GildedRose([ new GildedItem('normal', 10, 10), new GildedItem('normal', 0, 10)]);
        const items = gildedRose.updateQuality();
        expect(items[0].sellIn).to.equal(9);
        expect(items[1].sellIn).to.equal(-1);
    });

    it('aged brie quality increases by one from nine to ten before sellby day', function() {
        const gildedRose = new GildedRose([ new AgedBrie(1, 9)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(10);
    });
    it('aged brie quality increases by two from eight to ten after sellby day', function() {
        const gildedRose = new GildedRose([ new AgedBrie(0, 8)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(10);
    });

    it('backstage pass quality increases by one from nine to ten with eleven sellin days', function() {
        const gildedRose = new GildedRose([ new BackstagePass(11, 9)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(10);
    });
    it('backstage pass quality increases by two from eight to ten with ten sellin days', function() {
        const gildedRose = new GildedRose([ new BackstagePass(10, 8)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(10);
    });
    it('backstage pass quality increases by two from eight to ten with six sellin days', function() {
        const gildedRose = new GildedRose([ new BackstagePass(6, 8)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(10);
    });
    it('backstage pass quality increases by three from seven to ten with five sellin days', function() {
        const gildedRose = new GildedRose([ new BackstagePass(5, 7)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(10);
    });
    it('backstage pass quality increases by three from seven to ten with one sellin day', function() {
        const gildedRose = new GildedRose([ new BackstagePass(1, 7)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(10);
    });
    it('backstage pass quality is zero from ten with zero sellin days', function() {
        const gildedRose = new GildedRose([ new BackstagePass(0, 10)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(0);
    });

    it('sulfuras quality is constant at ten', function() {
        const gildedRose = new GildedRose([ new Sulfuras(10, 10)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(10);
    });
    it('sulfuras sellin is constant at ten', function() {
        const gildedRose = new GildedRose([ new Sulfuras(10, 10)]);
        const items = gildedRose.updateQuality();
        expect(items[0].sellIn).to.equal(10);
    });

    it('conjured item quality decreases by two from ten to eight before sellby day', function() {
        const gildedRose = new GildedRose([ new ConjuredItem('Mana Cake', 1, 10)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(8);
    });
    it('conjured item quality decreases by four from ten to six before sellby day', function() {
        const gildedRose = new GildedRose([ new ConjuredItem('Mana Cake', 0, 10)]);
        const items = gildedRose.updateQuality();
        expect(items[0].quality).to.equal(6);
    });
});

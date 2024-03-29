package com.magasin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MagasinTest {

    @Test
    void testItems() {
        Item[] items = new Item[] {
                new Item("Foo", 1, 0),
                new Item("Normal", 0, 34),
                new Item("Normal", 1, 2),
                new Item("Kryptonite", 0, 80),
                new Item("Pass VIP Concert", 4, 30),
                new Item("Pass VIP Concert", 1, 3),
                new Item("Comté", 4, 30),
                new Item("Comté", 1, 1),

        };
        Magasin app = new Magasin(items);
        app.updateQuality();
        app.updateQuality();

        StringBuilder actual = new StringBuilder();
        for(Item item : items){
            actual.append(item).append(" - ");
        }


        assertEquals("Foo, -1, 0 - Normal, -2, 30 - Normal, -1, 0 - Kryptonite, 0, 80 - Pass VIP Concert, 2, 36 - Pass VIP Concert, -1, 0 - Comté, 2, 32 - Comté, -1, 3 - ",actual.toString());
    }
@Test
    void TestPouvoirMagique() {
        Item[] items = new Item[]{
                new Item("Pouvoir magique", 1, 0),
                new Item("Pouvoir magique", 10, 34),
        };
        Magasin app = new Magasin(items);
        app.updateQuality();
        app.updateQuality();
        StringBuilder actual = new StringBuilder();
        for (Item item : items) {
            actual.append(item).append(" - ");
        }

        assertEquals("Pouvoir magique, -1, 0 - Pouvoir magique, 8, 32 - ", actual.toString());
    }

}

package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
    }

    public void updateQualityold() {
        for (Item item : items) {
            if (!item.name.equals("Comté")
                    && !item.name.equals("Pass VIP Concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Kryptonite")) {
                        item.quality = item.quality - 1;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals("Pass VIP Concert")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1;
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Kryptonite")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Comté")) {
                    if (!item.name.equals("Pass VIP Concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Kryptonite")) {
                                item.quality = item.quality - 1;
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        }
    }

    public void updateQuality() {
        for (Item item : items) {
            if(item.name.equals("Kryptonite"))
                continue;

            item.sellIn--;

            // cas particulier

            switch (item.name){
                case "Comté":
                    item.quality++;
                    break;

                case "Pass VIP Concert":
                    if(item.sellIn <= 0){
                        item.quality = 0;
                    }else if(item.sellIn<=5){
                        item.quality = item.quality + 3;
                    }else if(item.sellIn <= 10){
                        item.sellIn = item.quality + 2;
                    }
                    break;
                case "Pouvoirs magiques":
                    item.quality -= 2;
                    break;
                    // Tous les autres items
                default:
                    if(item.sellIn<0){
                        item.quality = item.quality - 2;
                    }else{
                        item.quality = item.quality - 1;
                    }
                    break;

            }

            item.quality = Math.min(50, item.quality);
            item.quality = Math.max(0, item.quality);
        }
    }
}

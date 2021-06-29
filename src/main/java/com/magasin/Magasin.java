package com.magasin;

class Magasin {
    Item[] items;

    public Magasin(Item[] items) {
        this.items = items;
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

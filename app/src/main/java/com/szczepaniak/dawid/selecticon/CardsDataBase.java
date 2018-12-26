package com.szczepaniak.dawid.selecticon;

import android.widget.ImageView;

public class CardsDataBase {


    private Card[] cards;

    public CardsDataBase() {

        Card[] c = {
                new Card(1,2,3,4,5,6,7,8),
                new Card(1,9,10,11,12,13,14,15),
                new Card(1,16,17,18,19,20,21,22),
                new Card(1,23,24,25,26,27,28,29),
                new Card(1,30,31,32,33,34,35,36),
                new Card(1,37,38,39,40,41,42,43),
                new Card(1,44,45,46,47,48,49,50),
                new Card(1,51,52,53,54,55,56,57),
                new Card(2,9,16,23,30,37,44,51 ),
                new Card(2,10,17,24,31,38,45,52 ),
                new Card(2,11,18,25,32,39,46,53 ),
                new Card(2,12,19,26,33,40,47,54 ),
                new Card(2,13,20,27,34,41,48,55 ),
                new Card(2,14,21,28,35,42,49,56 ),
                new Card(2,15,22,29,36,43,50,57 ),
                new Card(3,9,17,25,33,41,49,57 ),
                new Card(3,10,18,26,34,42,50,51 ),
                new Card(3,11,19,27,35,43,44,52 ),
                new Card(3,12,20,28,36,37,45,53 ),
                new Card(3,13,21,29,30,38,46,54 ),
                new Card(3,14,22,23,31,39,47,55 ),
                new Card(3,15,16,24,32,40,48,56 ),
                new Card(4,9,18,27,36,38,47,56 ),
                new Card(4,10,19,28,30,39,48,57 ),
                new Card(4,11,20,29,31,40,49,51 ),
                new Card(4,12,21,23,32,41,50,52 ),
                new Card(4,13,22,24,33,42,44,53 ),
                new Card(4,14,16,25,34,43,45,54 ),
                new Card(4,15,17,26,35,37,46,55 ),
                new Card(5,9,19,29,32,42,45,55 ),
                new Card(5,10,20,23,33,43,46,56 ),
                new Card(5,11,21,24,34,37,47,57 ),
                new Card(5,12,22,25,35,38,48,51 ),
                new Card(5,13,16,26,36,39,49,52 ),
                new Card(5,14,17,27,30,40,50,53 ),
                new Card(5,15,18,28,31,41,44,54 ),
                new Card(6,9,20,24,35,39,50,54 ),
                new Card(6,10,21,25,36,40,44,55 ),
                new Card(6,11,22,26,30,41,45,56 ),
                new Card(6,12,16,27,31,42,46,57 ),
                new Card(6,13,17,28,32,43,47,51 ),
                new Card(6,14,18,29,33,37,48,52 ),
                new Card(6,15,19,23,34,38,49,53 ),
                new Card(7,9,21,26,31,43,48,53 ),
                new Card(7,10,22,27,32,37,49,54 ),
                new Card(7,11,16,28,33,38,50,55 ),
                new Card(7,12,17,29,34,39,44,56 ),
                new Card(7,13,18,23,35,40,45,57 ),
                new Card(7,14,19,24,36,41,46,51 ),
                new Card(7,15,20,25,30,42,47,52 ),
                new Card(8,9,22,28,34,40,46,52 ),
                new Card(8,10,16,29,35,41,47,53 ),
                new Card(8,11,17,23,36,42,48,54 ),
                new Card(8,12,18,24,30,43,49,55 ),
                new Card(8,13,19,25,31,37,50,56 ),
                new Card(8,14,20,26,32,38,44,57 ),
                new Card(8,15,21,27,33,39,45,51 ),
        };
        this.cards = c;

    }

    public Card[] getCards() {
        return cards;
    }

    public void setIconImage(ImageView image, int index){

        switch (index){
            case 1:
                image.setImageResource(R.mipmap.airplane);
                break;
            case 2:
                image.setImageResource(R.mipmap.armchair);
                break;
            case 3:
                image.setImageResource(R.mipmap.automobile);
                break;
            case 4:
                image.setImageResource(R.mipmap.strawberry);
                break;
            case 5:
                image.setImageResource(R.mipmap.ball);
                break;
            case 6:
                image.setImageResource(R.mipmap.banana);
                break;
            case 7:
                image.setImageResource(R.mipmap.beer);
                break;
            case 8:
                image.setImageResource(R.mipmap.book);
                break;
            case 9:
                image.setImageResource(R.mipmap.cake);
                break;
            case 10:
                image.setImageResource(R.mipmap.camera);
                break;
            case 11:
                image.setImageResource(R.mipmap.cherry);
                break;
            case 12:
                image.setImageResource(R.mipmap.chocolate);
                break;
            case 13:
                image.setImageResource(R.mipmap.coins);
                break;
            case 14:
                image.setImageResource(R.mipmap.coffee);
                break;
            case 15:
                image.setImageResource(R.mipmap.cow);
                break;
            case 16:
                image.setImageResource(R.mipmap.cup);
                break;
            case 17:
                image.setImageResource(R.mipmap.dragon);
                break;
            case 18:
                image.setImageResource(R.mipmap.ear);
                break;
            case 19:
                image.setImageResource(R.mipmap.earth);
                break;
            case 20:
                image.setImageResource(R.mipmap.icecream);
                break;
            case 21:
                image.setImageResource(R.mipmap.giftbox);
                break;
            case 22:
                image.setImageResource(R.mipmap.elephant);
                break;
            case 23:
                image.setImageResource(R.mipmap.lamp);
                break;
            case 24:
                image.setImageResource(R.mipmap.motor);
                break;
            case 25:
                image.setImageResource(R.mipmap.rocket);
                break;
            case 26:
                image.setImageResource(R.mipmap.giraffe);
                break;
            case 27:
                image.setImageResource(R.mipmap.guitar);
                break;
            case 28:
                image.setImageResource(R.mipmap.pineapple);
                break;
            case 29:
                image.setImageResource(R.mipmap.tomato);
                break;
            case 30:
                image.setImageResource(R.mipmap.shark);
                break;
            case 31:
                image.setImageResource(R.mipmap.star);
                break;
            case 32:
                image.setImageResource(R.mipmap.gun);
                break;
            case 33:
                image.setImageResource(R.mipmap.tiger);
                break;
            case 34:
                image.setImageResource(R.mipmap.sword);
                break;
            case 35:
                image.setImageResource(R.mipmap.turkey);
                break;
            case 36:
                image.setImageResource(R.mipmap.bigben);
                break;
            case 37:
                image.setImageResource(R.mipmap.boxing);
                break;
            case 38:
                image.setImageResource(R.mipmap.burger);
                break;
            case 39:
                image.setImageResource(R.mipmap.coconut);
                break;
            case 40:
                image.setImageResource(R.mipmap.crocodile);
                break;
            case 41:
                image.setImageResource(R.mipmap.eiffel);
                break;
            case 42:
                image.setImageResource(R.mipmap.food);
                break;
            case 43:
                image.setImageResource(R.mipmap.groceries);
                break;
            case 44:
                image.setImageResource(R.mipmap.hotdog);
                break;
            case 45:
                image.setImageResource(R.mipmap.key);
                break;
            case 46:
                image.setImageResource(R.mipmap.lantern);
                break;
            case 47:
                image.setImageResource(R.mipmap.mouse);
                break;
            case 48:
                image.setImageResource(R.mipmap.orange);
                break;
            case 49:
                image.setImageResource(R.mipmap.palm);
                break;
            case 50:
                image.setImageResource(R.mipmap.panda);
                break;
            case 51:
                image.setImageResource(R.mipmap.smartphone);
                break;
            case 52:
                image.setImageResource(R.mipmap.sunny);
                break;
            case 53:
                image.setImageResource(R.mipmap.toy);
                break;
            case 54:
                image.setImageResource(R.mipmap.tree);
                break;
            case 55:
                image.setImageResource(R.mipmap.trucking);
                break;
            case 56:
                image.setImageResource(R.mipmap.shirt);
                break;
            case 57:
                image.setImageResource(R.mipmap.yeti);
                break;

        }
    }
}

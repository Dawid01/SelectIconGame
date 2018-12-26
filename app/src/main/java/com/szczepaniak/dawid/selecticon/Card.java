package com.szczepaniak.dawid.selecticon;

public class Card {

    private int[] cardNumbers;

    public Card(int a, int b, int c, int d, int e, int f, int g, int h) {
        int[] numbers = {a,b,c,d,e,f,g,h};
        this.cardNumbers = numbers;
    }

    public int[] getCardNumbers() {
        return cardNumbers;
    }
}

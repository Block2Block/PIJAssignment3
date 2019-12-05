package com.bham.pij.assignments.pontoon;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private static ArrayList<String> suits = new ArrayList<>(Arrays.asList("HEARTS", "SPADES", "CLUBS", "DIAMONDS"));
    private static ArrayList<String> values = new ArrayList<>(Arrays.asList("ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"));

    private List<Card> deck;
    private int size;

    public Deck() {
        //Generate the cards to populate the array.
        generateCards();
    }

    public Card dealCard(int i) {
        //Retrieve the deck and set its value in the array to null (so it can't be dealt again). Remove one from the size.
        Card card = deck.get(i);
        deck.set(i, null);
        size--;
        return card;
    }

    public int getDeckSize() {
        return size;
    }

    public Card getCard(int i) {
        return deck.get(i);
    }

    public void reset() {
        generateCards();
    }

    private void generateCards() {
        //Create a new array list, and for each of the suits, for each of the values, create a new card and add it to the deck.
        deck = new ArrayList<>();
        for (String suit : suits) {
            for (String value : values) {
                deck.add(new Card(suit, value));
            }
        }

        //Shuffle the deck and set its size to 52.
        Collections.shuffle(deck);
        size = 52;
    }

}

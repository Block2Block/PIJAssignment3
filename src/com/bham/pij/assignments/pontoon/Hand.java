package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card> hand;
    private ArrayList<Integer> numericalValues;


    public Hand() {
        hand = new ArrayList<>();
        numericalValues = new ArrayList<>();
        numericalValues.add(0);
    }

    public void addCard(Card card) {
        hand.add(card);

        //Create a new list to populate with values.
        ArrayList<Integer> values = new ArrayList<>();

        //For each number in the numerical values list, and for each value in the numerical values list, add each of them.
        for (int i : numericalValues) {
            for (int i2 : card.getNumericalValue()) {
                int i3 = i + i2;

                //If it is already in the array, do not add it again, as this becomes a duplicate (meaning it adds the same numbers in a different pattern).
                if (!values.contains(i3)) {
                    values.add(i3);
                }
            }
        }
        numericalValues = values;
    }

    public Card getCard(int i) {
        return hand.get(i);
    }

    public int getHandSize() {
        return hand.size();
    }

    public ArrayList<Integer> getNumericalValue() {
        return numericalValues;
    }

}

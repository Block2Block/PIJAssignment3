package com.bham.pij.assignments.pontoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Card {

    //For reference when generating random values.
    private static ArrayList<String> suits = new ArrayList<>(Arrays.asList("HEARTS", "SPADES", "CLUBS", "DIAMONDS"));
    private static ArrayList<String> values = new ArrayList<>(Arrays.asList("ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"));

    private String suit;
    private String value;
    private ArrayList<Integer> numericalValue;

    public Card(String suit, String value) {
        //Set the suit and value
        this.suit = suit;
        this.value = value;

        //Create an array list, then add the value of the card to it (and 2 if it is an ace).
        numericalValue = new ArrayList<>();

        //For the value, check it against these conditions.
        switch (value) {
            case "ACE":
                numericalValue.add(11);
                numericalValue.add(1);
                break;
            case "JACK":
            case "QUEEN":
            case "KING":
                //For all Jack, Queen and King, the value will be 10.
                numericalValue.add(10);
                break;
            default:
                //If it is a value card (2-10) then its index in the array will be its value (adding one, as it starts from 0)
                numericalValue.add(values.indexOf(value) + 1);
                break;
        }
    }

    public static String getRandomSuit() {
        //Chooses a random suit (4 different suits in total).
        return suits.get(chooseRan(0, 3));
    }

    public static String getRandomValue() {
        //Chooses a random value from ACE to KING (13 different values in total).
        return values.get(chooseRan(0, 12));
    }

    public ArrayList<Integer> getNumericalValue() {
        //Returns a clone of the numerical value array (otherwise they could change the array inside the object, as it returns a reference type)
        return (ArrayList<Integer>) numericalValue.clone();
    }

    public String getSuit() {
        return suit;
    }

    public String getValue() {
        return value;
    }

    private static int chooseRan(int min, int max){
        //Choosing a random value between the min and max.
        Random rn = new Random();
        //Calculates the range (and then nextInt() will generate a number between 0 and that number) then add on the min to be in the specified range.
        return rn.nextInt(max - min + 1) + min;
    }

    @Override
    public String toString() {
        //Outputs the card e.g. ACE OF SPADES, TWO OF HEARTS etc.
        String string = value + " OF " + suit;
        return string;
    }
}

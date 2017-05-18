package com.sardinecorp.quizzapp;

import java.util.Random;


public final class Question {

    public static int[] getQuestion() {
        Random random = new Random();
        int leftAdder = random.nextInt(90)+1;
        int rightAdder = random.nextInt(99 - leftAdder);
        int correctAns = leftAdder + rightAdder;
        int incorrect1;
        do {
            incorrect1 = correctAns + random.nextInt(10 + 1 +10) - 10;
        } while (incorrect1 <= 0 && incorrect1 == correctAns && incorrect1 >= 100);
        int incorrect2;
        do {
            incorrect2 = correctAns + random.nextInt(10 + 1 +10) - 10;
        } while (incorrect2 <= 0 && incorrect2 == correctAns && incorrect2 == incorrect1 && incorrect2 >= 100);

        return new int[] {leftAdder, rightAdder, correctAns, incorrect1, incorrect2};
    }
}

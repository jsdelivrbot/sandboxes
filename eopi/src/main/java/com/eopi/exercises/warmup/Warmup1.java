package com.eopi.exercises.warmup;


public class Warmup1 {

    private int numberCount = 0;
    private int fizzBuzzCount = 0;
    private int fizzCount = 0;
    private int buzzCount = 0;

    void run(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                fizzBuzz();
            } else if (i % 3 == 0) {
                fizz();
            } else if (i % 5 == 0) {
                buzz();
            } else {
                number(i);
            }
        }
    }

    private void fizzBuzz() {
        fizzBuzzCount++;
        System.out.println("fizz buzz");
    }

    private void fizz() {
        fizzCount++;
        System.out.println("fizz");
    }

    private void buzz() {
        buzzCount++;
        System.out.println("buzz");
    }

    void number(int num) {
        numberCount++;
        System.out.println(num);
    }

    int getNumberCount() {
        return numberCount;
    }

    int getFizzBuzzCount() {
        return fizzBuzzCount;
    }

    int getFizzCount() {
        return fizzCount;
    }

    int getBuzzCount() {
        return buzzCount;
    }
}

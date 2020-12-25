/*
 *
 */

import java.util.Scanner;


public class NumberGame {

    public static void main(String [] args){
        //Generate a number
        int randomNumber = (int) (Math.random() * 100) +1;
        boolean hasWon = false;
        System.out.println("I have selected a number between 1-100.");
        System.out.println("Try to guess it");
        //Number input
        Scanner scanner = new Scanner(System.in);
        //Guesses counter loop
        for(int i = 10; i>0; i--){
            System.out.println("You have " + i + " guess(es) left. Try again");
            int guess = scanner.nextInt();
            System.out.println(guess);
            //Answer indications:
            if (randomNumber < guess) {
                System.out.println("It's smaller than " + guess);
            } else if (randomNumber > guess){
                    System.out.println("It's bigger than "+ guess);
            } else {
                hasWon = true;
                break;
            }
        }
        if (hasWon){
            System.out.println("You've got the right answer");
        } else {
            System.out.println("You've lost. The answer was: "+ randomNumber);
        }
    }


}

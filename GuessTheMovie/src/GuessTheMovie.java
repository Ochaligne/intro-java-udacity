/*
 * Write description
 */

import java.io.File;
import java.util.Scanner;

public class GuessTheMovie {
    public static void main(String [] args) throws Exception{
        //Random number for line in file indexation
        int randomNumber = (int) (Math.random()*(25 - 1 + 1)+1); //number range 1-25 (max - min + 1) + min
        int lineCount = 0;
        int errCount = 10;
        String filmTarget="";
        String gameDisplay;
        String guess;
        //Load file - Randomly select a film as target
        File file = new File("movies.txt");
        Scanner fileScanner = new Scanner(file);
        while(fileScanner.hasNextLine() && lineCount !=randomNumber) {
            filmTarget = fileScanner.nextLine();
            lineCount++;
            System.out.println(filmTarget);
            System.out.println(lineCount);
        }
        //Count the letters
        int letterCount = 0;
        letterCount = filmTarget.length();// use to limit number of inputs
        System.out.println(letterCount);
        //Display dashes for the letters
        gameDisplay = filmTarget.replaceAll("\\p{Alpha}", "_");
        StringBuilder strDisplay = new StringBuilder(gameDisplay);
        System.out.println(strDisplay);
        //Ask for letter input
        System.out.println("Guess the film. Enter a letter:");
        while (errCount > 0){
            Scanner scanner = new Scanner(System.in);
            guess = scanner.next();
            System.out.println(guess);
            //Loop over the target to check if letter is in it
            int letterInd = filmTarget.lastIndexOf(guess);

            System.out.println(letterInd);
            // need to loop over all characters if matching add index to list and flag character found

            if (letterInd == -1) {
                //Else not right: -1 on wrong guesses counter (max 10)
                errCount --;
                System.out.println("Chances left: "+errCount+" Try again. Enter a letter:");
            } else {
                //if character found update display with letter using indexes list and check if the player won.
                strDisplay.setCharAt(letterInd, guess.charAt(0));
                System.out.println(strDisplay);
                if (String.valueOf(strDisplay).equals(filmTarget)){
                    //If all letters found: win
                    System.out.println("That's right. You've won.");
                    break;
                }else{
                    //Ask for another letter
                    System.out.println("Enter a new letter:");
                }
                }
        }


        // keep track of letters to not lose for same letter
        //If all letters found: win
        //If wrong guess counter >= 10: lose

    }
}
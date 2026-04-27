/**
	* File: Problem Set 4
	* Author: Leo
	* Date Created: April 26, 2026
	* Date Last Modified: April 27, 2026
	*/

import java.util.Scanner;
import java.util.Random;
public class ProblemSet {
    
    public static void main(String args[]) {
        
        Scanner input = new Scanner(System.in);
        int rounds = 0;
        boolean flag = false;
        
        System.out.println("Welcome to the High Low Guessing Game.");
        System.out.print("Input a number of rounds to play: ");
        
        //gets number of rounds
        while (flag == false) {
                if (!(input.hasNextInt())) {
                    input.nextLine();
                    System.out.println("\nInvalid input!");
                    System.out.print("Input a number of rounds to play: ");
                }
                else {
                    rounds = input.nextInt();
                    
                    if (rounds >= 1) {
                        flag = true;
                    }
                    else {
                        System.out.println("\nInvalid input!");
                        System.out.print("Input a number of rounds to play: ");
                    }
                }
            }
        
        int finalScore = highLowGame(rounds);

		//end message
        if (finalScore >= rounds / 2.0) {
            System.out.println("Congratulations you got " + finalScore + " out of " + rounds + " right!");
        }
        else {
            System.out.println("Better luck next time, you got " + finalScore + " out of " + rounds + " right." );
        }
    }
    
    public static int highLowGame(int rounds) {
        Scanner input = new Scanner(System.in);
        int score = 0;
        
        //main game loop
        for (int i = 0; i < rounds; i++) {
            
            int randNum = randomNumber();
            int guess = 0;
            boolean flag = false;
            
            System.out.println("\nRound " + (i + 1) + ":\n");
            System.out.println("Please select High, Low or Even:");
            System.out.println("1. High (11 to 20)\n" + "2. Low (0 to 9)\n" + "3. Even(10)\n");
            
            //makes sure user chooses valid option from menu
            while (flag == false) {
                if (!(input.hasNextInt())) {
                    input.nextLine();
                    System.out.println("\nInvalid input!\n" + "Please select High, Low or Even:");
                    System.out.println("1. High (11 to 20)\n" + "2. Low (0 to 9)\n" + "3. Even(10)\n");
                }
                else {
                    guess = input.nextInt();
                    
                    if (guess >= 1 && guess <= 3) {
                        flag = true;
                    }
                    else {
                        System.out.println("\nInvalid input!\n" + "Please select High, Low or Even:");
                        System.out.println("1. High (11 to 20)\n" + "2. Low (0 to 9)\n" + "3. Even(10)\n");
                    }
                }
            }
            
            //checks if generated number is high 
            if (guess == 1 && randNum > 10) {
                System.out.println("\nThe number was " + randNum + ", You were correct.");
                score++;
                System.out.println("Current score: " + score);
            }
            
            else if (guess == 1 && randNum <= 10) {
                System.out.println("\nThe number was " + randNum + ". You were incorrect.");
                System.out.println("Current score: " + score);
            }
            
            //checks if generated number is low
            else if (guess == 2 && randNum < 10) {
                System.out.println("\nThe number was " + randNum + ", You were correct.");
                score++;
                System.out.println("Current score: " + score);
            }
            else if (guess == 2 && randNum >= 10) {
                System.out.println("\nThe number was " + randNum + ". You were incorrect.");
                System.out.println("Current score: " + score);
            }
            
            //checks if generated number is even
            else if (guess == 3 && randNum == 10) {
                System.out.println("\nThe number was " + randNum + ", You were correct.");
                score++;
                System.out.println("Current score: " + score);
            }
            
            else if (guess == 3 && randNum != 10) {
                System.out.println("\nThe number was " + randNum + ". You were incorrect.");
                System.out.println("Current score: " + score);
            }
        }
    return score;    
    }

    //random number generator method
    public static int randomNumber() {
        Random random = new Random();
        int numRand = random.nextInt(21);
        return numRand;
    }
}

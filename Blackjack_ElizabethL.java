/*
 * Author: Elizabeth Li
 * Date: Nov. 1, 2018
 * Description: Will interact with user in games of blackjack with simple rules (goal is to try to get closer to 21 than the dealor)
 */

import java.util.Scanner;

public class Blackjack_ElizabethL 
{

    public static void main(String[] args) {
        
        //Scanner object created
        Scanner userInput = new Scanner(System.in);
        //Dealor object created
        Game d = new Game();
        
        //boolean and int for option of replay
        boolean replay = true;
        int playAgain =0;
        //first choice variable and second choice variable (choosing to start game and specifics of starting game)
        int choice1 = 0;
        int start = 0;
        int choice2 = 0;
        int choice3 = 0;
        int hit = 0;
        int diffU = 0;
        int diffD = 0;

        //variables to store the user's hand and dealor's hand
        String u1 = "";
        String u2 = "";
        String d1 = "";
        String d2 = "";
        

        System.out.println("Welcome to the Blackjack game!");
        System.out.println("Please enter your name: ");
        String name = userInput.nextLine();
        
        //new object that will be the user. The name is set to whatever the user entered
        Game u = new Game (name);
        
                
                
                System.out.println("\n1: Instructions");
                System.out.println("2: Start Game");
                
                //do while loop to check if user input is valid (an integer that's 1 or 2)
                do
                {
                        System.out.print("Please enter an integer to choose an option. ");
                        
                            while (!userInput.hasNextInt())
                            {
                                System.out.print("\nPlease enter either 1 or 2. ");
                                userInput.nextLine();
                            }
                        
                        choice1 = userInput.nextInt();
                    
                }while(choice1<1 || choice1>2);
                
                //print out instructions if user doesn't know how to play
                if (choice1 == 1)
                {
                        System.out.println("\nIn Blackjack, the goal of the game is to get closest to 21 than the dealor. ");
                        System.out.println("Ace can be 1, or 11, but in this version it will only be 1.\nThere also will not be any betting in this version.");
                        System.out.println("2 is 2, 3 is 3, etc. All face cards (Jack, Queen, King) are 10.");
                        System.out.println("The dealor will deal your numbers face up so you can see them, the dealor will then deal itself one card facedown and the other face up. ");
                        System.out.println("Based off this information, you can decide if you'd like another card, called 'Hit'.");
                        System.out.println("After you're happy with the sum of cards you have, you choose to 'Stand'.");
                        System.out.println("The dealor will reveal it's other card and you will see who's closest to 21. Whoever is will win!");
                        
                        System.out.println();
                        
                        //gives user time to read instructions and only play when they're ready
                        do
                        {
                            System.out.println("Enter 1 when you're ready to play!");

                                    while (!userInput.hasNextInt())
                                    {
                                    System.out.println("Please enter 1 when you're ready.");
                                    userInput.nextLine();
                                    }
                        
                                start = userInput.nextInt();
                            
                        }while (start != 1);
                        
                }
                
                
                System.out.println("\n");
                System.out.println("Time to start the game!");
                
                
        //while loop for play again feature
        while (replay == true)
        {
                //printing space to show seperation
                System.out.println("\n\n-----------------------------------------------------------\n\n");
                
                //reseting variables if user were to play again
                u1="";
                u2="";
                d1="";
                d2="";
                u.reset();
                d.reset();
                
                //storing the user's hand and dealor's hand
                u1 = u.setUser1();
                u2 = u.setUser2();
                d1 = d.setDealor1();
                
                System.out.println("Dealing your cards...");
                System.out.println("Your cards: \t " + u1 + "\t\t" + u2);
                System.out.println();
                System.out.println("Dealor dealing cards...");
                System.out.println("Dealor's cards: \t " + d1 + "\t\t" + "***" );
                System.out.println("\nYour Sum: " + u.getUserSum());
                System.out.println("Dealor Sum: " + d.getDealorSum() + "\n");
                
                
                //if your hand if under 21, you get the option to hit/stand
                if (u.getUserSum() < 21)
                {
                
                        System.out.println("1: Hit");
                        System.out.println("2: Stand");
                
                        //do while loop to make sure user enters a valid number to choose an option
                        do
                        {
                                System.out.print("Please enter an integer to choose an option. ");
                        
                                    while (!userInput.hasNextInt())
                                    {
                                            System.out.print("\nPlease enter a valid integer. ");
                                            userInput.nextLine();
                                    }
                        
                                choice2 = userInput.nextInt();
                    
                        }while(choice2<1 || choice2>2);
                        
                        //switch case for to hit or stand
                        switch(choice2)
                        {
                                case 1:     //do while loop for multiple hits if user wants to
                                            do
                                            {
                                                hit =0;
                                                hit = u.hitNum();
                                                System.out.println("\nNew Card: " + "\t" + hit);
                                                System.out.println("Your Sum: " + u.getUserSum());                                
                                                System.out.println("Dealor Sum: " + d.getDealorSum() + "\n");
                                                diffU = 21 - u.getUserSum();
                                                diffD = 21 - d.getDealorSum();

                                                //if you're over 21, it'll break and the dealor's second card will be revealed to see if the dealor wins or no one wins
                                                if (diffU <= 0)
                                                    break;
                                                else
                                                {
                                                    System.out.println("1: Hit");
                                                    System.out.println("2: Stand");
                                                
                                                    //do while looop do make sure a valid integer is chosen
                                                    do
                                                    {
                                                        System.out.print("Please enter an integer to choose an option. ");
                        
                                                            while (!userInput.hasNextInt())
                                                            {
                                                                System.out.print("\nPlease enter a valid integer. ");
                                                                userInput.nextLine();
                                                            }
                        
                                                        choice3 = userInput.nextInt();
                    
                                                    }while(choice3<1 || choice3>2);
                                                
                                                    if (choice3 == 1)
                                                        hit = 1;
                                                    else
                                                        hit = 2;
                                                }
                                            }while (hit == 1); //end while loop
                                            break;
                                case 2:     
                                default:    diffU = 21 - u.getUserSum();
                                            diffD = 21 - d.getDealorSum();
                                            break;
                        }
                        
                        //stores dealor's second card in variable
                        d2 = d.setDealor2();
                        
                        //displays final information and reveals dealor's other card
                        System.out.println("\nFINAL INFORMATION");
                        System.out.println("Game ID: " + Game.getGameID());
                        System.out.println("Dealor's other card: " + d2);
                        System.out.println("Your Sum: " + "\t" + u.getUserSum());
                        System.out.println("Dealor's Sum: " + "\t" + d.getDealorSum());
                        
                        
                        
                        //determinds if you've lost or won or tied (push) or if no one wins
                        if ((u.getUserSum() > 21 && d.getDealorSum() < 21) || (u.getUserSum() !=21 && d.getDealorSum() == 21) || (diffD < diffU))
                        {    
                            System.out.println("\n----------------Sorry " + u.getName() + "----------------" + "\n----------------YOU LOST----------------");
                            u.setLosses();
                            d.setWins();
                        }
                        else if ((u.getUserSum() == 21 && d.getDealorSum() != 21) || (u.getUserSum() < 21 && d.getDealorSum() >21) || (diffU < diffD))
                        {
                            System.out.println("\n----------------Good Job "+ u.getName() + "----------------" + "\n----------------YOU WIN----------------");
                            u.setWins();
                            d.setLosses();
                        }
                        else if (u.getUserSum() > 21 && d.getDealorSum() > 21)
                        {
                            System.out.println("\n----------------Good Job "+ u.getName() + "----------------" + "\n----------------NO ONE WON----------------");
                            u.setNoWinners();
                            d.setNoWinners();
                        }
                        else if (u.getUserSum() == d.getDealorSum())
                        {
                            System.out.println("\n----------------Good Job "+ u.getName() + "----------------" + "\n----------------PUSH----------------");
                            u.setPushes();
                            d.setPushes();
                        }

                }
                        
                        //prints out statistics
                        System.out.println("\n\n" + u.getName() + " Stats");
                        System.out.println("Wins: " + u.getWins() + " out of " + Game.getNumGames() + " game(s)");
                        System.out.println("Losses: " + u.getLosses() + " out of " + Game.getNumGames() + " game(s)");
                        System.out.println("Pushes: " + u.getPushes() + " out of " + Game.getNumGames() + " game(s)");
                        System.out.println("No Winners: " + u.getNoWinners() + " out of " + Game.getNumGames() + " game(s)");
                        System.out.println("Number of Hits: " + u.getNumHits() + " in " + Game.getNumGames() + " game(s)");
                        
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println( d.getName() + " Stats");
                        System.out.println("Wins: " + d.getWins() + " out of " + Game.getNumGames() + " games");
                        System.out.println("Losses: " + d.getLosses() + " out of " + Game.getNumGames() + " games");
                        System.out.println("Pushes: " + d.getPushes() + " out of " + Game.getNumGames() + " games");
                        System.out.println("No Winners: " + d.getNoWinners() + " out of " + Game.getNumGames() + " games");                
                        
                        //do while loop for play again feature
                        do
                        {
                            System.out.println("\nEnter 1 if you'd like to play again. \nEnter 2 to exit.");

                                    while (!userInput.hasNextInt())
                                    {
                                    System.out.println("Please enter a valid integer.");
                                    userInput.nextLine();
                                    }
                        
                            playAgain = userInput.nextInt();
                            
                        }while (playAgain != 1 && playAgain !=2);

                
                //if user doens't want to play again, will drop out of while loop
                if (playAgain == 2)
                {
                        replay = false;
                }
                else
                {
                        Game.setNumGames();
                }
                

        }//end while loop
        
        System.out.println("\nThanks for playing!");
    }
}
/*
 * Author: Elizabeth Li
 * Date: Nov. 1, 2018
 * Description: Will include include all attributes and behaviours for user's game of blackjack
 */

public class Game 
{
        //static variables
        private static int numGames=0;
        private static int gameID=0;
        
        //instance variables
        private String user = "";
        private int userSum;
        private int dealorSum;
        private int wins;
        private int losses;
        private int push;
        private int noWinners;
        private int numHits;

        //constructor with parameters 
        public Game (String name)
        {
                user = name;
                numGames++;
                gameID=numGames;
        }
        
        //constructor without parameters
        public Game ()
        {
                user = "Dealor";
        }
        
        
        //mutator method that sets up user's first card
        public String setUser1 ()
        {
                int user1 = (int)(Math.random() * 13 + 1);
                userSum += user1;
                
                if (user1 == 1)
                    return "Ace";
                else if (user1 == 11)
                    return "Jack";
                else if (user1 == 12)
                    return "Queen";
                else if (user1 == 13)
                    return "King";
                else
                    return String.valueOf(user1);
        }
                
        //mutator method that sets up user's second card
        public String setUser2()
        {
                int user2 = (int)(Math.random() * 13 + 1);
                userSum += user2;
                
                if (user2 == 1)
                    return "Ace";
                else if (user2 == 11)
                    return "Jack";
                else if (user2 == 12)
                    return "Queen";
                else if (user2 == 13)
                    return "King";
                else
                    return String.valueOf(user2);
        }
        
        //mutator method that sets up dealor's first card
        public String setDealor1()
        {
                int d1 = (int)(Math.random() * 13 + 1);
                dealorSum += d1;
                
                if (d1 == 1)
                    return "Ace";
                else if (d1 == 11)
                    return "Jack";
                else if (d1 == 12)
                    return "Queen";
                else if (d1 == 13)
                    return "King";
                else
                    return String.valueOf(d1);        
        }
        
        //mutator method that sets up dealor's second card
        public String setDealor2()
        {
                int d2 = (int)(Math.random() * 13 + 1);
                dealorSum += d2;
                
                if (d2 == 1)
                    return "Ace";
                else if (d2 == 11)
                    return "Jack";
                else if (d2 == 12)
                    return "Queen";
                else if (d2 == 13)
                    return "King";
                else
                    return String.valueOf(d2);   
        }
        
        //mutator method that sets hitNum to random number between 1-13
        public int hitNum ()
        {
                int hit = (int)(Math.random() * 13 + 1);
                userSum += hit;
                numHits++;
                return hit;
        }
        
        //mutator method that augments wins
        public int setWins()
        {
                return wins++;
        }
        
        //mutator method that augments losses
        public int setLosses()
        {
                return losses++;
        }
        
        //mutator method that augments pushes
        public int setPushes()
        {
                return push++;
        }
        
        //mutator method that augments no winners
        public int setNoWinners()
        {
                return noWinners++;
        }
        
        //mutator method to augment the number of games if player plays again
        public static void setNumGames()
        {
                numGames++;
        }
        //mutator method that resets variables in play again feature
        public void reset()
        {
                userSum=0;
                dealorSum=0;
        }
        
        //accessor method to get number of games
        public static int getNumGames()
        {
                return numGames;
        }
        
        //accessor method to get number of hits
        public int getNumHits()
        {
                return numHits;
        }
        
        //accessor method to get number of wins
        public int getWins()
        {
                return wins;
        }
        
        //accessor method to get number of losses
        public int getLosses()
        {
                return losses;
        }
        
        //accessor method to get number of pushes
        public int getPushes()
        {
                return push;
        }
        
        //accessor method to get number of no winners
        public int getNoWinners()
        {
                return noWinners;
        } 
        
        //accessor method to get the user's sum 
        public int getUserSum()
        {
                return userSum;
        }
        
        //accessor method to get the dealor's sum
        public int getDealorSum()
        {
                return dealorSum;
        }
        
        //accessor method to get username
        public String getName()
        {
                return user;
        }
        
        //accessor method to get gameID
        public static int getGameID()
        {
                return gameID;
        }

}
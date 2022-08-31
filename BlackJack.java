import java.util.Scanner;
/*
* @author Jemina Ubaldo
* ITSC1212-Mazunder
* @version 1.0
* @since 2021-11-16
* Lab 12
* Programming Fundamentals in Lab 12 Part C
*/
public class BlackJack {
    public static void main(String[] args) throws InterruptedException {
        Deck deck = new Deck();
        Scanner scnr = new Scanner(System.in);
        int playAgain=0;
        int wins = 0;
        int loses = 0;
        int tie = 0;
    while (playAgain == 0 ){
        Thread.sleep(500);
        int houseTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);
        int playerTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);
        System.out.println("The House is showing: " + houseTotal);

        while (playerTotal < 22){
            System.out.println("Players total is: " + playerTotal);
            System.out.println("Would you like to hit or stand? \n\tEnter 1 for hit or 0 for stand");
            int choice = scnr.nextInt();
            if (choice == 0 ){
                break;
            } else if (choice == 1){
                Card nextCard = deck.drawCard();

                System.out.println("The player has been dealt " + nextCard.declareCard());
                playerTotal += nextCard.getValue(true);
            } else  
                System.out.println("Invalid option, try again.");
        }

        if (playerTotal > 21){
            Thread.sleep(500);
            System.out.println("The player has busted! You lose :(");
            loses++;
        } else {
            Thread.sleep(500);
            //
            System.out.println("\nThe player stands with " + playerTotal);
            //
            System.out.println("The House will play next. \n");
            // 
        }

        if (playerTotal <= 21){
            while (houseTotal < 17){
                System.out.println("The House has " + houseTotal);
                System.out.println("The House takes another card.");
                Card nextHouseCard = deck.drawCard();
                System.out.println("The House is dealt " + nextHouseCard.declareCard());
                houseTotal += nextHouseCard.getValue(true);
            }
            Thread.sleep(500);
            System.out.println("Game Results!");
            Thread.sleep(500);
            if (houseTotal > 21){
            System.out.println("The House has busted! You Win :)");
                wins++;
            }
            else {
                System.out.println("\nThe House Stands with " + houseTotal);
            }

            if (houseTotal == playerTotal){
                System.out.println("It's a Tie!");
                tie++;
            } else if (houseTotal > playerTotal){
                System.out.println("The House Wins! Sorry :(");
                loses++;
            }
            else if (houseTotal < playerTotal){
                System.out.println("The Player Wins! Good Job!");
                wins++;
            }
        }
        System.out.println(" ");
        Thread.sleep(500);
        System.out.println("You won " + wins + " times");
        System.out.println("You lost " + loses + " times");
        System.out.println("You were tie " + tie + " times");
        System.out.println(" ");
        Thread.sleep(500);
        System.out.println("Would you like to play again? Enter 0 for Yes, Enter 1 for No");
        playAgain = scnr.nextInt();
    }
    }
}

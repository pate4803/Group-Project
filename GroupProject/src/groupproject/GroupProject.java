/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package groupproject;

/**
 *
 * @author Aryan
 */
import java.util.*;

public class GroupProject {

    private static List<Integer> deck = new ArrayList<>();
    private static List<Integer> playerHand = new ArrayList<>();
    private static List<Integer> computerHand = new ArrayList<>();

    public static void main(String[] args) {
        // Initializing deck
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(i);
            }
        }

        // Shuffling deck
        Collections.shuffle(deck);

        // Dealing cards
        for (int i = 0; i < 7; i++) {
            playerHand.add(deck.remove(deck.size()-1));
            computerHand.add(deck.remove(deck.size()-1));
        }

        // Sorting hands
        Collections.sort(playerHand);
        Collections.sort(computerHand);

        // Start of the game
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);

        while (!gameOver) {
            System.out.println("Your turn! Your hand: " + playerHand);
            System.out.println("Pick a card from your hand:");
            int card = scanner.nextInt();
            System.out.println("You chose " + card);
            if (computerHand.contains(card)) {
                System.out.println("Computer has that card! You get another turn!");
                computerHand.remove(Integer.valueOf(card));
                playerHand.add(card);
            } else {
                System.out.println("Go fish!");
                if(deck.size() > 0){
                    playerHand.add(deck.remove(deck.size()-1));
                }
            }
            Collections.sort(playerHand);
            if(deck.size() > 0){
                computerHand.add(deck.remove(deck.size()-1));
            }
            Collections.sort(computerHand);

            System.out.println("Computer's turn:");
            int computerCard = computerHand.get(new Random().nextInt(computerHand.size()));
            System.out.println("Computer chose " + computerCard);
            if (playerHand.contains(computerCard)) {
                System.out.println("You have that card! Computer gets another turn!");
                playerHand.remove(Integer.valueOf(computerCard));
                computerHand.add(computerCard);
            } else {
                System.out.println("Go fish!");
                if(deck.size() > 0){
                    computerHand.add(deck.remove(deck.size()-1));
                }
            }
            Collections.sort(computerHand);

            // End game condition
            if(deck.size() == 0){
                gameOver = true;
            }
        }

        // Counting cards
        System.out.println("Game Over! Counting cards...");
        System.out.println("Your cards: " + playerHand.size());
        System.out.println("Hence you have " + (playerHand.size()/4) + " sets.");
        System.out.println("Computer's cards: " + computerHand.size());
        System.out.println("Hence computer has " + (computerHand.size()/4) + " sets.");
        if (playerHand.size() > computerHand.size()) {
            System.out.println("You win!");
        } else if (playerHand.size() < computerHand.size()) {
            System.out.println("You lose!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}

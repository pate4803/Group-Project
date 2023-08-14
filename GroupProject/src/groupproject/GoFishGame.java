/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groupproject;

/**
 *
 * @author Aryan
 */
import java.util.*;

public class GoFishGame {
    private List<Integer> playerHand;
    private List<Integer> computerHand;
    private Deck deck;
    private Scanner scanner;

    public GoFishGame() {
        playerHand = new ArrayList<>();
        computerHand = new ArrayList<>();
        deck = new Deck();
        scanner = new Scanner(System.in);
    }

    public void start() {
        // Dealing cards
        for (int i = 0; i < 7; i++) {
            playerHand.add(deck.drawCard().getValue());
            computerHand.add(deck.drawCard().getValue());
        }

        // Sorting hands
        Collections.sort(playerHand);
        Collections.sort(computerHand);

        // Start of the game
        boolean gameOver = false;

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
                int drawnCard = deck.drawCard().getValue();
                if (drawnCard != 0) {
                    playerHand.add(drawnCard);
                }
            }
            Collections.sort(playerHand);
            int computerCard = computerHand.get(new Random().nextInt(computerHand.size()));
            System.out.println("Computer chose " + computerCard);
            if (playerHand.contains(computerCard)) {
                System.out.println("You have that card! Computer gets another turn!");
                playerHand.remove(Integer.valueOf(computerCard));
                computerHand.add(computerCard);
            } else {
                System.out.println("Go fish!");
                int drawnCard = deck.drawCard().getValue();
                if (drawnCard != 0) {
                    computerHand.add(drawnCard);
                }
            }
            Collections.sort(computerHand);

            // End game condition
            if (deck.isEmpty()) {
                gameOver = true;
            }
        }

        // Counting cards
        System.out.println("Game Over! Counting cards...");
        System.out.println("Your cards: " + playerHand.size());
        System.out.println("Computer's cards: " + computerHand.size());
        if (playerHand.size() > computerHand.size()) {
            System.out.println("You win!");
        } else if (playerHand.size() < computerHand.size()) {
            System.out.println("You lose!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Go Fish!");
        System.out.println("You are playing against the computer.");
        System.out.println("Let's get started!");

        GoFishGame game = new GoFishGame();
        game.start();
    }
}

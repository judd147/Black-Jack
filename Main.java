package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    /* Liyao Zhang
    CSC111 Spring 2018
    Programming Assignment 2 – Part 2
    March 5, 2018

    This program is an implementation of card game Blackjack. To win the game, the player needs to get 21 points
    on the player's first two cards, without a dealer blackjack; or reach a final score higher than the dealer without
    exceeding 21; or let the dealer draw additional cards until their hand exceeds 21.*/
    public static void shuffle(String[] shuffleDeck){                                                                 //In the shuffle stage, a random number between 50 and 100 is generated to determine how many times the deck will be shuffled.
        Random randGen = new Random();
        int shuffleTimes = randGen.nextInt(51)+50;
        for (int i = 0; i < shuffleTimes; i++) {
            int index1 = randGen.nextInt(52), index2 = randGen.nextInt(52);                             //Then two random numbers between 0 and 51 are generated to determine which two indices of the array will be swapped in position.
            while (index1 == index2){                                                                                  //This loop prevents two same numbers from being generated
                index1 = randGen.nextInt(52);
                index2 = randGen.nextInt(52);
            }
            String temp = shuffleDeck[index1];                                                                          //Swap the positions of two cards
            shuffleDeck[index1] = shuffleDeck[index2];
            shuffleDeck[index2] = temp;
        }
        System.out.println("The deck after shuffle is shown below.");
        for (int j = 0; j < 52; j++){                                                                                  //This loop helps print out the entire deck after shuffle
            System.out.print(shuffleDeck[j] + " ");
        }
    }

    public static void cutdeck(String[] cutDeck){
        String[] temp = new String[52];
        Random randGen = new Random();
        int cutNum = randGen.nextInt(51)+1;                                                                     //Generate a random number between 1 and 51 to determine how many cards to be removed from top to bottom
        for (int k = 0; k < 52-cutNum; k++){
            temp[k] = cutDeck[k+cutNum];                                                                                //This loop stores the original bottom deck to a temporary array
        }
        for (int a = 1; a <= cutNum; a++){
            temp[51-cutNum+a] = cutDeck[a-1];                                                                           //This loop stores the original top deck to the temporary array
        }
        for (int b = 0; b < 52; b++){
            cutDeck[b] = temp[b];                                                                                       //This loop returns the deck after being cut
        }
        System.out.println("The deck after cut is shown below.");                                                  //Print out the deck after being cut
        for (int print = 0; print < 52; print++){
            System.out.print(cutDeck[print]+" ");
        }
    }

    public static void deal(String[] dealDeck, String[] playerDeal, String[] dealerDeal){                             //Take the first two cards from the deck as the player's hand
        playerDeal[0] = dealDeck[0];                                                                                    //Then take another two cards from the deck as the dealer's hand
        playerDeal[1] = dealDeck[1];                                                                                    //The second card of dealer will actually be hidden in a real game(part 2)
        dealerDeal[0] = dealDeck[2];
        dealerDeal[1] = dealDeck[3];
        System.out.println("Your first card is " + playerDeal[0] + ", your second card is " + playerDeal[1]);     //Print out two hands after deal
        System.out.println("Dealer's first card is " + dealerDeal[0]);
    }

    public static void play(String[]playDeck, int[]playWin, String[]player, String[]dealer, int[]playCards){         //Declare several variables: scores of both sides, cards that have been used, and if player wants to hit
        Scanner snjr = new Scanner(System.in);
        int[] scores = {0,0};
        int userHit = 1, numCard = 4, numAces = 0;
        score(scores, player, dealer, playCards);                                                                       //Call method score to calculate scores after deal
        System.out.println("Your current score is "+scores[0]);
        while (userHit == 1&&scores[0]<=21) {                                                                          //Prompt player to hit or stay
            System.out.println("If you want a hit, enter 1. If not, enter 0 to stay.");
            userHit = snjr.nextInt();
            switch (userHit){
                case 0: break;
                case 1: player[numCard-2] = playDeck[numCard];
                playCards[0]++;
                    System.out.println("The card is " + playDeck[numCard]);
                    score(scores, player, dealer, playCards);                                                           //Update the score after each hit
                    numCard++;
                    System.out.println("Your current score is "+scores[0]);                                          //Print out current score
                    break;
            }
        }
        System.out.println("Dealer's second card is "+dealer[1]);
        while (scores[1]<17) {                                                                                         //Let the dealer hit until reaching 17
            dealer[playCards[1]] = playDeck[numCard];
            playCards[1]++;
            numCard++;
            score(scores, player, dealer, playCards);                                                                   //Update with dealer's scores
        }
        compare(scores, playWin);                                                                                       //Call method compare to determine who wins
    }

    public static void score(int[] sscc, String[]Player, String[]Dealer, int[]scoreCard){
        Scanner snjr = new Scanner(System.in);                                                                         //Nothing complicated in this method but have to start counting from the beginning each time it enters the method
        sscc[0] = 0;
        sscc[1] = 0;
        for (int i = 0; i < scoreCard[0]; i++){
            if (Player[i].equals("H2")||Player[i].equals("S2")||Player[i].equals("D2")||Player[i].equals("C2")){
                sscc[0] = sscc[0] + 2;}
                else if (Player[i].equals("H3")||Player[i].equals("S3")||Player[i].equals("D3")||Player[i].equals("C3")){
                sscc[0] = sscc[0] + 3;}
                else if (Player[i].equals("H4")||Player[i].equals("S4")||Player[i].equals("D4")||Player[i].equals("C4")){
                sscc[0] = sscc[0] + 4;}
                else if (Player[i].equals("H5")||Player[i].equals("S5")||Player[i].equals("D5")||Player[i].equals("C5")){
                sscc[0] = sscc[0] + 5;}
                else if (Player[i].equals("H6")||Player[i].equals("S6")||Player[i].equals("D6")||Player[i].equals("C6")){
                sscc[0] = sscc[0] + 6;}
                else if (Player[i].equals("H7")||Player[i].equals("S7")||Player[i].equals("D7")||Player[i].equals("C7")){
                sscc[0] = sscc[0] + 7;}
                else if (Player[i].equals("H8")||Player[i].equals("S8")||Player[i].equals("D8")||Player[i].equals("C8")){
                sscc[0] = sscc[0] + 8;}
                else if (Player[i].equals("H9")||Player[i].equals("S9")||Player[i].equals("D9")||Player[i].equals("C9")){
                sscc[0] = sscc[0] + 9;}
                else if (Player[i].equals("H10")||Player[i].equals("S10")||Player[i].equals("D10")||Player[i].equals("C10")
                    ||Player[i].equals("HJ")||Player[i].equals("HQ")||Player[i].equals("HK")||Player[i].equals("SJ")||Player[i].equals("SQ")
                    ||Player[i].equals("SK")||Player[i].equals("DJ")||Player[i].equals("DQ")||Player[i].equals("DK")||Player[i].equals("CJ")
                    ||Player[i].equals("CQ")||Player[i].equals("CK")){
                sscc[0] = sscc[0] + 10;}
                else if (Player[i].equals("HA")||Player[i].equals("SA")||Player[i].equals("DA")||Player[i].equals("CA")){
                    System.out.println("You got an Ace. Enter 1 or 11 to add that value to your score.");
                    int userAce = snjr.nextInt();
                    while (userAce!=1&&userAce!=11){
                        System.out.println("Error. Enter 1 or 11 to add that value to your score.");
                        userAce = snjr.nextInt();}
                    sscc[0] = sscc[0] + userAce; }
                }
        for (int j = 0; j < scoreCard[1]; j++){
            if (Dealer[j].equals("H2")||Dealer[j].equals("S2")||Dealer[j].equals("D2")||Dealer[j].equals("C2")){
                sscc[1] = sscc[1] + 2;}
            else if (Dealer[j].equals("H3")||Dealer[j].equals("S3")||Dealer[j].equals("D3")||Dealer[j].equals("C3")){
                sscc[1] = sscc[1] + 3;}
            else if (Dealer[j].equals("H4")||Dealer[j].equals("S4")||Dealer[j].equals("D4")||Dealer[j].equals("C4")){
                sscc[1] = sscc[1] + 4;}
            else if (Dealer[j].equals("H5")||Dealer[j].equals("S5")||Dealer[j].equals("D5")||Dealer[j].equals("C5")){
                sscc[1] = sscc[1] + 5;}
            else if (Dealer[j].equals("H6")||Dealer[j].equals("S6")||Dealer[j].equals("D6")||Dealer[j].equals("C6")){
                sscc[1] = sscc[1] + 6;}
            else if (Dealer[j].equals("H7")||Dealer[j].equals("S7")||Dealer[j].equals("D7")||Dealer[j].equals("C7")){
                sscc[1] = sscc[1] + 7;}
            else if (Dealer[j].equals("H8")||Dealer[j].equals("S8")||Dealer[j].equals("D8")||Dealer[j].equals("C8")){
                sscc[1] = sscc[1] + 8;}
            else if (Dealer[j].equals("H9")||Dealer[j].equals("S9")||Dealer[j].equals("D9")||Dealer[j].equals("C9")){
                sscc[1] = sscc[1] + 9;}
            else if (Dealer[j].equals("H10")||Dealer[j].equals("S10")||Dealer[j].equals("D10")||Dealer[j].equals("C10")
                    ||Dealer[j].equals("HJ")||Dealer[j].equals("HQ")||Dealer[j].equals("HK")||Dealer[j].equals("SJ")||Dealer[j].equals("SQ")
                    ||Dealer[j].equals("SK")||Dealer[j].equals("DJ")||Dealer[j].equals("DQ")||Dealer[j].equals("DK")||Dealer[j].equals("CJ")
                    ||Dealer[j].equals("CQ")||Dealer[j].equals("CK")){
                sscc[1] = sscc[1] + 10;}
            else if (sscc[1]<=10) {
                if (Dealer[j].equals("HA") || Dealer[j].equals("SA") || Dealer[j].equals("DA") || Dealer[j].equals("CA")) {
                    sscc[1] = sscc[1] + 11; }
            }
            else if (sscc[1]>10){
                if(Dealer[j].equals("HA")||Dealer[j].equals("SA")||Dealer[j].equals("DA")||Dealer[j].equals("CA")){
                    sscc[1] = sscc[1] + 1;}
            }
        }
    }

    public static void compare(int[] comScore, int[] comWin ){                                                       //The rules of determining the winner apply here
        if (comScore[0]==21&&comScore[1]!=21){
            comWin[0]++;
            System.out.println("You win!");
            System.out.println("Your score is "+comScore[0]+", dealer's score is "+comScore[1]+".");}
            else if (comScore[0]==comScore[1]){
            System.out.println("It's a tie.");}
            else if (comScore[0]<21&&comScore[1]==21){
            comWin[1]++;
            System.out.println("Dealer wins.");
            System.out.println("Your score is "+comScore[0]+", dealer's score is "+comScore[1]+".");}
            else if (comScore[0]>21){
            comWin[1]++;
            System.out.println("You have reached out 21. Dealer wins.");}
            else if (comScore[0]<21&&comScore[1]>21){
            comWin[0]++;
            System.out.println("You win!");
            System.out.println("Your score is "+comScore[0]+", dealer's score is "+comScore[1]+".");}
            else if (comScore[0]<21&&comScore[0]>comScore[1]){
            comWin[0]++;
            System.out.println("You win!");
            System.out.println("Your score is "+comScore[0]+", dealer's score is "+comScore[1]+".");}
            else if (comScore[1]<21&&comScore[0]<comScore[1]){
            comWin[1]++;
            System.out.println("Dealer wins.");
            System.out.println("Your score is "+comScore[0]+", dealer's score is "+comScore[1]+".");}
    }

    public static void main(String[] args) {                                                                          //Build up the menu
        Scanner snjr = new Scanner(System.in);
        int[] win = {0,0};
        boolean quit = false;
        System.out.println("Welcome to Blackjack. Please note that whenever you got an Ace, you will be asked to confirm the value you want to add twice.");
        while (!quit){
            System.out.println("Press Enter to start the game. If you want to quit, press q.");
            String userChoice, userFinal;
            userChoice = snjr.nextLine();
            int[] cards = {2,2};
            switch (userChoice){
                case "q":
                    quit = true;
                    if (win[0]>win[1]){
                        System.out.println("You had the most wins! Congratulations!");
                        System.out.println("Have a good day.");}
                        else if (win[0]<win[1]){
                        System.out.println("Dealer had the most wins. Keep it up.");
                        System.out.println("Have a good day.");}
                        else {
                        System.out.println("It is not all set yet. Enter y to resume the game or enter any button to quit.");
                        userFinal = snjr.nextLine();
                        if (userFinal.equals("y")) {
                            quit = false;
                        } else {
                            System.out.println("Have a good day.");
                        }
                    }
                    break;
                default:
                    System.out.println("Let's get started. H represents for Heart. S represents for Spade. D represents for Diamond. C represents for Club.");
                    String[] deck = {"HA","H2","H3","H4","H5","H6","H7","H8","H9","H10","HJ","HQ","HK","SA","S2","S3","S4","S5","S6","S7","S8","S9","S10","SJ","SQ","SK",
                            "DA","D2","D3","D4","D5","D6","D7","D8","D9","D10","DJ","DQ","DK","CA","C2","C3","C4","C5","C6","C7","C8","C9","C10","CJ","CQ","CK"};
                    String[] playerHand = new String[12];
                    String[] dealerHand = new String[12];                                                               //Initialize the deck and two hands
                    shuffle(deck);                                                                                      //Call the method shuffle
                    System.out.println(" ");
                    System.out.println(" ");
                    cutdeck(deck);                                                                                      //Call the method cutdeck
                    System.out.println(" ");
                    deal(deck, playerHand, dealerHand);                                                                 //Call the method deal
                    System.out.println(" ");
                    play(deck, win, playerHand, dealerHand, cards);                                                     //Call the method play
                    System.out.println("The rest cards in dealer's hand are:");                                    //Print out dealer's hand after game
                    for (int w = 2; w < cards[1]; w++){
                        System.out.print(dealerHand[w]+" ");
                    }
                    System.out.println(" ");
                    System.out.println("You have "+win[0]+" wins. Dealer has "+win[1]+" wins.");                   //Announce wins both sides have
            }
        }
    }
}
// Gabriella S Maria
// 04/20/2023
// Lab 3 - Deck of Card
import java.util.Scanner;
public class DeckofCardGame {
public static void main(String[] args) {
String[] deck = makeDeck();
String [] sDeck = shuffleDeck(deck);
Scanner scan = new Scanner(System.in);
// game loop
loop: while(true){
System.out.println("\nWhat part do you want to do?");
int choice = 0;
try{
String str = scan.next();
choice = Integer.parseInt(str);
}catch(NumberFormatException e){
System.out.println("Only Integers(1/2) allowed.");
continue;
}
switch (choice) {
case 1:
int humanCardValue, computerCardValue;
while(true){
try{
System.out.println("Enter a card location from 0 to 51:");
String card = scan.next();
humanCardValue = Integer.parseInt(card);
}catch(NumberFormatException e){
System.out.println("Only Integers allowed.");
continue;
}
if(humanCardValue >= 0 && humanCardValue <= 51){
break;
}else{
System.out.println("Invalid Input.");
}
}
computerCardValue = (int)(Math.random()*52);
System.out.println("Computer chose: "+computerCardValue);
System.out.println("You had a "+sDeck[humanCardValue]);
System.out.println("Computer has a "+sDeck[computerCardValue]);
if(declareWinner(sDeck[humanCardValue], sDeck[computerCardValue]) == 1){
System.out.println("You have a high card.");
}else if(declareWinner(sDeck[humanCardValue], sDeck[computerCardValue]) == -1){
System.out.println("Computer had a higher card.");
}else{
System.out.println("It's a tie");
}
break;
case 2:
int c1_score=0, c2_score=0;
for(int i=0; i<100; i++){
int c1 = (int)(Math.random()*52);
int c2 = (int)(Math.random()*52);
if(declareWinner(sDeck[c1], sDeck[c2]) == 1){
System.out.println("Computer 1 had a higher card: "+sDeck[c1]+sDeck[c2]);
c1_score++;
}else if(declareWinner(sDeck[c1], sDeck[c2]) == -1){
System.out.println("Computer 2 had a higher card: "+sDeck[c2]+sDeck[c1]);
c2_score++;
}else{
System.out.println("Tie");
}
sDeck = shuffleDeck(sDeck);
}
System.out.println("Computer 1 had "+c1_score+" wins.");
System.out.println("Computer 2 had "+c2_score+" wins.");
if(c1_score > c2_score){
System.out.println("Computer 1 won the game");
}else if(c1_score < c2_score){
System.out.println("Computer 2 won the game");
}else{
System.out.println("Its' a tie");
}
break;
case -1:
System.out.println("GoodBye");
break loop;
default:
System.out.println("Invalid Input, only (1/2).");
}
}
// Ask the user which part they want to do
// if the user chooses part 1
// get the user choice and the computer's choice
// Make sure the choices are valid. The user should not
// be able to enter card 150000.
// Get the value of the card from each choice. Note
// that the deck should be SHUFFLED. So if the human chooses card
// card 34, and the computer chooses card 2, the computer
// still might have a higher value card
// Your goal is to have the value of the card the human chose
// and have a value of the card the computer chose.
// You should be able to pass in the deck array display
// the card suits and ranks declareWinner(humanCardValue, computerCardValue, deck);
// get the winner for both computers for each round
// NOTE: HOW DOES THE PROGRAM KNOW WHO WON?
// do you need to change the declareWinner method?
// Will it need to return anything? And how?
// Collect the number of wins for each
//
// Display the number of wins for each and who won.
}
public static String[] makeDeck(){
String[] suits={"hearts","spades","clubs","diamonds"};
String[] ranks={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
// You have the suits and the rank,
// How do you put them as strings?
String[] sortedDeck = new String[52];
int i=0;
for(String suit: suits){
for(String rank: ranks){
sortedDeck[i++] = rank + " of " + suit;

} }
// How do you easily make all the combinations of them?
return sortedDeck;
}
public static String[] shuffleDeck(String [] deck){
String[] shuffled = deck;
// You need to shuffle the array
// swapping random cards to shuffle.
for(int i=0; i<500; i++){
int card1 = (int)(Math.random()*52);
int card2 = (int)(Math.random()*52);
String temp = shuffled[card1];
shuffled[card1] = shuffled[card2];
shuffled[card2] = temp;
}
return shuffled;
}
public static int declareWinner(String c1, String c2){
if(cardValue(c1) > cardValue(c2)){
return 1;
}else if(cardValue(c1) < cardValue(c2)){
return -1;
}else{
return 0;
}
}
public static int cardValue(String card){
String[] arr = card.split(" ");
int score = 0;
switch(arr[0]){
case "Ace":
score += 1;
break;
case "2":
score += 2;
break;
case "3":
score += 3;
break;
case "4":
score += 4;
break;
case "5":
score += 5;
break;
case "6":
score += 6;
break;
case "7":
score += 7;
break;
case "8":
score += 8;
break;

case "9":
score += 9;
break;
case "10":
score += 10;
break;
case "Jack":
score += 11;
break;
case "Queen":
score += 12;
break;
case "King":
score += 13;
}
switch(arr[2]){
case "hearts":
score += 0;
break;
case "spades":
score +=13;
break;
case "clubs":
score +=26;
break;
case "diamonds":
score +=39;
}
return score;
} }
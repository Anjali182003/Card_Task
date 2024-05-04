# Card_Task
A Java program simulating a deck of cards, including functionalities like  random card drawing, sorting, and (optional) shuffling.

# Explaination of code
Enums for Card Representation: Suit and Rank Enums represent the suit and rank of the playing cards, respectively. Enums are used here because they provide a convenient way to define custom constants. 

Card Class - A card class represents a single playing card. There are two areas: Suits and Ranks, which store suits and ranks of cards. The constructor initializes these fields, and getter methods are provided to access them. The toString() method is overridden to provide the string representation of the card.

Configuring the Comparator: The CardComparator class implements the Comparator interface to define custom comparison logic for configuring cards. Papers are compared by color (red or black), then by uniform, and finally by rank. The getColorValue() method is a helper method for determining the color value of the 
given suite. 


Deck Class: A deck class controls a deck of cards. It contains a list of Card objects that represent the deck. The creator starts the deck with 52 cards (one for each suit and rank combination). The shuffle() method uses Collections.shuffle() to shuffle the cards in the deck. The drawCard() method draws a card from the deck and removes it from the deck. The drawCards() method draws more cards from the deck. The size() method returns the number of cards remaining in the deck. 


Main Class: The main class contains the main() method, which acts as the entry point of the program. In main(), the Deck object is created, shuffled (optional), and 
then 20 cards are drawn from the deck. These downloaded cards are stored in inventory and sorted by CardComparator. Finally, the list of documents is printed on 
the console.

